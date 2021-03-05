package kh.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.ElecSelectClassDTO;
import kh.spring.dto.ProAttendMngDTO;
import kh.spring.dto.TakingClassDTO;
import kh.spring.service.ElecAttendService;

@Controller
@RequestMapping("/elec")
public class ElecAttendController {

	@Autowired
	HttpSession session;
	@Autowired
	private ElecAttendService eservice;

	// 전자출결 페이지로 이
	@RequestMapping("/toElectAttend")
	public String toElectAttend(Model model) {
		model.addAttribute("first", "첫화면에 사진");
		model.addAttribute("selected", "학기선택");
		return "/info/electAttend";
	}

	@RequestMapping("/comboChange")
	public String comboChange(String semester, String className, Model model) throws ParseException  {
		String id = (String) session.getAttribute("loginID");
		//semester 나오는 모양=> 2021년 1학기
		String semTitle = semester;
		String blankSplit_arr[] = semTitle.split(" ");
		String yearSplit_arr[] = blankSplit_arr[0].split("년");
		yearSplit_arr[0] = yearSplit_arr[0]+"학년도"; 
		
		String arr[] = semester.split(" ");
		arr[0] = arr[0].replaceAll("년", "");
		arr[0] = arr[0].substring(2);
		String sem = arr[1];

		if (sem.contentEquals("1학기")) {
			String regDate = arr[0] + "/02/19";
			SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
			Date date_registration = sdf.parse(regDate);
			List<ElecSelectClassDTO> classList = eservice.getClassList(id, date_registration);
			
			if (className != null) {
				sdf = new SimpleDateFormat("yy/MM/dd");
				date_registration = sdf.parse(regDate);
				List<TakingClassDTO> selClassInfoList = eservice.getClassInfo(id, date_registration, className);
				String lecCode = selClassInfoList.get(0).getLec_code().toString();
				List<ProAttendMngDTO> lecAttList = eservice.lecAttList(id,lecCode);
				String yearSemester = yearSplit_arr[0]+" "+sem;
				
				model.addAttribute("lecAttList", lecAttList);
				model.addAttribute("selClassInfoList", selClassInfoList);
				model.addAttribute("yearSemester", yearSemester);
				model.addAttribute("className", className);
			}
			else  {
				model.addAttribute("divide", "구분");
				model.addAttribute("classList", classList);
			}

			model.addAttribute("semester", semester);
			model.addAttribute("className", className);
			model.addAttribute("classList", classList);
		}
		else if (sem.contentEquals("2학기")) {
			String arr2[] = semester.split(" ");
			arr2[0] = arr2[0].replaceAll("년", "");
			arr2[0] = arr2[0].substring(2);

			String regDate = arr2[0] + "/08/19";
			SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
			Date date_registration = sdf.parse(regDate);
			List<ElecSelectClassDTO> classList = eservice.getClassList(id, date_registration);
			System.out.println("classList size 확인: "+ classList.size());
			
			if (className != null) {	
				sdf = new SimpleDateFormat("yy/MM/dd");
				date_registration = sdf.parse(regDate);
				List<TakingClassDTO> selClassInfoList = eservice.getClassInfo(id, date_registration, className);
				//String schedule = selClassInfoList.get(0).getLec_schedule().toString();
				String lecCode = selClassInfoList.get(0).getLec_code().toString();
				List<ProAttendMngDTO> lecAttList = eservice.lecAttList(id,lecCode);
				String yearSemester = yearSplit_arr[0]+" "+sem;
				
				model.addAttribute("lecAttList", lecAttList);
				model.addAttribute("selClassInfoList", selClassInfoList);
				model.addAttribute("yearSemester", yearSemester);
			}
			else{
				model.addAttribute("divide", "구분");
				model.addAttribute("classList", classList);
			}

			model.addAttribute("semester", semester);
			model.addAttribute("className", className);
			model.addAttribute("classList", classList);
		}
		return "/info/electAttend";
	}
	
	//전자출결 학생 등록정보
	@RequestMapping("/idRegisterInfo")
	public String idRegisterInfo(Model model) {
		String id = (String) session.getAttribute("loginID");
		String name = (String) session.getAttribute("userName");
		String major = (String) session.getAttribute("userMajor");
		
		model.addAttribute("regInfoBtn", "등록정보");
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		model.addAttribute("major", major);
		
		return "/info/electAttend";
	}
	

}
