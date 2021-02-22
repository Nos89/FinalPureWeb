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
import kh.spring.dto.GotMyCertificationDTO;
import kh.spring.dto.GradeListDTO;
import kh.spring.dto.MajorApplyDTO;
import kh.spring.dto.MilitaryDTO;
import kh.spring.dto.MyClassDTO;
import kh.spring.dto.MyClassListDTO;
import kh.spring.dto.MyClassTimeDTO;
import kh.spring.dto.MyGradeDTO;
import kh.spring.dto.MyMenuDTO;
import kh.spring.dto.RoomInfoDTO;
import kh.spring.dto.StuUpdateDTO;
import kh.spring.dto.StudentDetailDTO;
import kh.spring.dto.StudentInfoDTO;
import kh.spring.dto.TakeOffApplyDTO;

@Service
public class StudentService {
	
	@Autowired
	private StudentDAO sdao;
	
	public List<StudentInfoDTO> selectAllInfo(String id){		
		return sdao.selectAllInfo(id);
	}
	
	public StudentInfoDTO selectStuInfo(String id){		
		return sdao.selectStuInfo(id);
	}
	
	public List<MilitaryDTO> selectArmy(String id){
		return sdao.selectArmy(id);		
	}
	
	public List<StudentDetailDTO> selectStuDetail(String id){
		return sdao.selectStuDetail(id);		
	}
	
	public int updateStuInfo(StuUpdateDTO dto,String id) {
		Map<String, Object> info = new HashMap<>();
		info.put("dto", dto);
		info.put("id", id);
		return sdao.updateStuInfo(info);
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
	
	public List<GradeListDTO> getMyElectivesGrade(String id){
		return sdao.getMyElectivesGrade(id);
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
	
	public int gotCertification(String id,String name) {
		Map<String, Object> docu = new HashMap<>();
		docu.put("name", name);
		docu.put("id",id);
		return sdao.gotCertification(docu);
	}
	
	public List<GotMyCertificationDTO> gotMyCertification(String id){
		return sdao.gotMyCertification(id);
	}
	
	public int majorGotCredit(String id) {
		return sdao.majorGotCredit(id);
	}
	public int majorGetCredit(String id) {
		return sdao.majorGetCredit(id);
	}
	public int totalGotCredit(String id) {
		return sdao.totalGotCredit(id);
	}
	public int totalGetCredit(String id) {
		return sdao.totalGetCredit(id);
	}
	public int electivesGotCredit(String id) {
		return sdao.electivesGotCredit(id);
	}
	public int electivesGetCredit(String id) {
		return sdao.electivesGetCredit(id);
	}
	public int choiceGotCredit(String id) {
		return sdao.choiceGotCredit(id);
	}
	public int choiceGetCredit(String id) {
		return sdao.choiceGetCredit(id);
	}
	
	public List<MyMenuDTO> getMyMenu(String id){
		return sdao.getMyMenu(id);
	}
	
	public int myMenuAdd(String id,String menu_cd,String up_menu_cd,String menu_nm,String menu_lvl,String pgm_path,String pgm_id) {
		Map<String, Object> menu = new HashMap<>();
		menu.put("MENU_CD", menu_cd);
		menu.put("UP_MENU_CD", up_menu_cd);
		menu.put("MENU_NM", menu_nm);
		menu.put("MENU_LVL", menu_lvl);
		menu.put("PGM_PATH", pgm_path);
		menu.put("PGM_ID", pgm_id);
		menu.put("id",id);
		return sdao.myMenuAdd(menu);
	}
	
	public int myMenuDel(String menu_nm,String id) {
		Map<String, Object> menu = new HashMap<>();
		menu.put("MENU_NM", menu_nm);
		menu.put("id",id);
		return sdao.myMenuDel(menu);
	}
	
	public int checkMyMenu(String id,String menu_nm) {
		Map<String, Object> menu = new HashMap<>();
		menu.put("id", id);
		menu.put("MENU_NM", menu_nm);
		return sdao.checkMyMenu(menu);
	}
}
