package kh.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.ClassRegistrationDTO;

@Repository
public class ClassRegistrationDAO {
	@Autowired
	private SqlSession db;
	
	public List<ClassRegistrationDTO> selectCRList(String id){
		return db.selectList("CR.selectMyList", id);
	}

	public int addClass(ClassRegistrationDTO dto) {
		return db.insert("CR.addClass",dto);
	}
	public int partPlus(ClassRegistrationDTO dto) {
		return db.update("CR.partPlus",dto);
	}
	public int deleteCRList(ClassRegistrationDTO dto) {
		return db.delete("CR.deleteCRList", dto);
	}
}
