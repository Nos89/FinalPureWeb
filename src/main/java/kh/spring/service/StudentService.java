package kh.spring.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.StudentDAO;
import kh.spring.dto.ChangeDeptApplyDTO;
import kh.spring.dto.ClassTimeSearchDTO;
import kh.spring.dto.MajorApplyDTO;
import kh.spring.dto.MilitaryDTO;
import kh.spring.dto.StudentDetailDTO;
import kh.spring.dto.StudentInfoDTO;
import kh.spring.dto.TakeOffApplyDTO;

@Service
public class StudentService {
	
	@Autowired
	private StudentDAO sdao;
	
	public List<StudentInfoDTO> selectAllInfo(String id){		
		return sdao.selectStuInfo(id);
	}
	
	public List<MilitaryDTO> selectArmy(String id){
		return sdao.selectArmy(id);		
	}
	
	public List<StudentDetailDTO> selectStuDetail(String id){
		return sdao.selectStuDetail(id);		
	}
	
	public int updateStuInfo(StudentInfoDTO dto) {
		return sdao.updateStuInfo(dto);
	}
	
	public int majorApply(MajorApplyDTO dto,Date date){
		Map<String, Object> major = new HashMap<>();
		major.put("dto", dto);
		major.put("date",date);
		return sdao.majorApply(major);
	}
	
	public int takeOffApply(TakeOffApplyDTO dto,Date date){
		Map<String, Object> takeOff = new HashMap<>();
		takeOff.put("dto", dto);
		takeOff.put("date",date);
		return sdao.takeOffApply(takeOff);
	}
	
	public int checkTakeOffApply(String id) {
		return sdao.checkTakeOffApply(id);
	}
	
	public String checkStatus(String id) {
		return sdao.checkStatus(id);
	}
	
	public int changeDeptApply(ChangeDeptApplyDTO dto,Date date){
		Map<String, Object> changeDept = new HashMap<>();
		changeDept.put("dto", dto);
		changeDept.put("date",date);
		return sdao.changeDeptApply(changeDept);
	}
	
	public int checkChangeDeptApply(String id) {
		return sdao.checkChangeDeptApply(id);
	}
	
	public List<ClassTimeSearchDTO> selectAllCTS(){		
		return sdao.selectAllCTS();
	} 
}
