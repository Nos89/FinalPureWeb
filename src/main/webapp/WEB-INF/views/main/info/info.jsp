<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="/resources/css/info/main_schedule.css?ver=1">

<%@ include file="/resources/jsp/head.jsp"%>
<%@ include file="../header.jsp"%>
<div class="row body mt-3">
	<!-- Body 부분 입니다. 왼쪽 메뉴, 메인 컨텐츠 부분 넣어주세요. -->
	<%@ include file="left.jsp"%>
	
	
	
	
	<div class="col-10">
		<div class="row scheduleBox">
			<div class="col-12 subTitle">학사 일정</div>
			<div class="col-12 text-center title mb-2">
				학기 <select id=chageSemester onchange="chageSemester()">
					<option>2021학년도 1학기</option>
				</select>
				<button id=semChangeBtn>검색</button>
			</div>
			<div class="col-12 mb-5 text-center month" >
				<button id=jan>1월</button>
				<button id=feb>2월</button>
				<button id=march>3월</button>
				<button id=april>4월</button>
				<button id=may>5월</button>
				<button id=june>6월</button>
				<button id=july>7월</button>
				<button id=august>8월</button>
				<button id=sep>9월</button>
				<button id=oct>10월</button>
				<button id=nov>11월</button>
				<button id=dec>12월</button>
		
			</div>


			<div class="col-12 col-sm-5 mx-4 calendarWrapper">
				<table id="calendar">
					<tr>
						<td id="tbCalendarYM" colspan="7"></td>
					</tr>
					<tr id=weeks>
						<td align="center"><font color="red">일</font></td>
						<td align="center"><font color="white">월</font></td>
						<td align="center"><font color="white">화</font></td>
						<td align="center"><font color="white">수</font></td>
						<td align="center"><font color="white">목</font></td>
						<td align="center"><font color="white">금</font></td>
						<td align="center"><font color="blue">토</font></td>
					</tr>
				</table>
			</div>
			<div class="col-12 col-sm-5 mx-4 sche_contents">
				<div class="colSche_list">
					<c:forEach var="i" items="${main_colSche}" varStatus="status">
						<div class="sche_date">${i.sche_startDate } ~
							${i.sche_endDate }</div>
						<div class="sche_title">${i.title }</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	
</script>
<script>
	
</script>

<script>
	var today = new Date();//오늘 날짜//내 컴퓨터 로컬을 기준으로 today에 Date 객체를 넣어줌
	var date = new Date();//today의 Date를 세어주는 역할
	//
	document.getElementById("semChangeBtn").onclick = function() {
		let chageSemester = document.getElementById("chageSemester");
		let seme_selectValue = chageSemester.options[chageSemester.selectedIndex].text;
		//location.href = "info/changeSemester?semSelect=" + seme_selectValue;
	}
	//버튼 눌러서 달 바꿈
	if ("${result}" != "") {
		let result = "${result}";
		today.setTime(Date.parse(result));
		buildCalendar();

	}
	//학사안내 들어가자마자 현재 달에 대한 달력 보이기
	else{
		let result_main = "${result_main}";
		today.setTime(Date.parse(result_main));
		buildCalendar();
	}


	document.getElementById("jan").onclick = function() {
		location.href = "info/calendar?month_click=01";
		if ("${result}" != "") {
			location.href = "calendar?month_click=01"
		}
	}
	document.getElementById("feb").onclick = function() {
		location.href = "info/calendar?month_click=02";
		if ("${result}" != "") {
			location.href = "calendar?month_click=02"
		}
	}
	document.getElementById("march").onclick = function() {
		location.href = "info/calendar?month_click=03";
		if ("${result}" != "") {
			location.href = "calendar?month_click=03"
		}
	}
	document.getElementById("april").onclick = function() {
		location.href = "info/calendar?month_click=04";
		if ("${result}" != "") {
			location.href = "calendar?month_click=04"
		}
	}
	document.getElementById("may").onclick = function() {
		location.href = "info/calendar?month_click=05";
		if ("${result}" != "") {
			location.href = "calendar?month_click=05"
		}
	}
	document.getElementById("june").onclick = function() {
		location.href = "info/calendar?month_click=06";
		if ("${result}" != "") {
			location.href = "calendar?month_click=06"
		}
	}
	document.getElementById("july").onclick = function() {
		location.href = "info/calendar?month_click=07";
		if ("${result}" != "") {
			location.href = "calendar?month_click=07"
		}
	}
	document.getElementById("august").onclick = function() {
		location.href = "info/calendar?month_click=08";
		if ("${result}" != "") {
			location.href = "calendar?month_click=08"
		}
	}
	document.getElementById("sep").onclick = function() {
		location.href = "info/calendar?month_click=09";
		if("${result}" != ""){location.href="calendar?month_click=09"}
	}
	document.getElementById("oct").onclick = function() {
		location.href = "info/calendar?month_click=10";
		if("${result}" != ""){location.href="calendar?month_click=10"}
	}
	document.getElementById("nov").onclick = function() {
		location.href = "info/calendar?month_click=11";
		if("${result}" != ""){location.href="calendar?month_click=11"}
	}
	document.getElementById("dec").onclick = function() {
		location.href = "info/calendar?month_click=12";
		if("${result}" != ""){location.href="calendar?month_click=12"}
	}

	//

	function buildCalendar() {//현재 달 달력 만들기
		var doMonth = new Date(today.getFullYear(), today.getMonth(), 1);
		var lastDate = new Date(today.getFullYear(), today.getMonth() + 1, 0);
		var tbCalendar = document.getElementById("calendar");//날짜를 찍을 테이블 변수 만듬, 일 까지 다 찍힘
		var tbCalendarYM = document.getElementById("tbCalendarYM");//테이블에 정확한 날짜 찍는 변수
		currentDay = today.getFullYear() + "년 " + (today.getMonth() + 1) + "월";
		tbCalendarYM.innerHTML = currentDay;

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
		}
	}
</script>
<%@ include file="../footer.jsp"%>