package kh.spring.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {

	@RequestMapping("/main")
	public String simplePageGoTo(String pageGroup, String type, Model model) {
		model.addAttribute("type", type);
		return "main/"+pageGroup+"/"+type;
	}
	
	@RequestMapping("/home.nex")
	public String homeNEX(Locale locale, Model model) {
		return "redirect:/nex/index.html";
	}
}
