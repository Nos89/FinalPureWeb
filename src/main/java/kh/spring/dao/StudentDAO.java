package kh.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MilitaryDTO;
import kh.spring.dto.StudentDetailDTO;
import kh.spring.dto.StudentInfoDTO;

@Repository
public class StudentDAO {
	
	@Autowired
	private SqlSession db;
	
	public List<StudentInfoDTO> selectStuInfo(String id){
		return db.selectList("Student.selectAllInfo",id);
	};
	
	public List<MilitaryDTO> selectArmy(String id){
		return db.selectList("Student.selectArmy",id);
	};
	
	public List<StudentDetailDTO> selectStuDetail(String id){
		return db.selectList("Student.selectStuDetail",id);
	};
	
	public int updateStuInfo(StudentInfoDTO dto) {
		int result = db.update("Student.stuInfoUpdate",dto);
		return result;
	}

}
