package kh.spring.controller;

import java.sql.Date;
import java.util.ArrayList;
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
import kh.spring.service.InfoService;

@Controller
@RequestMapping("/elec")
public class ElecAttendController {

	@Autowired
	HttpSession session;
	@Autowired
	private ElecAttendService eservice;

	// 전자출결 페이지로 이동
	@RequestMapping("/toElectAttend")
	public String toElectAttend() {
		return "/info/electAttend";
	}

	@RequestMapping("/comboChange")
	public String comboChange(String semester, String className, Model model) {
		String id = (String) session.getAttribute("loginID");
		//semester 나오는 모양=> 2021년 1학기
		String semTitle = semester;
		//System.out.println(semester);
		String temp[] = semTitle.split(" ");
		String temp2[] = temp[0].split("년");
		temp2[0] = temp2[0]+"학년도"; 
		
		String arr[] = semester.split(" ");
		arr[0] = arr[0].replaceAll("년", "");
		arr[0] = arr[0].replaceAll("20", "");
		String sem = arr[1];

		if (sem.contentEquals("1학기")) {
			String regDate = arr[0] + "/02/19";
			List<ElecSelectClassDTO> classList = eservice.getClassList(id, regDate);
			
			if (className != null) {
				List<TakingClassDTO> selClassInfoList = eservice.getClassInfo(id, regDate, className);
				//String schedule = selClassInfoList.get(0).getLec_schedule().toString();
				String lecCode = selClassInfoList.get(0).getLec_code().toString();
				List<ProAttendMngDTO> lecAttList = eservice.lecAttList(id,lecCode);
				String yearSemester = temp2[0]+" "+sem;
				
				model.addAttribute("lecAttList", lecAttList);
				model.addAttribute("selClassInfoList", selClassInfoList);
				model.addAttribute("yearSemester", yearSemester);
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
