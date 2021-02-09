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
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
								<div class="col-3 col-sm-12 menuPart"><a href="/" class="d-inline-block">대표홈페이지</a></div>
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
								<a class="navbar-brand" href="/">oo대학교 포털사이트</a>

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
													href="/home.nex">종합정보시스템</a></li>
												<li class="nav-item active"><a class="nav-link"
													href="#">전자출결</a></li>
												<li class="nav-item active"><a class="nav-link"
													href="/">대표홈페이지</a></li>
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
													href="/home.nex">종합정보시스템</a></li>
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
									
												<c:forEach var="i" items="${timeList}" varStatus="status">
												<div class="subject_isu">${i}</div>
											</c:forEach>
											
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
										<c:forEach var="i" items="${timeList}" varStatus="status">
												<div class="subject_isu">${i}</div>
										</c:forEach>

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