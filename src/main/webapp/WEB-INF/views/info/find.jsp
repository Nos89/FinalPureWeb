<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/resources/jsp/head.jsp" %>
<body>
	<div class="container-fluid mt-4">
		<div class="row">
			<div class="col-12 text-center"><h2>${ find == "id"? "아이디 " : "비밀번호 " } 찾기</h2></div>
			<div class="col-12 findFormWrapper">
				<c:if test="${find != 'id' }">
				<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text">아이디</span>
				  </div>
				  <input type="text" name="userID" class="form-control" placeholder="아이디를 입력해주세요.">
				</div>
				</c:if>
				<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text">이름</span>
				  </div>
				  <input type="text" name="userName" class="form-control" placeholder="이름을 입력해주세요.">
				</div>
				<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text">주민번호</span>
				  </div>
				  <input type="text" name="prefixRRN" class="form-control">
				  <input type="password" name="suffixRRN" class="form-control">
				</div>
				<div class="input-group-prepend text-center">
				    <button class="btn btn-outline-secondary findIDPW" type="button">찾기</button>
				    <button class="btn btn-outline-secondary close" type="button">닫기</button>
				  </div>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function(){
			//new RegExp(/abc/g, 'i')
			var chkNum = new RegExp(/[^0-9]+$/, 'g');
			
			$(".findIDPW").click(function(){
				if( "${find}" == "id" ){
					$.ajax({
						url: "/info/findIDPW",
						data: {
							find : "${find}",
							userName : $("input[name=userName]").val(),
							userRRN : $("input[name=prefixRRN]").val() + $("input[name=suffixRRN]").val()
						},
						type: "post",
					}).done(function(resp){
						alert(resp);
					})
				} else {
					$.ajax({
						url: "/info/findIDPW",
						data: {
							find : "${find}",
							userID : $("input[name=userID]").val(),
							userName : $("input[name=userName]").val(),
							userRRN : $("input[name=prefixRRN]").val() + $("input[name=suffixRRN]").val()
						},
						type: "post",
					}).done(function(resp){
						alert(resp);
					})
				}
			})
			
		})
	</script>
</body>
</html>