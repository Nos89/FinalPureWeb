package kh.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

import kh.spring.dto.AttendanceStatusDTO;
import kh.spring.dto.ClassRegistrationDetailDTO;
import kh.spring.dto.DepartmentDTO;
import kh.spring.dto.DepartmentOfficeDTO;
import kh.spring.dto.GradeCardDTO;
import kh.spring.dto.GradeDTO;
import kh.spring.dto.LectureDTO;
import kh.spring.dto.MilitaryDTO;
import kh.spring.dto.MilitaryDTO_NEX;
import kh.spring.dto.OpenClass_LecPlan;
import kh.spring.dto.ProAttendMngDTO_NEX;
import kh.spring.dto.ProBusinessLog;
import kh.spring.dto.ProBusinessLog_NEX;
import kh.spring.dto.ProFileDTO;
import kh.spring.dto.ProListDTO;
import kh.spring.dto.ProScheduleDTO;
import kh.spring.dto.ProScheduleDTO_NEX;
import kh.spring.dto.ProfessorDTO;
import kh.spring.dto.ProfessorDTO_NEX;
import kh.spring.service.CommonService;
import kh.spring.service.LectureService;
import kh.spring.service.ProfessorService;
@RequestMapping("/professor")
@Controller
public class ProfessorController {
	
	@Autowired
	private ProfessorService pservice;
	
	@Autowired
	private LectureService lservice;
	
	@Autowired
	private CommonService comservice;
	
	
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
	public NexacroResult proInfoSave(@ParamDataSet(name="in_proInfo") ProfessorDTO_NEX pdto, @ParamDataSet(name="in_proMil") MilitaryDTO_NEX mdto){
		pservice.updateProInfo(pdto, mdto);
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
		List<OpenClass_LecPlan> oList = new ArrayList<>();
		oList = lservice.selectOpenClass_lecPlan(id);
	
		List<ClassRegistrationDetailDTO> cList = new ArrayList<>();
		cList = pservice.selectCRDetail(id);
		nr.addDataSet("out_openClass", oList);
		nr.addDataSet("out_crDetail", cList);
		return nr;
	}
	//===================================================개인일정관리
	@RequestMapping("/proScheduleOnload.nex")
	public NexacroResult proScheduleOnload(@ParamVariable(name="id")String id) {
		NexacroResult nr = new NexacroResult();
		List<ProScheduleDTO> list = new ArrayList<>();
		list = pservice.proScheduleOnload(id);
		nr.addDataSet("out_proSchedule", list);
		return nr;
	}
	
	@RequestMapping("/delProSchedule.nex")
	public NexacroResult delProSchedule(@ParamDataSet(name="in_ds")List<ProScheduleDTO_NEX> list)throws Exception {
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
		
	@RequestMapping("/updateProSchedule.nex")
	public NexacroResult updateProSchedule(@ParamDataSet(name="in_ds")ProScheduleDTO_NEX dto, @ParamVariable(name="id")String id)throws Exception {
		NexacroResult nr = new NexacroResult();
		System.out.println(dto.getSche_date() + dto.getSche_title()+dto.getCheck()+dto.getSche_proId()+dto.getSche_proName());
		int result = pservice.updateProSchedule(dto,id);
		if(result >=1) {
			nr.setErrorCode(1);
		}else {
			
			nr.setErrorCode(0);
		}
		
		return nr;
	}
	
	//===============================================================출결관리
	@RequestMapping("/attendMngOnLoad.nex")
	public NexacroResult attendMngOnLoad(@ParamVariable(name="id")String id) {
		NexacroResult nr = new NexacroResult();
		System.out.println(id);
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
	@RequestMapping("/reAttend.nex")
	public NexacroResult reAttend(@ParamVariable(name="id")String id) {
		NexacroResult nr = new NexacroResult();
		List<ProAttendMngDTO_NEX> aList = new ArrayList<>();
		aList = pservice.selectAttendMng(id);
		
		nr.addDataSet("out_proAttendMng", aList);
		
		return nr;
	}
	
	@RequestMapping("/saveAttend.nex")
	public NexacroResult saveAttend(@ParamDataSet(name="in_ds")List<ProAttendMngDTO_NEX> list) throws Exception {
		NexacroResult nr = new NexacroResult();
		int result = pservice.saveAttend(list);
		return nr;
	}
	@RequestMapping("/allAttCheckOnLoad.nex")
	public NexacroResult allAttCheckOnLoad(@ParamVariable(name="id")String id) {
		NexacroResult nr = new NexacroResult();
		List<OpenClass_LecPlan> oList = new ArrayList<>();
		oList = lservice.selectOpenClass_lecPlan(id);
		
		nr.addDataSet("out_ds", oList);
		
		return nr;
	}
	
	@RequestMapping("/attendCheckAll.nex")
	public NexacroResult attendCheckAll(@ParamVariable(name="code")String lec_code) {
		NexacroResult nr = new NexacroResult();
		System.out.println(lec_code);
		List<AttendanceStatusDTO> list = pservice.attendCheckAll(lec_code);
		for(AttendanceStatusDTO d: list) {
			System.out.println(d.getAtt_lecCode()+d.getAttend());
		}
		
		nr.addDataSet("out_ds", list);
		return nr;
	}
	
	
	//=====================================성적정보 입력
	@RequestMapping("/gradeMngOnLoad.nex")
	public NexacroResult gradeMngOnLoad(@ParamVariable(name="id")String id) {
		NexacroResult nr = new NexacroResult();
		List<OpenClass_LecPlan> oList = new ArrayList<>();
		oList = lservice.selectOpenClass_lecPlan(id);
	
		List<ClassRegistrationDetailDTO> cList = new ArrayList<>();
		cList = pservice.selectCRDetail(id);
		
		List<LectureDTO> lList = new ArrayList<>();
		lList = lservice.selectLecture(id);
		
		List<GradeDTO> gList = new ArrayList<>();
		gList = pservice.selectGrade(id);
		
		List<GradeCardDTO> gcList = new ArrayList<>();
		gcList = comservice.getGradeCard();
		
		System.out.println("다가져옴");
		nr.addDataSet("out_openClass", oList);
		nr.addDataSet("out_lecture", lList);
		nr.addDataSet("out_crDetail", cList);
		nr.addDataSet("out_grade", gList);
		nr.addDataSet("out_gradeCard",gcList);
		return nr;
	}
	
	@RequestMapping("/selectGrade.nex")
	public NexacroResult selectGrade(@ParamVariable(name="id")String id) {
		NexacroResult nr = new NexacroResult();
		List<GradeDTO> gList = new ArrayList<>();
		gList = pservice.selectGrade(id);
		
		nr.addDataSet("out_grade", gList);
		return nr;
	}
	
	@RequestMapping("/gradeAdd.nex")
	public NexacroResult gradeAdd(@ParamDataSet(name="in_ds")GradeDTO dto) {
		NexacroResult nr = new NexacroResult();
		System.out.println("신호옴");
		int result = pservice.addGrade(dto);
		nr.setErrorCode(result);
		return nr;
	}
	@RequestMapping("/deleteGrade.nex")
	public NexacroResult deleteGrade(@ParamDataSet(name="in_ds")GradeDTO dto) {
		NexacroResult nr = new NexacroResult();
		int result = pservice.deleteGrade(dto);
		nr.setErrorCode(result);
		return nr;
	}
	
	@RequestMapping("/updateGrade.nex")
	public NexacroResult updateGrade(@ParamDataSet(name="in_ds")List<GradeDTO> list) {
		NexacroResult nr = new NexacroResult();
		int result = pservice.updateGrade(list);
		System.out.println(result);
		return nr;
	}
	//===================================업무일지
	@RequestMapping("/diaryOnLoad.nex")
	public NexacroResult diaryOnLoad(@ParamVariable(name="id")String id) {
		NexacroResult nr = new NexacroResult();
		List<ProBusinessLog> list  = pservice.getMyDiary(id);
		
		nr.addDataSet("out_diary", list);
		return nr;
	}
	
	
	@RequestMapping("/updateDiary.nex")
	public NexacroResult updateDiary(@ParamDataSet(name="in_ds")ProBusinessLog_NEX dto, @ParamVariable(name="id")String id) throws Exception {
		NexacroResult nr = new NexacroResult();
		System.out.println(dto.getBusi_date()+dto.getBusi_proId()+dto.getBusi_proName()+id);
		int result = pservice.updateDiary(dto,id);
		if(result >=1) {
			nr.setErrorCode(1);
		}else {
			
			nr.setErrorCode(0);
		}
		
		return nr;
		
	}
	@RequestMapping("/delProDiary.nex")
	public NexacroResult delProDiary(@ParamDataSet(name="in_ds")List<ProBusinessLog_NEX> list) throws Exception{
		NexacroResult nr = new NexacroResult();
		int result = pservice.delProDiary(list);
		if(result != -1) {
			nr.setErrorMsg("삭제완료");
			nr.setErrorCode(1);
		}else {
			nr.setErrorMsg("실패");
			nr.setErrorCode(0);
		}
		
		return nr;	
	}
	
	@ExceptionHandler
	public String Exceptionhandler(Exception e) {
		e.printStackTrace();
		return "error";
	}
}
