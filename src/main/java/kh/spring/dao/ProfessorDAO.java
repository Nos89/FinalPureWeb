package kh.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.LectureDTO;
import kh.spring.dto.MilitaryDTO;
import kh.spring.dto.OpenClass_LecPlan;
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
		return db.update("Professor.proInfoUpdate",dto);
	
	}
	

}
