<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/head.jsp" %>
<%@ include file="../header.jsp" %>
<div class="row body m-0 mt-3">
	<!-- Body 부분 입니다. 왼쪽 메뉴, 메인 컨텐츠 부분 넣어주세요. -->
	<%@ include file="left.jsp" %>
	<div class="col-10">
		<div class="row">
			<div class="col-12 subTitle mb-5">
				정시 안내
			</div>
			<div class="col-12">
				<iframe src="/resources/2021jungsi.pdf" style="width:100%;height:700px;"></iframe>
			</div>
		</div>
	</div>
</div>
<%@ include file="../footer.jsp" %>