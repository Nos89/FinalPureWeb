package kh.spring.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "/info/login";
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
	
	@RequestMapping("/home.nex")
	public String homeNEX(Locale locale, Model model) {
		return "redirect:/nex/index.html";
	}
}
