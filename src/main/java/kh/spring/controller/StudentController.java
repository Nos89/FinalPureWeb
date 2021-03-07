package kh.spring.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

import kh.spring.dto.ChangeDeptApplyForStdDTO;
import kh.spring.dto.ClassTimeDTO;
import kh.spring.dto.ClassTimeSearchDTO;
import kh.spring.dto.CollegeDTO;
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
import kh.spring.dto.MyMenuDTO2;
import kh.spring.dto.ProFileDTO;
import kh.spring.dto.ReturnApplyForStdDTO;
import kh.spring.dto.RoomInfoDTO;
import kh.spring.dto.StuUpdateDTO;
import kh.spring.dto.StudentDetailDTO;
import kh.spring.dto.StudentInfoDTO;
import kh.spring.dto.TakeOffApplyForStdDTO;
import kh.spring.service.ProfessorService;
import kh.spring.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService sservice;
	
	@Autowired
	private ProfessorService pservice;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/stuInfoOnLoad.nex")
	public NexacroResult stuInfoOnLoad() {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		StudentInfoDTO infoList = new StudentInfoDTO();
		infoList = sservice.selectStuInfo(id);
		
		List<MilitaryDTO> armyInfoList = new ArrayList<>();
		armyInfoList = sservice.selectArmy(id);
		
		ProFileDTO dto = pservice.checkImg(id);
		
		List<StudentDetailDTO> stuDetailList = new ArrayList<>();
		stuDetailList = sservice.selectStuDetail(id);

		nr.addDataSet("out_stuDetail", stuDetailList);
		nr.addDataSet("out_proFile", dto);
	    nr.addDataSet("out_stuInfo", infoList);
	    nr.addDataSet("out_stuArmy", armyInfoList);
		return nr;
	}
	
	@RequestMapping("/stuInfoSave.nex")
	public NexacroResult stuInfoSave(@ParamDataSet(name="in_update") StuUpdateDTO sdto){
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		int result = sservice.updateStuInfo(sdto,id);
		if(result == 1) {
			nr.setErrorCode(1);
		}else {
			nr.setErrorCode(5);
		}
		return nr;
	}
	
	@RequestMapping("/stuMajorApply.nex")
	public NexacroResult stuMajorApply(@ParamDataSet(name="in_majorApply") MajorApplyDTO mdto,@ParamVariable(name="date") Date e) {
		java.sql.Date s = new java.sql.Date(e.getTime());
		sservice.majorApply(mdto,s);
		return new NexacroResult();
	}
	
	@RequestMapping("/stuTakeOffApply.nex")
	public NexacroResult stuTakeOffApply(@ParamDataSet(name="in_takeOff") TakeOffApplyForStdDTO tdto,@ParamVariable(name="date") Date e) {
		NexacroResult nr = new NexacroResult();
		if(sservice.checkTakeOffApply(tdto.getId()) == 1) {
			System.out.println("신청된 내역이 있음");
		nr.setErrorCode(0);
		}else {
			java.sql.Date s = new java.sql.Date(e.getTime());
			System.out.println("신청된 내역이 없음");
			sservice.takeOffApply(tdto,s);
			nr.setErrorCode(1);
		}
		return nr;
	}
	
	@RequestMapping("/checkStatus.nex")
	public NexacroResult checkStatus() {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		if(sservice.checkStatus(id).contentEquals("휴학")) {
			nr.setErrorCode(1);
		}else {
			nr.setErrorCode(0);
		}
		return nr;
	}
	
	@RequestMapping("/checkStatus2.nex")
	public NexacroResult checkStatus2() {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		if(sservice.checkStatus2(id).contentEquals("재학")) {
			nr.setErrorCode(1);
		}else {
			nr.setErrorCode(0);
		}
		return nr;
	}
	
	@RequestMapping("/stuReturnApply.nex")
	public NexacroResult stuReturnApply(@ParamDataSet(name="in_return") ReturnApplyForStdDTO tdto,@ParamVariable(name="date") Date e) {
		NexacroResult nr = new NexacroResult();
		if(sservice.checkReturnApply(tdto.getId()) == 1) {
			System.out.println("신청된 내역이 있음");
		nr.setErrorCode(0);
		}else {
			java.sql.Date s = new java.sql.Date(e.getTime());
			System.out.println("신청된 내역이 없음");
			sservice.returnApply(tdto,s);
			nr.setErrorCode(1);
		}
		return nr;
	}
	
	@RequestMapping("/takeOffCancel.nex")
	public NexacroResult takeOffCancel() {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		int result = sservice.takeOffCancel(id);
		if(result == 1) {
			nr.setErrorCode(1);
		}else {
			nr.setErrorCode(0);
		}
		return nr;
	}
	
	@RequestMapping("/returnCancel.nex")
	public NexacroResult returnCancel() {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		int result = sservice.returnCancel(id);
		if(result == 1) {
			nr.setErrorCode(1);
		}else {
			nr.setErrorCode(0);
		}
		return nr;
	}
	
	@RequestMapping("/changeDeptCancel.nex")
	public NexacroResult changeDeptCancel() {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		int result = sservice.changeDeptCancel(id);
		if(result == 1) {
			nr.setErrorCode(1);
		}else {
			nr.setErrorCode(0);
		}
		return nr;
	}
	
	@RequestMapping("/stuChangeDeptApply.nex")
	public NexacroResult stuChangeDeptApply(@ParamDataSet(name="in_changeDept") ChangeDeptApplyForStdDTO cdto,@ParamVariable(name="date") Date e) {
		
		NexacroResult nr = new NexacroResult();
		if(sservice.checkChangeDeptApply(cdto.getId()) == 1) {
			System.out.println("신청된 내역이 있음");
		nr.setErrorCode(0);
		}else {
			java.sql.Date s = new java.sql.Date(e.getTime());
			System.out.println("신청된 내역이 없음");
			sservice.changeDeptApply(cdto,s);
			nr.setErrorCode(1);
		}
		return nr;
	}
	
	@RequestMapping("/classTimeSearch.nex")
	public NexacroResult classTimeSearch() {
		NexacroResult nr = new NexacroResult();
		
		List<ClassTimeSearchDTO> ctsList = new ArrayList<>();
		ctsList = sservice.selectAllCTS();
		
		List<CollegeDTO> outCode01 = new ArrayList<>();
		CollegeDTO dto = new CollegeDTO();
		dto.setCol_code("-1");
		dto.setCol_title("--선택--");
		outCode01.add(dto);
		outCode01.addAll(sservice.getCollege());
		
		List<CollegeDTO> outCode02 = new ArrayList<>();
		outCode02.add(dto);
		outCode02.addAll(sservice.getDepartment());
		
		nr.addDataSet("out_classList",ctsList);
		nr.addDataSet("out_code01",outCode01);
		nr.addDataSet("out_code02",outCode02);
		return nr;
	}
	
	@RequestMapping("/roomInfoOnload.nex")
	public NexacroResult roomInfoOnload() {
		NexacroResult nr = new NexacroResult();

		List<RoomInfoDTO> riList = new ArrayList<>();
		riList = sservice.roomInfo();
		
		nr.addDataSet("out_room",riList);
		nr.addDataSet("out_build", sservice.buildInfo());
		
		return nr;
	}
	
	@RequestMapping("/getClassTime.nex")
	public NexacroResult getClassTime(@ParamDataSet(name="in_conditionByRoom") ConditionForRoomInfoDTO cdto) {
		NexacroResult nr = new NexacroResult();

		List<ClassTimeDTO> ctList = new ArrayList<>();
		ctList = sservice.getClassTime(cdto);
		
		nr.addDataSet("out_classTime",ctList);
		
		return nr;
	}
	
	@RequestMapping("/getMyClassTime.nex")
	public NexacroResult getMyClassTime(@ParamDataSet(name="in_condition") ConditionForMyClassDTO cdto) {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		
		List<MyClassTimeDTO> ctList = new ArrayList<>();
		ctList = sservice.getMyClassTime(cdto,id);


		nr.addDataSet("out_classTime",ctList);
		
		return nr;
	}
	
	@RequestMapping("/getMyClass.nex")
	public NexacroResult getMyClass(@ParamDataSet(name="in_condition") ConditionForMyClassDTO cdto) {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		
		List<MyClassDTO> classList = new ArrayList<>();
		classList = sservice.getMyClass(cdto,id);
		
		List<MyClassListDTO> myClassList = new ArrayList<>();
		myClassList = sservice.getMyClassList(cdto,id);
		
		nr.addDataSet("out_myClassList",myClassList);
		nr.addDataSet("out_classList",classList);
		return nr;
	}
	
	@Transactional
	@RequestMapping("/withdrawMyClass.nex")
	public NexacroResult withdrawMyClass(@ParamDataSet(name="in_condition") ConditionForMyClassDTO cdto,@ParamVariable(name="oc_code") String oc_code) {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		if(sservice.checkGrade(id,oc_code) > 0) {
			nr.addVariable("cancel", "점수를 취득한 과목은 취소가 불가능합니다.");
			System.out.println("asd");
			return nr;
		}
		int result = sservice.withdrawMyClass(cdto,id,oc_code);
		if(result == 1) {
			sservice.countDown(oc_code);
			sservice.delAttend(id);
		}
		
		return nr;
	}
	
	@RequestMapping("/getMyGrade.nex")
	public NexacroResult getMyGrade(@ParamDataSet(name="in_condition") ConditionForMyClassDTO cdto) {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		System.out.println(id);
		List<MyGradeDTO> mgList = new ArrayList<>();
		mgList = sservice.getMyGrade(cdto,id);
		
		List<GradeListDTO> glList = new ArrayList<>();
		glList = sservice.getGradeList(cdto,id);
		
		nr.addDataSet("out_myGrade",mgList);
		nr.addDataSet("out_gradeList",glList);
		return nr;
	}
	
	@RequestMapping("/getMyElectivesGrade.nex")
	public NexacroResult getMyElectivesGrade() {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		
		List<GradeListDTO> glList = new ArrayList<>();
		glList = sservice.getMyElectivesGrade(id);
		System.out.println(id);
		nr.addDataSet("out_gradeList",glList);
		return nr;
	}
	
	@RequestMapping("/creditRenounceApply.nex")
	public NexacroResult creditRenounceApply(@ParamVariable(name="code") String code) {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		
		if(sservice.checkCreditRenounceApply(id,code) == 1) {
			nr.setErrorCode(0);
		}else {
			sservice.creditRenounceApply(id,code);
			nr.setErrorCode(1);
		}
		return nr;
	}
	
	@RequestMapping("/creditRenounceCancel.nex")
	public NexacroResult creditRenounceCancel(@ParamVariable(name="code") String code) {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		
			int result = sservice.creditRenounceCancel(id,code);
			if(result == 1) {
				nr.setErrorCode(1);
			}

		return nr;
	}
	
	@RequestMapping("/whichCertification.nex")
	public NexacroResult whichCertification(@ParamVariable(name="name") String name) {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		sservice.gotCertification(id,name);
		
		session.setAttribute("cName", name);

		return nr;
	}
	
	@RequestMapping("/getCertification.nex")
	public String goCertification() {
		String id = (String)session.getAttribute("loginID");
		StudentInfoDTO dto = sservice.selectStuInfo(id);
		List<StudentDetailDTO> stdDetail = sservice.selectStuDetail(id);
		StudentDetailDTO dto2 = stdDetail.get(0);
		int std_year = dto2.getStd_year();
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		String myName = dto.getName();
		String inDate = sdf.format(dto.getInDate());
		String dept = dto.getDept_title();
		String col = dto.getCol_title();
		String birthday = sdf.format(dto.getBirth());
		List<GotMyCertificationDTO> list = sservice.gotMyCertification(id);
		GotMyCertificationDTO gmc = list.get(0);
		String number = gmc.getCer_seq();
		String today = sdf.format(d);
		
		session.setAttribute("inDate", inDate);
		session.setAttribute("number", number);
		session.setAttribute("today", today);
		session.setAttribute("name", myName);
		session.setAttribute("dept", dept);
		session.setAttribute("col", col);
		session.setAttribute("birthday", birthday);
		session.setAttribute("std_year", std_year);
		String cName = (String)session.getAttribute("cName");
	
		if(cName.contentEquals("졸업증명서")) {
			return "certification/graduate";
		}else if(cName.contentEquals("재학증명서")) {
			return "certification/beingInSchool";
		}else if(cName.contentEquals("재적증명서")) {
			return "certification/enrollment";
		}else if(cName.contentEquals("수료증명서")) {
			return "certification/complete";
		}else if(cName.contentEquals("교육비납입증명서")) {
			return "certification/tuition";
		}else if(cName.contentEquals("추천서")) {
			return "certification/reference";
		}else if(cName.contentEquals("성적증명서")) {
			return "certification/grade";
		}else if(cName.contentEquals("학적부")) {
			return "certification/schoolRegister";
		}
		
		return "redirect:/error";
	}
	
	@RequestMapping("/gotMyCertification.nex")
	public NexacroResult gotMyCertification() {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		List<GotMyCertificationDTO> list = new ArrayList<>(); 
		list = sservice.gotMyCertification(id);
		
		nr.addDataSet("out_specificList",list);

		return nr;
	}
	
	@RequestMapping("/stuMyCredit.nex")
	public NexacroResult stuMyCredit() {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		
		int majorGotCredit = sservice.majorGotCredit(id);
		int majorGetCredit = sservice.majorGetCredit(id);
		int totalGotCredit = sservice.totalGotCredit(id);
		int totalGetCredit = sservice.totalGetCredit(id);
		int electivesGotCredit = sservice.electivesGotCredit(id);
		int electivesGetCredit = sservice.electivesGetCredit(id);
		int choiceGotCredit = sservice.choiceGotCredit(id);
		int choiceGetCredit = sservice.choiceGetCredit(id);
		
		nr.addVariable("majorGotCredit", majorGotCredit);
		nr.addVariable("majorGetCredit", majorGetCredit);
		nr.addVariable("totalGotCredit", totalGotCredit);
		nr.addVariable("totalGetCredit", totalGetCredit);
		nr.addVariable("electivesGotCredit", electivesGotCredit);
		nr.addVariable("electivesGetCredit", electivesGetCredit);
		nr.addVariable("choiceGotCredit", choiceGotCredit);
		nr.addVariable("choiceGetCredit", choiceGetCredit);

		return nr;
	}
	
	
	
	@RequestMapping("/jusoSearch.nex")
	public String toJusoSearch() {
		return "jusoopenapisearch";
	}
	
	@RequestMapping("/getMyMenu.nex")
	public NexacroResult getMyMenu() {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		
		List<MyMenuDTO> myMenuList = new ArrayList<>();
		myMenuList = sservice.getMyMenu(id);
		System.out.println(myMenuList.size());
		List<MyMenuDTO2> myMenuList2 = new ArrayList<>();
		for(int i=0; i<myMenuList.size();i++) {
			MyMenuDTO2 mdto = new MyMenuDTO2();
			mdto.setMENU_CD(myMenuList.get(i).getMenu_cd());
			mdto.setUP_MENU_CD(myMenuList.get(i).getUp_menu_cd());
			mdto.setMENU_NM(myMenuList.get(i).getMenu_nm());
			mdto.setMENU_LVL(myMenuList.get(i).getMenu_lvl());
			mdto.setPGM_PATH(myMenuList.get(i).getPgm_path());
			mdto.setPGM_ID(myMenuList.get(i).getPgm_id());
			myMenuList2.add(mdto);
		}
		nr.addDataSet("out_myMenu",myMenuList2);
		
		return nr;
	}
	
	@RequestMapping("/myMenuDel.nex")
	public NexacroResult myMenuDel(@ParamVariable(name="menu_nm") String menu_nm) {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		System.out.println(menu_nm);
		sservice.myMenuDel(menu_nm,id);
		
		return nr;
	}
	
	@RequestMapping("/myMenuAdd.nex")
	public NexacroResult myMenuAdd(@ParamVariable(name="menu_cd") String menu_cd,@ParamVariable(name="up_menu_cd") String up_menu_cd,@ParamVariable(name="menu_nm") String menu_nm,@ParamVariable(name="menu_lvl") String menu_lvl,@ParamVariable(name="pgm_path") String pgm_path,@ParamVariable(name="pgm_id") String pgm_id) {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		if(sservice.checkMyMenu(id,menu_nm) == 1) {
			nr.setErrorCode(0);
		}else {
			int result = sservice.myMenuAdd(id,menu_cd,up_menu_cd,menu_nm,menu_lvl,pgm_path,pgm_id);
			nr.setErrorCode(1);
		}
		return nr;
	}
}
