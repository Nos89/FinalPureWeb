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

import kh.spring.dto.InfoBoardDTO;
import kh.spring.dto.TakingClassDTO;
import kh.spring.service.InfoService;


@Controller
@RequestMapping("/info")
public class InfoController {
	
	@Autowired
	HttpSession session;
	@Autowired
	private InfoService iservice;

		
	@RequestMapping("")
	public String infoPageGoTo() {
		return "info/info";
	}
	

	@RequestMapping("/login")
	public String login(String id, String pw, Model model) {
		try {
			int result = iservice.login(id, pw);
			String name = iservice.getName(id,pw);
			String major = iservice.getMajor(id,pw);
			
			List<InfoBoardDTO> list_std = iservice.getRecentStd();
			List<InfoBoardDTO> list_scholar = iservice.getRecentScholar();
			List<InfoBoardDTO> list_enter = iservice.getRecentEnter();
			
			session.setAttribute("loginID", id);
			if (result > 0) {
				session.setAttribute("loginID", id);
				session.setAttribute("loginPW", pw);
				session.setAttribute("userName", name);
				session.setAttribute("userMajor", major);
				
				session.setAttribute("list_std", list_std);
				session.setAttribute("list_scholar", list_scholar);
				session.setAttribute("list_enter", list_enter);

				SimpleDateFormat format = new SimpleDateFormat ("yy/MM/dd");
				//
				Date time = new Date();
				String current = format.format(time);
				String[] date = current.split("/");
				String currentRegYear = date[0]; //21(년)
				int currentRegMonth = Integer.parseInt(date[1]);
				
				String arrId[] = id.split("-");		
				String openClassYear="20"+currentRegYear;
				if(arrId[0].contentEquals("S")) { //학생 종합정보페이지
					session.setAttribute("userPart","학생");
					
					String classRegDate;
					String semester;
					if(currentRegMonth==1 || currentRegMonth==2 || currentRegMonth==3 || currentRegMonth==4 || currentRegMonth==5 || currentRegMonth==6 ) {
						//1학기						
						classRegDate = currentRegYear+"-02-22";	
						semester="1";
				        List<TakingClassDTO> list_takingClass = iservice.takingClass(id,classRegDate);
				        List<TakingClassDTO> list_classSche = iservice.classSche(id,classRegDate);
				        
//				        System.out.println(list_classSche.get(0).getLec_title());
//				        System.out.println(list_classSche.get(0).getLec_schedule());
//				        System.out.println(list_classSche.get(1).getLec_title());
//				        System.out.println(list_classSche.get(1).getLec_schedule());
				        
				        String schedule = list_classSche.get(1).getLec_schedule();
				        String sche1[] = schedule.split("\\("); //금(6,7)
				        System.out.println(sche1[0]); //금			       
				        
				        String sche2[] = schedule.split(",");
				        String time1 = sche2[0].replace(sche1[0]+"(", "");
				        String time2 = sche2[1].replace(")", "");
				        System.out.println(time1);
				        System.out.println(time2);
				        
						session.setAttribute("list_takingClass", list_takingClass);
						session.setAttribute("openClassYear", openClassYear);
						session.setAttribute("semester", semester);
						return "info/info";
					}
					else if(currentRegMonth==7 || currentRegMonth==8 || currentRegMonth==9 || currentRegMonth==10 || currentRegMonth==11 || currentRegMonth==12 ) {
						//2학기						
						classRegDate = currentRegYear+"-08-22";		
						semester="2";
				        List<TakingClassDTO> list_takingClass = iservice.takingClass(id,classRegDate);
						session.setAttribute("list_takingClass", list_takingClass);
						session.setAttribute("openClassYear", openClassYear);
						session.setAttribute("semester", semester);
						return "info/info";
					}
				
				}else if(arrId[0].contentEquals("P")) { //교수종합정보페이지
					session.setAttribute("userPart", "교수");
					String classOpenDate;
					String semester;
					if(currentRegMonth==1 || currentRegMonth==2 || currentRegMonth==3 || currentRegMonth==4 || currentRegMonth==5 || currentRegMonth==6 ) {
						//1학기		
						System.out.println("교수 1학기 강의목록 보여주기");
						semester="1";
						classOpenDate = currentRegYear+"-01-25";					        
				        List<TakingClassDTO> list_takingClass = iservice.takingClass(id,semester,classOpenDate);
						session.setAttribute("list_takingClass", list_takingClass);
						session.setAttribute("semester", semester);
						session.setAttribute("openClassYear", openClassYear);
						return "info/info";
					}
					else if(currentRegMonth==7 || currentRegMonth==8 || currentRegMonth==9 || currentRegMonth==10 || currentRegMonth==11 || currentRegMonth==12 ) {
						//2학기						
						classOpenDate = currentRegYear+"-08-22";		
						semester="2";
				        List<TakingClassDTO> list_takingClass = iservice.takingClass(id,semester,classOpenDate);
						session.setAttribute("list_takingClass", list_takingClass); //강의항목
						session.setAttribute("semester", semester); //학기
						session.setAttribute("openClassYear", openClassYear); //개강년도(현재년도)
						return "info/info";
					}
					
					return "info/info";
				}
			} else if (result == 0) {
				return "info/info";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	@RequestMapping("/logout")
	public String logout() {
		session.removeAttribute("loginID");
		session.removeAttribute("loginPW");
		session.removeAttribute("loginID");
		session.removeAttribute("userName");
		session.removeAttribute("userMajor");
		session.removeAttribute("userPart");
		session.removeAttribute("list_std");
		session.removeAttribute("list_scholar");
		session.removeAttribute("list_enter");
		session.removeAttribute("list_takingClass");
		session.removeAttribute("semester");
		session.removeAttribute("openClassYear");
		return "info/info";
		
	}

}
