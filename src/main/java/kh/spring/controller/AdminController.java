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

import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardDTO_NEX;
import kh.spring.dto.BuildDTO;
import kh.spring.dto.ClassroomDTO;
import kh.spring.dto.ColScheduleDTO;
import kh.spring.dto.ColScheduleDTO_NEX;
import kh.spring.dto.CollegeDTO;
import kh.spring.dto.DepartmentDTO;
import kh.spring.dto.LectureDTO;
import kh.spring.dto.NoticeDTO;
import kh.spring.dto.NoticeDTO_NEX;
import kh.spring.dto.ProfessorDTO;
import kh.spring.dto.ProfessorDTO_NEX;
import kh.spring.dto.StudentDTO;
import kh.spring.dto.StudentDTO_NEX;
import kh.spring.service.AdminService;
import kh.spring.service.CommentService;
import kh.spring.utils.ConvertDate;

@Controller
public class AdminController {

	@Autowired
	private AdminService admService;
	@Autowired
	CommentService cservice;
	
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
		admService.writeNotice(dto);
		return new NexacroResult();
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
		System.out.println("게시판 타입: "+boardType);
		if(boardType.contentEquals("notice")) {
			NoticeDTO dto = admService.getNotice(seq);
			nr.addDataSet("out_notice",dto);
		}else {
			BoardDTO dto = admService.getPost(seq);
			nr.addDataSet("out_board",dto);
		}
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
		int seq = admService.writePost(dto);
		return new NexacroResult();
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
	public NexacroResult updateProfessor(@ParamDataSet(name="in_pro")List<ProfessorDTO_NEX> list) throws Exception {
		admService.updateProfessor1(list); // user 테이블
		admService.updateProfessor2(list); // professor 테이블
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
}
