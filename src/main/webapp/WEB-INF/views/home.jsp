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
			<div class="row goBox mb-4">
				<div class="col-12 col-lg-6 p-0">
					<a href="/main?pageGroup=admission&type=susi">
						<img src="/resources/img/home/admissionInfo.png">
					</a>
				</div>
				<div class="col-12 col-lg-6 gotoPortal p-0">
					<a href="/info" class="d-flex align-items-center text-center">
						<img src="/resources/img/home/infoPage.png">
					</a>
				</div>
			</div>
			<div class="col-1"></div>
			<div class="col-10 advSliderWrapper p-0">
				<div class="advSlider"></div>
			</div>
			<div class="col-1"></div>
			<div class="col-1 pt-3 mb-3"></div>
			<div class="col-10 pt-3 mb-3">
				<div class="row">
					<div class="col-12 col-lg-7 rounded">
						<div class="row p-0 noticeBoardWrapper">
							<div class="col-10 p-0">
								<div class="boardTitleWrapper">
									<div class="btn btn-primary active">학사</div>
									<div class="btn btn-light">일반</div>
									<div class="btn btn-light">장학</div>
									<div class="btn btn-light">입학</div>
								</div>
							</div>
							<div class="col-2 btn btn-light btnNoticeMore">+</div>
						</div>
						<div class="col-12">
							<div class="row border border-secondary rounded noticeWrapper p-0"></div>
						</div>
					</div>
					<div class="col-12 col-lg-5 mt-2 mt-lg-0">
						<div class="row">
							<div class="col-8 col-lg-7 p-0">
								<button class="btn btn-primary" disabled>학사일정</button>
							</div>
							<div class="col-4 col-lg-5">
								<div class="row btnScheduleWrapper">
									<div class="col-4 btn btn-light btnUpColSchedule">△ </div>
									<div class="col-4 btn btn-light btnDownColSchedule">▽</div>
									<div class="col-4 btn btn-light btnMoreColSchedule">+</div>
								</div>
							</div>
						</div>
						<div class="row border border-secondary rounded colScheduleWrapper">
							<c:forEach var="i" items="${colSchedule}" varStatus="q">
							<div class="col-12 pb-2 border-bottom colScheduleItem">
								<div class="row">
									<div class="col-6 col-lg-12 colScheduleDate">${i.sche_startDate} ~ ${i.sche_endDate}</div>
									<div class="col-6 col-lg-12 colScheduleTitle">${i.title}</div>
								</div>
							</div>
							</c:forEach>
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
					
					// Promotion
					let tagp = '';
					let tagimg = '';
					let advItemWrapper = '';
					let promoteImg = '';
					let promoteTitle = '';
					let promoteDate = '';
					let promotelink = '';
					let href = '';
					
					console.log("${promote}");
					<c:forEach var="i" items="${promote}">
						tagp = '${i.contents}';
						tagimg = $(tagp).children('img').eq(0);
						
						advItemWrapper = $("<div></div>");
						advItemWrapper.addClass("advItemWrapper");
						//promoteTItle = $('<p>${i.title}</p>');
						promoteTitle = $('<p class="mt-2"></p>');
						promoteTitle.append('${i.title}');
						promoteDate = $("<p>${i.writeDate}</p>");
						
						promotelink = $("<a></a>");
						href = "/main/board.view?pageGroup=community&type=promote&seq=${i.seq}&page=1&purp=view";
						promotelink.attr("href", href);
						//promotelink.attr("target", "_blank");
						promotelink.append(promoteTitle);
						
						advItemWrapper.append(tagimg);
						advItemWrapper.append(promotelink);
						advItemWrapper.append(promoteDate);
						$(".advSlider").append(advItemWrapper);
					</c:forEach>
					
					let advSlider = $(".advSlider").bxSlider({
						auto: true,
						minSlides: 1,
						maxSlides: 10,
						slideWidth: 200,
						slideHeight: 300,
						moveSlides: 1,
						captions: true,
						pager: false,
						autoHover: true,
						stopAutoOnClick: true,
						touchEnabled : (navigator.maxTouchPoints > 0),
						onSlideAfter: function($slideElement, oldIndex, newIndex){
							advSlider.startAuto();
						}
					})
					
					$(".boardTitleWrapper").children("div").hover(function(){
						$(this).removeClass("btn-light");
						$(this).addClass("btn-primary");
					}, function(){
						if( !$(this).hasClass("active") ){
							$(this).removeClass("btn-primary");
							$(this).addClass("btn-light");
						}
					})
					
					getNotice("학사");
					
					let arrNotice = ['학사', '일반', '장학', '입학', '채용'];
					$(".boardTitleWrapper").children("div").click(function(){
						$(this).siblings(".active").removeClass("btn-primary");
						$(this).siblings(".active").addClass("btn-light");
						$(this).siblings(".active").removeClass("active");
						$(this).removeClass("btn-light");
						$(this).addClass("btn-primary");
						$(this).addClass("active");
						
						getNotice($(this).html());				
					})
					
					let arrColSchedule = $(".colScheduleWrapper").children(".colScheduleItem");
					for( var i = 0; i < arrColSchedule.length; i++ ){
						if( i >= 5 ){
							arrColSchedule.eq(i).addClass("d-none");
						} else {
							arrColSchedule.eq(i).addClass("d-block");
						}
					}
					
					$(".btnDownColSchedule").click(function(){
						for( var i = 0; i < arrColSchedule.length; i++ ){
							if( i + 5 >= arrColSchedule.length ){
								break;
							} else {
								if( arrColSchedule.eq(i).hasClass("d-block") ){
									arrColSchedule.eq(i).removeClass("d-block");
									arrColSchedule.eq(i).addClass("d-none");
									arrColSchedule.eq(i+5).removeClass("d-none");
									arrColSchedule.eq(i+5).addClass("d-block");
									break;
								}
							}
						}
					})
					
					$(".btnUpColSchedule").click(function(){
						for( var i = arrColSchedule.length-1; i >= 0; i-- ){
							if( i - 5 < 0 ){
								console.log(1);
								break;
							} else {
								if( arrColSchedule.eq(i).hasClass("d-block") ){
								console.log(2);
									arrColSchedule.eq(i).removeClass("d-block");
									arrColSchedule.eq(i).addClass("d-none");
									arrColSchedule.eq(i-5).removeClass("d-none");
									arrColSchedule.eq(i-5).addClass("d-block");
									break;
								}
							}
						}
					})
					
					$(".btnMoreColSchedule").click(function(){
						location.href = "/main?pageGroup=info&type=info";
					})
				})
				
				let getNotice = function(noticeType){
					$(".noticeWrapper").html("");
					
					$.ajax({
						url: "/getNotice",
						type: "post",
						data: {
							division: noticeType
						}
					}).done(function(resp){
						resp = JSON.parse(resp);
						
						let noticeItemWrapper = '';
						let noticeTitle = '';
						let noticeWriteDate = '';
						
						for( var i = 0; i < resp.length; i++ ){
							var noti = JSON.parse(resp[i]);
							noticeItemWrapper = $("<div></div>");
							noticeItemWrapper.addClass("col-12 mt-1 mb-1");
							noticeItemWrapper.addClass("noticeItemWrapper");
							
							var notiItem = $("<div></div>");
							notiItem.addClass("row");
							
							noticeTitle = $("<div></div>");
							noticeTitle.addClass("col-9");
							var taga = $("<a></a>");
							taga.append(noti.noti_title);
							var href = "/main/board.view?";
							href += "pageGroup=community";
							href += "&type=notice";
							href += "&seq=" + noti.noti_seq;
							href += "&page=1";
							href += "&purp=view";
							href += "&category=" + $(".boardTitleWrapper").children(".active").html(); 
							taga.attr("href", href);
							noticeTitle.append(taga);
							notiItem.append(noticeTitle);
							
							noticeWriteDate = $("<div></div>");
							noticeWriteDate.addClass("col-3");
							console.log( "서버에서 넘어온 formatDate 값 : " + noti.formatDate);
							
							noticeWriteDate.append(noti.formatDate);
							notiItem.append(noticeWriteDate);
							
							noticeItemWrapper.append(notiItem);
							$(".noticeWrapper").append(noticeItemWrapper);
						}
						
					})
					
					$(".btnNoticeMore").hover(function(){
						$(this).removeClass("btn-light");
						$(this).addClass("btn-primary");
					}, 
					function(){
						$(this).removeClass("btn-primary");
						$(this).addClass("btn-light");
					})
					
					$(".btnNoticeMore").click(function(){
						location.href=
							"/main/board.list?pageGroup=community&type=notice&category="+$(".boardTitleWrapper").children(".active").html();
					})
					
					$(".btnScheduleWrapper").children("div").hover(
							function(){
								$(this).removeClass("btn-light");
								$(this).addClass("btn-primary");
							}, 
							function(){
								$(this).removeClass("btn-primary");
								$(this).addClass("btn-light");
							})
					
					$(".goBox").children().children().children().hover(function(){
					}, function(){
					})
				}
			</script>
		</div>
<%@ include file="main/footer.jsp" %>
