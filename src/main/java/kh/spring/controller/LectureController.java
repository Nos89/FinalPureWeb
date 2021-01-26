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
import kh.spring.dto.OpenClass_LecPlan;
import kh.spring.service.LectureService;

@RequestMapping("/lecture")
@Controller
public class LectureController {
	@Autowired
	private LectureService lservice;
	
	@RequestMapping("/lecturePlanOnLoad")
	public NexacroResult lecturePlanOnload(@ParamVariable(name="id") String id) {
		NexacroResult nr = new NexacroResult();
		System.out.println("신호옴");
		List<OpenClass_LecPlan> list = new ArrayList<>();
		list = lservice.selectOpenClass_lecPlan(id);
		
		List<LectureDTO> list2 = new ArrayList<>();
		list2 = lservice.selectLecture(id);
	
		nr.addDataSet("out_openClass", list);
		nr.addDataSet("out_lecture",list2);
		return nr;
	}
	
	@RequestMapping("/lectureInfoOnLoad")
	public NexacroResult lectureInfoOnLoad(@ParamVariable(name="id")String id){
		NexacroResult nr = new NexacroResult();
		System.out.println("신호옴");
		List<OpenClass_LecPlan> list = new ArrayList<>();
		list = lservice.selectOpenClass_lecPlan(id);
		
		List<LectureDTO> list2 = new ArrayList<>();
		list2 = lservice.selectLecture(id);
		
		nr.addDataSet("out_openClass", list);
		nr.addDataSet("out_lecture",list2);
		return nr;
	}
	@RequestMapping("/updateLecturePlan")
	public NexacroResult updateLecturePlan(@ParamDataSet(name="in_lecture")LectureDTO dto) {
		lservice.updateLecturePlan(dto);
		
		return new NexacroResult();
	}
	
	@RequestMapping("/insertLecturePlan")
	public NexacroResult insertLecturePlan(@ParamDataSet(name="in_lecture")LectureDTO dto) {
		lservice.insertLecturePlan(dto);
		return new NexacroResult();
	}

}
