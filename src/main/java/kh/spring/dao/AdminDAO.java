package kh.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.NoticeDTO;
import kh.spring.dto.ProfessorDTO;
import kh.spring.dto.StudentDTO;

@Repository
public class AdminDAO {
	
	@Autowired
	private SqlSession db;
	
	// 공지사항 가져오기
	public List<NoticeDTO> getNotice() throws Exception {
		return db.selectList("Admin.getNotice");
	}
	
	// 교수 목록 가져오기
	public List<ProfessorDTO> getProfessor() throws Exception {
		return db.selectList("Admin.getProfessor");
	}
	
	// 교수 명단에 등록
	public int addProfessor(List<ProfessorDTO> list) throws Exception {
		return db.insert("Admin.addProfessor", list);
	}
	
	// 학생 목록 가져오기
	public List<StudentDTO> getStudentOnLoad() throws Exception {
		return db.selectList("Admin.getStudent");
	}
	
	// 학생 명단 등록
	public int addStudent(List<StudentDTO> list) throws Exception {
		return db.insert("Admin.addStudent", list);
	}
}
