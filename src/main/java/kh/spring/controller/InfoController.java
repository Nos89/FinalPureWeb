package kh.spring.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.spring.service.InfoService;


@Controller
@RequestMapping("/info")
public class InfoController {
	
	@Autowired
	HttpSession session;
	@Autowired
	private InfoService iservice;
	
	@RequestMapping("/login")
	public String login(String id, String pw, Model model) {
		try {
			//System.out.println(id +" : "+ pw);
			int result = iservice.login(id, pw);
			String name = iservice.getName(id,pw);
			String major = iservice.getMajor(id,pw);
			if (result > 0) {
				session.setAttribute("loginID", id);
				session.setAttribute("loginPW", pw);
				session.setAttribute("userName", name);
				session.setAttribute("userMajor", major);
				
				String arrId[] = id.split("-");
				//System.out.println(arrId[0]);
				
				if(arrId[0].contentEquals("S")) {
					model.addAttribute("userPart", "학생");
					return "info/userPage";
					
				}else if(arrId[0].contentEquals("P")) {
					model.addAttribute("userPart", "교수");
					return "info/userPage";
				}
			} else if (result == 0) {
				return "/info/login";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
