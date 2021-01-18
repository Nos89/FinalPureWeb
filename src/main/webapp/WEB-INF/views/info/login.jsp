<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Info login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" >
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script> 
   <link rel="stylesheet" href="/resources/css/info/login.css?ver=1">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<div class="wrapper">
            <div class="row " id="title">
                <div class="col" >사다리대학교(로고사진+타이틀)</div>
         </div>
              <div class="row" id=box>
              
                  <div id=loginBox>
                      <div id=loginTitle><h3>로그인</h3></div><div id=loginTitle_eng>Login</div>
                      <div id=part>
                      <div id="loginStd">학부생용</div>
                      <div id="loginPro">교수용</div>
                      </div>
                      <div id=loginID><div id=idTitle>ID</div><input type=text name=id id=idText placeholder="id placeholder"></div>
                    <div id=loginPW><div id=pwTitle>PW</div><input type=text name=pw id=pwText placeholder="pw placeholder"></div>
                      <div id=rmbId><input type=checkbox id=chkBox > 아이디 저장</div>
                      <div id=findIDPW><input type=button id=findID value="아이디찾기"><input type=button id=findPW value="비밀번호재설정"></div>
                      
                      <div id=loginBtn><input type=submit value=로그인  id=loginSubmit></div>
                  </div>
                  
                  <script>
                  $("#loginSubmit").on("click", function(){
                	  	let id = document.getElementById("idText").value;
                	  	let pw = document.getElementById("pwText").value;
                		location.href="/info/login?id="+id+"&pw="+pw;
                	})
                	
                  </script>
                  
                   
                  <div id=scheBox>
                   <div id=acdmCalTitle><h3>학사일정</h3></div><div id=acdmCalTitle_eng>Academic Calendar</div>
                      <div id=acmdContainer>
                      <div id=acmdCalIcon>
                          <img src="/resources/img/학사일정아이콘.png"></div>
                      <div id=acmdCalContents>
                          <div id=acmdCalPart>
                              <div id=acmdCalTitle>[학사일정] 계절학기수업</div>
                            <div id=acmdCalDate>2021-01-04 ~ 2021-01-22</div>
                          </div>
                          <div id=acmdCalPart>
                              <div id=acmdCalTitle>[학사일정] 계절학기수업</div>
                            <div id=acmdCalDate>2021-01-04 ~ 2021-01-22</div>
                          </div>
                          <div id=acmdCalPart>
                              <div id=acmdCalTitle>[학사일정] 계절학기수업</div>
                            <div id=acmdCalDate>2021-01-04 ~ 2021-01-22</div>
                          </div>
                          <div id=acmdCalPart>
                              <div id=acmdCalTitle>[학사일정] 계절학기수업</div>
                            <div id=acmdCalDate>2021-01-04 ~ 2021-01-22</div>
                          </div>
                          </div>
                          
                      </div>
                      
                  </div>
                  <div id=menuBox>
                      <div class=menuPart>수강신청</div>
                    <div class=menuPart>대표홈페이지</div>
                       <div class=menuPart>~~로 이동</div>
                       <div class=menuPart>~~로 이동</div>
                       <div class=menuPart>도움말</div>
                  </div>
              </div>
         
         
        
         </div>
 
</body>
</html>