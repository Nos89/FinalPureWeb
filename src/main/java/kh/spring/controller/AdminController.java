package kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardDTO_NEX;
import kh.spring.dto.BuildDTO;
import kh.spring.dto.ClassroomDTO;
import kh.spring.dto.ColScheduleDTO;
import kh.spring.dto.ColScheduleDTO_NEX;
import kh.spring.dto.CollegeDTO;
import kh.spring.dto.DepartmentDTO;
import kh.spring.dto.FilesDTO;
import kh.spring.dto.LectureDTO;
import kh.spring.dto.NoticeDTO;
import kh.spring.dto.NoticeDTO_NEX;
import kh.spring.dto.ProfessorDTO;
import kh.spring.dto.ProfessorDTO_NEX;
import kh.spring.dto.StudentDTO;
import kh.spring.dto.StudentDTO_NEX;
import kh.spring.service.AdminService;
import kh.spring.service.BoardService;
import kh.spring.utils.ConvertDate;

@Controller
public class AdminController {

	@Autowired
	private AdminService admService;
	
	
	@Autowired
	private BoardService bService;
	
	// 공지사항 로드
	@RequestMapping("NoticeOnLoad.nex")
	public NexacroResult noticeOnLoad(@ParamVariable(name="category")String category) throws Exception{
		NexacroResult nr = new NexacroResult();
		List<NoticeDTO> list = admService.getNotice(category);
		int rowCount = list.size();
		nr.addDataSet("out_notice", list);
		nr.addVariable("totalRowCount",rowCount);
		return nr;
	}
	
	// 공지사항 탭 변경
	@RequestMapping("NoticeTabChanged.nex")
	public NexacroResult notiTabChanged(@ParamVariable(name="category")String category) throws Exception {
		NexacroResult nr = new NexacroResult();
		List<NoticeDTO> list = admService.getNotice(category);
		int rowCount = list.size();
		nr.addDataSet("out_notice",list);
		nr.addVariable("totalRowCount",rowCount);
		return nr;
	}
	
	// 공지사항 검색
	@RequestMapping("SearchNotice.nex")
	public NexacroResult searchNotice(@ParamVariable(name="sTarget")String target, @ParamVariable(name="sKeyword")String keyword, @ParamVariable(name="category")String category) throws Exception {
		NexacroResult nr = new NexacroResult();
		List<NoticeDTO> list = admService.searchNotice(target, keyword, category);
		int rowCount = list.size();
		nr.addDataSet("out_notice",list);
		nr.addVariable("totalRowCount",rowCount);
		return nr;
	}
	
	// 공지사항 삭제
	@RequestMapping("DeleteNotice.nex")
	public NexacroResult deleteNotice(@ParamDataSet(name="in_notice")List<NoticeDTO_NEX> list) throws Exception {
		admService.deleteNotice(list);
		return new NexacroResult();
	}
	
	// 공지사항 작성
	
	// 홍보게시글 작성폼
	@RequestMapping("GoWritePromo.nex")
	public String goWritePage() {
		return "admin/boardWrite";
	}
	
	//자료게시판 등록폼
	@RequestMapping("GoWriteArchives.nex")
	public String GoWriteArchives() {
		return "admin/boardWrite2";
		
	}
	//게시판 등록
	@RequestMapping("boardWrite.nex")
	public NexacroResult boardWrite(@ParamDataSet(name="in_ds")BoardDTO_NEX dto) {
		NexacroResult nr = new NexacroResult();
		int result =bService.writeArticle_NEX(dto);
		
		nr.addVariable("param", result);
		
		return nr;
	}
	
//	// 홍보게시글 작성
//	@RequestMapping("WriteBoardPromo.nex")
//	public String writePost() {
//		
//	}
	
	// 게시판 로드
	@RequestMapping("BoardOnLoad.nex")
	public NexacroResult getBoard(@ParamVariable(name="bdDiv")String bdDiv) throws Exception {
		NexacroResult nr = new NexacroResult();
		List<BoardDTO> list = admService.getBoard(bdDiv);

		int rowCount = list.size();
		nr.addDataSet("out_board",list);
		nr.addVariable("totalRowCount",rowCount);
		return nr;
	}
	
	// 게시판 검색
	@RequestMapping("SearchBoard.nex")
	public NexacroResult searchBoard(@ParamVariable(name="sTarget")String target, @ParamVariable(name="sKeyword")String keyword, @ParamVariable(name="bdDiv")String bdDiv) throws Exception {
		NexacroResult nr = new NexacroResult();
		System.out.println("target: "+target+" | keyword: "+keyword+" | bdDiv: "+bdDiv);
		List<BoardDTO> list = admService.searchBoard(target, keyword, bdDiv);
		int rowCount = list.size();
		nr.addDataSet("out_board",list);
		nr.addVariable("totalRowCount", rowCount);
		return nr;
	}
	
	// 게시판 삭제
	@RequestMapping("DeleteBoard.nex")
	public NexacroResult deleteBoard(@ParamDataSet(name="in_board")List<BoardDTO_NEX> list) throws Exception {
		admService.deleteBoard(list);
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
	
	//게시판 수정하기
	@RequestMapping("updateBoard.nex")
	public NexacroResult updateBoard(@ParamDataSet(name="in_board")BoardDTO_NEX dto){
		NexacroResult nr = new NexacroResult();
		int result = admService.updateBoard(dto);
		if(result >0) {
			nr.setErrorCode(1);
			nr.addVariable("param", dto.getSeq());
		}else {
			nr.setErrorCode(0);	
		}
		return nr;
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
	
	// 교수 등록
	@RequestMapping("ProfessorUpdate.nex")
	public NexacroResult updateProfessor(@ParamDataSet(name="in_pro")List<ProfessorDTO_NEX> list) throws Exception {
		admService.updateProfessor1(list);
		admService.updateProfessor2(list);
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
	
	// 학생 등록
	@RequestMapping("StudentUpdate.nex")
	public NexacroResult modifyStudent(@ParamDataSet(name="in_std")List<StudentDTO_NEX> list) throws Exception {
		System.out.println(list.size());
		admService.modifyStudent1(list);
		admService.modifyStudent2(list);
		return new NexacroResult();
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
		nr.addDataSet("out_colSchedule",list);
		return nr;
	}
	
	// 학사일정 추가
	@RequestMapping("ColScheduler.nex")
	public NexacroResult colScheduler(@ParamDataSet(name="in_colScheduler")ColScheduleDTO_NEX dto, @ParamVariable(name="code")String code) throws Exception {
		
		ColScheduleDTO dto2 = new ColScheduleDTO();
		dto2.setSeq(dto.getSeq());
		dto2.setTitle(dto.getTitle());
		dto2.setContents(dto.getContents());
		dto2.setSche_startDate(ConvertDate.stringToDate(dto.getSche_startDate()));
		dto2.setSche_endDate(ConvertDate.stringToDate(dto.getSche_endDate()));
		
		if(code.contentEquals("new")) {
			System.out.println("일정 추가 요청");
			int result = admService.addColSchedule(dto2);
			System.out.println("일정 추가: "+result);
		}else if(code.contentEquals("modify")) {
			System.out.println("일정 수정 요청");
			int result = admService.updateColSchedule(dto2);
			System.out.println("일정 수정: "+result);
		}else if(code.contentEquals("delete")) {
			
		}else {
			System.out.println("코드 에러");
		}
		return new NexacroResult();
	}
	
}
