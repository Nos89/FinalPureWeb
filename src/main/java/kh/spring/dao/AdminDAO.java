package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardDTO_NEX;
import kh.spring.dto.BuildDTO;
import kh.spring.dto.ChangeDeptApplyDTO;
import kh.spring.dto.ClassroomDTO;
import kh.spring.dto.ColScheduleDTO;
import kh.spring.dto.CollegeDTO;
import kh.spring.dto.CreditRenounceDTO;
import kh.spring.dto.DepartmentDTO;
import kh.spring.dto.FilesDTO;
import kh.spring.dto.LectureDTO;
import kh.spring.dto.MailDTO;
import kh.spring.dto.NoticeDTO;
import kh.spring.dto.ProfessorDTO;
import kh.spring.dto.ReturnApplyDTO;
import kh.spring.dto.StudentDTO;
import kh.spring.dto.StudentDTO_NEX;
import kh.spring.dto.TakeOffApplyDTO;

@Repository
public class AdminDAO {
	
	@Autowired
	private SqlSession db;
	
	// 공지사항 목록 가져오기
	public List<NoticeDTO> getBoardNotice(String category) throws Exception {
		return db.selectList("Admin.getBoardNotice",category);
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
		return db.delete("Admin.deleteNotice",list);
	}
	
	// 공지사항 가져오기
	public NoticeDTO getNotice(int noti_seq) {
		return db.selectOne("Admin.getNotice",noti_seq);
	}
	
	// 공지사항 작성
	public int writeNotice(NoticeDTO dto) {
		 db.insert("Admin.writeNotice",dto);
		return dto.getNoti_seq();
	}
	
	// 공지사항 수정
	public int modifyNotice(NoticeDTO dto) {
		return db.update("Admin.modifyNotice",dto);
	}
	
	// 게시판 목록
	public List<BoardDTO> getBoard(String boardType) throws Exception {
		return db.selectList("Admin.getBoard", boardType);
	}
	
	// 게시판 검색
	public List<BoardDTO> searchBoard(String target, String keyword, String boardType) throws Exception {
		Map<String, String> map = new HashMap<>();
		if(target.contentEquals("title")) {target = "b.title";}
		map.put("search_target", target);
		map.put("search_keyword", keyword);
		map.put("boardType", boardType);
		return db.selectList("Admin.searchBoard", map);
	}
	
	// 게시글 가져오기
	public BoardDTO getPost(int seq) {
		return db.selectOne("Admin.getPost",seq);
	}
	
	// 게시글 첨부파일 가져오기
	public List<FilesDTO> getFiles(int parent_code) {
		return db.selectList("Board.getFiles", parent_code);
	}
	
	// 글쓰기
	public int writePost(BoardDTO dto) {
		db.insert("Board.insert", dto);
		return dto.getSeq();
	}
	
	// 게시글 수정
	public int modifyPost(BoardDTO dto) {
		return db.update("Admin.modifyPost",dto);
	}
	
	// 게시글 삭제
	public int deleteBoard(Map<String, Object> map) throws Exception {
		return db.delete("Admin.deletePosts", map);
	}
	
	
	
	// 단과대 목록
	public List<CollegeDTO> getCollege() {
		return db.selectList("Admin.getCollege");
	}
	
	// 학과 목록
	public List<DepartmentDTO> getDepartment() {
		return db.selectList("Admin.getDepartment");
	}
	
	// 교수 목록 가져오기
	public List<ProfessorDTO> getProfessor() throws Exception {
		return db.selectList("Admin.getProfessor");
	}
	
	// 교수 추가
	public int addProfessor(ProfessorDTO dto) {
		return db.insert("Admin.addProfessor",dto);
	}
	
	// 교수 정보 변경
	public int modifyProfessor(ProfessorDTO dto) {
		db.update("Admin.modifyProfessorP", dto);
		return db.update("Admin.modifyProfessorU", dto);
	}
	
	// 교수 정보 삭제
	public int deleteProfessor(String id) {
		db.delete("Admin.deleteProfessorP",id);
		return db.delete("Admin.deleteProfessorU",id);
	}
	
	// 학생 목록 가져오기
	public List<StudentDTO> getStudentOnLoad() throws Exception {
		return db.selectList("Admin.getStudent");
	}
	
	// 학생 추가
	public int addStudent(StudentDTO dto) {
		return db.insert("Admin.addStudent",dto);
	}
	
	// 학생 정보 변경
	public int modifyStudent(StudentDTO dto) {
		db.update("Admin.modifyStudentS",dto);
		return db.update("Admin.modifyStudentU", dto);
	}
	
	// 학생 정보 삭제
	public int deleteStudent(String id) {
		db.delete("Admin.deleteStudentS",id);
		return db.delete("Admin.deleteStudentU",id);
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
	
	
	
	// 학사일정 조회
	public List<ColScheduleDTO> getColSchedule(){
		return db.selectList("Admin.getColSchedule");
	}
	
	// 학사일정 추가
	public int addColSchedule(ColScheduleDTO dto){
		return db.insert("Admin.addColSchedule", dto);
	}
	
	//학사일정 수정
	public int updateColSchedule(ColScheduleDTO dto) {
		return db.update("Admin.updateColSchedule",dto);
	}
	
	// 학사일정 삭제
	public int delColSchedule(int seq) {
		return db.delete("Admin.delColSchedule",seq);
	}
	
	
	
	// 전과신청 목록
	public List<ChangeDeptApplyDTO> getChangeDeptApply(){
		return db.selectList("Admin.getChangeDeptApply");
	}
	
	// 전과신청 처리
	public int changeDeptApproval(ChangeDeptApplyDTO dto) {
		return db.update("Admin.changeDeptApproval",dto);
	}
	
	// 휴학신청 목록
	public List<TakeOffApplyDTO> getTakeOffApply(){
		return db.selectList("Admin.getTakeOffApply");
	}
	
	// 휴학신청 처리
	public int takeOffApproval(TakeOffApplyDTO dto) {
		return db.update("Admin.takeOffApproval",dto);
	}
	
	// 복학신청 목록
	public List<ReturnApplyDTO> getReturnApply(){
		return db.selectList("Admin.getReturnApply");
	}
	
	// 복학신청 처리
	public int returnApproval(ReturnApplyDTO dto){
		return db.update("Admin.returnApproval",dto);
	}
	
	// 학점포기신청 목록
	public List<CreditRenounceDTO> getCreditRenounceApply(){
		return db.selectList("Admin.getCreditRenounce");
	}
	
	// 학점포기신청 처리
	public int creditRenounceApproval(CreditRenounceDTO dto) {
		return db.update("Admin.creditRenounce",dto);
	}
	
	// 신청결과 메일 통지
	public int sendMail(MailDTO dto) {
		return db.insert("Admin.sendMail",dto);
	}
	
	// 수신인 목록
	public List<StudentDTO> getReceiverList(){
		return db.selectList("Admin.getReceiverList");
	}
	
	// 수신인 이름
	public List<StudentDTO> getReceiverName(){
		return db.selectList("Admin.getReceiverName");
	}
	
	// 발신메일함 목록
	public List<MailDTO> getOutBox(){
		return db.selectList("Admin.getOutBox");
	}
}