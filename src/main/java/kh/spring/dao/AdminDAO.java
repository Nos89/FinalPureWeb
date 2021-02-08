package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.BuildDTO;
import kh.spring.dto.ClassroomDTO;
import kh.spring.dto.CollegeDTO;
import kh.spring.dto.DepartmentDTO;
import kh.spring.dto.LectureDTO;
import kh.spring.dto.NoticeDTO;
import kh.spring.dto.ProfessorDTO;
import kh.spring.dto.StudentDTO;

@Repository
public class AdminDAO {
	
	@Autowired
	private SqlSession db;
	
	// 공지사항 가져오기
	public List<NoticeDTO> getNotice(String category) throws Exception {
		return db.selectList("Admin.getNotice",category);
	}
	
	// 공지사항 검색
	public List<NoticeDTO> searchNotice(String target, String keyword, String category) throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("search_target", target);
		map.put("search_keyword", keyword);
		map.put("category", category);
		return db.selectList("Admin.searchNotice",map);
	}
	
	// 공지사항 식제
	public int deleteNotice(List<NoticeDTO> list) throws Exception {
		return db.delete("deleteNotice",list);
	}
	
	// 게시판 온로드
	public List<BoardDTO> getBoard(String bdDiv) throws Exception {
		return db.selectList("Admin.getBoard", bdDiv);
	}
	
	// 게시판 검색
	public List<BoardDTO> searchBoard(String target, String keyword, String bdDiv) throws Exception {
		Map<String, String> map = new HashMap<>();
		if(target.contentEquals("title")) {target = "b.title";}
		map.put("search_target", target);
		map.put("search_keyword", keyword);
		map.put("bdDiv", bdDiv);
		System.out.println(map.get("search_target")+" / "+map.get("search_keyword")+" / "+map.get("bdDiv"));
		return db.selectList("Admin.searchBoard", map);
	}
	
	// 게시판 삭제
	public int deleteBoard(List<BoardDTO> list) throws Exception {
		return db.delete("Admin.deleteBoard", list);
	}
	
	// 단과대 목록
	public List<CollegeDTO> getCollege() throws Exception {
		return db.selectList("Admin.getCollege");
	}
	
	// 학과 목록
	public List<DepartmentDTO> getDepartment() throws Exception {
		return db.selectList("Admin.getDepartment");
	}
	
	// 교수 목록 가져오기
	public List<ProfessorDTO> getProfessor() throws Exception {
		return db.selectList("Admin.getProfessor");
	}
	
	// 교수 정보 변경
	public int updateProfessor1(List<ProfessorDTO> list) throws Exception {
		return db.update("Admin.updateProfessor1", list);
	}
	public int updateProfessor2(List<ProfessorDTO> list) throws Exception {
		return db.update("Admin.updateProfessor2", list);
	}
	
	// 학생 목록 가져오기
	public List<StudentDTO> getStudentOnLoad() throws Exception {
		return db.selectList("Admin.getStudent");
	}
	
	// 학생 정보 변경
	public int modifyStudent1(List<StudentDTO> list) throws Exception {
		return db.update("Admin.modifyStudent1", list);
	}
	public int modifyStudent2(List<StudentDTO> list) throws Exception {
		return db.update("Admin.modifyStudent2", list);
	}
	
	// 강의계획서 가져오기
	public List<LectureDTO> getSyllabus() {
		return db.selectList("Admin.getSyllabus");
	}

	// 강의계획서 승인
	public int syllabusApproved(LectureDTO dto) {
		return db.update("Admin.syllabusApproved", dto);
	}
	
	// 강의계획서 반려
	public int syllabusRejected(LectureDTO dto) {
		return db.update("Admin.syllabusRejected",dto);
	}
	
	// 건물 정보
	public List<BuildDTO> getBuild(){
		return db.selectList("Admin.getBuildInfo");
	}
	
	// 강의실 정보
	public List<ClassroomDTO> getClassroom(){
		return db.selectList("Admin.getClassroomInfo");
	}
	
	// 강의실 시간표 조회
	public List<LectureDTO> searchTimetable(String classroom, String year, int semester){
		Map<String,Object> map = new HashMap<>();
		map.put("classroom", classroom);
		map.put("year",year);
		map.put("semester",semester);
		return db.selectList("Admin.searchClsTimetable", map);
	}
}
