package kh.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

import kh.spring.dto.ClassRegistrationDTO;
import kh.spring.dto.CollegeDTO;
import kh.spring.dto.DepartmentDTO;
import kh.spring.dto.IsuDTO;
import kh.spring.dto.OpenClass_LecPlan;
import kh.spring.dto.ShoppingBasketDTO;
import kh.spring.dto.StudentDetailDTO;
import kh.spring.dto.StudentInfoDTO;
import kh.spring.service.ClassRegistrationService;
import kh.spring.service.CommonService;
import kh.spring.service.StudentService;

@RequestMapping("/classRegistration")
@Controller
public class ClassRegistrationController {
	@Autowired
	private ClassRegistrationService cservice;
	
	@Autowired
	private StudentService sservice;
	
	@Autowired
	private CommonService comservice;
	
	@RequestMapping("onload.nex")
	public NexacroResult onLoad(@ParamVariable(name="id")String id) {
		System.out.println("신호신호");
		NexacroResult nr = new NexacroResult();
		List<OpenClass_LecPlan> oList = new ArrayList<>();
		oList = cservice.selectAllOpenClass();
		
		List<StudentInfoDTO> stdList = new ArrayList<>();
		stdList = sservice.selectAllInfo(id);
		
		List<StudentDetailDTO> detailList = new ArrayList<>();
		detailList = sservice.selectStuDetail(id);
		
		List<DepartmentDTO> dList = new ArrayList<>();
		dList = comservice.getDepartment();
		
		List<IsuDTO> iList = new ArrayList<>();
		iList = comservice.getIsu();
 		
		List<CollegeDTO> cList = new ArrayList<>();
		cList =comservice.getCollege();
		
		List<ClassRegistrationDTO> crList= new ArrayList<>();
		crList = cservice.selectCRList(id);
		nr.addDataSet("out_dummy",oList);
		nr.addDataSet("out_openClass",oList);
		nr.addDataSet("out_college",cList);
		nr.addDataSet("out_department",dList);
		nr.addDataSet("out_isu",iList);
		nr.addDataSet("out_student",stdList);
		nr.addDataSet("out_stdDetail",detailList);
		nr.addDataSet("out_crList",crList);
		return nr;
	}
	
	@RequestMapping("addClass.nex")
	public NexacroResult addClass(@ParamDataSet(name="in_ds")ClassRegistrationDTO dto) {
		NexacroResult nr = new NexacroResult();
		int result = cservice.partPlus(dto);;

		if(result==1) {
			int result2 = cservice.addClass(dto);
			if(result2==1) {
			nr.setErrorCode(1);
			nr.setErrorMsg("신청완료");
			}
		}else { 
			nr.setErrorCode(0);  
			nr.setErrorMsg("신청인원이 초과 되었습니다"); 
			}
		return nr;
	}
	
	@RequestMapping("reload.nex")
	public NexacroResult reload(@ParamVariable(name="id")String id) {
		NexacroResult nr = new NexacroResult();
		List<OpenClass_LecPlan> oList = new ArrayList<>();
		oList = cservice.selectAllOpenClass();
		
		List<ClassRegistrationDTO> crList= new ArrayList<>();
		crList = cservice.selectCRList(id);
		
		nr.addDataSet("out_dummy",oList);
		nr.addDataSet("out_openClass",oList);
		nr.addDataSet("out_crList",crList);
		
		return nr;
	}
	
	@RequestMapping("cancleCR.nex")
	public NexacroResult cancleCR(@ParamDataSet(name="in_ds")ClassRegistrationDTO dto) {
		System.out.println("123123");
		NexacroResult nr = new NexacroResult();
		int result = cservice.deleteCRList(dto);
		if(result==1) {
			int result2 = cservice.partMinus(dto);
			if(result2==1) {
				nr.setErrorCode(1);
				nr.setErrorMsg("취소되었습니다.");
			}else {
				nr.setErrorCode(0);  
				nr.setErrorMsg("취소하지 못했습니다. 다시 시도해주세요."); 
			}
		}else {
			nr.setErrorCode(0);  
			nr.setErrorMsg("취소하지 못했습니다. 다시 시도해주세요."); 
		}
		
		return nr;
	}
	
	@RequestMapping("basketOnLoad.nex")
	public NexacroResult basketOnLoad(@ParamVariable(name="id")String id) {
		System.out.println("basket넘어옴");
		NexacroResult nr = new NexacroResult();
		List<ShoppingBasketDTO> bList = new ArrayList<>();
		bList = cservice.selectBasketList(id);
		
		List<ClassRegistrationDTO> crList= new ArrayList<>();
		crList = cservice.selectCRList(id);
		
		nr.addDataSet("out_basket",bList);
		nr.addDataSet("out_crList",crList);
		
		return nr;
	}
	
	@RequestMapping("basketToCrList.nex")
	public NexacroResult basketToCrList(@ParamDataSet(name="in_ds")List<ClassRegistrationDTO>list) {
		System.out.println("toList 넘어옴");
		NexacroResult nr = new NexacroResult();
		int result = cservice.insertBasketToCrList(list);
		nr.setErrorCode(1);
		nr.setErrorMsg(""+result+"개 신청완료");
		return nr;
	}
	@RequestMapping("basketReLoad.nex")
	public NexacroResult basketReLoad(@ParamVariable(name="id")String id) {
		System.out.println("basket넘어옴");
		NexacroResult nr = new NexacroResult();
		
		List<ClassRegistrationDTO> crList= new ArrayList<>();
		crList = cservice.selectCRList(id);

		nr.addDataSet("out_crList",crList);	
		return nr;
	}
	//================================================================장바구니 수강신청
	@RequestMapping("onLoadBasket.nex")
	public NexacroResult onLoadBasket(@ParamVariable(name="id")String id) {
		System.out.println("신호신호");
		NexacroResult nr = new NexacroResult();
		List<OpenClass_LecPlan> oList = new ArrayList<>();
		oList = cservice.selectAllOpenClass();
		
		List<StudentInfoDTO> stdList = new ArrayList<>();
		stdList = sservice.selectAllInfo(id);
		
		List<StudentDetailDTO> detailList = new ArrayList<>();
		detailList = sservice.selectStuDetail(id);
		
		List<DepartmentDTO> dList = new ArrayList<>();
		dList = comservice.getDepartment();
		
		List<IsuDTO> iList = new ArrayList<>();
		iList = comservice.getIsu();
 		
		List<CollegeDTO> cList = new ArrayList<>();
		cList =comservice.getCollege();
		
		List<ShoppingBasketDTO> bList= new ArrayList<>();
		bList = cservice.selectBasketList(id);
		nr.addDataSet("out_dummy",oList);
		nr.addDataSet("out_openClass",oList);
		nr.addDataSet("out_college",cList);
		nr.addDataSet("out_department",dList);
		nr.addDataSet("out_isu",iList);
		nr.addDataSet("out_student",stdList);
		nr.addDataSet("out_stdDetail",detailList);
		nr.addDataSet("out_basket",bList);
		return nr;
	}
	@RequestMapping("addClassBasket.nex")
	public NexacroResult addClassBasket(@ParamDataSet(name="in_ds")ShoppingBasketDTO dto) {
		NexacroResult nr = new NexacroResult();
		int result = cservice.addClassBasket(dto);
		if(result==1) {
			nr.setErrorCode(1);
			nr.setErrorMsg("신청완료");
		}else { 
			nr.setErrorCode(0);  
			nr.setErrorMsg("신청하지 못했습니다 잠시 후 다시 시도해주세요."); 
			}
		return nr;
	}
	@RequestMapping("cancleBasket.nex")
	public NexacroResult cancleBasket(@ParamDataSet(name="in_ds")ShoppingBasketDTO dto) {
		System.out.println("123123");
		NexacroResult nr = new NexacroResult();
		int result = cservice.deleteBasket(dto);
		if(result==1) {	
				nr.setErrorCode(1);
				nr.setErrorMsg("취소되었습니다.");
		}else {
			nr.setErrorCode(0);  
			nr.setErrorMsg("취소하지 못했습니다. 다시 시도해주세요."); 
		}
		
		return nr;
	}
	
	@RequestMapping("reloadBasket.nex")
	public NexacroResult reloadBasket(@ParamVariable(name="id")String id) {
		NexacroResult nr = new NexacroResult();
		List<OpenClass_LecPlan> oList = new ArrayList<>();
		oList = cservice.selectAllOpenClass();
		
		List<ShoppingBasketDTO> bList= new ArrayList<>();
		bList = cservice.selectBasketList(id);
		
		nr.addDataSet("out_dummy",oList);
		nr.addDataSet("out_openClass",oList);
		nr.addDataSet("out_basket",bList);
		
		return nr;
	}
	
}
