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
import kh.spring.dto.MajorApplyDTO;
import kh.spring.dto.MilitaryDTO;
import kh.spring.dto.ProFileDTO;
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
		
		ProFileDTO dto = pservice.checkImg("S-1001");
		
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
		id = "S-1001";
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
	
	@RequestMapping("/jusoSearch.nex")
	public String TojusoSearch() {
		return "jusoopenapisearch";
	}
}
