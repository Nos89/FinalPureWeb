package kh.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
	public String simplePageGoTo(String pageGroup, String type, Model model) {
		model.addAttribute("type", type);
		model.addAttribute("pageGroup", pageGroup);
		if( pageGroup.contentEquals("community")) {
			model.addAttribute("write", false);
			return "redirect:/main/board.list";
		}
		return "main/"+pageGroup+"/"+type;
	}
	
	@RequestMapping("/info")
	public String infoPageGoTo(Model model) {
		SimpleDateFormat format2 = new SimpleDateFormat("yy/MM/dd"); // 오늘날짜 요일 가져오기
		Date time2 = new Date();
		String day2 = format2.format(time2); //21/02/18
		String dayArr[] = day2.split("/");
		String yearMonth = dayArr[0]+"/"+dayArr[1];
		List<ColScheduleDTO> list4_colSche = iservice.get4ColSchedule(yearMonth);
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
