<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/head.jsp"%>
<%@ include file="../header.jsp"%>
<div class="row body mt-3">
	<!-- Body 부분 입니다. 왼쪽 메뉴, 메인 컨텐츠 부분 넣어주세요. -->
	<%@ include file="../info/left.jsp"%>
	<div class="col-10">
		<div class="row">
            <div class="col-12 subTitle mb-5"><h4>전자출결</h4></div>
			<div class="col-2"></div>
			<div class="col-12 annoSecondTitle mb-3"><h3 class="annoH3">전자출결시스템 안내</h3></div>
			<div class="col-12 mb-5">선진적인 교육환경 제공과 효율적인 출석 및 학사 관리를 위하여 음파출결시스템을 도입하였기에 사용방법을 안내합니다.</div>
			<div class="col-12 annoSecondTitle mb-3"><h4 class="socialH4">전자출결시스템 출결 입력 안내</h4></div>
			<div class="col-2 d-none d-lg-block"></div>
			<div class="col-6 col-lg-4 attTableTitle" style="border-right: 1px solid #c6c6c6;">변경전</div>
           <div class="col-6  col-lg-4 attTableTitle">변경후</div>
           <div class="col-2 d-none d-lg-block"></div>
            <div class="col-2 d-none d-lg-block"></div>
            <div class="col-6  col-lg-4 attTableContent" style="border-right: 1px solid #c6c6c6;"><ul>
	        <li>자동출결시스템 장비설치 강의실(20개)</li>
          <li>장비 미설치 강의실(수기입력방식)</li></ul>
           </div>
           <div class="col-6  col-lg-4 attTableContent mb-3"><ul>
	        <li>음파출결시스템 사용</li>
          <li>전자출결시스템 수기입력방식 사용</li></ul>
           </div>
            <div class="col-2 d-none d-lg-block"></div>
			<div class="col-12 mb-5"><ul>
	<li><em class="em_red">학생 출결입력은 해당수업이 진행된 그 주 일요일 23:00까지 입력하여야 합니다</em>(수업관리지침 제3조 3항).</li>
	<li>학생 학적 및 수강신청 과목 변동 등의 변경 사항이 있을 경우 변경일 기준 1일 후에 전자출결시스템에 반영됩니다.(매일 새벽에 업데이트 됨)</li>
	<li>집중수업 및 창업수업 :  실제로 수업하는 날짜만 출석부에 보여지므로 주차해제를 하지 않고 일반 수업과 같은 방법으로 입력하시면 됩니다.</li>
	<li>동일 수업일의 연속수업인 경우 첫번째 교시를 출석변경하면 두번째, 세번째 교시가 같은 출결로 변경됩니다.</li>
</ul>       
		</div>
		<div class="col-12 secondTitle mb-3"><h4 class="socialH4">음파출결시스템 사용방법 안내</h4></div>
			<div class="col-12 mb-5"><ul>
	<li>음파출결시스템이란 수업 담당교수 휴대폰의 전자출결시스템 앱의 음파를 이용하여 학생이 스마트폰 앱을 통해 출석체크하면 자동으로 출석이 되는 방식입니다.</li>
	<li>음파출결시스템을 사용하기 위해서는 <em class="em_blue">담당교수와 학생 모두 전자출결시스템 앱을 다운로드 받아 설치해야 하고, 앱을 통하여 교수님이 음파송신을 클릭하면 10분동안 학생들이 출석체크를 할 수 있습니다.</em></li>
	<li><b>전자교탁이 없는 실습실이나 일반 강의실에서도 학생들이 직접 출석 체크할 수 있습니다.</b></li>
	<li>동일 수업일의 연속수업의 경우 음파출결 앱에서 연속출결 기능은 없으니 매교시 출결체크 하여야 합니다.</li>
	<li>휴대폰을 소지하지 않았거나 스마트폰이 아닌 휴대폰을 소지하여 음파출결방식을 사용할 수 없을 경우 기존처럼 온라인출결시스템에 수기로 출결사항을 입력하시면 됩니다.</li>
	<li>전자출결 앱은 항상 최신버전으로 유지되어야 합니다</li>
</ul>       
		</div>
		<div class="col-12 secondTitle mb-3"><h4 class="socialH4">음파출결시스템 사용하여 출석체크하는 방법</h4></div>
			<div class="col-12 mb-5"><ul>
	<li>휴대폰 방식에 맞는 스토어 실행</li>
	<li>「가차대학교 전자출결시스템」 어플리케이션(앱)을 다운로드</li>
	<li>앱을 실행한 후 로그인</li>
	<li>수업 담당교수가 음파송신을 시작하면</li>
	<li>전자출결 앱 오디오 사용 허용해야 함.(휴대폰의 기종에 따라 팝업창이 안 뜰수 있음)</li>
	<li>학생들은 본인 강의가 맞는 지 확인 후 출석체크 버튼 클릭</li>
	<li>학생들이 출석확인 버튼 클릭(출석부 상에 학생의 출석 상황이 표시됨)</li>
</ul>       
		</div>
				<div class="col-12 secondTitle mb-3"><h4 class="socialH4">전자출결시스템 출석입력 관련 유의사항</h4></div>
			<div class="col-12 mb-5"><ul class="bu">
	<li><em class="em_blue">아이폰 사용자(IOS방식)은 첨부된 음파출결시스템 학생용 사용서를 반드시 확인하시고 실행하시기 바랍니다.</em></li>
	<li><em class="em_blue">학생들은 1인 1일 1개 휴대폰만 로그인 가능합니다. 다른 학생 휴대폰으로 로그인하면 본인 휴대폰으로 같은 날 로그인해서 출석 체크 불가합니다(부정출석 방지).</em></li>
	<li><em class="em_blue">휴대폰 기기가 변경된 경우 다음날부터 로그인 가능합니다.</em></li>
	<li>학생들도 앱에서 본인의 출결상황 확인 가능합니다.(전자출결 앱을 실행한 후 로그인 → 메인화면으로 이동 → 출결조회 버튼을 클릭)</li>
	<li><b>스마트폰 버전이 낮거나 스마트폰이 아닌 경우, 스마트폰이 없는 경우, 오류가 발생한 경우 담당교수님이 전자출결시스템 사이트에서 수기로 출결사항 변경 가능하니 담당교수님께 출석 요청 바랍니다.</b></li>
	<li>담당교수님이 음파송신후 10분 동안 출석체크 할 수 있습니다.</li>
	<li>학생들이 수강변경후 변경된 내용은 변경일 기준 1일후 출석부에 반영됩니다.(학기중은 매일 새벽에 업데이트됨)</li>
</ul>       
		</div>
					<div class="col-12 secondTitle mb-3"><h4 class="socialH4">성적정정</h4></div>
			<div class="col-12 mb-5"><ul class="bu">
	<li>성적에 이의가 있으면 소정기간(학기초1주일)내에 담당교수에게 이의 신청한다.</li>
	<li>성적예고제 이후에 정정의 사유가 있으면 성적 정정원에 증빙서류를 첨부하여 해당과목 담당교수가 소속 대학장을 경유 교무처에 제출한 후 교무처장의 승인을 받아 정정할 수 있다.</li>
</ul>       
		</div>
	</div>
</div>
    </div>	
<%@ include file="../footer.jsp"%>