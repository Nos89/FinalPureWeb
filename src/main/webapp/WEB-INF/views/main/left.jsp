<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-2">
	<div class="row text-center leftMenu">
		<div class="col-12"><p>수업</p></div>
		<div class="col-12">
			<ul class="list-group">
			  <li class="list-group-item"><a href="/main?pageGroup=class&type=gradeAnnouncement">성적 예고제</a> </li>
			  <li class="list-group-item"><a href="/main?pageGroup=class&type=testAndGrade">시험 및 성적</a></li>
			  <li class="list-group-item"><a href="/main?pageGroup=class&type=seasonalSemester">계절 학기</a></li>
			  <li class="list-group-item"><a href="/main?pageGroup=class&type=socialServiceCourse">사회 봉사 과목 이수</a></li>
			  <li class="list-group-item"><a href="/main?pageGroup=class&type=employmentSubject">취업 관련 교과목 이수</a></li>
			  <li class="list-group-item"><a href="/main?pageGroup=class&type=attendence">전자 출결부</a></li>
			</ul>
		</div>
	</div>
</div>
<script>
	$(document).ready(
			function() {
				let listLength = $(".list-group-item").length;
				let arrType = [];
				for (let i = 0; i < listLength; i++) {
					let href = $(".list-group-item").eq(i).children().attr(
							"href");
					arrType[i] = href.substring(href.indexOf("type=") + 5,
							href.length);
				}
				console.log(arrType);
				for (let i = 0; i < arrType.length; i++) {
					if ("${type}" == arrType[i]) {
						$(".list-group-item").eq(i).addClass("active");
					}
				}
			})
</script>