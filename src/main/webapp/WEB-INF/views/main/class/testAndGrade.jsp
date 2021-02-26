<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/head.jsp"%>
<%@ include file="../header.jsp"%>
<div class="row body mt-3">
	<!-- Body 부분 입니다. 왼쪽 메뉴, 메인 컨텐츠 부분 넣어주세요. -->
	<%@ include file="../info/left.jsp"%>
	<div class="col-10">
		<div class="row">
			<div class="col-12 subTitle mb-5">
				<h4>시험 및 성적</h4>
			</div>
			<div class="col-2"></div>
			<div class="col-12 annoSecondTitle mb-3">
				<h3 class="annoH3">시험 방법</h3>
			</div>
			<div class="col-12 mb-5">
				<ul class="bu">
					<li>해당학기 수업한 각 교과목에 대하여 매학기 중간 및 기말에 평가한다.</li>
					<li>필답고사를 원칙으로 하되 교과목의 성질에 따라 담당교수가 평가횟수 및 평가방법 등을 별도로 결정하여
						수시평가 할 수 있다.</li>
					<li>수업시간에 수시평가 또는 정기시험 기간에 함을 원칙으로 한다.</li>
				</ul>
			</div>
			<div class="col-12 annoSecondTitle mb-3">
				<h3 class="annoH3">시험응시</h3>
			</div>
			<div class="col-12 mb-5">
				<ul class="bu">
					<li>해부득이한 사정으로 중간 및 기말고사에 응시하지 못한 자는 과제물 제출등으로 대체할 수 있다.</li>
				</ul>
			</div>
			<div class="col-12 annoSecondTitle mb-3">
				<h3 class="annoH3">성적</h3>
			</div>
			<div class="col-12 mb-5">
				<ul class="bu">
					<li>수업시간의 3/4이상 출석한 자에 한해 취득한 성적을 인정할 수 있다.</li>
					<li>학업성적은 각 교과목의 출석, 과제 및 시험성적 등을 종합하여 평가한다. 다만, 실험, 실습, 실기 및
						기타 이에 준하는 특수과목의 성적평가 방법은 담당교수가 따로 정할 수 있다.</li>
					<li>학업성적의 평가 요소별 비율은 담당교수가 평가 목적에 맞게 정한다.</li>
					<li>상대평가 교과목의 등급별 비율은 A급 20%, B급 30%, C급 40%, D급 10%를 기준으로 하되
						5% 이내에서 증감 할 수 있으며, F는 10%를 초과할 수 없다. 단, 출석미달 및 시험 불응자는 평가 비율에서
						제외하고 상대평가 대상 과목 중 교직과목과 군사학과 전공과목에 대해서는 A등급 25% 이하로 하고 B등급 이하 등급은
						자율로 평가 할 수 있다.</li>
				</ul>
			</div>
			<div class="col-12 annoSecondTitle mb-3">
				<h3 class="annoH3">학점인정</h3>
			</div>
			<div class="col-12 mb-5">
				<ul class="bu">
					<li>학점을 인정하는 시기는 매학기말로 한다. 성적등급 D급 이상을 얻은 교과목을 학점취득으로 인정한다.</li>
					<li>수강신청하지 않고 수강한 과목은 학점을 인정하지 않으며, 학점이 인정된 과목을 중복이수하여 취득한 학점은
						졸업학점으로 인정하지 않는다.</li>
					<li>수강 승인된 교과목을 임의로 이수치 않을 경우 성적 미취득으로 F처리 된다.</li>
					<li>수업시간의 3/4이상 출석한 자에 한해 기말시험에 응시할 자격을 부여하고 취득한 성적을 인정한다.</li>
					<li>수업일수 3/4선 이후에 군입대 휴학으로 인하여 기말고사에 응시하지 못하는 경우에는 기말고사 이전의
						평가로 해당학기 성적을 인정한다.(3/4 이상 출석한자)</li>
					<li>정당한 사유없이 소정의 등록기간내에 등록을 필하지 않고(미등록 제적대상자) 취득한 성적의 학점은 인정하지
						않는다.</li>
					<li>중간시험 이후 기말시험 종료전에 일반(질병)휴학자의 취득한 성적의 학점은 무효로 한다.</li>
					<li>계절학기에 취득한 성적의 학점은 이수 구분별로 인정하되 매학기 평점평균에 산입하지 않고 졸업학점 및
						총평점 평균 산출시만 적용한다.</li>
					<li>R.O.T.C학생은 그 과정 이수로서 제3학년 및 제4학년의 군사학점을 인정한다.</li>
				</ul>
			</div>
			<div class="col-12 annoSecondTitle mb-3">
				<h3 class="annoH3">평점 평균의 산출방법</h3>
			</div>
			<div class="col-12 mb-5">
				<ul class="bu">
					<li>(각과목별 학점수 x 각 과목별 성적평점)의 합계 / 수강신청학점 이며, 소수점이하 셋째자리에서 반올림
						한다.</li>
					<li>수강신청하지 않고 수강한 과목은 학점을 인정하지 않으며, 학점이 인정된 과목을 중복이수하여 취득한 학점은
						졸업학점으로 인정하지 않는다.</li>
					<li>P/NP교과목은 학점으로 이정하되 평점평균에는 제외한다.</li>
				</ul>
			</div>
			<div class="col-12 annoSecondTitle mb-3">
				<h3 class="annoH3">성적정정</h3>
			</div>
			<div class="col-12 mb-5">
				<ul class="bu">
					<li>성적에 이의가 있으면 소정기간(학기초1주일)내에 담당교수에게 이의 신청한다.</li>
					<li>성적예고제 이후에 정정의 사유가 있으면 성적 정정원에 증빙서류를 첨부하여 해당과목 담당교수가 소속
						대학장을 경유 교무처에 제출한 후 교무처장의 승인을 받아 정정할 수 있다.</li>
				</ul>
			</div>
		</div>
	</div>
</div>
<%@ include file="../footer.jsp"%>