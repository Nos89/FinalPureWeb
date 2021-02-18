package kh.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

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
import kh.spring.dto.ProFileDTO;
import kh.spring.dto.RoomInfoDTO;
import kh.spring.dto.StudentDetailDTO;
import kh.spring.dto.StudentInfoDTO;
import kh.spring.dto.TakeOffApplyDTO;
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
		List<StudentInfoDTO> infoList = new ArrayList<>();
		infoList = sservice.selectAllInfo(id);
		
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
	public NexacroResult stuInfoSave(@ParamDataSet(name="in_stuInfo") StudentInfoDTO sdto){
		sservice.updateStuInfo(sdto);
		return new NexacroResult();
	}
	
	@RequestMapping("/stuMajorApply.nex")
	public NexacroResult stuMajorApply(@ParamDataSet(name="in_majorApply") MajorApplyDTO mdto,@ParamVariable(name="date") Date e) {
		java.sql.Date s = new java.sql.Date(e.getTime());
		sservice.majorApply(mdto,s);
		return new NexacroResult();
	}
	
	@RequestMapping("/stuTakeOffApply.nex")
	public NexacroResult stuTakeOffApply(@ParamDataSet(name="in_takeOff") TakeOffApplyDTO tdto,@ParamVariable(name="date") Date e) {
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
	
	@RequestMapping("/stuChangeDeptApply.nex")
	public NexacroResult stuChangeDeptApply(@ParamDataSet(name="in_changeDept") ChangeDeptApplyDTO cdto,@ParamVariable(name="date") Date e) {
		
		cdto.setChangeDept(cdto.getChangeDept().replace(cdto.getChangeCollege(), ""));
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
		
		nr.addDataSet("out_classList",ctsList);
		
		return nr;
	}
	
	@RequestMapping("/roomInfoOnload.nex")
	public NexacroResult roomInfoOnload() {
		NexacroResult nr = new NexacroResult();

		List<RoomInfoDTO> riList = new ArrayList<>();
		riList = sservice.roomInfo();
		
		nr.addDataSet("out_room",riList);
		
		return nr;
	}
	
	@RequestMapping("/getClassTime.nex")
	public NexacroResult getClassTime(@ParamDataSet(name="in_condition") ConditionForRoomInfoDTO cdto) {
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
	
	@RequestMapping("/withdrawMyClass.nex")
	public NexacroResult withdrawMyClass(@ParamDataSet(name="in_condition") ConditionForMyClassDTO cdto,@ParamVariable(name="oc_code") String oc_code) {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		int result = sservice.withdrawMyClass(cdto,id,oc_code);
		if(result == 1) {
			sservice.countDown(oc_code);
		}
		
		return nr;
	}
	
	@RequestMapping("/getMyGrade.nex")
	public NexacroResult getMyGrade(@ParamDataSet(name="in_condition") ConditionForMyClassDTO cdto) {
		NexacroResult nr = new NexacroResult();
		String id = (String)session.getAttribute("loginID");
		
		List<MyGradeDTO> mgList = new ArrayList<>();
		mgList = sservice.getMyGrade(cdto,id);
		
		List<GradeListDTO> glList = new ArrayList<>();
		glList = sservice.getGradeList(cdto,id);
		
		nr.addDataSet("out_myGrade",mgList);
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
	
	@RequestMapping("/jusoSearch.nex")
	public String TojusoSearch() {
		return "jusoopenapisearch";
	}
}
