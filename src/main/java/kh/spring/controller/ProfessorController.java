package kh.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

import kh.spring.dto.DepartmentDTO;
import kh.spring.dto.DepartmentOfficeDTO;
import kh.spring.dto.MilitaryDTO;
import kh.spring.dto.ProListDTO;
import kh.spring.dto.ProfessorDTO;
import kh.spring.dto.ProfessorDTO_NEX;
import kh.spring.service.ProfessorService;
@RequestMapping("/professor")
@Controller
public class ProfessorController {
	
	@Autowired
	private ProfessorService pservice;
	
	
	@RequestMapping("/proInfoOnLoad.nex")
	public NexacroResult proInfoOnLoad(@ParamVariable(name="id") String id) {
		NexacroResult nr = new NexacroResult();
		System.out.println("신호옴 :"+id);
		List<ProfessorDTO> infoList = new ArrayList<>();
		infoList = pservice.selectInfo(id);
		
		List<MilitaryDTO> milList = new ArrayList<>();
		milList = pservice.selectMil(id);
	    nr.addDataSet("out_proInfo", infoList);
	    nr.addDataSet("out_proMil", milList);
		return nr;
	}
	
	@RequestMapping("/proInfoSave.nex")
	public NexacroResult proInfoSave(@ParamDataSet(name="in_proInfo") ProfessorDTO_NEX pdto){
		System.out.println("신호옴");
		pservice.updateProInfo(pdto);
		return new NexacroResult();
	}
	
	@RequestMapping("/departmentInfoOnLoad")
	public NexacroResult departmentInfoOnload(@ParamVariable(name="id")String id) {
		NexacroResult nr = new NexacroResult();
		System.out.println(id);
		List<ProListDTO> list = new ArrayList<>();
		list = pservice.selectProList(id);
		
		DepartmentDTO ddto = new DepartmentDTO();
		ddto = pservice.selectDepartment(id); 
		
		DepartmentOfficeDTO odto = new DepartmentOfficeDTO();
		odto = pservice.selectDepartmentOffice(id);
		
		nr.addDataSet("out_department", ddto);
		nr.addDataSet("out_departmentOffice", odto);
		nr.addDataSet("out_proList", list);
		return nr;
	}
}
