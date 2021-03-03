package kh.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

import kh.spring.dto.ColScheduleDTO;
import kh.spring.dto.NoticeDTO;
import kh.spring.service.BoardService;
import kh.spring.service.CommonService;
import kh.spring.service.InfoService;



@Controller
public class HomeController {

	@Autowired
	HttpSession session;
	@Autowired
	private InfoService iservice;
	@Autowired
	private BoardService bservice;
	@Autowired
	private CommonService cservice;
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		model.addAttribute("promote", bservice.getPromote());
		model.addAttribute("notice", bservice.getNotice("학사"));
		model.addAttribute("colSchedule", cservice.getColSchedule());
		return "home";
	}
	
	@RequestMapping(value="/getNotice", produces = "text/plain; charset=UTF8")
	@ResponseBody
	public String getNotice(String division) {
		List<NoticeDTO> list = bservice.getNotice(division);
		Gson gs = new Gson();
		JsonArray jrr = new JsonArray();
		for( NoticeDTO d : list ) {
			jrr.add(gs.toJson(d));
		}
		return jrr.toString();
	}
	
	@RequestMapping("/main")
	public String simplePageGoTo(String pageGroup, String type, Model model, HttpServletResponse response) throws ParseException {
		model.addAttribute("type", type);
		model.addAttribute("pageGroup", pageGroup);
		System.out.println(type + " : " + pageGroup);
		if( pageGroup.contentEquals("community")) {
			model.addAttribute("write", false);
			return "redirect:/main/board.list";
		}
		else if( pageGroup.contentEquals("info")) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
			Date time = new Date();
			String current = format.format(time);
	
			String arr[] = current.split("-");
			arr[0] = arr[0].replaceAll("20", "");
			String month_click2 = arr[0]+"/"+arr[1];
			System.out.println("arr[1] : "+ arr[1]);
			
			SimpleDateFormat fm = new SimpleDateFormat("yy/MM");
			Date tempDate = fm.parse(month_click2);
			System.out.println("tempDate : "+ tempDate);
			
			//List<ColScheduleDTO> main_colSche = iservice.getMainSchedule(month_click2);
			List<ColScheduleDTO> main_colSche = iservice.getMainSchedule(tempDate);
						
			model.addAttribute("result_main", current+"-01");
			model.addAttribute("main_colSche", main_colSche);
		}
		return "main/"+pageGroup+"/"+type;
	}
	
	@RequestMapping("/info") //종합정보페이지 로그인 옆에 잇는 학사일정 4개 
	public String infoPageGoTo(Model model) throws ParseException {
		SimpleDateFormat format2 = new SimpleDateFormat("yy/MM/dd"); // 오늘날짜 요일 가져오기
		Date time2 = new Date();
		String day2 = format2.format(time2); //21/02/18
		String dayArr[] = day2.split("/");		
		String yearMonth = dayArr[0]+"/"+dayArr[1];
		
		SimpleDateFormat fm = new SimpleDateFormat("yy/MM");
		Date tempDate = fm.parse(yearMonth);
		
		List<ColScheduleDTO> list4_colSche = iservice.get4ColSchedule(tempDate);
		model.addAttribute("list4_colSche", list4_colSche);
		return "info/info";
	}
	
	@RequestMapping("/home.nex")
	public String homeNEX(Locale locale, Model model) {
		return "redirect:/nex/index.html";
	}
	
	@RequestMapping("/whichUser.nex")
	public NexacroResult whichUser() {
		NexacroResult nr = new NexacroResult();
		
		String loginID = (String)session.getAttribute("loginID");
		System.out.println(loginID);
		if( loginID.split("-")[0].contentEquals("S")) {
			nr.addVariable("userType", "학생");
		} else if ( loginID.split("-")[0].contentEquals("P")) {
			nr.addVariable("userType", "교수");
		} else if ( loginID.split("-")[0].contentEquals("A")) {
			nr.addVariable("userType", "관리자");
		}
		nr.addVariable("loginID", (String)session.getAttribute("loginID"));
		nr.addVariable("userName",(String)session.getAttribute("userName"));
		return nr;
	}
	@RequestMapping("/mainHome")
	public String mainHome() {
		return "redirect:/";
	}
	@RequestMapping("/classRegistration.nex")
	public String viewClassRegistration() {
		return "redirect:/nex/index.html?name=sugang";
	}
}
