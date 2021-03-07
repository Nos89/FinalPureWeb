<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/head.jsp" %>
<%@ include file="main/header.jsp" %>
		<div class="row body mt-3">
			<div class="col-3"></div>
			<div class="col-6">
				<div class="row border border-primary text-center">
					<div class="col-12">
						<p>에러가 발생했습니다.</p>
						<p>지속적으로 에러가 발생한다면, 관리자에게 문의해주세요.</p>
					</div>
					<div class="col-12">
						<button class="btn btn-primary btnHome">홈으로</button>
					</div>
				</div>			
			</div>		
			<div class="col-3"></div>
			<script>
				$(".btnHome").click(function(){
					location.href="/";
				})
			</script>
		</div>
<%@ include file="main/footer.jsp" %>