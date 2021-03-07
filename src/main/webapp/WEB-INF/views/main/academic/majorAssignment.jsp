<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/head.jsp"%>
<%@ include file="../header.jsp"%>
<div class="row body mt-3 mx-1">
	<!-- Body 부분 입니다. 왼쪽 메뉴, 메인 컨텐츠 부분 넣어주세요. -->
	<%@ include file="../info/left.jsp"%>
	<div class="col-10">
		<div class="row">
			<div class="col-12 subTitle mb-5">
				<h4>전공배정</h4>
			</div>
			<div class="col-2"></div>
			<div class="col-12 annoSecondTitle mb-3">
				<h3 class="annoH3">전공배정</h3>
			</div>
			<div class="col-12 mb-5">학부입학생의전공배정규정에 의거 학부입학생(모집단위가 전공인 경우
				제외)의 전공배정에 관한 세부내용에 대한 공지</div>
			<div class="col-12 mb-5">
				<ul>
					<li>희망전공 : 학생들이 희망하는 전공을 사전 조사하여 각 전공에 통보</li>
					<li>신청시기 : 4월, 10월중 신청</li>
				</ul>
			</div>
			<div class="col-12 annoSecondTitle mb-3">
				<h3 class="annoH3">주전공배정 신청</h3>
			</div>
			<div class="col-12 mb-5">
				<ul>
					<li>대상 : 학부입학생 중 1학년 재학생(모집단위 전공입학생은 제외)</li>
					<li>신청시기 : 12월 초</li>
					<li>배정인원 : 기준정원을 기준으로 전공배정위원회에서 정함</li>
					<li>전공배정 인원 초과시 배정기준
						<ul style="list-style: none;">
							<li><b>1)</b> 1학년(1,2학기) 성적 우선 선발</li>
							<li><b>2)</b> 동점자 처리기준(이수학점수, 최근성적 우선)</li>
							<li><b>3)</b> 1), 2)항이 같을 경우 초과하여 배정</li>
						</ul>
					</li>
				</ul>
			</div>
			<div class="col-12 annoSecondTitle mb-3">
				<h3 class="annoH3">주전공배정 후 이수구분 변경</h3>
			</div>
			<div class="col-12 mb-5">
				<ul>
					<li>1학년 학부수업 중 타전공과목은 자선으로 이수구분이 변경</li>
					<li>예) 관광호텔경영학부(관광항공경영학전공, 호텔외식경영학전공)에 입학한 학생이 관광항공경영학전공으로 배정된
						경우,호텔외식경영학전공에서 개설된 과목은 자선으로 이수구분 변경</li>
				</ul>
			</div>
			<div class="col-2 d-none d-lg-block"></div>
			<div class="col-12 col-xl-7">
				<table class="table mb-5">
					<caption>주전공배정 후 이수구분 변경 표이며 표의 학과는 예시임, 개설전공, 교과목, 이수구분,
						비고에 대한 정보를 제공</caption>
					<thead>
						<tr class="majorTableTitle">
							<th rowspan="2" style="padding-bottom: 35px;">개설전공</th>
							<th rowspan="2" style="padding-bottom: 35px;">교과목</th>
							<th colspan="2">이수구분</th>
							<th rowspan="2" style="padding-bottom: 35px;">비고</th>
						</tr>
						<tr class="majorTableTitle">
							<th>전공배정 전</th>
							<th>전공배정 후</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>관광항공경영학</td>
							<td>관광자원의이해</td>
							<td>전공선택</td>
							<td>전공선택</td>
							<td></td>
						</tr>
						<tr>
							<td>호텔외식경영학</td>
							<td>호텔경영학원론</td>
							<td>전공선택</td>
							<td>자유선택</td>
							<td>이수구분변경</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-12 secondTitle mb-3">
				<h4 class="socialH4">복학생 신청방법</h4>
			</div>
			<div class="col-12 mb-5">
				<ul>
					<li class="mb-3">1학년 2학기 복학생 : 재학생과 동일</li>
					<li>2학년 1학기 역복학생(1-1학기 이수후 2-1학기로 복학하는 경우)

						<ul>
							<li>학사지원팀 방문하여 신청</li>
							<li>여석이 없을 경우 배정당시 최저평점평균(마지막 배정자)의 성적과 비교하여 높을 경우 배정, 그렇지
								않을 경우 다른전공으로 배정함.</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
<%@ include file="../footer.jsp"%>