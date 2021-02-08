package kh.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

import kh.spring.dto.ClassRegistrationDetailDTO;
import kh.spring.dto.DepartmentDTO;
import kh.spring.dto.DepartmentOfficeDTO;
import kh.spring.dto.MilitaryDTO;
import kh.spring.dto.OpenClass_LecPlan;
import kh.spring.dto.ProAttendMngDTO;
import kh.spring.dto.ProAttendMngDTO_NEX;
import kh.spring.dto.ProFileDTO;
import kh.spring.dto.ProListDTO;
import kh.spring.dto.ProScheduleDTO;
import kh.spring.dto.ProScheduleDTO_NEX;
import kh.spring.dto.ProfessorDTO;
import kh.spring.dto.ProfessorDTO_NEX;
import kh.spring.service.LectureService;
import kh.spring.service.ProfessorService;
@RequestMapping("/professor")
@Controller
public class ProfessorController {
	
	@Autowired
	private ProfessorService pservice;
	
	@Autowired
	private LectureService lservice;
	
	
	@RequestMapping("/proInfoOnLoad.nex")
	public NexacroResult proInfoOnLoad(@ParamVariable(name="id") String id) {
		NexacroResult nr = new NexacroResult();
		System.out.println("신호옴 :"+id);
		List<ProfessorDTO> infoList = new ArrayList<>();
		infoList = pservice.selectInfo(id);
		
		List<MilitaryDTO> milList = new ArrayList<>();
		milList = pservice.selectMil(id);
		
		ProFileDTO pdto = new ProFileDTO();
		pdto = pservice.checkImg(id);
		
		nr.addDataSet("out_proFile", pdto);
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
	//학과정보보기
	
	@RequestMapping("/departmentInfoOnLoad.nex")
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
	
	//강의별 학생정보보기
	@RequestMapping("/proStudentInfo.nex")
	public NexacroResult proAttendMngOnLoad(@ParamVariable(name="id")String id){
		NexacroResult nr = new NexacroResult();
		List<ProAttendMngDTO> list = new ArrayList<>();
		list = pservice.proAttendMngOnload(id);
		
		nr.addDataSet("out_proAttendMng", list);
		return nr;
	}
	
	@RequestMapping("/proScheduleOnload.nex")
	public NexacroResult proScheduleOnload(@ParamVariable(name="id")String id) {
		NexacroResult nr = new NexacroResult();
		List<ProScheduleDTO> list = new ArrayList<>();
		list = pservice.proScheduleOnload(id);
		nr.addDataSet("out_proSchedule", list);
		return nr;
	}
	
	@RequestMapping("/delProSchedule")
	public NexacroResult delProSchedule(@ParamDataSet(name="in_ds")List<ProScheduleDTO_NEX> list) {
		NexacroResult nr = new NexacroResult();
		int result = pservice.delProSchedule(list);
		if(result != -1) {
			nr.setErrorMsg("성공");
			nr.setErrorCode(1);
		}else {
			nr.setErrorMsg("실패");
			nr.setErrorCode(0);
		}
		return nr;
	}
	
	
	@RequestMapping("/updateProSchedule")
	public NexacroResult updateProSchedule(@ParamDataSet(name="in_ds")ProScheduleDTO_NEX dto, @ParamVariable(name="id")String id) {
		NexacroResult nr = new NexacroResult();
		int result = pservice.updateProSchedule(dto,id);
		if(result >=1) {
			nr.setErrorCode(1);
		}else {
			
			nr.setErrorCode(0);
		}
		
		return nr;
	}
	
	//===============================================================
	@RequestMapping("/attendMngOnLoad.nex")
	public NexacroResult attendMngOnLoad(@ParamVariable(name="id")String id) {
		NexacroResult nr = new NexacroResult();
		System.out.println("넘어왓어용!");
		List<OpenClass_LecPlan> oList = new ArrayList<>();
		oList = lservice.selectOpenClass_lecPlan(id);
		
		List<ProAttendMngDTO_NEX> aList = new ArrayList<>();
		aList = pservice.selectAttendMng(id);
		
		List<ClassRegistrationDetailDTO> cList = new ArrayList<>();
		cList = pservice.selectCRDetail(id);
		
		nr.addDataSet("out_proAttendMng", aList);
		nr.addDataSet("out_openClass",oList);
		nr.addDataSet("out_crDetail", cList);
		return nr;
	}
	@RequestMapping("/insertAttend.nex")
	public NexacroResult inertAttend(@ParamDataSet(name="in_ds")ProAttendMngDTO_NEX dto) {
		System.out.println("넘어왔다구!");
		NexacroResult nr = new NexacroResult();
		pservice.insertAttend(dto);
	
		return nr;
	}
	@RequestMapping("/reAttend")
	public NexacroResult reAttend(@ParamVariable(name="id")String id) {
		NexacroResult nr = new NexacroResult();
		List<ProAttendMngDTO_NEX> aList = new ArrayList<>();
		aList = pservice.selectAttendMng(id);
		
		nr.addDataSet("out_proAttendMng", aList);
		
		return nr;
	}
	
	@RequestMapping("/saveAttend")
	public NexacroResult saveAttend(@ParamDataSet(name="in_ds")List<ProAttendMngDTO_NEX> list) throws Exception {
		NexacroResult nr = new NexacroResult();
		int result = pservice.saveAttend(list);
		return nr;
	}
	
	@ExceptionHandler
	public String Exceptionhandler(Exception e) {
		e.printStackTrace();
		return "error";
	}
}
