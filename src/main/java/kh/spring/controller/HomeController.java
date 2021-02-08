package kh.spring.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro.uiadapter17.spring.core.data.NexacroResult;



@Controller
public class HomeController {

	@Autowired
	HttpSession session;
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		return "home";
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
	public String infoPageGoTo() {
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
		if( loginID.split("-")[0].contentEquals("S")) {
			nr.addVariable("userType", "학생");
		} else if ( loginID.split("-")[0].contentEquals("P")) {
			nr.addVariable("userType", "교수");
		} 
		nr.addVariable("loginID", (String)session.getAttribute("loginID"));
		return nr;
	}
	@RequestMapping("/mainHome")
	public String mainHome() {
		return "redirect:/";
	}
}
