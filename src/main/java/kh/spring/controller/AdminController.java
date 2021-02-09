package kh.spring.controller;

import java.util.ArrayList;
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
import kh.spring.dto.LectureDTO;
import kh.spring.dto.NoticeDTO;
import kh.spring.dto.NoticeDTO_NEX;
import kh.spring.dto.ProfessorDTO;
import kh.spring.dto.ProfessorDTO_NEX;
import kh.spring.dto.StudentDTO;
import kh.spring.dto.StudentDTO_NEX;
import kh.spring.service.AdminService;
import kh.spring.utils.ConvertDate;

@Controller
public class AdminController {

	@Autowired
	private AdminService admService;
	
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
