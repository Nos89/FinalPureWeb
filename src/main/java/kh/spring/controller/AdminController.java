package kh.spring.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;
import com.nexacro17.xapi.data.DataSet;
import com.nexacro17.xapi.data.PlatformData;
import com.nexacro17.xapi.data.Variable;
import com.nexacro17.xapi.tx.HttpPlatformRequest;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardDTO_NEX;
import kh.spring.dto.BuildDTO;
import kh.spring.dto.ChangeDeptApplyDTO;
import kh.spring.dto.ChangeDeptApplyDTO_NEX;
import kh.spring.dto.ClassroomDTO;
import kh.spring.dto.CloudStorageDTO;
import kh.spring.dto.ColScheduleDTO;
import kh.spring.dto.ColScheduleDTO_NEX;
import kh.spring.dto.CollegeDTO;
import kh.spring.dto.CreditRenounceDTO;
import kh.spring.dto.CreditRenounceDTO_NEX;
import kh.spring.dto.DepartmentDTO;
import kh.spring.dto.FilesDTO;
import kh.spring.dto.LectureDTO;
import kh.spring.dto.NoticeDTO;
import kh.spring.dto.NoticeDTO_NEX;
import kh.spring.dto.ProfessorDTO;
import kh.spring.dto.ReturnApplyDTO;
import kh.spring.dto.ReturnApplyDTO_NEX;
import kh.spring.dto.StudentDTO;
import kh.spring.dto.TakeOffApplyDTO;
import kh.spring.dto.TakeOffApplyDTO_NEX;
import kh.spring.service.AdminService;
import kh.spring.service.BoardService;
import kh.spring.service.CommentService;
import kh.spring.utils.ConvertDate;

@Controller
public class AdminController {

	@Autowired
	private AdminService admService;
	@Autowired
	CommentService cservice;
	
	
	@Autowired
	private BoardService bService;
	
	// 공지사항 로드
	@RequestMapping("getBoardNotice.nex")
	public NexacroResult getBoardNotice(@ParamVariable(name="category")String category) throws Exception{
		NexacroResult nr = new NexacroResult();
		List<NoticeDTO> list = admService.getBoardNotice(category);
		int rowCount = list.size();
		nr.addDataSet("out_notice", list);
		nr.addVariable("totalRowCount",rowCount);
		return nr;
	}
	
	// 공지사항 탭 변경
	@RequestMapping("noticeTabChanged.nex")
	public NexacroResult notiTabChanged(@ParamVariable(name="category")String category) throws Exception {
		NexacroResult nr = new NexacroResult();
		List<NoticeDTO> list = admService.getBoardNotice(category);
		int rowCount = list.size();
		nr.addDataSet("out_notice",list);
		nr.addVariable("totalRowCount",rowCount);
		return nr;
	}
	
	// 공지사항 검색
	@RequestMapping("searchNotice.nex")
	public NexacroResult searchNotice(@ParamVariable(name="sTarget")String target, @ParamVariable(name="sKeyword")String keyword, @ParamVariable(name="category")String category) throws Exception {
		NexacroResult nr = new NexacroResult();
		List<NoticeDTO> list = admService.searchNotice(target, keyword, category);
		int rowCount = list.size();
		nr.addDataSet("out_notice",list);
		nr.addVariable("totalRowCount",rowCount);
		return nr;
	}
	
	// 공지사항 삭제
	@RequestMapping("deleteNotice.nex")
	public NexacroResult deleteNotice(@ParamDataSet(name="in_notice")List<NoticeDTO_NEX> list) throws Exception {
		admService.deleteNotice(list);
		return new NexacroResult();
	}
	
	// 공지사항 작성
	@RequestMapping("writeNotice")
	public NexacroResult writeNotice(@ParamDataSet(name="in_notice")NoticeDTO dto){
		NexacroResult nr = new NexacroResult();
		int seq = admService.writeNotice(dto);
		
		nr.addVariable("param", seq);
		return nr;
	}
	
	// 공지사항 수정
	@RequestMapping("modifyNotice.nex")
	public NexacroResult modifyNotice(@ParamDataSet(name="in_notice")NoticeDTO_NEX dto) throws Exception {
		admService.modifyNotice(dto);
		return new NexacroResult();
	}
	
	
	// 게시글 보기
	@RequestMapping("viewPost")
	public String goPost(int seq, String commentPage, Model model, String type) {
		System.out.println(seq);
		List<FilesDTO> list =admService.getFiles(seq);
		for(FilesDTO m : list) {
			System.out.println(m.getOriName());
			System.out.println(m.getParent_code());
			System.out.println(m.getSavedName());
		}
		model.addAttribute("files", admService.getFiles(seq));
		model.addAttribute("commentPage", this.convertPage(commentPage));
		model.addAttribute("comments", cservice.getComments(seq, this.convertPage(commentPage)));
		if(type.contentEquals("notice")){
			model.addAttribute("article",admService.getNotice(seq));
			return "admin/noticeBoardView";
		}else {
			model.addAttribute("article",admService.getPost(seq));
			return "admin/boardView";
		}
	}
	
	// 게시글 가져오기
	@RequestMapping("getPost.nex")
	public NexacroResult getPost(@ParamVariable(name="seq")int seq, @ParamVariable(name="boardType")String boardType) {
		NexacroResult nr = new NexacroResult();
		if(boardType.contentEquals("notice")) {
			NoticeDTO dto = admService.getNotice(seq);
			nr.addDataSet("out_notice",dto);
		}else {
			BoardDTO dto = admService.getPost(seq);
			nr.addDataSet("out_board",dto);
		}
		List<FilesDTO> list = bService.getFiles(seq);
		nr.addDataSet("out_files", list);
		return nr;
	}
	
	// 게시글 작성폼
	@RequestMapping("goWrite.nex")
	public String goWritePage(String type) {
		if(type.contentEquals("notice")) {
			return "admin/noticeBoardWrite";
		} else {
			return "admin/boardWrite";
		}
	}
		
	// 게시글 작성
	@RequestMapping("writeBoard.nex")
	public NexacroResult writePost(@ParamDataSet(name="in_board")BoardDTO dto) {
		NexacroResult nr = new NexacroResult();
		int seq = admService.writePost(dto);
		nr.addVariable("param",seq);
		return nr;
	}
	
	// 게시글 수정폼
	@RequestMapping("goModify")
	public String goModifyPage(int seq, String commentPage, Model model, String type) {
		System.out.println("type: "+type);
		model.addAttribute("files", admService.getFiles(seq));
		model.addAttribute("commentPage", this.convertPage(commentPage));
		model.addAttribute("comments", cservice.getComments(seq, this.convertPage(commentPage)));
		if(type.contentEquals("notice")){
			model.addAttribute("article",admService.getNotice(seq));
			return "admin/noticeBoardModify";
		}else {
			model.addAttribute("article",admService.getPost(seq));
			return "admin/boardModify";
		}
	}
	
	// 게시글 수정
	@RequestMapping("modifyBoard.nex")
	public NexacroResult modifyPost(@ParamDataSet(name="in_board")BoardDTO_NEX dto) throws Exception {
		admService.modifyPost(dto);
		return new NexacroResult();
	}

	
	// 게시판 로드
	@RequestMapping("BoardOnLoad.nex")
	public NexacroResult getBoard(@ParamVariable(name="boardType")String boardType) throws Exception {
		NexacroResult nr = new NexacroResult();

		List<BoardDTO> list = admService.getBoard(boardType);
		int rowCount = list.size();
		nr.addDataSet("out_board",list);
		nr.addVariable("totalRowCount",rowCount);
		return nr;
	}
	
	// 게시글 검색
	@RequestMapping("SearchBoard.nex")
	public NexacroResult searchBoard(@ParamVariable(name="sTarget")String target, @ParamVariable(name="sKeyword")String keyword, @ParamVariable(name="boardType")String boardType) throws Exception {
		NexacroResult nr = new NexacroResult();
		List<BoardDTO> list = admService.searchBoard(target, keyword, boardType);
		int rowCount = list.size();
		nr.addDataSet("out_board",list);
		nr.addVariable("totalRowCount", rowCount);
		return nr;
	}
	
	// 게시글 삭제
	@RequestMapping("DeleteBoard.nex")
	public NexacroResult deleteBoard(@ParamDataSet(name="in_board")List<BoardDTO_NEX> list, @ParamVariable(name="boardType")String boardType) throws Exception {
		admService.deleteBoard(list, boardType);
		return new NexacroResult();
	}
	
	
	//게시판 수정시 글에 첨부된 파일목록 불러오기
	@RequestMapping("getFileList.nex")
	public NexacroResult getFileList(@ParamVariable(name="seq")int seq) {
		System.out.println(seq);
		NexacroResult nr = new NexacroResult();
		List<FilesDTO> list = bService.getFiles(seq);
		nr.addDataSet("out_ds", list);
		return nr;
	}
	
	//게시판 수정시 파일 삭제
	@RequestMapping("delFile.nex")
	public NexacroResult delFile(@ParamVariable(name="fileSeq")int fileSeq,@ParamVariable(name="parent_code")int parent_code, @ParamVariable(name="name")String name) {
		System.out.println(fileSeq+parent_code+name);
		NexacroResult nr = new NexacroResult();
		List<FilesDTO> list =admService.delSpecFile(name,fileSeq,parent_code);
		nr.addDataSet("out_ds", list);
		return nr;
	}
	
	// 페이지 유효성
	private int convertPage(String page) {
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(page);
		} catch (Exception e) {
			currentPage = 1;
		}
		return currentPage;
	}
	
	// 교수 목록 로드
	@RequestMapping("ProfessorOnLoad.nex")
	public NexacroResult professorOnLoad() throws Exception {
		NexacroResult nr = new NexacroResult();
		List<ProfessorDTO> list = admService.getProfessor();
		List<CollegeDTO> list2 = admService.getCollege();
		List<DepartmentDTO> list3 = admService.getDepartment();
		nr.addDataSet("out_pro", list);
		nr.addDataSet("out_col",list2);
		nr.addDataSet("out_dept",list3);
		return nr;
	}
	
	// 교수 정보 수정
	@RequestMapping("ProfessorUpdate.nex")
	public NexacroResult updateProfessor(HttpServletRequest request) throws Exception {
		HttpPlatformRequest pReq =  new HttpPlatformRequest(request);
		pReq.receiveData();
		PlatformData inData = pReq.getData();
		DataSet ds = inData.getDataSet("in_pro");
		Variable var = inData.getVariable("user");
		String user = var.getString();
		String filePath = request.getSession().getServletContext().getRealPath("/resources/webhard/");
		
		// 삭제된 데이터
		for(int i=0;i<ds.getRemovedRowCount();i++) {
			String id = ds.getRemovedStringData(i, "id");
			System.out.println("삭제된 아이디: "+id);
			admService.deleteProfessor(id, filePath);
		}
		
		// 추가, 수정된 데이터
		for(int i=0;i<ds.getRowCount();i++) {
			ProfessorDTO dto = new ProfessorDTO();
			dto.setId(dsGet(ds,i,"id"));
			dto.setPw(dsGet(ds,i,"birth"));
			dto.setName(dsGet(ds,i,"name"));
			dto.setBirth(ConvertDate.stringToDate(dsGet(ds,i,"birth")));
			dto.setGender(dsGet(ds,i,"gender"));
			dto.setCountry(dsGet(ds,i,"country"));
			dto.setInDate(ConvertDate.stringToDate(dsGet(ds,i,"inDate")));
			dto.setOutDate(ConvertDate.stringToDate(dsGet(ds,i,"outDate")));
			dto.setColcode(dsGet(ds,i,"colcode"));
			dto.setDeptcode(dsGet(ds,i,"deptcode"));
			dto.setZipcode(dsGet(ds,i,"zipcode"));
			dto.setAddr1(dsGet(ds,i,"addr1"));
			dto.setAddr2(dsGet(ds,i,"addr2"));
			dto.setEmail(dsGet(ds,i,"email"));
			dto.setPhone(dsGet(ds,i,"phone"));
			dto.setBank(dsGet(ds,i,"bank"));
			dto.setAccountnum(dsGet(ds,i,"accountnum"));
			dto.setPro_office(dsGet(ds,i,"pro_office"));
			dto.setPro_status(dsGet(ds,i,"pro_status"));
			int rowType = ds.getRowType(i);
			System.out.println("row타입: "+rowType);
			admService.modifyProfessor(dto,rowType);
		}
		return new NexacroResult();
	}
	
	
	// 학생 목록 로드
	@RequestMapping("StudentOnLoad.nex")
	public NexacroResult getStudentOnLoad() throws Exception {
		NexacroResult nr = new NexacroResult();
		List<StudentDTO> list = admService.getStudentOnLoad();
		List<CollegeDTO> list2 = admService.getCollege();
		List<DepartmentDTO> list3 = admService.getDepartment();
		nr.addDataSet("out_std",list);
		nr.addDataSet("out_col",list2);
		nr.addDataSet("out_dept",list3);
		return nr;		
	}
	
	// 학생 정보 수정
	@RequestMapping("StudentUpdate.nex")
	public NexacroResult modifyStudent(HttpServletRequest request) throws Exception {
		HttpPlatformRequest pReq = new HttpPlatformRequest(request);
		pReq.receiveData();
		PlatformData inData = pReq.getData();
		DataSet ds = inData.getDataSet("in_std");
		String filePath = request.getSession().getServletContext().getRealPath("/resources/webhard/");
		
		// 삭제된 데이터
		for(int i=0;i<ds.getRemovedRowCount();i++) {
			String id = ds.getRemovedStringData(i, "id");
			System.out.println("삭제된 아이디: "+id);
			admService.deleteStudent(id, filePath);
		}
		
		// 추가, 수정된 데이터
		for(int i=0;i<ds.getRowCount();i++) {
			StudentDTO dto = new StudentDTO();
			dto.setId(dsGet(ds,i,"id"));
			dto.setPw(dsGet(ds,i,"birth"));
			dto.setName(dsGet(ds,i,"name"));
			dto.setBirth(ConvertDate.stringToDate(dsGet(ds,i,"birth")));
			dto.setGender(dsGet(ds,i,"gender"));
			dto.setCountry(dsGet(ds,i,"country"));
			dto.setInDate(ConvertDate.stringToDate(dsGet(ds,i,"inDate")));
			dto.setOutDate(ConvertDate.stringToDate(dsGet(ds,i,"outDate")));
			dto.setColcode(dsGet(ds,i,"colcode"));
			dto.setDeptcode(dsGet(ds,i,"deptcode"));
			dto.setZipcode(dsGet(ds,i,"zipcode"));
			dto.setAddr1(dsGet(ds,i,"addr1"));
			dto.setAddr2(dsGet(ds,i,"addr2"));
			dto.setEmail(dsGet(ds,i,"email"));
			dto.setPhone(dsGet(ds,i,"phone"));
			dto.setBank(dsGet(ds,i,"bank"));
			dto.setAccountnum(dsGet(ds,i,"accountnum"));
			dto.setStd_status(dsGet(ds,i,"std_status"));
			dto.setStd_year(Integer.parseInt(dsGet(ds,i,"std_year")));
			int rowType = ds.getRowType(i);
			System.out.println("row타입: "+rowType);
			admService.modifyStudent(dto,rowType);
		}
		return new NexacroResult();
	}

	private String dsGet(DataSet ds, int rowNum, String colName) {
		String result = ds.getString(rowNum, colName);
		if(result==null) {
			return "";
		}else {
			return result;
		}
	}

	
	// 강의계획서 가져오기
	@RequestMapping("SyllabusOnLoad.nex")
	public NexacroResult getSyllabus() {
		NexacroResult nr = new NexacroResult();
		List<LectureDTO> list = admService.getSyllabus();
		nr.addDataSet("out_lecture",list);
		return nr;
	}
	
	// 강의계획서 승인
	@RequestMapping("SyllabusApproved.nex")
	public NexacroResult syllabusApproved(@ParamDataSet(name="in_lecture")LectureDTO dto) {
		admService.syllabusApproved(dto);
		return new NexacroResult();
	}
	
	// 강의계획서 반려
	@RequestMapping("SyllabusRejected.nex")
	public NexacroResult syllabusRejected(@ParamDataSet(name="in_lecture")LectureDTO dto) {
		admService.syllabusRejected(dto);
		return new NexacroResult();		
	}
	
	// 건물 정보
	@RequestMapping("ClassroomOnLoad.nex")
	public NexacroResult getClassroomInfo() {
		NexacroResult nr = new NexacroResult();
		List<BuildDTO> list1 = admService.getBuild();
		List<ClassroomDTO> list2 = admService.getClassroom();
		nr.addDataSet("out_build",list1);
		nr.addDataSet("out_classroom",list2);
		return nr;
	}
	
	// 강의장 시간표 조회
	@RequestMapping("SearchTimetable")
	public NexacroResult searchTimetable(@ParamVariable(name="classroom")String classroom, @ParamVariable(name="year")String year, @ParamVariable(name="semester")int semester) {
		NexacroResult nr = new NexacroResult();
		List<LectureDTO> list = admService.searchClsTimetable(classroom, year, semester);
		nr.addDataSet("out_timetable",list);
		return nr;
	}
	
	// 학사일정 불러오기
	@RequestMapping("getColSchedule.nex")
	public NexacroResult getColSchedule() {
		NexacroResult nr = new NexacroResult();
		List<ColScheduleDTO> list = admService.getColSchedule();
		List<ColScheduleDTO_NEX> list2 = new ArrayList<>();
		
		for(ColScheduleDTO dto:list) {
			ColScheduleDTO_NEX dto2 = new ColScheduleDTO_NEX();
			dto2.setSeq(dto.getSeq());
			dto2.setTitle(dto.getTitle());
			dto2.setContents(dto.getContents());
			dto2.setSche_startDate(ConvertDate.dateToString(dto.getSche_startDate()));
			dto2.setSche_endDate(ConvertDate.dateToString(dto.getSche_endDate()));
			dto2.setType(dto.getType());
			list2.add(dto2);
		}
		nr.addDataSet("out_colSchedule",list2);
		return nr;
	}
	
	// 학사일정 추가/수정
	@RequestMapping("UpdateColSchedule.nex")
	public NexacroResult updColSchedule(@ParamDataSet(name="in_colScheduler")ColScheduleDTO_NEX dto, @ParamVariable(name="code")String code) throws Exception {
		// 날짜 변환
		ColScheduleDTO dto2 = new ColScheduleDTO();
		dto2.setSeq(dto.getSeq());
		dto2.setTitle(dto.getTitle());
		dto2.setContents(dto.getContents());
		dto2.setSche_startDate(ConvertDate.stringToDate(dto.getSche_startDate()));
		dto2.setSche_endDate(ConvertDate.stringToDate(dto.getSche_endDate()));
		dto2.setType(dto.getType());
		
		if(code.contentEquals("new")) {
			admService.addColSchedule(dto2);
		}else if(code.contentEquals("modify")) {
			admService.updateColSchedule(dto2);
		}else {
			System.out.println("코드 에러");
		}
		return new NexacroResult();
	}
	
	// 학사일정 삭제
	@RequestMapping("DeleteColSchedule.nex")
	public NexacroResult delColSchedule(@ParamVariable(name="seq")int seq) {
		admService.delColSchedule(seq);
		return new NexacroResult();
	}
	
	// 신청사항 목록 가져오기
	@RequestMapping("getApplication.nex")
	public NexacroResult getApplication(@ParamVariable(name="applyFor")String applyFor) {
		NexacroResult nr = new NexacroResult();
		if(applyFor.contentEquals("전과")) {
			List<ChangeDeptApplyDTO> list = admService.getChangeDeptApply();
			nr.addDataSet("out_changeDeptApply",list);
		}else if(applyFor.contentEquals("휴학")) {
			List<TakeOffApplyDTO> list = admService.getTakeOffApply();
			nr.addDataSet("out_takeOffApply",list);
		}else if(applyFor.contentEquals("복학")) {
			List<ReturnApplyDTO> list = admService.getReturnApply();
			nr.addDataSet("out_returnApply",list);			
		}else if(applyFor.contentEquals("학점포기")) {
			List<CreditRenounceDTO> list = admService.getCreditRenounceApply();
			nr.addDataSet("out_creditRenounce",list);
		}
		return nr;
	}
	
	// 전과 처리
	@RequestMapping("changeDeptApproval.nex")
	public NexacroResult changeDeptApproval(@ParamDataSet(name="in_changeDeptApply")ChangeDeptApplyDTO_NEX dto) throws Exception {
		admService.changeDeptApproval(dto);
		return new NexacroResult();
	}
	
	// 휴학 처리
	@RequestMapping("takeOffApproval.nex")
	public NexacroResult takeOffApproval(@ParamDataSet(name="in_takeOffApply")TakeOffApplyDTO_NEX dto) throws Exception {
		admService.takeOffApproval(dto);
		return new NexacroResult();
	}
	
	// 복학 처리
	@RequestMapping("returnApproval.nex")
	public NexacroResult returnApproval(@ParamDataSet(name="in_returnApply")ReturnApplyDTO_NEX dto) throws Exception {
		admService.returnApproval(dto);
		return new NexacroResult();
	}
	
	// 학첨포기 처리
	@RequestMapping("creditRenounceApproval.nex")
	public NexacroResult creditRenounceApproval(@ParamDataSet(name="in_creditRenounce")CreditRenounceDTO_NEX dto) throws Exception {
		admService.creditRenounceApproval(dto);
		return new NexacroResult();		
	}
	
	// 웹하드 이용 명단 가져오기
	@RequestMapping("getCloudStorage.nex")
	public NexacroResult getCloudStorage() {
		NexacroResult nr = new NexacroResult();
		List<CloudStorageDTO> list = admService.getCloudStorage();
		nr.addDataSet("out_cloudStorage",list);
		return nr;
	}
	
	// 웹하드 용량 변경
	@RequestMapping("modifyCloudStorage.nex")
	public NexacroResult modifyStorage(@ParamDataSet(name="in_cloudStorage")List<CloudStorageDTO> list) {
		admService.modifyCloudStorage(list);		
		return new NexacroResult();
	}
}
