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
<script>
	<script>
	var today = new Date();//오늘 날짜//내 컴퓨터 로컬을 기준으로 today에 Date 객체를 넣어줌
	var date = new Date();//today의 Date를 세어주는 역할
	function prevCalendar() {//이전 달
		// 이전 달을 today에 값을 저장하고 달력에 today를 넣어줌
		//today.getFullYear() 현재 년도//today.getMonth() 월  //today.getDate() 일 
		//getMonth()는 현재 달을 받아 오므로 이전달을 출력하려면 -1을 해줘야함
		today = new Date(today.getFullYear(), today.getMonth() - 1, today
				.getDate());
		buildCalendar(); //달력 cell 만들어 출력 
	}
	function nextCalendar() {//다음 달
		// 다음 달을 today에 값을 저장하고 달력에 today 넣어줌
		//today.getFullYear() 현재 년도//today.getMonth() 월  //today.getDate() 일 
		//getMonth()는 현재 달을 받아 오므로 다음달을 출력하려면 +1을 해줘야함
		today = new Date(today.getFullYear(), today.getMonth() + 1, today
				.getDate());
		buildCalendar();//달력 cell 만들어 출력
	}
	function buildCalendar() {//현재 달 달력 만들기
		var doMonth = new Date(today.getFullYear(), today.getMonth(), 1);
		//이번 달의 첫째 날,
		//new를 쓰는 이유 : new를 쓰면 이번달의 로컬 월을 정확하게 받아온다.     
		//new를 쓰지 않았을때 이번달을 받아오려면 +1을 해줘야한다. 
		//왜냐면 getMonth()는 0~11을 반환하기 때문
		var lastDate = new Date(today.getFullYear(), today.getMonth() + 1, 0);
		//이번 달의 마지막 날
		//new를 써주면 정확한 월을 가져옴, getMonth()+1을 해주면 다음달로 넘어가는데
		//day를 1부터 시작하는게 아니라 0부터 시작하기 때문에 
		//대로 된 다음달 시작일(1일)은 못가져오고 1 전인 0, 즉 전달 마지막일 을 가져오게 된다
		var tbCalendar = document.getElementById("calendar");
		//날짜를 찍을 테이블 변수 만듬, 일 까지 다 찍힘
		var tbCalendarYM = document.getElementById("tbCalendarYM");
		//테이블에 정확한 날짜 찍는 변수
		//innerHTML : js 언어를 HTML의 권장 표준 언어로 바꾼다
		//new를 찍지 않아서 month는 +1을 더해줘야 한다. 
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
				//1주일이 7일 이므로 일요일 구하기
				//월화수목금토일을 7로 나눴을때 나머지가 1이면 cnt가 1번째에 위치함을 의미한다
				cell.innerHTML = "<font color=red>" + i
				//1번째의 cell에만 색칠
			}
			if (cnt % 7 == 0) {/* 1주일이 7일 이므로 토요일 구하기*/
				//월화수목금토일을 7로 나눴을때 나머지가 0이면 cnt가 7번째에 위치함을 의미한다
				cell.innerHTML = "<font color=blue>" + i
				//7번째의 cell에만 색칠
				row = calendar.insertRow();
				//토요일 다음에 올 셀을 추가
			}
			/*오늘의 날짜에 노란색 칠하기*/
			if (today.getFullYear() == date.getFullYear()
					&& today.getMonth() == date.getMonth()
					&& i == date.getDate()) {
				//달력에 있는 년,달과 내 컴퓨터의 로컬 년,달이 같고, 일이 오늘의 일과 같으면
				cell.bgColor = "#FAF58C";//셀의 배경색을 노랑으로 

			}
		}
	}
</script>

</head>
<body>
	<c:choose>
		<c:when test="${loginID==null}">
			<div class="container-fluid title">
				<div class="row">
					<div class="col-2 mx-5 my-2">oo 대학교 (로고사진)</div>
				</div>
			</div>

			<div class="container center">
				<form action="/info/login" method=post>
					<div class="row">
						<div class=" col-sm-5 login">
							<div id=loginTitle>
								<h3>로그인</h3>
							</div>
							<div id=loginTitle_eng>Login</div>
							<div id=part>
								<div id="loginStd"
									style="background-color: #272727; color: ivory;">학부생용</div>
								<div id="loginPro">교수용</div>
							</div>
							<div id=loginID>
								<div id=idTitle>ID</div>
								<input type=text name=id id=idText placeholder="id placeholder"
									required>
							</div>
							<div id=loginPW>
								<div id=pwTitle>PW</div>
								<input type=text name=pw id=pwText placeholder="pw placeholder"
									required>
							</div>
							<div id=rmbId>
								<input type=checkbox id=chkBox> 아이디 저장
							</div>
							<div id=findIDPW>
								<input type=button id=findID value="아이디찾기"><input
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
									<div id=acmdCalPart>
										<div id=acmdCalTitle>[학사일정] 계절학기수업</div>
										<div id=acmdCalDate>2021-01-04 ~ 2021-01-22</div>
									</div>
									<div id=acmdCalPart>
										<div id=acmdCalTitle>[학사일정] 계절학기수업</div>
										<div id=acmdCalDate>2021-01-04 ~ 2021-01-22</div>
									</div>
									<div id=acmdCalPart>
										<div id=acmdCalTitle>[학사일정] 계절학기수업</div>
										<div id=acmdCalDate>2021-01-04 ~ 2021-01-22</div>
									</div>
									<div id=acmdCalPart>
										<div id=acmdCalTitle>[학사일정] 계절학기수업</div>
										<div id=acmdCalDate>2021-01-04 ~ 2021-01-22</div>
									</div>
								</div>

							</div>
						</div>
						<div class="col-sm-2 menu">
							<div class="row">
								<div class="col-3 col-sm-12 menuPart">수강신청</div>
								<div class="col-3 col-sm-12 menuPart">대표홈페이지</div>
								<div class="col-2 col-sm-12  menuPart">~~로 이동</div>
								<div class="col-2 col-sm-12  menuPart">~~로 이동</div>
								<div class="col-2 col-sm-12  menuPart">도움말</div>
							</div>

						</div>
					</div>
				</form>
			</div>
			<script>
				let loginPro = document.getElementById("loginPro");
				let loginStd = document.getElementById("loginStd");

				loginStd.onclick = function() {
					loginPro.style.backgroundColor = "transparent";
					loginPro.style.color = "black";
					loginStd.style.backgroundColor = "#272727";
					loginStd.style.color = "ivory";
				}
				loginPro.onclick = function() {
					loginStd.style.backgroundColor = "transparent";
					loginStd.style.color = "black";
					loginPro.style.backgroundColor = "#272727";
					loginPro.style.color = "ivory";
				}
			</script>
		</c:when>
		<c:otherwise>
			<div class="container-fluid userPage">
				<div class="row">
					<div class="col-12 ">
						<nav class="navbar navbar-expand-lg navbar-light bg-light">
							<div class="container">
								<a class="navbar-brand" href="#">oo대학교 포털사이트</a>

								<ul class="nav justify-content-end">

									<li class="nav-item"><a class="nav-link" href="#">Home</a>
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
											<ul class="navbar-nav mr-auto">
												<li class="nav-item active"><a class="nav-link"
													href="#">종합정보시스템</a></li>
												<li class="nav-item active"><a class="nav-link"
													href="#">전자출결</a></li>
												<li class="nav-item active"><a class="nav-link"
													href="#">대표홈페이지</a></li>
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
													href="#">종합정보시스템</a></li>
												<li class="nav-item active"><a class="nav-link"
													href="#">전자출결</a></li>
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
											<div class="mail_notReadNum">건</div>
										</div>
										<div class="consultReqPart">
											<div class=consultReq>상담신청</div>
											<div class="consultReqNum">건</div>
										</div>

									</div>
								</c:when>
								<c:when test="${userPart == '교수' }">
									<div class="col-12 col-sm-4 my">
										<div class=name>${userName }님</div>
										<div class="major">${userMajor }학과</div>
										<div class="mail">
											<div class=mail_notRead>안 읽은 메일</div>
											<div class="mail_notReadNum">건</div>
										</div>
									</div>
								</c:when>
							</c:choose>


							<div class="col-12 col-sm-8 board">
								<div class="row">
									<div class="col-11">
										<ul class="nav nav-tabs">
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
														<div class="tab_title">${i.noti_title}</div>
														<div class="tab_date">${i.noti_writedate}</div>
													</c:forEach>
												</div>
											</div>
											<div class="tab-pane fade" id="nav-scholarship-tab">
												<div class="tab_list">
													<c:forEach var="i" items="${list_scholar}"
														varStatus="status">
														<div class="tab_title">${i.noti_title}</div>
														<div class="tab_date">${i.noti_writedate}</div>
													</c:forEach>
												</div>
											</div>
											<div class="tab-pane fade" id="nav-enter-tab">
												<div class="tab_list">
													<c:forEach var="i" items="${list_enter}" varStatus="status">
														<div class="tab_title">${i.noti_title}</div>
														<div class="tab_date">${i.noti_writedate}</div>
													</c:forEach>
												</div>
											</div>
										</div>

									</div>
									<div class="col-1">
										<nav class="nav justify-content-end">
											<a class="nav-link " href="#"
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
														style="color: black; font-weight: bold; font-size: 14px;">수강과목</a>
												</nav>
											</div>
											<div class="col-7">
												<nav class="nav justify-content-end">
													<a class="nav-link disabled" href="#" aria-disabled="true"
														style="color: black; font-size: 12px;">${openClassYear }년도 ${semester }학기</a>
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
														style="color: black; font-weight: bold; font-size: 14px;">강의과목</a>
												</nav>
											</div>
											<div class="col-7">
												<nav class="nav justify-content-end">
													<a class="nav-link disabled" href="#" aria-disabled="true"
														style="color: black; font-size: 12px;">${openClassYear }년도 ${semester }학기</a>
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

									<div class="col-12 col-sm-6 calendar">달력</div>
									<div class="col-12 col-sm-6 sche">
										<div class="row ">
											<div class="col-6 ">
												<nav class="nav">
													<a class="nav-link disabled" href="#" aria-disabled="true"
														style="color: black; font-weight: bold; font-size: 14px;">학사일정</a>
												</nav>
											</div>
											<div class="col-6">
												<nav class="nav justify-content-end">
													<a class="nav-link " href="#"
														style="color: black; font-weight: bold;">+</a>
												</nav>
											</div>
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
													style="color: black; font-weight: bold; font-size: 14px;">강의시간표</a>
											</nav>
										</div>
										<div class="col-6">
											<nav class="nav justify-content-end">
												<a class="nav-link disabled" href="#" aria-disabled="true"
													style="color: black; font-size: 11.3px;">${openClassYear }년도 ${semester }학기</a>
											</nav>
										</div>
									</div>

									<div class="realtimetable">
										<table border="1"
											style="height: 100%; width: 100%; text-align: center;">
											<tr>
												<td></td>
												<td>월</td>
												<td>화</td>
												<td>수</td>
												<td>목</td>
												<td>금</td>
											</tr>
											<tr>
												<td>1</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
											<tr>
												<td>2</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
											<tr>
												<td>3</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
											<tr>
												<td>4</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
											<tr>
												<td>5</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
											<tr>
												<td>6</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
											<tr>
												<td>7</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
											<tr>
												<td>8</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
											<tr>
												<td>9</td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
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
													style="color: black; font-weight: bold; font-size: 14px;">수강시간표</a>
											</nav>
										</div>
										<div class="col-6">
											<nav class="nav justify-content-end">
												<a class="nav-link disabled" href="#" aria-disabled="true"
													style="color: black; font-size: 11.3px;">${openClassYear }년도 ${semester }학기</a>
											</nav>
										</div>
									</div>
									<div class="realtimetable">
										<table border="1"
											style="height: 100%; width: 100%; text-align: center;">
											<tr>
												<td></td>
												<td>월</td><td>화</td><td>수</td><td>목</td><td>금</td>
											</tr>
											<tr>
												<td>1</td>
												<td id=mon1></td><td id=tue1></td><td></td><td></td><td id=fri1></td>
											</tr>
											<tr>
												<td>2</td>
												<td id=mon2></td><td id=tue2></td><td></td><td></td><td id=fri2></td>
											</tr>
											<tr>
												<td>3</td>
												<td id=mon3></td><td id=tue3></td><td></td><td></td><td id=fri3></td>
											</tr>
											<tr>
												<td>4</td>
												<td id=mon4></td><td id=tue4></td><td></td><td></td><td id=fri4></td>
											</tr>
											<tr>
												<td>5</td>
												<td id=mon5></td><td id=tue5></td><td></td><td></td><td id=fri5></td>
											</tr>
											<tr>
												<td>6</td>
												<td id=mon6></td><td id=tue6></td><td></td><td></td><td id=fri6></td>
											</tr>
											<tr>
												<td>7</td>
												<td id=mon7></td><td id=tue7></td><td></td><td></td><td id=fri7></td>
											</tr>
											<tr>
												<td>8</td>
												<td id=mon8></td><td id=tue8></td><td></td><td></td><td id=fri8></td>
											</tr>
											<tr>
												<td>9</td>
												<td id=mon9></td><td id=tue9></td><td></td><td></td><td id=fri9></td>
											</tr>
										</table>


									</div>
								</div>
							</c:when>
						</c:choose>
					</div>

				</div>

			</div>
			<div class="container shortcutPart" style="margin-top: 30px;">
				<div class="row">
					<div class="col-12 col-sm-1 shortcut">바로가기</div>
					<div class="col-2 col-sm-2 toClassSche">학사일정</div>
					<div class="col-2 col-sm-2 toBus">통학버스</div>
					<div class="col-2 col-sm-2 toDomi">생활관안내</div>
					<div class="col-2 col-sm-2 toReportBoard">건의게시판</div>
					<div class="col-2 col-sm-2 toExAuth">인터넷증명</div>
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
										<li class="nav-item active"><a class="nav-link" href="#">개인정보처리방침</a>
										</li>
										<li class="nav-item active"><a class="nav-link" href="#">정보공개</a>
										</li>
										<li class="nav-item active"><a class="nav-link" href="#">이메일수집거부</a>
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
						<div class="container">copyright 사진</div>
					</div>
				</div>


			</div>




		</c:otherwise>
	</c:choose>















	<script language="javascript" type="text/javascript">
		buildCalendar();//
	</script>
	<!--바로가기 모음  -->
	<script>
		$(document).on('click', '.toClassSche', function() {
			location.href = "";
		});
		$(document).on('click', '.toBus', function() {
			location.href = "";
		});
		$(document).on('click', '.toDomi', function() {
			location.href = "";
		});
		$(document).on('click', '.toReportBoard', function() {
			location.href = "";
		});
		$(document).on('click', '.toExAuth', function() {
			location.href = "";
		});
	</script>


</body>
</html>