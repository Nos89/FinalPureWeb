<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elecAttend</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/info/elecAttend.css?ver=1">
<link rel="stylesheet"
	href="/resources/css/info/elecRegisterInfo.css?ver=1">

</head>
<body>
	<div class="container-fluid">
		<div class="container">
			<div class="row">
				<div class="col-sm-2 order-0 order-sm-0"
					style="border: 1px solid black;">title</div>
				<div class="col-sm-8 order-2 order-sm-1"
					style="border: 1px solid black;">전자출결</div>
				<div class="col-sm-2 order-1 order-sm-2"
					style="border: 1px solid black;">${userName }</div>
			</div>
		</div>

	</div>
	<div class="container" style="margin-top: 20px;">
		<div class="row">
			<div class="col-12 col-sm-2">
				<div class="row">
					<div class="col-12" style="border: 1px solid black; height: 200px;">
						- 학기
						<form>
							<select id=semesterSelect onchange="chageSemesterSelect()">
								<option>= 학기선택 =</option>
								<option value="abc">2021년 1학기</option>
								<option>2020년 2학기</option>
								<option>2020년 1학기</option>
								<option>2019년 2학기</option>
								<option>2019년 1학기</option>

							</select>
						</form>


					</div>
					<div class="col-12" style="border: 1px solid black; height: 300px;">
						- 전자출석부
						<form>
							<select id=classSelect onchange="chageClassSelect()">
								<option>==과목 선택==</option>
								<c:forEach var="i" items="${classList}" varStatus="status">
									<option>${i.lec_title }</option>
								</c:forEach>
							</select>
						</form>
						-기타
						<button id=btnRegisterInfo>전자출결 등록정보</button>
					</div>
				</div>
			</div>
			<div class="col-12 col-sm-10">
				<c:choose>

					<c:when test="${selClassInfoList != null }">

						<div class="title" style="border: 1px solid black;">${yearSemester }
							출석부</div>

						<c:forEach var="i" items="${selClassInfoList}" varStatus="status">
							<div class="row">
								<div class="col-12 col-sm-3" style="border: 1px solid black;">
									<div class="row">
										<div class="col-sm-6" style="border: 1px solid black;">교과목코드/분반</div>
										<div class="col-sm-6" style="border: 1px solid black;">${i.lec_code }</div>
									</div>
								</div>
								<div class="col-12 col-sm-6" style="border: 1px solid black;">
									<div class="row" style="height: 100%;">
										<div class="col-sm-6" style="border: 1px solid black;">교과목명</div>
										<div class="col-sm-6" style="border: 1px solid black;">${i.lec_title }</div>
									</div>
								</div>
								<div class="col-12 col-sm-3" style="border: 1px solid black;">
									<div class="row" style="height: 100%;">
										<div class="col-sm-6" style="border: 1px solid black;">담당교수</div>
										<div class="col-sm-6" style="border: 1px solid black;">${i.pro_name }</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-12 col-sm-3" style="border: 1px solid black;">
									<div class="row">
										<div class="col-sm-6" style="border: 1px solid black;">강의실</div>
										<div class="col-sm-6" style="border: 1px solid black;">${i.lec_classroom }</div>
									</div>
								</div>
								<div class="col-12 col-sm-6" style="border: 1px solid black;">
									<div class="row" style="height: 100%;">
										<div class="col-sm-6" style="border: 1px solid black;">수업시간</div>
										<div class="col-sm-6" style="border: 1px solid black;">${i.lec_schedule }</div>
									</div>
								</div>
								<div class="col-12 col-sm-3" style="border: 1px solid black;">
									<div class="row" style="height: 100%;">
										<div class="col-sm-6" style="border: 1px solid black;">학점</div>
										<div class="col-sm-6" style="border: 1px solid black;">${i.lec_score }</div>
									</div>
								</div>
							</div>
						</c:forEach>
						<div class="row my-2">
							<div class="col-12 col-sm-9" style="float:right;">정상출석/지각/결석처리</div>
						</div>
						<div class="row">
							<div class="col-sm-2" style="border: 1px solid black;">주차</div>
							<div class="col-sm-2" style="border: 1px solid black;">수업순서</div>
							<div class="col-sm-4" style="border: 1px solid black;">수업일자</div>
							<div class="col-sm-4" style="border: 1px solid black;">출석결과</div>
						</div>

						<c:forEach var="i" items="${lecAttList}" varStatus="status">
							<c:set var="number" value="${number+1 }" />
							<c:if test="${number > 3 }">
								<c:set var="number" value="1" />
							</c:if>

							<div class="row">
								<div class="col-sm-2" style="border: 1px solid black;">${i.att_week }</div>
								<div class="col-sm-2" style="border: 1px solid black;">${number }</div>
								<div class="col-sm-4" style="border: 1px solid black;">${i.att_date }</div>
								<div class="col-sm-4" style="border: 1px solid black;">${i.att_attend }</div>
							</div>
						</c:forEach>
					</c:when>
					<c:when test="${regInfoBtn=='등록정보' }">
						<div class=wrapper>
							<div>
								<h2>| 전자출결 시스템 등록정보</h2>
							</div>
							<div style="border: 1px solid black; margin-top: 30px">-
								전자출결 시스템 등록정보 입니다.</div>

						</div>
						<div class=wrapper2>
							<div class=photo>사진</div>
							<div class="info">
								<div class=fixed>학번</div>
								<div class="moreInfo">${id }</div>
								<div class=fixed>이름</div>
								<div class="moreInfo">${name }</div>
								<div class=fixed>신분</div>
								<div class="moreInfo">학부생</div>
								<div class=fixed>학과</div>
								<div class="moreInfo">${major }</div>

							</div>

						</div>
					</c:when>

				</c:choose>


			</div>
		</div>

	</div>
	<script>
		let semester = "${semester}";

		function chageSemesterSelect() {
			let semesterSelect = document.getElementById("semesterSelect");
			let seme_selectValue = semesterSelect.options[semesterSelect.selectedIndex].text;
			location.href = "/elec/comboChange?semester=" + seme_selectValue;

		}
		function chageClassSelect() {
			let classSelect = document.getElementById("classSelect");
			let class_selectValue = classSelect.options[classSelect.selectedIndex].value;
			location.href = "/elec/comboChange?semester=" + semester
					+ "&className=" + class_selectValue;
		}

		document.getElementById("btnRegisterInfo").onclick = function() {
			location.href = "/elec/idRegisterInfo";
		}
	</script>
</body>
</html>