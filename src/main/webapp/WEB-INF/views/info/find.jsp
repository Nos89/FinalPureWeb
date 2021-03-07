<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/resources/jsp/head.jsp" %>
<body>
	<div class="container-fluid mt-4">
		<div class="row">
			<div class="col-12 text-center"><h2>${ find == "id"? "아이디 " : "비밀번호 " } 찾기</h2></div>
			<div class="col-12 findFormWrapper">
				<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <label class="input-group-text" for="findUserType">구분</label>
				  </div>
				  <select class="custom-select" id="findUserType" name="userType">
				    <option selected>선택해주세요.</option>
				    <option value="S">학생</option>
				    <option value="P">교수</option>
				  </select>
				</div>
				<c:if test="${find != 'id' }">
				<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text">아이디</span>
				  </div>
				  <input type="text" name="userID" class="form-control" placeholder="아이디를 입력해주세요.">
				</div>
				<script>
					$(document).ready(function(){
						var userType = "";
						$("select[name=userType]").change(function(){
							userType = $(this).val() + "-";
							$("input[name=userID]").val(userType);
						})
					})
				</script>
				</c:if>
				<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text">이름</span>
				  </div>
				  <input type="text" name="userName" class="form-control" placeholder="이름을 입력해주세요.">
				</div>
				<div class="input-group mb-3">
				  <div class="input-group-prepend">
				    <span class="input-group-text">핸드폰번호</span>
				  </div>
				  <input type="text" name="firstPN" class="form-control">
				  <input type="text" name="secondPN" class="form-control">
				  <input type="text" name="thirdPN" class="form-control">
				</div>
				<div class="input-group text-center mb-3">
					<div class="input-group-prepend resultDiv">
						
					</div>
				</div>
				<div class="input-group-prepend text-center">
				    <button class="btn btn-outline-secondary findIDPW" type="button">찾기</button>
				    <button class="btn btn-outline-secondary btnClose" type="button">닫기</button>
			  	</div>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function(){
			
			$("input[name=firstPN]").keydown(function(e){
				if( $("input[name=firstPN]").val().length >= 3 && e.keyCode != 8){
					$("input[name=secondPN]").focus();
				}
			})
			
			$("input[name=secondPN]").keydown(function(e){
				if( $("input[name=secondPN]").val().length >= 4 && e.keyCode != 8){
					$("input[name=thirdPN]").focus();
				} else if( $("input[name=secondPN").val().length == 0 && e.keyCode == 8 ){
					$("input[name=firstPN]").focus();
				}
			})
			
			$("input[name=thirdPN]").keydown(function(e){
				if( $("input[name=thirdPN]").val().length >= 4 && e.keyCode != 8){
					$(".findIDPW").focus();
				} else if( $("input[name=thirdPN]").val().length == 0 && e.keyCode == 8 ){
					$("input[name=secondPN]").focus();
				}
			})
			
			$(".findIDPW").click(function(){
				// 유효성 체크
				var pn = $("input[name=firstPN]").val()+"-"+
						$("input[name=secondPN]").val()+"-"+
						$("input[name=thirdPN]").val();
				console.log($("select[name=userType]").val());
				if( $("select[name=userType]").val() == "선택해주세요." ){
					alert("학생/교수 를 선택해주세요.");
					return;
				}
				if( "${find}" == "id" ){
					if( $("input[name=userName]").val() == "" ){
						alert("이름을 입력해주세요.");
						return;
					} else if( $("input[name=firstPN]").val() == "" || $("input[name=secondPN]").val() == "" || $("input[name=thirdPN]").val() == "" ){
						alert("연락처를 입력해주세요.");
						return;
					} 
					$.ajax({
						url: "/info/findIDPW",
						data: {
							find : "${find}",
							userType : $("select[name=userType]").val(),
							userName : $("input[name=userName]").val(),
							pn : pn
						},
						type: "post"
					}).done(function(resp){
						$(".resultDiv").html("");
						$(".resultDiv").siblings().remove();
						
						console.log(resp);
						
						var sp = $("<span></span>");
						sp.addClass("input-group-text");
						if( resp.result == false ){
							sp.append("일치하는 아이디가 없습니다.");
						} else {
							sp.append("아이디");
							var input = $("<input>");
							input.attr("type", "text");
							input.attr("name", "result");
							input.addClass("form-control");
							input.val(resp.id);
							$(".resultDiv").parent().append(input);
						}
						
						$(".resultDiv").append(sp);
					})
				} else {
					if( $("input[name=userID]").val() == "" ){
						alert("아이디를 입력해주세요.");
						return;
					} else if( $("input[name=userName]").val() == "" ){
						alert("이름을 입력해주세요.");
						return;
					} else if( $("input[name=firstPN]").val() == "" || $("input[name=secondPN]").val() == "" || $("input[name=thirdPN]").val() == "" ){
						alert("연락처를 입력해주세요.");
						return;
					}
					
					$.ajax({
						url: "/info/findIDPW",
						data: {
							find : "${find}",
							userType : $("select[name=userType]").val(),
							userID : $("input[name=userID]").val(),
							userName : $("input[name=userName]").val(),
							pn : pn
						},
						type: "post",
					}).done(function(resp){
						console.log(resp.result);
						var sp = $("<span></span>");
						sp.addClass("input-group-text");
						
						if( resp.result != false ){
							$(".resultDiv").html("");
							$(".resultDiv").siblings().remove();
							
							sp.append("비밀번호");
							var input1 = $("<input>");
							input1.attr("type", "password");
							input1.attr("name", "firstPW");
							input1.addClass("form-control");
							var input2 = $("<input>");
							input2.attr("type", "password");
							input2.attr("name", "secondPW");
							input2.addClass("form-control");
							$(".resultDiv").append(sp);
							$(".resultDiv").parent().append(input1);
							$(".resultDiv").parent().append(input2);
							var btnDiv = $("<div></div>");
							btnDiv.addClass("input-group-append");
							var btn = $("<button>재설정</button>");
							btn.attr("type", "button");
							btn.addClass("btn btn-outline-secondary resetPW");
							btnDiv.append(btn);
							$(".resultDiv").parent().append(btnDiv);
							
							btn.click(function(){
								if( input1.val() == "" || input2.val() == ""){
									alert("비밀번호를 입력해주세요.");
									return;
								}
								
								if( input1.val() != input2.val() ){
									alert("비밀번호가 일치하지 않습니다.");
								} else {
									$.ajax({
										url: "/info/changePW",
										type: "post",
										data: {
											userID: $("input[name=userID]").val(),
											pw: input1.val()
										}
									}).done(function(resp){
										console.log(resp);
										if( resp == true ){
											alert("비밀번호가 변경됐습니다.");
											close();
										}
									})
								}
							})
						} else {
							$(".resultDiv").html("");
							$(".resultDiv").siblings().remove();
							
							var sp = $("<span></span>");
							sp.addClass("input-group-text");
							sp.append("일치하는 정보가 없습니다.");
							$(".resultDiv").append(sp);
						}
					})
				}
			})
			
			$(".btnClose").click(function(){
				close();
			})
		})
	</script>
</body>
</html>