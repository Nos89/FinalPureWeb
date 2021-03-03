<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Info login</title>


<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/resources/css/info/login.css?ver=1">
<link rel="stylesheet" href="/resources/css/info/userPage.css?ver=1">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
	<!-- 테스트 -->
	<script>
		console.log("info.jsp 로딩 : ${loginID}");
		console.log("userName : ${userName}");
		console.log("userMajor : ${userMajor}");
		console.log("${msg} : ${errMsg}");
	</script>
	<script>
		if ("${errMsg}" != "") {
			alert("${errMsg}");
			location.href = "/info";
		}
	</script>
	<c:if test="${not empty  cookie.saveID}">
		<c:set value="checked" var="checked" />
	</c:if>
	<c:choose>
		<c:when test="${loginID==null}">
			<div class="newContainer">
				<div class="container-fluid title">
					<div class="row">
						<div class="col-2 gachalogo mx-5 my-2"
							style="border: 0px solid white;"></div>
					</div>
				</div>

				<div class="container center">
					<form action="/info/login" method=post>
						<div class="row">
							<div class=" col-sm-5 login" style="background-color: #ffffff">
								<div id=loginTitle>
									<h3>로그인</h3>
								</div>
								<div id=loginTitle_eng>Login</div>
								<div class="part" id=part>
									<div class="selectUser" id="loginStd"
										style="background-color: #272727; color: ivory; border: 0px solid white;">학부생용</div>
									<div class="selectUser" id="loginPro"
										style="border: 0px solid white;">교수용</div>
									<div class="selectUser" id="loginAdmin"
										style="border: 0px solid white;">관리자용</div>
								</div>
								<div id=loginID>
									<div id=idTitle>ID</div>
									<input type=text name=id id=idText value="S-"
										placeholder="ID 학번입력" required
										value="${cookie.saveID!=''? cookie.saveID.value:'' }">
								</div>
								<div id=loginPW>
									<div id=pwTitle>PW</div>
									<input type=password name=pw id=pwText placeholder="비밀번호 입력"
										required>
								</div>
								<div id=rmbId>
									<input type=checkbox name="saveID" id=chkBox ${checked}>
									아이디 저장
								</div>
								<div id=findIDPW>
									<input type=button id=findID value="아이디찾기/"> <input
										type=button id=findPW value="비밀번호재설정">
								</div>

								<div id=loginBtn>
									<input type=submit value="로 그 인" id=loginSubmit
										style="border: none; background-color: transparent; color: white; width: 100%;">
								</div>
							</div>

							<div class="col-sm-5 acaCal">
								<div id=acdmCalTitle>
									<h3>학사일정</h3>
								</div>
								<div id=acdmCalTitle_eng>Academic Calendar</div>
								<div id=acmdContainer>
									<div id=acmdCalIcon>
										<img src="/resources/img/info/학사일정아이콘.png">
									</div>
									<div id=acmdCalContents>
										<c:forEach var="i" items="${list4_colSche}" varStatus="status">
											<div id=acmdCalPart>
												<div id=acmdCalTitle>${i.title }</div>
												<div id=acmdCalDate>${i.sche_startDate }~
													${i.sche_endDate }</div>
											</div>
										</c:forEach>
									</div>

								</div>
							</div>
							<div class="col-sm-2 menu">
								<div class="row">
									<div class="col-3 col-sm-12 menuPart" id="classRegistation"
										style="border-bottom: 1px solid #0c3181;">
										<div class="goSugang"></div>
										<p>수강신청</p>
									</div>
									<div class="col-3 col-sm-12 menuPart" id="goHome"
										style="border-top: 1px solid #0c3181; border-bottom: 1px solid #0c3181;">
										<div class="goHome"></div>
										<p>대표홈페이지</p>
									</div>
									<div class="col-2 col-sm-12  menuPart" id="goCalendar"
										style="border-top: 1px solid #0c3181; border-bottom: 1px solid #0c3181;">
										<div class="goCalender"></div>
										<p>학사일정 바로가기</p>
									</div>
									<div class="col-2 col-sm-12  menuPart" id="goComunity"
										style="border-top: 1px solid #0c3181; border-bottom: 1px solid #0c3181;">
										<div class="goComunity"></div>
										<p>커뮤니티</p>
									</div>
									<div class="col-2 col-sm-12  menuPart" id="goIntro"
										style="border-top: 1px solid #0c3181;">
										<div class="goIntro"></div>
										<p>학사소개</p>
									</div>
								</div>

							</div>
						</div>
					</form>
				</div>
			</div>
			<script>
				let loginPro = document.getElementById("loginPro");
				let loginStd = document.getElementById("loginStd");
				let loginAdmin = document.getElementById("loginAdmin");
				loginStd.onclick = function() {
					loginStd.style.backgroundColor = "#272727";
					loginStd.style.color = "ivory";
					loginPro.style.backgroundColor = "transparent";
					loginPro.style.color = "black";
					loginAdmin.style.backgroundColor = "transparent";
					loginAdmin.style.color = "black";
					$("#idText").val("S-");
				}
				loginPro.onclick = function() {
					loginStd.style.backgroundColor = "transparent";
					loginStd.style.color = "black";
					loginPro.style.backgroundColor = "#272727";
					loginPro.style.color = "ivory";
					loginAdmin.style.backgroundColor = "transparent";
					loginAdmin.style.color = "black";
					$("#idText").val("P-");
				}
				loginAdmin.onclick = function() {
					loginStd.style.backgroundColor = "transparent";
					loginStd.style.color = "black";
					loginPro.style.backgroundColor = "transparent";
					loginPro.style.color = "black";
					loginAdmin.style.backgroundColor = "#272727";
					loginAdmin.style.color = "ivory";
					$("#idText").val("A-");
				}
				$(document)
						.keydown(
								function(e) {
									if (e.target.nodeName == "INPUT") {
										if (e.keyCode === 8) {
											if (e.target.value.indexOf('S-') == 0
													|| e.target.value
															.indexOf('P-') == 0
													|| e.target.value
															.indexOf('A-') == 0) {
												if (e.target.value.length < 2) {
													return false;
												} else if (e.target.value
														.indexOf('S-') == 0) {
													$("#idText").val("S-s");
												} else if (e.target.value
														.indexOf('P-') == 0) {
													$("#idText").val("P-s");
												} else if (e.target.value
														.indexOf('A-') == 0) {
													$("#idText").val("A-s");
												}
											}
										}
									}
								});
				//각 메뉴 페이지 연결
				document.getElementById("classRegistation").onclick = function() {
					location.href = "/classRegistration.nex";
				}
				document.getElementById("goHome").onclick = function() {
					location.href = "/";
				}
				document.getElementById("goCalendar").onclick = function() {
					location.href = "/main?pageGroup=info&type=info";
				}
				document.getElementById("goIntro").onclick = function() {
					location.href = "/main?pageGroup=intro&type=intro";
				}
				document.getElementById("goComunity").onclick = function() {
					location.href = "/main?pageGroup=community&type=free";
				}
				$(document).ready(
						function() {
							<c:if test="${result == true}">
							nw.close();
							</c:if>
							$("#findID").click(
									function() {
										var nw = window.open(
												"/info/find?find=id", "아이디 찾기",
												"width=500px; height=300px");
									})

							$("#findPW").click(
									function() {
										var nw = window.open(
												"/info/find?find=pw",
												"비밀번호 찾기",
												"width=500px; height=330px");
									})
						})
			</script>
		</c:when>
		<c:otherwise>
			<div class="newContainer2">
				<div class="container-fluid userPage">
					<div class="row">
						<div class="col-12 ">
							<nav class="navbar navbar-expand-lg navbar-light bg-light">
								<div class="container top">
									<div class="col-4 p-0">
										 <img
											src="/resources/img/info/gachalogo.png" class="headerLogo">
											<a class="navbar-brand" href="/info">포털사이트</a>
									</div>
								
									

									<ul class="nav justify-content-end">

										<li class="nav-item"><a class="nav-link" href="/">Home</a>
										</li>
										<li class="nav-item"><a class="nav-link"
											href="/info/logout">Logout</a></li>
									</ul>
								</div>
							</nav>
						</div>
					</div>
					<c:choose>
						<c:when test="${userPart == '학생' }">
							<div class="row">
								<div class="col-12 topMenu">
									<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
										<button class="navbar-toggler" type="button"
											data-toggle="collapse" data-target="#navbarText"
											aria-controls="navbarText" aria-expanded="false"
											aria-label="Toggle navigation">
											<span class="navbar-toggler-icon"></span>
										</button>
										<div class="collapse navbar-collapse" id="navbarText">
											<div class="container">
												<ul class="navbar-nav mr-auto" id=topMenuInfo>
													<li class="nav-item active"><a class="nav-link"
														href="/home.nex" id=system>종합정보시스템</a></li>
													<li class="nav-item active"><a class="nav-link"
														id="electAttend" href="/elec/toElectAttend"
														target="_blank">전자출결</a></li>
													<li class="nav-item active"><a class="nav-link"
														id=mainpage href="/">대표홈페이지</a></li>
												</ul>
											</div>

										</div>
									</nav>

								</div>
							</div>

						</c:when>
						<c:when test="${userPart == '교수' }">
							<div class="row">
								<div class="col-12 topMenu">
									<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
										<button class="navbar-toggler" type="button"
											data-toggle="collapse" data-target="#navbarText"
											aria-controls="navbarText" aria-expanded="false"
											aria-label="Toggle navigation">
											<span class="navbar-toggler-icon"></span>
										</button>
										<div class="collapse navbar-collapse" id="navbarText">
											<div class="container">
												<ul class="navbar-nav mr-auto">
													<li class="nav-item active"><a class="nav-link"
														href="/home.nex" id=system>종합정보시스템</a></li>
													<li class="nav-item active"><a class="nav-link"
														href="/" id=mainpage>대표홈페이지</a></li>
												</ul>
											</div>
											</div>
											</nav>
											</div>
											</div>
					</c:when>
					<c:when test="${userPart == '교수'}">
						<div class="row">
							<div class="col-12 topMenu">
								<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
									<button class="navbar-toggler" type="button"
										data-toggle="collapse" data-target="#navbarText"
										aria-controls="navbarText" aria-expanded="false"
										aria-label="Toggle navigation">
										<span class="navbar-toggler-icon"></span>
									</button>
									<div class="collapse navbar-collapse" id="navbarText">
										<div class="container">
											<ul class="navbar-nav mr-auto">
												<li class="nav-item active"><a class="nav-link"
													href="/home.nex" id=system>종합정보시스템</a></li>
												<li class="nav-item active"><a class="nav-link"
													href="/" id=mainpage>대표홈페이지</a></li>
											</ul>
										</div>

										</div>
									</nav>

								</div>
							</div>

						</c:when>
					</c:choose>

				</div>
				<div class="container center" style="margin-top: 30px;">
					<div class="row">
						<div class="col-sm-9">
							<div class="row">

							<c:choose>
								<c:when test="${userPart == '학생' }">
									<div class="col-12 col-sm-4 my">
										<div class=name>${userName }님</div>
										<div class="major">${userMajor }학과</div>
										<div class="mail">
											<div class=mail_notRead>안 읽은 메일</div>
											<div class="mail_notReadNum">${unread}건</div>
										</div>
									</div>
								</c:when>
								<c:when test="${userPart == '교수' }">
									<div class="col-12 col-sm-4 my">
										<div class=name>${userName }님</div>
										<div class="major">${userMajor }학과</div>
										<div class="mail">
											<div class=mail_notRead>안 읽은 메일</div>
											<div class="mail_notReadNum">${unread}건</div>

										</div>
										</div>
									</c:when>
								</c:choose>


								<div class="col-12 col-sm-8 board">
									<div class="row">
										<div class="col-11">
											<ul class="nav nav-tabs ">
												<li class="nav-item"><a class="nav-link active"
													data-toggle="tab" href="#nav-std-tab">학사</a></li>
												<li class="nav-item"><a class="nav-link"
													data-toggle="tab" href="#nav-scholarship-tab">장학</a></li>
												<li class="nav-item"><a class="nav-link"
													data-toggle="tab" href="#nav-enter-tab">입학</a></li>
											</ul>

											<div class="tab-content">
												<div class="tab-pane fade show active" id="nav-std-tab">
													<div class="tab_list">
														<c:forEach var="i" items="${list_std}" varStatus="status">
															<div class="tab_title_std">${i.noti_title}<div
																	id=std_seq style="display: none;">${i.noti_seq }</div>
															</div>
															<div class="tab_date">${i.noti_writedate}</div>
														</c:forEach>
													</div>
												</div>

												<script>
													$(document)
															.on(
																	'click',
																	'.tab_title_std',
																	function() {
																		let seq = $(
																				this)
																				.children()
																				.html();
																		location.href = "/info/tabToGoBoard?category=학사&seq="
																				+ seq;
																	});
												</script>

												<div class="tab-pane fade" id="nav-scholarship-tab">
													<div class="tab_list">
														<c:forEach var="i" items="${list_scholar}"
															varStatus="status">
															<div class="tab_title_scholar">${i.noti_title}<div
																	id=std_seq style="display: none;">${i.noti_seq }</div>
															</div>
															<div class="tab_date">${i.noti_writedate}</div>
														</c:forEach>
													</div>
												</div>
												<script>
													$(document)
															.on(
																	'click',
																	'.tab_title_scholar',
																	function() {
																		let seq = $(
																				this)
																				.children()
																				.html();
																		location.href = "/info/tabToGoBoard?category=장학&seq="
																				+ seq;
																	});
												</script>


												<div class="tab-pane fade" id="nav-enter-tab">
													<div class="tab_list">
														<c:forEach var="i" items="${list_enter}"
															varStatus="status">
															<div class="tab_title_enter" id=tabTitle_enter>${i.noti_title}<div
																	id=std_seq style="display: none;">${i.noti_seq }</div>
															</div>
															<div class="tab_date">${i.noti_writedate}</div>
														</c:forEach>
													</div>
												</div>
												<script>
													$(document)
															.on(
																	'click',
																	'.tab_title_enter',
																	function() {
																		let seq = $(
																				this)
																				.children()
																				.html();
																		location.href = "/info/tabToGoBoard?category=입학&seq="
																				+ seq;
																	});
												</script>
											</div>


										</div>
										<div class="col-1">
											<nav class="nav justify-content-end">
												<a class="nav-link "
													href="/main/board.list?pageGroup=community&type=notice"
													style="color: black; font-weight: bold;">+</a>
											</nav>
										</div>
									</div>

								</div>
							</div>
							<div class="row">
								<c:choose>
									<c:when test="${userPart == '학생' }">
										<div class="col-12 col-sm-4 subject">
											<div class="row ">
												<div class="col-5 ">
													<nav class="nav">
														<a class="nav-link disabled" href="#" aria-disabled="true"
															style="color: white; font-weight: bold; font-size: 14px;">수강과목</a>
													</nav>
												</div>
												<div class="col-7">
													<nav class="nav justify-content-end">
														<a class="nav-link disabled" href="#" aria-disabled="true"
															style="color: white; font-size: 12px;">${openClassYear }년도
															${semester }학기</a>
													</nav>
												</div>
											</div>
											<div class="subject_list">
												<c:forEach var="i" items="${list_takingClass}"
													varStatus="status">
													<div class="subject_isu">[${i.lec_isu }]</div>
													<div class="subject_title">${i.lec_title }</div>
													<div class="subject_score">- 학점 ${i.lec_score }점</div>
												</c:forEach>
											</div>
										</div>
									</c:when>
									<c:when test="${userPart == '교수' }">
										<div class="col-12 col-sm-4 subject">
											<div class="row ">
												<div class="col-5 ">
													<nav class="nav">
														<a class="nav-link disabled" href="#" aria-disabled="true"
															style="color: white; font-weight: bold; font-size: 14px;">강의과목</a>
													</nav>
												</div>
												<div class="col-7">
													<nav class="nav justify-content-end">
														<a class="nav-link disabled" href="#" aria-disabled="true"
															style="color: white; font-size: 12px;">${openClassYear }년도
															${semester }학기</a>
													</nav>
												</div>
											</div>

											<div class="subject_list">
												<c:forEach var="i" items="${list_takingClass}"
													varStatus="status">
													<div class="subject_isu">[${i.lec_isu }]</div>
													<div class="subject_title">${i.lec_title }</div>
													<div class="subject_score">- 학점 ${i.lec_score }점</div>
												</c:forEach>
											</div>
										</div>
									</c:when>
								</c:choose>

								<div class="col-12 col-sm-8 schedule">
									<div class="row">

										<div class="col-12 col-sm-6 calendar"
											style="padding-left: 0px; padding-right: 0px;">
											<table id="calendar"
												style="width: 100%; height: 100%; text-align: center">
												<tr>
													<td id="tbCalendarYM" colspan="5">yyyy년 m월</td>
													<td><label onclick="prevCalendar()"
														style="cursor: pointer">◀</label></td>
													<td><label onclick="nextCalendar()"
														style="cursor: pointer;">▶</label></td>
												</tr>
												<tr id=weeks>
													<td align="center"><font color="red">SUN</font></td>
													<td align="center"><font color="white">MON</font></td>
													<td align="center"><font color="white">TUE</font></td>
													<td align="center"><font color="white">WED</font></td>
													<td align="center"><font color="white">THU</font></td>
													<td align="center"><font color="white">FRI</font></td>
													<td align="center"><font color="blue">SAT</font></td>
												</tr>
											</table>
										</div>
										<div class="col-12 col-sm-6 sche" style="overflow: scroll;">
											<div class="row ">
												<div class="col-6 ">
													<nav class="nav">
														<a class="nav-link disabled" href="#" aria-disabled="true"
															style="color: black; font-weight: bold; font-size: 14px;">학사일정</a>
													</nav>
												</div>
												<div class="col-6">
													<nav class="nav justify-content-end">
														<a class="nav-link " href="/main?pageGroup=info&type=info"
															style="color: black; font-weight: bold;">+</a>
													</nav>
												</div>
											</div>
											<div class="colSche_list">
												<c:forEach var="i" items="${list_colSche}"
													varStatus="status">
													<div class="colSche_day">${i.sche_startDate }~
														${i.sche_endDate }</div>
													<div class="colSche_title">${i.title }</div>
												</c:forEach>
											</div>


										</div>

									</div>
								</div>
							</div>
						</div>

						<div class="col-12 col-sm-3 timetable">
							<c:choose>
								<c:when test="${userPart == '학생' }">

									<div class="classtimetable">
										<div class="row ">
											<div class="col-6 ">
												<nav class="nav">
													<a class="nav-link disabled" href="#" aria-disabled="true"
														style="color: black; font-weight: bold; font-size: 14px;">수강시간표</a>
												</nav>
											</div>
											<div class="col-6">
												<nav class="nav justify-content-end">
													<a class="nav-link disabled" href="#" aria-disabled="true"
														style="color: black; font-size: 11.3px;">${openClassYear }년도
														${semester }학기</a>
												</nav>
											</div>
										</div>
										<div class="realtimetable">
											<table class="timeTable" border=1>
												<tr>
													<th style="font-size: 10px;">요일 / 교시</th>
													<th>월</th>
													<th>화</th>
													<th>수</th>
													<th>목</th>
													<th>금</th>
												</tr>
												<tr class="time">
													<td>1</td>
												</tr>
												<tr class="time">
													<td>2</td>
												</tr>
												<tr class="time">
													<td>3</td>
												</tr>
												<tr class="time">
													<td>4</td>
												</tr>
												<tr class="time">
													<td>5</td>
												</tr>
												<tr class="time">
													<td>6</td>
												</tr>
												<tr class="time">
													<td>7</td>
												</tr>
												<tr class="time">
													<td>8</td>
												</tr>
												<tr class="time">
													<td>9</td>
												</tr>
											</table>
										</div>
									</div>

								</c:when>
								<c:when test="${userPart == '교수' }">
									<div class="classtimetable">
										<div class="row ">
											<div class="col-6 ">
												<nav class="nav">
													<a class="nav-link disabled" href="#" aria-disabled="true"
														style="color: black; font-weight: bold; font-size: 14px;">강의시간표</a>
												</nav>
											</div>
											<div class="col-6">
												<nav class="nav justify-content-end">
													<a class="nav-link disabled" href="#" aria-disabled="true"
														style="color: black; font-size: 11.3px;">${openClassYear }년도
														${semester }학기</a>
												</nav>
											</div>
										</div>
										<div class="realtimetable">
											<table class="timeTable" border=1>
												<tr>
													<th style="font-size: 10px;">요일 / 교시</th>
													<th style="width: 15%;">월</th>
													<th style="width: 15%;">화</th>
													<th style="width: 15%;">수</th>
													<th style="width: 15%;">목</th>
													<th style="width: 15%;">금</th>
												</tr>
												<tr class="time">
													<td>1</td>
												</tr>
												<tr class="time">
													<td>2</td>
												</tr>
												<tr class="time">
													<td>3</td>
												</tr>
												<tr class="time">
													<td>4</td>
												</tr>
												<tr class="time">
													<td>5</td>
												</tr>
												<tr class="time">
													<td>6</td>
												</tr>
												<tr class="time">
													<td>7</td>
												</tr>
												<tr class="time">
													<td>8</td>
												</tr>
												<tr class="time">
													<td>9</td>
												</tr>
											</table>

										</div>
									</div>
								</c:when>
							</c:choose>
						</div>

					</div>

				</div>
				<div class="container shortcutPart">
					<div class="row">
						<div class="col-12 col-sm-1 shortcut">바로가기</div>
						<div class="col-2 col-sm-2 toClassSche">
							<div class="image">
								<img src="/resources/img/info/Calendar.png">
							</div>
							<div class="text">학사일정</div>
						</div>
						<div class="col-2 col-sm-2 toReturnSchool">
							<div class="image">
								<img src="/resources/img/info/returnSchool.png">
							</div>
							<div class="text">휴ㆍ복학 안내</div>
						</div>
						<div class="col-2 col-sm-2 toTestAndGrade">
							<div class="image">
								<img src="/resources/img/info/dormitory.png">
							</div>
							<div class="text">시험 및 성적</div>
						</div>
						<div class="col-2 col-sm-2 toReportBoard">
							<div class="image">
								<img src="/resources/img/info/board.png">
							</div>
							<div class="text">건의게시판</div>
						</div>
						<div class="col-2 col-sm-2 toExAuth">
							<div class="image">
								<img src="/resources/img/info/document.png">
							</div>
							<div class="text">인터넷증명</div>
						</div>
					</div>
				</div>
			</div>
			<div class="container-fluid footer" style="margin-top: 30px;">
				<div class="row">
					<div class="col-12">
						<nav class="navbar navbar-expand-lg navbar-light bg-light">
							<button class="navbar-toggler" type="button"
								data-toggle="collapse" data-target="#navbarText"
								aria-controls="navbarText" aria-expanded="false"
								aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>
							<div class="collapse navbar-collapse" id="navbarText">
								<div class="container">
									<ul class="navbar-nav mr-auto">
										<li class="nav-item active"><a class="nav-link"
											href="https://github.com/Nos89" target="_blank">Git-hub</a></li>
										<li class="nav-item active"><a class="nav-link"
											href="https://www.notion.so/TEAM-HOME-Template-7a319abf285249c8ac20ab8162de2a21"
											target="_blank">Notion</a></li>
										<li class="nav-item active"><a class="nav-link"
											href="https://discord.gg/SVTQrFAC" target="_blank">Discord</a>
										</li>
									</ul>
								</div>

							</div>
						</nav>
					</div>
				</div>


			</div>
			<div class="container-fluid footer">
				<div class="row">
					<div class="col-12">
						<div class=footerText>[874-88] 서울시 어디구 어디로 87-99 | TEL:
							02-0008-4545 | FAX: 02-4878-6524</div>
						<div class=footerText>COPYRIGHTⓒ 2017 GACHA UNIVERSITY. ALL
							RIGHTS RESERVED.</div>
					</div>
				</div>


			</div>
			<script>
				var today = new Date();//오늘 날짜//내 컴퓨터 로컬을 기준으로 today에 Date 객체를 넣어줌
				var date = new Date();//today의 Date를 세어주는 역할

				buildCalendar();

				function prevCalendar() {//이전 달
					today = new Date(today.getFullYear(), today.getMonth() - 1,
							today.getDate());
					buildCalendar();
				}
				function nextCalendar() {//다음 달
					today = new Date(today.getFullYear(), today.getMonth() + 1,
							today.getDate());
					buildCalendar();
				}
				function buildCalendar() {//현재 달 달력 만들기
					var doMonth = new Date(today.getFullYear(), today
							.getMonth(), 1);
					var lastDate = new Date(today.getFullYear(), today
							.getMonth() + 1, 0);
					var tbCalendar = document.getElementById("calendar");//날짜를 찍을 테이블 변수 만듬, 일 까지 다 찍힘
					var tbCalendarYM = document.getElementById("tbCalendarYM");//테이블에 정확한 날짜 찍는 변수
					tbCalendarYM.innerHTML = today.getFullYear() + "년 "
							+ (today.getMonth() + 1) + "월";
					/*while은 이번달이 끝나면 다음달로 넘겨주는 역할*/
					while (tbCalendar.rows.length > 2) {
						//열을 지워줌
						//기본 열 크기는 body 부분에서 2로 고정되어 있다.
						tbCalendar.deleteRow(tbCalendar.rows.length - 1);
						//테이블의 tr 갯수 만큼의 열 묶음은 -1칸 해줘야지 
						//30일 이후로 담을달에 순서대로 열이 계속 이어진다.
					}
					var row = null;
					row = tbCalendar.insertRow();
					//테이블에 새로운 열 삽입//즉, 초기화
					var cnt = 0;// count, 셀의 갯수를 세어주는 역할
					// 1일이 시작되는 칸을 맞추어 줌
					for (i = 0; i < doMonth.getDay(); i++) {
						/*이번달의 day만큼 돌림*/
						cell = row.insertCell();//열 한칸한칸 계속 만들어주는 역할
						cnt = cnt + 1;//열의 갯수를 계속 다음으로 위치하게 해주는 역할
					}
					/*달력 출력*/
					for (i = 1; i <= lastDate.getDate(); i++) {
						//1일부터 마지막 일까지 돌림
						cell = row.insertCell();//열 한칸한칸 계속 만들어주는 역할
						cell.innerHTML = i;//셀을 1부터 마지막 day까지 HTML 문법에 넣어줌
						cnt = cnt + 1;//열의 갯수를 계속 다음으로 위치하게 해주는 역할
						if (cnt % 7 == 1) {/*일요일 계산*/
							cell.innerHTML = "<font color=red>" + i
						}
						if (cnt % 7 == 0) {/*토요일 구하기*/
							cell.innerHTML = "<font color=blue>" + i
							row = calendar.insertRow();//토요일 다음에 올 셀을 추가
						}
						/*오늘의 날짜에 노란색 칠하기*/
						if (today.getFullYear() == date.getFullYear()
								&& today.getMonth() == date.getMonth()
								&& i == date.getDate()) {
							cell.bgColor = "#FAF58C";
						}
					}
				}
			</script>

			<script>
				let day;
				let time;
				let title;
				let classroom;
				let fillEmpty = function(fillLength) {
					for (let j = 0; j < 9; j++) {
						if ($(".time").eq(j).children().length <= fillLength) {
							let emptyLength = fillLength
									- $(".time").eq(j).children().length + 1;
							for (let k = 0; k < emptyLength; k++) {
								let empty = $("<td></td>");
								$(".time").eq(j).append(empty);
							}
						}
					}
				}

				<c:forEach var="i" items="${timeList}" varStatus="status">
				//가*/월/2/강의명/강의실
				day = "${i}".split("/")[0];
				day = day.split("*");
				day = day[1];
				time = "${i}".split("/")[1];
				title = "${i}".split("/")[2];
				classroom = "${i}".split("/")[3];

				if (day == "월") {
					let lecture = $("<td></td>");
					lecture.html(title);
					$(".time").eq(time[0] - 1).append(lecture);
				}
				if (day == "화") {
					fillEmpty(1);
					let lecture = $("<td></td>");
					lecture.html(title);
					$(".time").eq(time[0] - 1).append(lecture);
				}
				if (day == "수") {
					fillEmpty(2);
					let lecture = $("<td></td>");
					lecture.html(title);
					$(".time").eq(time[0] - 1).append(lecture);
				}
				if (day == "목") {
					fillEmpty(3);
					let lecture = $("<td></td>");
					lecture.html(title);
					$(".time").eq(time[0] - 1).append(lecture);
				}
				if (day == "금") {
					fillEmpty(4);
					let lecture = $("<td></td>");
					lecture.html(title);
					$(".time").eq(time[0] - 1).append(lecture);
				}
				if (day == "토") {
					fillEmpty(5);
				}
				</c:forEach>
			</script>

			<script>
			<!--바로가기 모음  -->
				$(document).on('click', '.toClassSche', function() {
					location.href = "/main?pageGroup=info&type=info";
				});
				$(document)
						.on(
								'click',
								'.toReturnSchool',
								function() {
									location.href = "/main?pageGroup=academic&type=returnSchool";
								});
				$(document).on('click', '.toTestAndGrade', function() {
					location.href = "/main?pageGroup=class&type=testAndGrade";
				});
				$(document).on('click', '.toReportBoard', function() {
					location.href = "/main?pageGroup=community&type=report";
				});
				$(document)
						.on(
								'click',
								'.toExAuth',
								function() {
									location.href = "/main?pageGroup=certificate&type=academicIssuance";
								});
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>