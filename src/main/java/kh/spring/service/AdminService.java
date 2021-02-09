package kh.spring.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.AdminDAO;
import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardDTO_NEX;
import kh.spring.dto.BuildDTO;
import kh.spring.dto.ClassroomDTO;
import kh.spring.dto.ColScheduleDTO;
import kh.spring.dto.CollegeDTO;
import kh.spring.dto.DepartmentDTO;
import kh.spring.dto.LectureDTO;
import kh.spring.dto.NoticeDTO;
import kh.spring.dto.NoticeDTO_NEX;
import kh.spring.dto.ProfessorDTO;
import kh.spring.dto.ProfessorDTO_NEX;
import kh.spring.dto.StudentDTO;
import kh.spring.dto.StudentDTO_NEX;
import kh.spring.utils.ConvertDate;

@Service
public class AdminService {
	
	@Autowired
	private AdminDAO admdao;
	
	
	// 공지사항 가져오기
	public List<NoticeDTO> getNotice(String category) throws Exception {
		return admdao.getNotice(category);
	}
	
	// 공지사항 검색
	public List<NoticeDTO> searchNotice(String target, String keyword, String category) throws Exception {
		return admdao.searchNotice(target,keyword,category);
	}
	
	// 공지사항 삭제
	public int deleteNotice(List<NoticeDTO_NEX> list) throws Exception {
		List<NoticeDTO> list2 = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			NoticeDTO dto = new NoticeDTO();
			dto.setChk(list.get(i).getChk());
			dto.setNoti_seq(list.get(i).getNoti_seq());
			dto.setNoti_title(list.get(i).getNoti_title());
			dto.setNoti_contents(list.get(i).getNoti_contents());
			dto.setNoti_writeDate(ConvertDate.stringToDate(list.get(i).getNoti_writeDate()));
			dto.setCategory(list.get(i).getCategory());
			list2.add(dto);
		}
		return admdao.deleteNotice(list2);
	}
	
	// 게시판 온로드
	public List<BoardDTO> getBoard(String bdDiv) throws Exception {
		return admdao.getBoard(bdDiv);
	}
	
	// 게시판 검색
	public List<BoardDTO> searchBoard(String target, String keyword, String bdDiv) throws Exception {
		return admdao.searchBoard(target, keyword, bdDiv);
	}
	
	// 게시판 삭제
	public int deleteBoard(List<BoardDTO_NEX> list) throws Exception {
		List<BoardDTO> list2 = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			BoardDTO dto = new BoardDTO();
			dto.setChk(list.get(i).getChk());
			dto.setSeq(list.get(i).getSeq());
			dto.setTitle(list.get(i).getTitle());
			dto.setContents(list.get(i).getContents());
			dto.setWriter(list.get(i).getWriter());
			dto.setWriteDate(ConvertDate.stringToDate(list.get(i).getWriteDate()));
			dto.setBoardType(list.get(i).getBoardType());
			list2.add(dto);
		}
		return admdao.deleteBoard(list2);
	}
	
	// 단과대 목록
	public List<CollegeDTO> getCollege() throws Exception {
		return admdao.getCollege();
	}
	
	// 학과 목록
	public List<DepartmentDTO> getDepartment() throws Exception {
		return admdao.getDepartment();
	}
	
	// 교수 목록 가져오기
	public List<ProfessorDTO> getProfessor() throws Exception {
		return admdao.getProfessor();
	}
	
	// 교수 명단 업데이트
	public int updateProfessor1(List<ProfessorDTO_NEX> list) throws Exception {
		List<ProfessorDTO> list2 = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			ProfessorDTO dto = new ProfessorDTO();
			dto.setId(list.get(i).getId());
			dto.setPw(list.get(i).getPw());
			dto.setName(list.get(i).getName());
			dto.setBirth(ConvertDate.utilToSql(list.get(i).getBirth()));
			dto.setGender(list.get(i).getGender());
			dto.setCountry(list.get(i).getCountry());
			dto.setInDate(ConvertDate.utilToSql(list.get(i).getInDate()));
			dto.setOutDate(ConvertDate.utilToSql(list.get(i).getOutDate()));
			dto.setColcode(list.get(i).getColcode());
			dto.setDeptcode(list.get(i).getDeptcode());
			dto.setCol_title(list.get(i).getCol_title());
			dto.setDept_title(list.get(i).getDept_title());
			dto.setZipcode(list.get(i).getZipcode());
			dto.setAddr1(list.get(i).getAddr1());
			dto.setAddr2(list.get(i).getAddr2());
			dto.setEmail(list.get(i).getEmail());
			dto.setPhone(list.get(i).getPhone());
			dto.setBank(list.get(i).getBank());
			dto.setAccountnum(list.get(i).getAccountnum());
			dto.setPro_office(list.get(i).getPro_office());
			dto.setPro_status(list.get(i).getPro_status());
			list2.add(dto);
		}
		return admdao.updateProfessor1(list2);
	}
	public int updateProfessor2(List<ProfessorDTO_NEX> list) throws Exception {
		List<ProfessorDTO> list2 = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			ProfessorDTO dto = new ProfessorDTO();
			dto.setId(list.get(i).getId());
			dto.setPw(list.get(i).getPw());
			dto.setName(list.get(i).getName());
			dto.setBirth(ConvertDate.utilToSql(list.get(i).getBirth()));
			dto.setGender(list.get(i).getGender());
			dto.setCountry(list.get(i).getCountry());
			dto.setInDate(ConvertDate.utilToSql(list.get(i).getInDate()));
			dto.setOutDate(ConvertDate.utilToSql(list.get(i).getOutDate()));
			dto.setColcode(list.get(i).getColcode());
			dto.setDeptcode(list.get(i).getDeptcode());
			dto.setCol_title(list.get(i).getCol_title());
			dto.setDept_title(list.get(i).getDept_title());
			dto.setZipcode(list.get(i).getZipcode());
			dto.setAddr1(list.get(i).getAddr1());
			dto.setAddr2(list.get(i).getAddr2());
			dto.setEmail(list.get(i).getEmail());
			dto.setPhone(list.get(i).getPhone());
			dto.setBank(list.get(i).getBank());
			dto.setAccountnum(list.get(i).getAccountnum());
			dto.setPro_office(list.get(i).getPro_office());
			dto.setPro_status(list.get(i).getPro_status());
			list2.add(dto);
		}
		return admdao.updateProfessor2(list2);
	}
	
	// 학생 목록 가져오기
	public List<StudentDTO> getStudentOnLoad() throws Exception {
		return admdao.getStudentOnLoad();
	}
	
	// 학생 명단 등록
	public int modifyStudent1(List<StudentDTO_NEX> list) throws Exception {
		List<StudentDTO> list2 = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			StudentDTO dto = new StudentDTO();
			dto.setId(list.get(i).getId());
			dto.setPw(list.get(i).getPw());
			dto.setName(list.get(i).getName());
			Date d1 = ConvertDate.stringToDate(list.get(i).getBirth());
			dto.setBirth(d1);
			dto.setGender(list.get(i).getGender());
			dto.setCountry(list.get(i).getCountry());
			Date d2 = ConvertDate.stringToDate(list.get(i).getInDate());
			dto.setInDate(d2);
			Date d3 = ConvertDate.stringToDate(list.get(i).getOutDate());
			dto.setOutDate(d3);
			dto.setColcode(list.get(i).getColcode());
			dto.setDeptcode(list.get(i).getDeptcode());
			dto.setCol_title(list.get(i).getCol_title());
			dto.setDept_title(list.get(i).getDept_title());
			dto.setZipcode(list.get(i).getZipcode());
			dto.setAddr1(list.get(i).getAddr1());
			dto.setAddr2(list.get(i).getAddr2());
			dto.setEmail(list.get(i).getEmail());
			dto.setPhone(list.get(i).getPhone());
			dto.setBank(list.get(i).getBank());
			dto.setAccountnum(list.get(i).getAccountnum());
			dto.setStd_year(list.get(i).getStd_year());
			dto.setStd_status(list.get(i).getStd_status());
			list2.add(dto);
		}
		return admdao.modifyStudent1(list2);
	}
	
	// 학생 명단 등록
	public int modifyStudent2(List<StudentDTO_NEX> list) throws Exception {
		List<StudentDTO> list2 = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			StudentDTO dto = new StudentDTO();
			dto.setId(list.get(i).getId());
			dto.setPw(list.get(i).getPw());
			dto.setName(list.get(i).getName());
			Date d1 = ConvertDate.stringToDate(list.get(i).getBirth());
			dto.setBirth(d1);
			dto.setGender(list.get(i).getGender());
			dto.setCountry(list.get(i).getCountry());
			Date d2 = ConvertDate.stringToDate(list.get(i).getInDate());
			dto.setInDate(d2);
			Date d3 = ConvertDate.stringToDate(list.get(i).getOutDate());
			dto.setOutDate(d3);
			dto.setColcode(list.get(i).getColcode());
			dto.setDeptcode(list.get(i).getDeptcode());
			dto.setCol_title(list.get(i).getCol_title());
			dto.setDept_title(list.get(i).getDept_title());
			dto.setZipcode(list.get(i).getZipcode());
			dto.setAddr1(list.get(i).getAddr1());
			dto.setAddr2(list.get(i).getAddr2());
			dto.setEmail(list.get(i).getEmail());
			dto.setPhone(list.get(i).getPhone());
			dto.setBank(list.get(i).getBank());
			dto.setAccountnum(list.get(i).getAccountnum());
			dto.setStd_year(list.get(i).getStd_year());
			dto.setStd_status(list.get(i).getStd_status());
			list2.add(dto);
		}
		return admdao.modifyStudent2(list2);
	}
	
	// 강의계획서 가져오기
	public List<LectureDTO> getSyllabus() {
		return admdao.getSyllabus();
	}
	
	// 강의계획서 승인
	public int syllabusApproved(LectureDTO dto) {
		return admdao.syllabusApproved(dto);
	}
	
	// 강의계획서 반려
	public int syllabusRejected(LectureDTO dto) {
		return admdao.syllabusRejected(dto);
	}
	
	// 건물 정보
	public List<BuildDTO> getBuild(){
		return admdao.getBuild();
	}
	
	// 강의실 정보
	public List<ClassroomDTO> getClassroom(){
		return admdao.getClassroom();
	}
	
	// 강의실 정보 조회
	public List<LectureDTO> searchClsTimetable(String classroom, String year, int semester){
		return admdao.searchTimetable(classroom, year, semester);
	}
	
	// 학사일정 조회
	public List<ColScheduleDTO> getColSchedule(){
		return admdao.getColSchedule();
	}
	
	// 학사일정 추가
	public int addColSchedule (ColScheduleDTO dto) {
		return admdao.addColSchedule(dto);
	}
	
	// 학사일정 수정
	public int updateColSchedule (ColScheduleDTO dto) {
		return admdao.updateColSchedule(dto);
	}
}
