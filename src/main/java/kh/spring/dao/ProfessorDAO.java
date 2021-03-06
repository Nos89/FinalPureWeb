package kh.spring.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.AttendanceStatusDTO;
import kh.spring.dto.ClassRegistrationDetailDTO;
import kh.spring.dto.DepartmentDTO;
import kh.spring.dto.DepartmentOfficeDTO;
import kh.spring.dto.GradeDTO;
import kh.spring.dto.MilitaryDTO;
import kh.spring.dto.ProAttendMngDTO;
import kh.spring.dto.ProBusinessLog;
import kh.spring.dto.ProListDTO;
import kh.spring.dto.ProScheduleDTO;
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
	
	public int updateProMil(MilitaryDTO mdto) {
		return db.update("Professor.proMillUpdate",mdto);
		
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
	public List<ProScheduleDTO> selectProSchedule(String id){
		return db.selectList("Professor.selectProSchedule",id);
	}
	public int delProSchedule(List<ProScheduleDTO> list) {
		return db.delete("Professor.delProSchedule", list);
	}
	public int insertProSchedule(ProScheduleDTO dto) {
		System.out.println(dto.getSche_date() + dto.getSche_title()+dto.getCheck()+dto.getSche_proId()+dto.getSche_proName());
		return db.insert("Professor.insertProSchedule", dto);	
	}
	public int updateProSchedule(ProScheduleDTO dto) {
		System.out.println("업데이트 실행");
		System.out.println(dto.getSche_title()+dto.getSche_date()+dto.getSche_contents()+dto.getSche_proId()+dto.getSche_seq());
		return db.update("Professor.updateProSchedule", dto);
	}
	
	public List<ClassRegistrationDetailDTO> selectCRDetail(String id){
		return db.selectList("Professor.selectCRDetail", id);
		
	}
	public int insertAttend(ProAttendMngDTO dto) {
		return db.insert("Professor.insertAttend", dto);
	}
	
	public int saveAttend(List<ProAttendMngDTO> list) {
		
		return db.update("Professor.saveAttend", list);
	}
	
	public List<AttendanceStatusDTO> attendCheckAll(String code){
		System.out.println(code);
		return db.selectList("Professor.selectAttCheckAll", code);
		
	}
	public List<GradeDTO> selectGrade(String id){
		return db.selectList("Professor.selectGrade", id);
	}
	public int addGrade(GradeDTO dto) {
		return db.insert("Professor.addGrade", dto);
	}
	public int deleteGrade(GradeDTO dto) {
		return db.delete("Professor.deleteGrade", dto);
	}
	public int updateGrade(List<GradeDTO> list) {
		return db.update("Professor.updateGrade",list);
	}
	public List<ProBusinessLog> getMyDiary(String id){
		return db.selectList("Professor.getMyDiary", id);
	}
	
	public int insertDiary(ProBusinessLog dto) {
		return db.insert("Professor.isnertDiary", dto);
	}
	public int updateDiary(ProBusinessLog dto) {
		return db.update("Professor.updateDiary", dto);
				
	}
	public int deleteDiary(List<ProBusinessLog> list) {
		return db.delete("Professor.deleteDiary", list);
	}
}
