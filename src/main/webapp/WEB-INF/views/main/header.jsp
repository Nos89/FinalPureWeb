<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
	<div class="container-fluid">
		<div class="row header m-0">
			<!-- Header 부분입니다. 로고, 타이틀, 상단 메뉴 등을 넣어주세요. -->
			<div class="col-12 h-50">
				<div class="row">
					<div class="col-1 p-0 my-1">
						<a href="/" class="navbar-brand">
							<img src="/resources/img/info/gachalogo.png" class="headerLogo">
						</a>
					</div>
					<div class="col-11 text-center rounded mainMenu" >
						<div class="row navbarItemWrapper h-100">
							<div class="col-3 menuItem pt-3" href="#introduce">
								<a href="/main?pageGroup=intro&type=intro">학사 소개</a>
							</div>
							<div class="col-3 menuItem pt-3" href="#intCol">
								<a href="/main?pageGroup=info&type=info">학사 안내</a>
							</div>
							<div class="col-3 menuItem pt-3" href="#community">
								<a href="/main?pageGroup=community&type=free">커뮤니티</a>
							</div>
							<div class="col-3 menuItem pt-3 font-weight-bold" href="#signUpInfo">
								<a href="/main?pageGroup=admission&type=susi">입학 안내</a>
							</div>
						</div>
					</div>
				</div>
				<div class="row position-relative">
					<div class="col-12 collapse p-3 position-absolute border menuDetail" id="introduce">
						<div class="row">
							<div class="col-2 d-none d-lg-block  bg-light"><p>학사 소개<p></div>
							<div class="col-12 col-lg-3 border-top pt-2 menuItemWrapper">
								<ol>
									<li><a href="/main?pageGroup=intro&type=intro"><b>학사 소개</b></a></li>
									<li><a href="/main?pageGroup=intro&type=history"><b>연혁</b></a></li>
									<li><a href="/main?pageGroup=intro&type=educationalPhilosophy"><b>교육이념</b></a></li>
									
								</ol>
							</div>
						</div>
						<div class="col-lg-7 d-none d-lg-block"></div>
					</div>
				</div>
				<div class="row position-relative">
					<div class="col-12 collapse p-3 position-absolute border menuDetail" id="intCol">
						<div class="row">
							<div class="col-2 d-none d-lg-block bg-light"><p>학사 안내<p></div>
							<div class="col-12 col-lg-3 border-top pt-2 menuItemWrapper">
								<ol>
									<li><a href="/main?pageGroup=info&type=info"><b>학사 일정</b></a></li>
									<li><a href="/main?pageGroup=curriculum&type=multipleMajor"><b>교과 과정</b></a></li>
									<li>	
										<ol class="subMenu">
											<li><a href="/main?pageGroup=curriculum&type=multipleMajor">복수 전공 / 부 전공</a></li>
											<li><a href="/main?pageGroup=curriculum&type=teachingCourse">교직과정</a></li>
										</ol>
									</li>
								</ol>
							</div>
							<div class="col-12 col-lg-3 border-top pt-2 menuItemWrapper">
								<ol>
									<li><a href="/main?pageGroup=class&type=gradeAnnouncement"><b>수업</b></a></li>
									<li>
										<ol class="subMenu">
											<li><a href="/main?pageGroup=class&type=gradeAnnouncement">성적 예고제</a></li>
											<li><a href="/main?pageGroup=class&type=testAndGrade">시험 및 성적</a></li>
											<li><a href="/main?pageGroup=class&type=seasonalSemester">계절 학기</a></li>
											<li><a href="/main?pageGroup=class&type=socialServiceCourse">사회 봉사 과목 이수</a></li>
											<li><a href="/main?pageGroup=class&type=employmentSubject">취업 관련 교과목 이수</a></li>
											<li><a href="/main?pageGroup=class&type=attendence">전자 출결부</a></li>
										</ol>
									</li>
								</ol>
							</div>
							<div class="col-12 col-lg-2 border-top pt-2 menuItemWrapper">
								<ol>
									<li><b>학적</b></li>
									<li>
										<ol class="subMenu">
											<li><a href="/main?pageGroup=academic&type=reEntering">재입학</a></li>
											<li><a href="/main?pageGroup=academic&type=returnSchool">휴복학</a></li>
											<li><a href="/main?pageGroup=academic&type=majorAssignment">전공배정</a></li>
											<li><a href="/main?pageGroup=academic&type=exclusion">유급 제적</a></li>
										</ol>
									</li>
								</ol>
							</div>
							<div class="col-12 col-lg-2 border-top pt-2 menuItemWrapper">
								<ol>
									<li><b>등록</b></li>
									<li>
										<ol class="subMenu">
											<li><a href="/main?pageGroup=registration&type=tuition">등록급 납부</a></li>
											<li><a href="https://www.kosaf.go.kr/ko/tuition.do?pg=tuition_main&">학자금 대출</a></li>
										</ol>
									</li>
									<li><a href="/main?pageGroup=&type=gradution"><b>졸업</b></a></li>
									<li><a href="/main?pageGroup=&type=road-map"><b>대학 ROAD-MAP</b></a></li>
									<li><b>증명서 발급</b></li>
									<li>
										<ol class="subMenu">
											<li><a href="/main?pageGroup=certificate&type=academicIssuance">학적 증명서 발급</a></li>
											<li><a href="/main?pageGroup=certificate&type=studentID">학생증 발급</a></li>
										</ol>
									</li>
								</ol>
							</div>
						</div>
					</div>
				</div>
				<div class="row position-relative">
					<div class="col-12 collapse p-3 position-absolute border menuDetail" id="community">
						<div class="row">
							<div class="col-lg-2 d-none d-lg-block bg-light">
								<p>커뮤니티</p>
							</div>
							<div class="col-12 col-lg-3 border-top pt-2 menuItemWrapper">
								<ol>
									<li><a href="/main?pageGroup=community&type=free">자유 게시판</a></li>
									<li><a href="/main?pageGroup=community&type=anonym">대나무숲</a></li>
									<li><a href="/main?pageGroup=community&type=report">건의 게시판</a></li>
									<li><a href="/main?pageGroup=community&type=notice">공지사항</a></li>
									<li><a href="/main?pageGroup=community&type=promote">홍보 게시판</a></li>
									<li><a href="/main?pageGroup=community&type=event">행사 게시판</a></li>
									<li><a href="/main?pageGroup=community&type=archive">학사 자료실</a></li>
								</ol>
							</div>
						</div>	
					</div>
				</div>
			</div>
		</div>
		<script>
			$(".menuItem").mouseover(function(){
				let link = $(this).attr("href");
				console.log(link);
				$(link).addClass("show");
				//$(link).collapse("show");
			})
			$(".menuItem").mouseout(function(){
				let link = $(this).attr("href");
				$(link).removeClass("show");
				//$(link).collapse("hide");
			})
			$(".collapse").mouseover(function(){
				$(this).addClass("show");
				//$(this).collapse("show");
			})
			$(".collapse").mouseout(function(){
				$(this).removeClass("show");
				//$(this).collapse("show");
			})
			
			
			function callAlert(){alert("미구현 페이지 입니다");
			}
		</script>