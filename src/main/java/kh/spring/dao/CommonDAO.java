package kh.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.CollegeDTO;
import kh.spring.dto.DepartmentDTO;
import kh.spring.dto.IsuDTO;
import kh.spring.dto.SubjectDTO;

@Repository
public class CommonDAO {
	@Autowired
	private SqlSession db;
	
	public List<SubjectDTO> getSubject(){
		return db.selectList("Common.getSubject");
	}
	public List<DepartmentDTO> getDepartment(){
		return db.selectList("Common.getDepartment");
	}
	public List<IsuDTO> getIsu(){
		return db.selectList("Common.getIsu");
	}
	public List<CollegeDTO> getCollege(){
		return db.selectList("Common.getCollege");
	}
}
