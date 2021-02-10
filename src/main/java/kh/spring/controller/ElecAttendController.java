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
		System.out.println("학ㄱ기ㅣ!!!!!!! : " + semester);
		String arr[] = semester.split(" ");
		arr[0] = arr[0].replaceAll("년", "");
		arr[0] = arr[0].replaceAll("20", "");
		String sem = arr[1];

		if (sem.contentEquals("1학기")) {
			String regDate = arr[0] + "/02/22";
			List<ElecSelectClassDTO> classList = eservice.getClassList(id, regDate);
			List<TakingClassDTO> selClassInfoList = eservice.getClassInfo(id, regDate, className);
			
			if (className != null) {
				String schedule = selClassInfoList.get(0).getLec_schedule().toString();
				String lecCode = selClassInfoList.get(0).getLec_code().toString();
				List<ProAttendMngDTO> lecAttList = eservice.lecAttList(id,lecCode);
				model.addAttribute("lecAttList", lecAttList);

			}

			model.addAttribute("semester", semester);
			model.addAttribute("className", className);
			model.addAttribute("classList", classList);
			model.addAttribute("selClassInfoList", selClassInfoList);

		}
		return "/info/electAttend";
	}

}
