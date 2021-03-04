<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col-2">
	<div class="row text-center leftMenu">
		<div class="col-12"><p>학사 안내</p></div>
		<div class="col-12">
			<ul class="list-group leftMenuWrapper">
			  <li class="list-group-item p-0 pt-2 pb-2 leftItem"><a href="/main?pageGroup=info&type=info">학사 일정</a></li>
			  <li class="list-group-item p-0 pt-2 pb-2">
			  	<button class="collapseControl" type="button" data-toggle="collapse" data-target="#curriculumCollapse">교과 과정</button>
			  	<div class="collapse leftCollapseItem" id="curriculumCollapse">
			  		<ul class="list-group">
					  <li class="list-group-item leftItem"><a href="/main?pageGroup=curriculum&type=multipleMajor">복수전공 / 부전공</a> </li>
					  <li class="list-group-item leftItem"><a href="/main?pageGroup=curriculum&type=teachingCourse">교직과정</a></li>
					</ul>
			  	</div>
			  	</li>
			  <li class="list-group-item p-0 pt-2 pb-2">
			  	<button class="collapseControl" type="button" data-toggle="collapse" data-target="#classCollapse">수업</button>
			  	<div class="collapse leftCollapseItem" id="classCollapse">
			  		<ul class="list-group">
					  <li class="list-group-item leftItem"><a href="/main?pageGroup=class&type=gradeAnnouncement">성적 예고제</a> </li>
					  <li class="list-group-item leftItem"><a href="/main?pageGroup=class&type=testAndGrade">시험 및 성적</a></li>
					  <li class="list-group-item leftItem"><a href="/main?pageGroup=class&type=seasonalSemester">계절 학기</a></li>
					  <li class="list-group-item leftItem"><a href="/main?pageGroup=class&type=socialServiceCourse">사회 봉사 과목 이수</a></li>
					  <li class="list-group-item leftItem"><a href="/main?pageGroup=class&type=employmentSubject">취업 관련 교과목 이수</a></li>
					  <li class="list-group-item leftItem"><a href="/main?pageGroup=class&type=attendence">전자 출결부</a></li>
					</ul>
			  	</div>
			  	</li>
			  <li class="list-group-item p-0 pt-2 pb-2">
			  	<button class="collapseControl" type="button" data-toggle="collapse" data-target="#academyCollapse">학적</button>
			  	<div class="collapse leftCollapseItem" id="academyCollapse">
			  		<ul class="list-group">
			  			<li class="list-group-item leftItem"><a href="/main?pageGroup=academic&type=reEntering">재입학</a></li>
						<li class="list-group-item leftItem"><a href="/main?pageGroup=academic&type=returnSchool">휴복학</a></li>
						<li class="list-group-item leftItem"><a href="/main?pageGroup=academic&type=majorAssignment">전공배정</a></li>
						<li class="list-group-item leftItem"><a href="/main?pageGroup=academic&type=exclusion">유급 제적</a></li>
			  		</ul>
			  	</div>
	  		</li>
			  <li class="list-group-item p-0 pt-2 pb-2">
			  	<button class="collapseControl" type="button" data-toggle="collapse" data-target="#registrationCollapse">등록</button>
			  	<div class="collapse leftCollapseItem" id="registrationCollapse">
			  		<ul class="list-group">
			  			<li class="list-group-item leftItem"><a href="/main?pageGroup=registration&type=tuition">등록급 납부</a></li>
						<li class="list-group-item leftItem"><a href="https://www.kosaf.go.kr/ko/tuition.do?pg=tuition_main&">학자금 대출</a></li>
			  		</ul>
			  	</div>
			  
			  </li>

			  <li class="list-group-item p-0 pt-2 pb-2 leftItem"><a href="/main?pageGroup=&type=gradution">졸업</a></li>
			  <li class="list-group-item p-0 pt-2 pb-2 leftItem"><a href="/main?pageGroup=&type=road-map">대학 ROAD-MAP</a></li>
			  <li class="list-group-item p-0 pt-2 pb-2">
			  	<button class="collapseControl" type="button" data-toggle="collapse" data-target="#certificateCollapse">증명서 발급</button>
  			  	<div class="collapse leftCollapseItem" id="certificateCollapse">
				  	<ul class="list-group">
					  	<li class="list-group-item leftItem"><a href="/main?pageGroup=certificate&type=academicIssuance">학적 증명서 발급</a></li>
						<li class="list-group-item leftItem"><a href="/main?pageGroup=certificate&type=studentID">학생증 발급</a></li>
					</ul>
				</div>
		  	</li>
			</ul>
		</div>
	</div>
</div>
<script>
$(document).ready(function(){
	var leftMenuLen = $(".leftItem").length;
	for( var i = 0; i < leftMenuLen; i++ ){
		var exists = $(".leftItem").eq(i).children("a").attr("href").indexOf("type=${type}");
		console.log( "${type} : " + exists);
		if( exists >= 0 ){
			$(".leftItem").eq(i).addClass("active");
			$(".leftItem").eq(i).parent().parent().collapse("show");
			$(".leftItem").eq(i).parent().parent().siblings("collapseControl").addClass("active btn btn-primary");
		}
	}
	
	let listLength = $(".list-group-item").length;
	let arrType = [];
	for( let i = 0; i < listLength; i++ ){
		let href = $(".list-group-item").eq(i).children().attr("href");
	}
	console.log(arrType);
	for( let i = 0; i < arrType.length; i++ ){
		if( "${type}" == arrType[i] ){
			$(".list-group-item").eq(i).addClass("active");
		}
	}
	
	$(".collapseControl").click(function(){
		$(window).scrollTop(0);
		if( $(this).hasClass("active") ){
			$(this).removeClass("active btn btn-primary");
		} else {
			for( var i = 0; i < $(".collapseControl").length; i++ ){
				$(".collapseControl").eq(i).removeClass("active btn btn-primary");
			}
			$(this).addClass("active btn btn-primary");
		}
		
		var target = $(this).attr("data-target");
		var colLength = $(".leftCollapseItem").length;
		for( var i = 0; i < colLength; i++ ){
			$(".leftCollapseItem").eq(i).collapse("hide");
		}
		$(target).collapse("show");
	})
})
</script>