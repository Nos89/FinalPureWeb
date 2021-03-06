package kh.spring.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.ClassTimeDTO;
import kh.spring.dto.ClassTimeSearchDTO;
import kh.spring.dto.CollegeDTO;
import kh.spring.dto.ConditionForRoomInfoDTO;
import kh.spring.dto.DepartmentDTO;
import kh.spring.dto.GotMyCertificationDTO;
import kh.spring.dto.GradeListDTO;
import kh.spring.dto.MilitaryDTO;
import kh.spring.dto.MyClassDTO;
import kh.spring.dto.MyClassListDTO;
import kh.spring.dto.MyClassTimeDTO;
import kh.spring.dto.MyGradeDTO;
import kh.spring.dto.MyMenuDTO;
import kh.spring.dto.RoomInfoDTO;
import kh.spring.dto.StudentDetailDTO;
import kh.spring.dto.StudentInfoDTO;

@Repository
public class StudentDAO {
	
	@Autowired
	private SqlSession db;
	
	public List<StudentInfoDTO> selectAllInfo(String id){
		return db.selectList("Student.selectAllInfo",id);
	};
	
	public StudentInfoDTO selectStuInfo(String id){
		return db.selectOne("Student.selectAllInfo",id);
	};
	
	public List<MilitaryDTO> selectArmy(String id){
		return db.selectList("Student.selectArmy",id);
	};
	
	public List<StudentDetailDTO> selectStuDetail(String id){
		return db.selectList("Student.selectStuDetail",id);
	};
	
	public int updateStuInfo(Map info) {
		return db.update("Student.stuInfoUpdate",info);
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
	
	public List<RoomInfoDTO> roomInfo(){
		return db.selectList("Student.roomInfo");
	}
	
	public List<ClassTimeDTO> getClassTime(ConditionForRoomInfoDTO dto){
		return db.selectList("Student.getClassTime",dto);
	}
	
	public List<MyClassTimeDTO> getMyClassTime(Map myClass){
		return db.selectList("Student.getMyClassTime",myClass);
	}
	
	public List<MyClassDTO> getMyClass(Map myClass){
		return db.selectList("Student.getMyClass",myClass);
	}
	
	public List<MyClassListDTO> getMyClassList(Map myClass){
		return db.selectList("Student.getMyClassList",myClass);
	}
	
	public int withdrawMyClass(Map myClass) {
		return db.delete("Student.withdrawMyClass",myClass);
	}
	
	public int countDown(String oc_code) {
		return db.update("Student.countDown",oc_code);
	}
	
	public List<MyGradeDTO> getMyGrade(Map myGrade){
		return db.selectList("Student.getMyGrade",myGrade);
	}
	
	public List<GradeListDTO> getGradeList(Map myGrade){
		return db.selectList("Student.getGradeList",myGrade);
	}
	
	public List<GradeListDTO> getMyElectivesGrade(String id){
		return db.selectList("Student.getMyElectivesGrade",id);
	}
	
	public int creditRenounceApply(Map apply) {
		return db.insert("Student.creditRenounceApply",apply);
	}
	
	public int checkCreditRenounceApply(Map check) {
		return db.selectList("Student.checkCreditRenounceApply",check).size();
	}
	
	public int creditRenounceCancel(Map cancel) {
		return db.delete("Student.creditRenounceCancel",cancel);
	}
	
	public int gotCertification(Map docu) {
		return db.insert("Student.gotCertification",docu);
	}
	
	public List<GotMyCertificationDTO> gotMyCertification(String id){
		return db.selectList("Student.gotMyCertification",id);
	}
	
	public int majorGotCredit(String id) {
		return db.selectOne("Student.majorGotCredit",id);
	}
	
	public int majorGetCredit(String id) {
		return db.selectOne("Student.majorGetCredit",id);
	}
	
	public int totalGotCredit(String id) {
		return db.selectOne("Student.totalGotCredit",id);
	}
	
	public int totalGetCredit(String id) {
		return db.selectOne("Student.totalGetCredit",id);
	}
	
	public int electivesGotCredit(String id) {
		return db.selectOne("Student.electivesGotCredit",id);
	}
	
	public int electivesGetCredit(String id) {
		return db.selectOne("Student.electivesGetCredit",id);
	}
	
	public int choiceGotCredit(String id) {
		return db.selectOne("Student.choiceGotCredit",id);
	}
	
	public int choiceGetCredit(String id) {
		return db.selectOne("Student.choiceGetCredit",id);
	}
	
	public List<MyMenuDTO> getMyMenu(String id){
		return db.selectList("Student.getMyMenu",id);
	};
	
	public int myMenuAdd(Map menu) {
		return db.insert("Student.myMenuAdd",menu);
	}
	
	public int myMenuDel(Map menu) {
		return db.delete("Student.myMenuDel",menu);
	}
	
	public int checkMyMenu(Map menu) {
		return db.selectList("Student.checkMyMenu",menu).size();
	}
	
	public List<CollegeDTO> getCollege(){
		return db.selectList("Student.getCollege");
	}
	
	public List<CollegeDTO> getDepartment(){
		return db.selectList("Student.getDepartment");
	}
}
