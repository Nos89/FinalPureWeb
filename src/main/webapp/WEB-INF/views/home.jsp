<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/head.jsp" %>
<%@ include file="main/header.jsp" %>
		<div class="row body mt-3">
			<!-- Body 부분 입니다. 왼쪽 메뉴, 메인 컨텐츠 부분 넣어주세요. -->
			<div class="col-12">
				<div class="homeSlide">
					<div><img src="/resources/img/home/homeSlider01.jpg"></div>
					<div><img src="/resources/img/home/homeSlider02.jpg"></div>
					<div><img src="/resources/img/home/homeSlider03.jpg"></div>
				</div>
			</div>
			<div class="col-1"></div>
			<div class="col-10 advSliderWrapper">
				<div class="advSlider">
					<div class="advItemWrapper">
						<img src="/resources/img/home/adv01.jpg">
						<p>행사1</p>
						<p>2020-04-10</p>
					</div>
					<div class="advItemWrapper">
						<img src="/resources/img/home/adv02.jpg">
						<p>행사2</p>
						<p>2020-04-10</p>
					</div>
					<div class="advItemWrapper">
						<img src="/resources/img/home/adv03.jpg">
						<p>행사3</p>
						<p>2020-04-10</p>
					</div>
					<div class="advItemWrapper">
						<img src="/resources/img/home/adv04.png">
						<p>행사4</p>
						<p>2020-04-10</p>
					</div>
					<div class="advItemWrapper">
						<img src="/resources/img/home/adv05.jpg">
						<p>행사5</p>
						<p>2020-04-10</p>
					</div>
					<div class="advItemWrapper">
						<img src="/resources/img/home/adv06.jpg">
						<p>행사6</p>
						<p>2020-04-10</p>
					</div>
					<div class="advItemWrapper">
						<img src="/resources/img/home/adv07.jpg">
						<p>행사7</p>
						<p>2020-04-10</p>
					</div>
					<div class="advItemWrapper">
						<img src="/resources/img/home/adv08.jpg">
						<p>행사8</p>
						<p>2020-04-10</p>
					</div>
					<div class="advItemWrapper">
						<img src="/resources/img/home/adv09.jpg">
						<p>행사9</p>
						<p>2020-04-10</p>
					</div>
					<div class="advItemWrapper">
						<img src="/resources/img/home/adv10.jpg">
						<p>행사10</p>
						<p>2020-04-10</p>
					</div>
				</div>
			</div>
			<div class="col-1"></div>
			<div class="col-1 pt-3 mb-3"></div>
			<div class="col-10 pt-3 mb-3">
				<div class="row">
					<div class="col-6 border border-secondary">
						<div class="row">
							<div class="col-10">
								<div class="boardTitleWrapper">
									<div>학사</div>
									<div>일반</div>
									<div>장학</div>
									<div>입학</div>
								</div>
							</div>
							<div class="col-2">+</div>
						</div>
						<div class="col-12">
							<div class="row">
								<div class="col-12">더미</div>
								<div class="col-12">더미</div>
								<div class="col-12">더미</div>
								<div class="col-12">더미</div>
								<div class="col-12">더미</div>
								<div class="col-12">더미</div>
								<div class="col-12">더미</div>
								<div class="col-12">더미</div>
								<div class="col-12">더미</div>
								<div class="col-12">더미</div>
							</div>
						</div>
					</div>
					<div class="col-3 border border-secondary">
						<div class="row">
							<div class="col-6">학사일정</div>
							<div class="col-4">△ ▽ +</div>
						</div>
						<div class="row">
							<div class="col-12">
								<div class="col-12">더미 날짜</div>
								<div class="col-12">더미 내용</div>
							</div>
							<div class="col-12">
								<div class="col-12">
									<div class="col-12">더미 날짜</div>
									<div class="col-12">더미 내용</div>
								</div>
							</div>
							<div class="col-12">
								<div class="col-12">
									<div class="col-12">더미 날짜</div>
									<div class="col-12">더미 내용</div>
								</div>
							</div>
							<div class="col-12">
								<div class="col-12">
									<div class="col-12">더미 날짜</div>
									<div class="col-12">더미 내용</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-3 border border-secondary text-center">
						<div class="row h-100 goBox">
							<div class="col-12 h-50">입학 정보 한눈에 보기</div>
							<div class="col-12 h-50 gotoPortal">
								<a href="/info" class="d-flex align-items-center text-center">포털 바로가기</a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-1 pt-3 mb-3"></div>
			<script>
				$(document).ready(function(){
					$(".homeSlide").bxSlider({
						auto: true,
						pager: false,
						controls: false
					});
					
					let advSlider = $(".advSlider").bxSlider({
						auto: true,
						minSlides: 4,
						maxSlides: 4,
						slideWidth: 200,
						slideHeight: 300,
						moveSlides: 1,
						captions: true,
						pager: false,
						autoHover: true,
						stopAutoOnClick: true,
						onSlideAfter: function($slideElement, oldIndex, newIndex){
							advSlider.startAuto();
						}
					})
				})
				
			</script>
		</div>
<%@ include file="main/footer.jsp" %>
