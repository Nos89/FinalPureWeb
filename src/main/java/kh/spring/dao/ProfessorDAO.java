package kh.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.DepartmentDTO;
import kh.spring.dto.DepartmentOfficeDTO;
import kh.spring.dto.MilitaryDTO;
import kh.spring.dto.ProAttendMngDTO;
import kh.spring.dto.ProListDTO;
import kh.spring.dto.ProfessorDTO;

@Repository
public class ProfessorDAO {
	
	@Autowired
	private SqlSession db;
	
	public List<ProfessorDTO> selectProInfo(String id){
		return db.selectList("Professor.selectInfo", id);
	}
	public List<MilitaryDTO> selectMil(String id){
		return db.selectList("Professor.selectMil",id);
	}
	
	public int updateProInfo(ProfessorDTO dto) {
		return db.update("Professor.proInfoUpdate",dto);
	}
	public List<ProListDTO> selectProList(String id){
		return db.selectList("Professor.selectProList", id);
	}
	
	public DepartmentDTO selectDepartment(String id) {
		return db.selectOne("Professor.selectDepartment", id);
	}
	public DepartmentOfficeDTO selectDepartmentOffice(String id) {
		return db.selectOne("Professor.selectDepartmentOffice",id );
	}
	public List<ProAttendMngDTO> selectProAttendMngOnload(String id){
		return db.selectList("Professor.selectProAttendMng", id);
	}
}
