package kh.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

import kh.spring.dto.MilitaryDTO;
import kh.spring.dto.ProFileDTO;
import kh.spring.dto.StudentDetailDTO;
import kh.spring.dto.StudentInfoDTO;
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
	
	@RequestMapping("/jusoSearch.nex")
	public String TojusoSearch() {
		return "jusoopenapisearch";
	}
}
