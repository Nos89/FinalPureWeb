package kh.spring.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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

	@RequestMapping("/login")
	public String login(String id, String pw, Model model) {
		int result = iservice.login(id, pw);
		String name = iservice.getName(id, pw);
		String major = iservice.getMajor(id, pw);

		List<InfoBoardDTO> list_std = iservice.getRecentStd();
		List<InfoBoardDTO> list_scholar = iservice.getRecentScholar();
		List<InfoBoardDTO> list_enter = iservice.getRecentEnter();

		if (result > 0) {
			session.setAttribute("loginID", id);
			session.setAttribute("userName", name);
			session.setAttribute("userMajor", major);

			session.setAttribute("list_std", list_std);
			session.setAttribute("list_scholar", list_scholar);
			session.setAttribute("list_enter", list_enter);

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
					classRegDate = currentRegYear + "-02-22";
					semester = "1";
					List<TakingClassDTO> list_takingClass = iservice.takingClass(id, classRegDate);
					List<TakingClassDTO> list_classSche = iservice.classSche(id, classRegDate);

					String schedule;
					String classTitle;
					String classRoom;

					// List<TimetableDTO> timeList = new ArrayList<>();
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

								if (divSche[0].contentEquals("월")) {divSche[0] = "가*" + divSche[0];}
								if (divSche[0].contentEquals("화")) {divSche[0] = "나*" + divSche[0];}
								if (divSche[0].contentEquals("수")) {divSche[0] = "다*" + divSche[0];}
								if (divSche[0].contentEquals("목")) {divSche[0] = "라*" + divSche[0];}
								if (divSche[0].contentEquals("금")) {divSche[0] = "마*" + divSche[0];}

								if (divSche[1].contains(",")) { // divSche[1]==1,4
									String divTime[] = divSche[1].split(","); // 1 4

									for (int j1 = 0; j1 < divTime.length; j1++) {
										divTime[j1] = divTime[j1].replaceAll(" ", "");
										int clTime = Integer.parseInt(divTime[j1]);
										String clDay = divSche[0];

										// timetable(clDay,classTitle,clTime,day,timeList,classRoom);
										String todayClassInfo = clDay + "/" + divTime[j1] + "/" + classTitle + "/" + classRoom;
										timeList.add(todayClassInfo);
										// System.out.println(todayClassInfo);

									}

								} else if (!divSche[1].contains(",")) {
									divSche[1] = divSche[1].replaceAll(" ", "");
									int clTime = Integer.parseInt(divSche[1]);
									String clDay = divSche[0];

									String todayClassInfo = clDay + "/" + divSche[1] + "/" + classTitle + "/" + classRoom;
									// System.out.println(todayClassInfo);
									timeList.add(todayClassInfo);
									// timetable(clDay,classTitle,clTime,day,timeList,classRoom);
								}
							}

						} else if (!schedule.contains("/")) { // 금(6,7) 금(8)
							String divSche[] = schedule.split("\\("); // 금 6,7)
							// System.out.println(divSche[0]); // 금
							// System.out.println(divSche[1]); // 6,7)
							divSche[1] = divSche[1].replaceAll("\\)", " "); // )지우기
							// System.out.println(a[1]); //6,7
							if (divSche[0].contentEquals("월")) {divSche[0] = "가*" + divSche[0];	}
							if (divSche[0].contentEquals("화")) {divSche[0] = "나*" + divSche[0];	}
							if (divSche[0].contentEquals("수")) {divSche[0] = "다*" + divSche[0];	}
							if (divSche[0].contentEquals("목")) {divSche[0] = "라*" + divSche[0];	}
							if (divSche[0].contentEquals("금")) {divSche[0] = "마*" + divSche[0];}

							if (divSche[1].contains(",")) {
								String divTime[] = divSche[1].split(",");
								for (int j1 = 0; j1 < divTime.length; j1++) {
									divTime[j1] = divTime[j1].replaceAll(" ", "");
									int clTime = Integer.parseInt(divTime[j1]);
									String clDay = divSche[0];

									String todayClassInfo = clDay + "/" + divTime[j1] + "/" + classTitle + "/" + classRoom;
									// System.out.println(todayClassInfo);
									timeList.add(todayClassInfo);

									// timetable(clDay,classTitle,clTime,day,timeList,classRoom);
								}
							} else if (!divSche[1].contains(",")) { // 금(8)
								String divTime[] = schedule.split("\\("); // 금 8)
								divTime[1] = divTime[1].replaceAll("\\)", " ");
								divSche[1] = divSche[1].replaceAll(" ", "");
								int clTime = Integer.parseInt(divSche[1]);
								String clDay = divSche[0];

								String todayClassInfo = clDay + "/" + divSche[1] + "/" + classTitle + "/" + classRoom;
								// System.out.println(todayClassInfo);
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
					session.setAttribute("openClassYear", openClassYear);
					session.setAttribute("semester", semester);

					// test
					model.addAttribute("msg", 1);
					return "info/info";
				} else if ( currentRegMonth >= 7 && currentRegMonth <= 12 ) {
					// 2학기
					classRegDate = currentRegYear + "-08-22";
					semester = "2";
					List<TakingClassDTO> list_takingClass = iservice.takingClass(id, classRegDate);
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
					System.out.println("교수 1학기 강의목록 보여주기");
					semester = "1";
					classOpenDate = currentRegYear + "-01-25";
					List<TakingClassDTO> list_takingClass = iservice.takingClass(id, semester, classOpenDate);
					List<TakingClassDTO> list_classSche = iservice.classSche(id, semester, classOpenDate);

					String schedule;
					String classTitle;
					String classRoom;

					// List<TimetableDTO> timeList = new ArrayList<>();
					List<String> timeList = new ArrayList<>();
					// TimetableDTO dto = new TimetableDTO();
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
								if (divSche[0].contentEquals("월")) {divSche[0] = "가*" + divSche[0];}
								if (divSche[0].contentEquals("화")) {divSche[0] = "나*" + divSche[0];}
								if (divSche[0].contentEquals("수")) {divSche[0] = "다*" + divSche[0];}
								if (divSche[0].contentEquals("목")) {divSche[0] = "라*" + divSche[0];}
								if (divSche[0].contentEquals("금")) {divSche[0] = "마*" + divSche[0];}

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
									String todayClassInfo = divSche[0] + "/" + divSche[1] + "/" + classTitle + "/" + classRoom;
									timeList.add(todayClassInfo);
								}
							}

						} else if (!schedule.contains("/")) { // 금(6,7) 금(8)
							String divSche[] = schedule.split("\\("); // 금 6,7)
							// System.out.println(divSche[0]); // 금
							// System.out.println(divSche[1]); // 6,7)
							divSche[1] = divSche[1].replaceAll("\\)", " "); // )지우기
							// System.out.println(a[1]); //6,7
							if (divSche[0].contentEquals("월")) {divSche[0] = "가*" + divSche[0];}
							if (divSche[0].contentEquals("화")) {divSche[0] = "나*" + divSche[0];}
							if (divSche[0].contentEquals("수")) {divSche[0] = "다*" + divSche[0];}
							if (divSche[0].contentEquals("목")) {divSche[0] = "라*" + divSche[0];}
							if (divSche[0].contentEquals("금")) {divSche[0] = "마*" + divSche[0];}

							if (divSche[1].contains(",")) {
								String divTime[] = divSche[1].split(",");
								for (int j1 = 0; j1 < divTime.length; j1++) {
									divTime[j1] = divTime[j1].replaceAll(" ", "");
									String todayClassInfo = divSche[0] + "/" + divTime[j1] + "/" + classTitle + "/" + classRoom;
									timeList.add(todayClassInfo);
								}
							} else if (!divSche[1].contains(",")) { // 금(8)
								String divTime[] = schedule.split("\\("); // 금 8)
								divTime[1] = divTime[1].replaceAll("\\)", " ");
								divSche[1] = divSche[1].replaceAll(" ", "");
								String todayClassInfo = divSche[0] + "/" + divSche[1] + "/" + classTitle + "/" + classRoom;
								timeList.add(todayClassInfo);

								// timetable(clDay,classTitle,clTime,day,timeList,classRoom);
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
				} else if ( currentRegMonth >= 7 && currentRegMonth <= 12 ) {
					// 2학기
					classOpenDate = currentRegYear + "-08-22";
					semester = "2";
					List<TakingClassDTO> list_takingClass = iservice.takingClass(id, semester, classOpenDate);
					session.setAttribute("list_takingClass", list_takingClass); // 강의항목
					session.setAttribute("semester", semester); // 학기
					session.setAttribute("openClassYear", openClassYear); // 개강년도(현재년도)

					// test
					model.addAttribute("msg", 4);
					return "info/info";
				}

				return "info/info";
			}
		} else if (result == 0) {
			model.addAttribute("errMsg", "아이디와 비밀번호 확인");
			return "info/info";
		}
		return "info/info";
	}

	
	@RequestMapping("/logout")
	public String logout() {
//		session.removeAttribute("loginID");
//		session.removeAttribute("loginPW");
//		session.removeAttribute("loginID");
//		session.removeAttribute("userName");
//		session.removeAttribute("userMajor");
//		session.removeAttribute("userPart");
//		session.removeAttribute("list_std");
//		session.removeAttribute("list_scholar");
//		session.removeAttribute("list_enter");
//		session.removeAttribute("list_takingClass");
//		session.removeAttribute("semester");
//		session.removeAttribute("openClassYear");
		session.invalidate();

		return "info/info";

	}

}
