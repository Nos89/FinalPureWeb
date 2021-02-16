package kh.spring.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.StudentDAO;
import kh.spring.dto.ChangeDeptApplyDTO;
import kh.spring.dto.ClassTimeDTO;
import kh.spring.dto.ClassTimeSearchDTO;
import kh.spring.dto.ConditionForMyClassDTO;
import kh.spring.dto.ConditionForRoomInfoDTO;
import kh.spring.dto.GradeListDTO;
import kh.spring.dto.MajorApplyDTO;
import kh.spring.dto.MilitaryDTO;
import kh.spring.dto.MyClassDTO;
import kh.spring.dto.MyClassListDTO;
import kh.spring.dto.MyClassTimeDTO;
import kh.spring.dto.MyGradeDTO;
import kh.spring.dto.RoomInfoDTO;
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
	
	public List<RoomInfoDTO> roomInfo(){
		return sdao.roomInfo();
	}
	
	public List<ClassTimeDTO> getClassTime(ConditionForRoomInfoDTO dto){
		return sdao.getClassTime(dto);
	}
	
	public List<MyClassTimeDTO> getMyClassTime(ConditionForMyClassDTO dto,String id){
		Map<String, Object> myClass = new HashMap<>();
		myClass.put("dto", dto);
		myClass.put("id",id);
		return sdao.getMyClassTime(myClass);
	}
	
	public List<MyClassDTO> getMyClass(ConditionForMyClassDTO dto,String id){
		Map<String, Object> myClass = new HashMap<>();
		myClass.put("dto", dto);
		myClass.put("id",id);
		return sdao.getMyClass(myClass);
	}
	
	public List<MyClassListDTO> getMyClassList(ConditionForMyClassDTO dto,String id){
		Map<String, Object> myClass = new HashMap<>();
		myClass.put("dto", dto);
		myClass.put("id",id);
		return sdao.getMyClassList(myClass);
	}
	
	public int withdrawMyClass(ConditionForMyClassDTO dto,String id,String oc_code) {
		Map<String, Object> myClass = new HashMap<>();
		myClass.put("dto", dto);
		myClass.put("id",id);
		myClass.put("oc_code", oc_code);
		return sdao.withdrawMyClass(myClass);
	}
	
	public int countDown(String oc_code) {
		return sdao.countDown(oc_code);
	}
	
	public List<MyGradeDTO> getMyGrade(ConditionForMyClassDTO dto,String id){
		Map<String, Object> myGrade = new HashMap<>();
		myGrade.put("dto", dto);
		myGrade.put("id",id);
		return sdao.getMyGrade(myGrade);
	}
	
	public List<GradeListDTO> getGradeList(ConditionForMyClassDTO dto,String id){
		Map<String, Object> myGrade = new HashMap<>();
		myGrade.put("dto", dto);
		myGrade.put("id",id);
		return sdao.getGradeList(myGrade);
	}
	
	public int creditRenounceApply(String id, String code) {
		Map<String, Object> apply = new HashMap<>();
		apply.put("code", code);
		apply.put("id",id);
		return sdao.creditRenounceApply(apply);
	}
	
	public int checkCreditRenounceApply(String id, String code) {
		Map<String, Object> check = new HashMap<>();
		check.put("code", code);
		check.put("id",id);
		return sdao.checkCreditRenounceApply(check);
	}
	
	public int creditRenounceCancel(String id, String code) {
		Map<String, Object> cancel = new HashMap<>();
		cancel.put("code", code);
		cancel.put("id",id);
		return sdao.creditRenounceCancel(cancel);
	}
	
}
