package kh.spring.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MilitaryDTO;
import kh.spring.dto.ProfessorDTO;

@Repository
public class ProfessorDAO {
	
	@Autowired
	private SqlSession db;
	
	public List<ProfessorDTO> selectProInfo(String id){
		return db.selectList("Professor.selectInfo", id);
	};

	public List<MilitaryDTO> selectMil(String id){
		return db.selectList("Professor.selectMil",id);
	};
	
	public int updateProInfo(ProfessorDTO dto) {
		System.out.println("여기까지옴");
		int result = db.update("Professor.proInfoUpdate",dto);
		System.out.println("성공함");
		return result;
	}
}
