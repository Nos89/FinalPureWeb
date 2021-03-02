package kh.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;

import kh.spring.dto.ColScheduleDTO;
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

	@RequestMapping("/login")
	public String login(String id, String pw, Boolean saveID, Model model, HttpServletResponse response) throws ParseException {
		int result = iservice.login(id, pw);
		String name = iservice.getName(id, pw);
		String major = iservice.getMajor(id, pw);
		int unread = iservice.getUnreadMailNum(id);

		List<InfoBoardDTO> list_std = iservice.getRecentStd();
		List<InfoBoardDTO> list_scholar = iservice.getRecentScholar();
		List<InfoBoardDTO> list_enter = iservice.getRecentEnter();

		SimpleDateFormat format2 = new SimpleDateFormat("yy/MM/dd"); // 오늘날짜 요일 가져오기
		Date time2 = new Date();
		String day2 = format2.format(time2); // 21/02/18
		String dayArr[] = day2.split("/");
		String yearMonth = dayArr[0] + "/" + dayArr[1];
		
		SimpleDateFormat fm = new SimpleDateFormat("yy/MM");
		Date tempDate = fm.parse(yearMonth);
		
		List<ColScheduleDTO> list_colSche = iservice.getColSchedule(tempDate);
		

		//System.out.println(id + " : " + pw + " : " + result);
		if (result > 0) {
			System.out.println("로그인 성공 아이디 : " +id);
			session.setAttribute("loginID", id);
			session.setAttribute("userName", name);
			session.setAttribute("userMajor", major);
			session.setAttribute("unread", unread);
			
			Cookie cookie = new Cookie("saveID", id);
			if( saveID != null ) {
				if( saveID ) {
					response.addCookie(cookie);
				}
			} else {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			
			session.setAttribute("list_std", list_std);
			session.setAttribute("list_scholar", list_scholar);
			session.setAttribute("list_enter", list_enter);
			session.setAttribute("list_colSche", list_colSche);

			SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd");
			//
			Date time = new Date();
			String current = format.format(time);
			String[] date = current.split("/");
			String currentRegYear = date[0]; // 21(년)
			int currentRegMonth = Integer.parseInt(date[1]);

			String arrId[] = id.split("-");
			String openClassYear = "20" + currentRegYear;
			
			if (arrId[0].contentEquals("S")) { // 학생 종합정보페이지
				session.setAttribute("userPart", "학생");

				String classRegDate;
				String semester;
				if (currentRegMonth >= 1 && currentRegMonth <= 6) {
					// 1학기
					classRegDate = currentRegYear + "/02/19";
					fm = new SimpleDateFormat("yy/MM/dd");
					tempDate = fm.parse(classRegDate);
					//System.out.println("tempDate : " + tempDate);

					semester = "1";
					List<TakingClassDTO> list_takingClass = iservice.takingClass(id, tempDate);
					List<TakingClassDTO> list_classSche = iservice.classSche(id, tempDate);

					String schedule;
					String classTitle;
					String classRoom;

					List<String> timeList = new ArrayList<>();
					for (int j = 0; j < list_classSche.size(); j++) {
						schedule = list_classSche.get(j).getLec_schedule();
						classTitle = list_classSche.get(j).getLec_title();
						classRoom = list_classSche.get(j).getLec_classroom();

						SimpleDateFormat format1 = new SimpleDateFormat("E"); // 오늘날짜 요일 가져오기
						Date time1 = new Date();
						String day = format1.format(time1);

						if (schedule.contains("/")) { // 월(1,4)/수(4,7) 수(1,2)/목(3)
							String[] divSche_temp = schedule.split("/");// 월(1,4) 수(4,7)

							for (int i = 0; i < divSche_temp.length; i++) {
								String divSche[] = divSche_temp[i].split("\\("); // 월(1,4)
								// System.out.println(divSche[0]); // 월 *****
								// System.out.println(divSche[1]); // 1,4)
								divSche[1] = divSche[1].replaceAll("\\)", " "); // )지우기 => 1,4 *****

								if (divSche[0].contentEquals("월")) {
									divSche[0] = "가*" + divSche[0];
								}
								if (divSche[0].contentEquals("화")) {
									divSche[0] = "나*" + divSche[0];
								}
								if (divSche[0].contentEquals("수")) {
									divSche[0] = "다*" + divSche[0];
								}
								if (divSche[0].contentEquals("목")) {
									divSche[0] = "라*" + divSche[0];
								}
								if (divSche[0].contentEquals("금")) {
									divSche[0] = "마*" + divSche[0];
								}

								if (divSche[1].contains(",")) { // divSche[1]==1,4
									String divTime[] = divSche[1].split(","); // 1 4

									for (int j1 = 0; j1 < divTime.length; j1++) {
										divTime[j1] = divTime[j1].replaceAll(" ", "");
										int clTime = Integer.parseInt(divTime[j1]);
										String clDay = divSche[0];
										String todayClassInfo = clDay + "/" + divTime[j1] + "/" + classTitle + "/"
												+ classRoom;
										timeList.add(todayClassInfo);
									}

								} else if (!divSche[1].contains(",")) {
									divSche[1] = divSche[1].replaceAll(" ", "");
									int clTime = Integer.parseInt(divSche[1]);
									String clDay = divSche[0];

									String todayClassInfo = clDay + "/" + divSche[1] + "/" + classTitle + "/"
											+ classRoom;
									timeList.add(todayClassInfo);
								}
							}

						} else if (!schedule.contains("/")) { // 금(6,7) 금(8)
							String divSche[] = schedule.split("\\("); // 금 6,7)
							// System.out.println(divSche[0]); // 금
							// System.out.println(divSche[1]); // 6,7)
							divSche[1] = divSche[1].replaceAll("\\)", " "); // )지우기
							// System.out.println(a[1]); //6,7
							if (divSche[0].contentEquals("월")) {
								divSche[0] = "가*" + divSche[0];
							}
							if (divSche[0].contentEquals("화")) {
								divSche[0] = "나*" + divSche[0];
							}
							if (divSche[0].contentEquals("수")) {
								divSche[0] = "다*" + divSche[0];
							}
							if (divSche[0].contentEquals("목")) {
								divSche[0] = "라*" + divSche[0];
							}
							if (divSche[0].contentEquals("금")) {
								divSche[0] = "마*" + divSche[0];
							}

							if (divSche[1].contains(",")) {
								String divTime[] = divSche[1].split(",");
								for (int j1 = 0; j1 < divTime.length; j1++) {
									divTime[j1] = divTime[j1].replaceAll(" ", "");
									int clTime = Integer.parseInt(divTime[j1]);
									String clDay = divSche[0];

									String todayClassInfo = clDay + "/" + divTime[j1] + "/" + classTitle + "/"
											+ classRoom;
									timeList.add(todayClassInfo);

								}
							} else if (!divSche[1].contains(",")) { // 금(8)
								String divTime[] = schedule.split("\\("); // 금 8)
								divTime[1] = divTime[1].replaceAll("\\)", " ");
								divSche[1] = divSche[1].replaceAll(" ", "");
								int clTime = Integer.parseInt(divSche[1]);
								String clDay = divSche[0];

								String todayClassInfo = clDay + "/" + divSche[1] + "/" + classTitle + "/" + classRoom;
								timeList.add(todayClassInfo);
							}
						}
					}

					timeList.add("바*토/");
					Collections.sort(timeList);
					for (String i : timeList) {
						//System.out.println(i);
					}
					session.setAttribute("timeList", timeList);
					//model.addAttribute("timeList", timeList);
					session.setAttribute("list_takingClass", list_takingClass);
					session.setAttribute("openClassYear", openClassYear);
					session.setAttribute("semester", semester);

					// test
					model.addAttribute("msg", 1);
					return "info/info";
				} else if (currentRegMonth >= 7 && currentRegMonth <= 12) {
					// 2학기
					classRegDate = currentRegYear + "-08-22";
					semester = "2";
					fm = new SimpleDateFormat("yy-MM-dd");
					tempDate = fm.parse(classRegDate);

					List<TakingClassDTO> list_takingClass = iservice.takingClass(id, tempDate);
					session.setAttribute("list_takingClass", list_takingClass);
					session.setAttribute("openClassYear", openClassYear);
					session.setAttribute("semester", semester);

					// test
					model.addAttribute("msg", 2);
					return "info/info";
				}

			} else if (arrId[0].contentEquals("P")) { // 교수종합정보페이지
				session.setAttribute("userPart", "교수");
				String classOpenDate;
				String semester;
				if (currentRegMonth >= 1 && currentRegMonth <= 6) {
					// 1학기
					semester = "1";
					classOpenDate = currentRegYear + "-01-25";
					fm = new SimpleDateFormat("yy-MM-dd");
					tempDate = fm.parse(classOpenDate);

					List<TakingClassDTO> list_takingClass = iservice.takingClass(id, semester, tempDate);
					List<TakingClassDTO> list_classSche = iservice.classSche(id, semester, tempDate);

					String schedule;
					String classTitle;
					String classRoom;

					List<String> timeList = new ArrayList<>();
					for (int j = 0; j < list_classSche.size(); j++) {
						schedule = list_classSche.get(j).getLec_schedule();
						classTitle = list_classSche.get(j).getLec_title();
						classRoom = list_classSche.get(j).getLec_classroom();

						SimpleDateFormat format1 = new SimpleDateFormat("E"); // 오늘날짜 요일 가져오기
						Date time1 = new Date();
						String day = format1.format(time1);

						if (schedule.contains("/")) { // 월(1,4)/수(4,7) 수(1,2)/목(3)
							String[] divSche_temp = schedule.split("/");// 월(1,4) 수(4,7)

							for (int i = 0; i < divSche_temp.length; i++) {
								String divSche[] = divSche_temp[i].split("\\("); // 월(1,4)
								// System.out.println(divSche[0]); // 월 *****
								// System.out.println(divSche[1]); // 1,4)
								divSche[1] = divSche[1].replaceAll("\\)", " "); // )지우기 => 1,4 *****
								if (divSche[0].contentEquals("월")) {
									divSche[0] = "가*" + divSche[0];
								}
								if (divSche[0].contentEquals("화")) {
									divSche[0] = "나*" + divSche[0];
								}
								if (divSche[0].contentEquals("수")) {
									divSche[0] = "다*" + divSche[0];
								}
								if (divSche[0].contentEquals("목")) {
									divSche[0] = "라*" + divSche[0];
								}
								if (divSche[0].contentEquals("금")) {
									divSche[0] = "마*" + divSche[0];
								}

								if (divSche[1].contains(",")) { // divSche[1]==1,4
									String divTime[] = divSche[1].split(","); // 1 4

									for (int j1 = 0; j1 < divTime.length; j1++) {
										divTime[j1] = divTime[j1].replaceAll(" ", "");
										String todayClassInfo = divSche[0] + "/" + divTime[j1] + "/" + classTitle + "/"
												+ classRoom;
										timeList.add(todayClassInfo);
									}

								} else if (!divSche[1].contains(",")) {
									divSche[1] = divSche[1].replaceAll(" ", "");
									String todayClassInfo = divSche[0] + "/" + divSche[1] + "/" + classTitle + "/"
											+ classRoom;
									timeList.add(todayClassInfo);
								}
							}

						} else if (!schedule.contains("/")) { // 금(6,7) 금(8)
							String divSche[] = schedule.split("\\("); // 금 6,7)
							// System.out.println(divSche[0]); // 금
							// System.out.println(divSche[1]); // 6,7)
							divSche[1] = divSche[1].replaceAll("\\)", " "); // )지우기
							// System.out.println(a[1]); //6,7
							if (divSche[0].contentEquals("월")) {
								divSche[0] = "가*" + divSche[0];
							}
							if (divSche[0].contentEquals("화")) {
								divSche[0] = "나*" + divSche[0];
							}
							if (divSche[0].contentEquals("수")) {
								divSche[0] = "다*" + divSche[0];
							}
							if (divSche[0].contentEquals("목")) {
								divSche[0] = "라*" + divSche[0];
							}
							if (divSche[0].contentEquals("금")) {
								divSche[0] = "마*" + divSche[0];
							}

							if (divSche[1].contains(",")) {
								String divTime[] = divSche[1].split(",");
								for (int j1 = 0; j1 < divTime.length; j1++) {
									divTime[j1] = divTime[j1].replaceAll(" ", "");
									String todayClassInfo = divSche[0] + "/" + divTime[j1] + "/" + classTitle + "/"
											+ classRoom;
									timeList.add(todayClassInfo);
								}
							} else if (!divSche[1].contains(",")) { // 금(8)
								String divTime[] = schedule.split("\\("); // 금 8)
								divTime[1] = divTime[1].replaceAll("\\)", " ");
								divSche[1] = divSche[1].replaceAll(" ", "");
								String todayClassInfo = divSche[0] + "/" + divSche[1] + "/" + classTitle + "/"
										+ classRoom;
								timeList.add(todayClassInfo);

							}
						}
					}
					timeList.add("바*토/");
					Collections.sort(timeList);
					for (String i : timeList) {
						System.out.println(i);
					}
					model.addAttribute("timeList", timeList);
					session.setAttribute("list_takingClass", list_takingClass);
					session.setAttribute("semester", semester);
					session.setAttribute("openClassYear", openClassYear);

					// test
					model.addAttribute("msg", 3);
					return "info/info";
				} else if (currentRegMonth >= 7 && currentRegMonth <= 12) {
					// 2학기
					classOpenDate = currentRegYear + "-08-22";
					semester = "2";
					fm = new SimpleDateFormat("yy-MM-dd");
					tempDate = fm.parse(classOpenDate);

					List<TakingClassDTO> list_takingClass = iservice.takingClass(id, semester, tempDate);
					session.setAttribute("list_takingClass", list_takingClass); // 강의항목
					session.setAttribute("semester", semester); // 학기
					session.setAttribute("openClassYear", openClassYear); // 개강년도(현재년도)

					// test
					model.addAttribute("msg", 4);
					return "info/info";
				}

				return "info/info";
			} else if (arrId[0].contentEquals("A")) { // 관리자 넥사크로 페이지로 이동
				session.setAttribute("userPart", "관리자");
				return "info/info";
			}
		} else if (result == 0) {
			System.out.println("비번 틀림 ==> "+id + " : " + " : " + pw + " : "+ result);
			model.addAttribute("errMsg", "아이디 또는 비밀번호를 확인하세요.");
			return "info/info";
		}
		return "info/info";
	}

	// 달력 넘어가면 그 날짜에 맞는 학사일정 옆에 보이게 하는...(미완성)
	@RequestMapping("/calendar")
	public String calendar(int month_click, Model model) throws ParseException {		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date time = new Date();
		String current = format.format(time);
		String arr[] = current.split("/");
		String result = arr[0]+"-0"+month_click+"-01";
		
		arr[0] = arr[0].replaceAll("20", "");
		String month_click2 =null;
		month_click2 = arr[0]+"/0"+Integer.toString(month_click);
		SimpleDateFormat fm = new SimpleDateFormat("yy/MM");
		Date tempDate = fm.parse(month_click2);
		
		List<ColScheduleDTO> main_colSche = iservice.getMainSchedule(tempDate);
		
		model.addAttribute("type", "info");
		model.addAttribute("result", result);
		model.addAttribute("main_colSche", main_colSche);
		return "main/info/info";
	}
	
	@RequestMapping("/changeSemester")
	public String changeSemester(String semSelect, Model model) {		
		System.out.println("changeSemester : "+ semSelect);
		String arr[] = semSelect.split(" ");
		model.addAttribute("change", arr[1]);
		return "main/info/info";
	}

	@RequestMapping("/tabToGoBoard")
	public String tabToGoBoard(int seq, String category) {
		return "redirect:/main/board.view?pageGroup=community&type=notice&seq="+seq+"&page=1&purp=view&category="+category+"";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/info";
	}
	
	@RequestMapping("/find")
	public String find(String find, Model model) {
		model.addAttribute("find", find);
		return "/info/find";
	}
	
	@RequestMapping(value="/findIDPW", produces="application/json; charset=utf8")
	@ResponseBody
	public String findIDPW(String find, String userID, String userName, String pn ) {
		String result = "";
		result = iservice.findIDPW(find, userID, userName, pn);
		JsonObject jo = new JsonObject();
		if( result != null ) {
			System.out.println(result.toString());
			jo.addProperty("result", true);
			jo.addProperty("id", result );
			
			return jo.toString();
		} else {
			jo.addProperty("result", false);
			return jo.toString();
		}
	}
	
	@RequestMapping(value="/changePW", produces="application/json; charset=utf8")
	@ResponseBody
	public String changePW(String userID, String pw) {
		int result = iservice.changePW(userID, pw);
		System.out.println(result);
		if( result > 0 ) {
			return "true";
		} else {
			return "false";
		}
	}
}
