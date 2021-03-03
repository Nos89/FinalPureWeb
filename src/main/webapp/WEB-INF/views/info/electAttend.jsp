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


</head>
<body style="background-color: #dfe2e9;">
	<div class="container-fluid top" style="background-color: white;">
		<div class="container">
			<div class="row">
				<div class="col-sm-1 order-0 order-sm-0 my-2" id="titleImge">
					<img src="/resources/img/info/gachalogo.png" class="headerLogo">
				</div>
				<div class="col-sm-9 order-2 order-sm-1 title mx-1" id="titleText">전자출결</div>
				<div class="col-sm-1 order-1 order-sm-1 userName">${userName }</div>
			</div>
		</div>

	</div>
	<div class="container" style="margin-top: 20px;">
		<div class="row">
			<div class="col-12 col-sm-2">
				<div class="row">
					<div class="col-12 changeSemester">
						- 학기
						<form>
							<select id=semesterSelect onchange="chageSemesterSelect()">
								<option>2021년 1학기</option>
								<option>2020년 2학기</option>
							</select>
						</form>
					</div>
					<div class="col-12 changeClass">
						- 전자출석부
						<form>
							<select id=classSelect onchange="chageClassSelect()">
								<option>=과목 선택=</option>
								<c:forEach var="i" items="${classList}" varStatus="status">
									<option>${i.lec_title }</option>
								</c:forEach>
							</select>
						</form>
						<br>-기타
						<button id=btnRegisterInfo>전자출결 등록정보</button>
					</div>
				</div>
			</div>
			<div class="col-12 col-sm-10">
				<c:choose>
					<c:when test="${first=='첫화면에 사진' || divide != null}">
						<div class="firstImg">
							<img src="/resources/img/info/elecAttendFirstImg.png">
						</div>
					</c:when>
					<c:when test="${selClassInfoList != null }">
						<div class="ClassInfoListWrapper">
							<div class=classInfoTitle>
								<h4>| ${yearSemester } 출석부</h4>
							</div>

							<c:forEach var="i" items="${selClassInfoList}" varStatus="status">
								<div class=infoBox_class>
									<div class=fixed_class>교과목코드</div>
									<div class=contents20>${i.lec_code }</div>
									<div class=fixed_class>교과목명</div>
									<div class=contents30>${i.lec_title }</div>
									<div class=fixed_class>담당교수</div>
									<div class=contents20>${i.pro_name }</div>
									<div class=fixed_class>강의실</div>
									<div class=contents20>${i.lec_classroom }</div>
									<div class=fixed_class>수업시간</div>
									<div class=contents30>${i.lec_schedule }</div>
									<div class=fixed_class>학점</div>
									<div class=contents20>${i.lec_score }</div>
								</div>
							</c:forEach>

							<div class=marks>
								<font style="color: #418cc6; font-weight: bold;">O</font>:정상출석 <font
									style="color: #f97f35; font-weight: bold;">/</font>:지각 <font
									style="color: #fc1b1b; font-weight: bold;">X</font>:결석처리
							</div>

							<div class=attednInfoBox>
								<div class=attendInfoFixed style="width: 10%;">주차</div>
								<div class=attendInfoFixed style="width: 20%;">수업순서</div>
								<div class=attendInfoFixed style="width: 40%;">수업일자</div>
								<div class=attendInfoFixed style="width: 30%;">출석결과</div>

								<c:forEach var="i" items="${lecAttList}" varStatus="status">
									<c:set var="number" value="${number+1 }" />
									<c:if test="${number > 3 }">
										<c:set var="number" value="1" />
									</c:if>

									<div class=attendInfoContets style="width: 10%;">${i.att_week }</div>
									<div class=attendInfoContets style="width: 20%;">${number }</div>
									<div class=attendInfoContets style="width: 40%;">${i.att_date }</div>
									<div class=attendInfoContets style="width: 30%;">
										<c:choose>
											<c:when test="${i.att_attend == 'O' }">
												<font style="color: #418cc6;">${i.att_attend }</font>
											</c:when>
											<c:when test="${i.att_attend == '/' }">
												<font style="color: #f97f35;">${i.att_attend }</font>
											</c:when>
											<c:when test="${i.att_attend == 'X' }">
												<font style="color: #fc1b1b;">${i.att_attend }</font>
											</c:when>
										</c:choose>

									</div>
								</c:forEach>


							</div>


						</div>
					</c:when>
					<c:when test="${regInfoBtn=='등록정보' }">
						<div class="userInfoWrapper">
							<div class=userInfoTitle>
								<h4>| 전자출결 시스템 등록정보</h4>
							</div>
							<div class=titleExplain>- 전자출결 시스템 등록정보 입니다.</div>
							<div class=infoBox>
								<div class=photo>사진</div>
								<div class=infoBoxDetail>
									<div class=fixedOutline>
										<div class=fixed>학번</div>
										<div class=contents>${id }</div>
									</div>
									<div class=fixedOutline>
										<div class=fixed>이름</div>
										<div class=contents>${name }</div>
									</div>
									<div class=fixedOutline>
										<div class=fixed>신분</div>
										<div class=contents>학부생</div>
									</div>
									<div class=fixedOutline>
										<div class=fixed>학과</div>
										<div class=contents>${major }</div>
									</div>

								</div>

								<button class=preButton id=preButton>이전화면</button>

							</div>
						</div>
						<script>
							document.getElementById("preButton").onclick = function() {
								location.href = "/elec/toElectAttend";
							}
						</script>
					</c:when>

				</c:choose>


			</div>
		</div>

	</div>
	<div class="container-fluid footer">
		<div class="row">
			<div class="col-3 my-1">
				<img src="/resources/img/info/gachalogo.png" class="footerLogo">
			</div>
			<div class="col-9 my-3">
				<div>[가차대학교 전자출결시스템]</div>
				<div class=grayText>[874-88] 서울시 어디구 어디로 87-99 | TEL:
					02-0008-4545 | FAX: 02-4878-6524</div>
				<div class=grayText>COPYRIGHTⓒ 2017 GACHA UNIVERSITY. ALL
					RIGHTS RESERVED.</div>
			</div>
		</div>


	</div>





	<script>
		let semester = "${semester}";
		let className = "${className}";

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

		if (semester != "") {
			$("#semesterSelect").val(semester).attr("selected", "selected");
		}

		if (className != "") {
			$("#classSelect").val(className).attr("selected", "selected");
		}

		document.getElementById("btnRegisterInfo").onclick = function() {
			location.href = "/elec/idRegisterInfo";
		}
		document.getElementById("titleImge").onclick = function() {
			location.href = "/elec/toElectAttend";
		}
		document.getElementById("titleText").onclick = function() {
			location.href = "/elec/toElectAttend";
		}
	</script>
</body>
</html>