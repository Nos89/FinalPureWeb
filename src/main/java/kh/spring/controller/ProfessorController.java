package kh.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

import kh.spring.dto.LectureDTO;
import kh.spring.dto.MilitaryDTO;
import kh.spring.dto.OpenClass_LecPlan;
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
	
	
}
