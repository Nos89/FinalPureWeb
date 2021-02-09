package kh.spring.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.ClassTimeSearchDTO;
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
	
	public int majorApply(Map major){
		return db.insert("Student.majorApply",major);
	}
	
	public int takeOffApply(Map takeOff) {
		return db.insert("Student.takeOffApply",takeOff);
	}
	
	public int checkTakeOffApply(String id) {
		return db.selectList("Student.checkTakeOffApply",id).size();
	}
	
	public String checkStatus(String id) {
		return db.selectOne("Student.checkStatus",id);
	}
	
	public int changeDeptApply(Map changeDept) {
		return db.insert("Student.changeDeptApply",changeDept);
	}
	
	public int checkChangeDeptApply(String id) {
		return db.selectList("Student.checkChangeDeptApply",id).size();
	}
	
	public List<ClassTimeSearchDTO> selectAllCTS(){
		return db.selectList("Student.selectAllCTS");
	};
}
