<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<body>
	<div class="container">
		<div class="row header">
			<!-- Header 부분입니다. 로고, 타이틀, 상단 메뉴 등을 넣어주세요. -->
			<div class="col-12">
				<div class="row">
					<div class="col-2 "><img src="/resources/img/home/Logo.jpg" class="headerLogo"></div>
					<div class="col-8 mainMenu">
						<div class="menuItem" data-bs-toggle="collapse" href="#introduce"><a href="#">학사 소개</a></div>
						<div class="menuItem" data-bs-toggle="collapse" href="#intCol"><a href="#">학사 안내</a></div>
						<div class="menuItem" data-bs-toggle="collapse" href="#community"><a href="#">커뮤니티</a></div>
						<div class="menuItem" data-bs-toggle="collapse" href="#signUpInfo"><a href="#">입학 안내</a></div>
					</div>
					<div class="col-2"></div>
				</div>
				<div class="row position-relative">
					<div class="col-12 collapse p-3 position-absolute" id="introduce">
						<div class="row">
							<div class="col-2"><p>학사 소개<p></div>
							<div class="col-3 menuItemWrapper">
								<ol>
									<li>학사 소개</li>
									<li>연혁</li>
									<li>조직도</li>
								</ol>
							</div>
						</div>
						<div class="col-7"></div>
					</div>
				</div>
				<div class="row position-relative">
					<div class="col-12 collapse p-3 position-absolute" id="intCol">
						<div class="row">
							<div class="col-2"><p>학사 안내<p></div>
							<div class="col-3 menuItemWrapper">
								<ol>
									<li>학사 일정</li>
									<li>교과 과정</li>
									<li>	
										<ol class="subMenu">
											<li>복수 전공 / 부 전공</li>
											<li>교직과정</li>
										</ol>
									</li>
								</ol>
							</div>
							<div class="col-3 menuItemWrapper">
								<ol>
									<li>수업</li>
									<li>
										<ol class="subMenu">
											<li>성적 예고제</li>
											<li>시험 및 성적</li>
											<li>계절 학기</li>
											<li>사회 봉사 과목 이수</li>
											<li>취업 관련 교과목 이수</li>
											<li>강의 평가</li>
											<li>전자 출결부</li>
											<li>휴강 보강</li>
											<li>공결 허가</li>
										</ol>
									</li>
								</ol>
							</div>
							<div class="col-2 menuItemWrapper">
								<ol>
									<li>학적</li>
									<li>
										<ol class="subMenu">
											<li>재입학</li>
											<li>휴복학</li>
											<li>전공배정</li>
											<li>유급 제적</li>
											<li>수료자 졸업</li>
										</ol>
									</li>
								</ol>
							</div>
							<div class="col-2 menuItemWrapper">
								<ol>
									<li>등록</li>
									<li>
										<ol class="subMenu">
											<li>등록급 납부</li>
											<li>학자금 대출</li>
										</ol>
									</li>
									<li>졸업</li>
									<li>대학 ROAD-MAP</li>
									<li>증명서 발급</li>
									<li>
										<ol class="subMenu">
											<li>학적 증명서 발급</li>
											<li>학생증 발급</li>
										</ol>
									</li>
								</ol>
							</div>
						</div>
					</div>
				</div>
				<div class="row position-relative">
					<div class="col-12 collapse p-3 position-absolute" id="community">
						<div class="row">
							<div class="col-2">
								<p>커뮤니티</p>
							</div>
							<div class="col-3 menuItemWrapper">
								<ol>
									<li>자유 게시판</li>
									<li>대나무숲</li>
									<li>건의 게시판</li>
									<li>공지사항</li>
									<li>홍보 게시판</li>
									<li>행사 게시판</li>
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
			})
			$(".menuItem").mouseout(function(){
				let link = $(this).attr("href");
				$(link).removeClass("show");
			})
			$(".collapse").mouseover(function(){
				$(this).addClass("show");
			})
			$(".collapse").mouseout(function(){
				$(this).removeClass("show");
			})
		</script>