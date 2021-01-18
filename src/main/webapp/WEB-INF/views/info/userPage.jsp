<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Info Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" >
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script> 
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
 <meta http-equiv="Expires" content="0">
  <meta http-equiv="Pragma" content="no-cache">
 <link rel="stylesheet" href="/resources/css/info/userPage.css?ver=1">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	 <div class="container-fluid wrapper">
        <div class="row">
            <div class="col title" style="width: 150px; margin-left: 150px;">OO대학교(로고사진) 포털시스템</div>
            </div>
            <div class="row menu">
                <div class="col-4 menu_infosys" style="margin-left: 150px; ">종합정보시스템</div>
           <div class="col-4 menu_eleattend" >전자출결</div>
                <div class="col-4 menu_homepage" >대표홈페이지</div>
          
            </div>
            
            <div class="row left">
            
                <div class="col-3 my" >
            <c:choose>    
                	<c:when test="${userPart == '학생' }">
                		<div class=name>${userName } 님</div><div class="major">${userMajor }</div>
                    	<div class="mail">
                         	<div class=mail_notRead>안 읽은 메일</div>
                        	<div class="mail_notReadNum">건</div>     
                    	</div>
                   		<div class="consultReqPart">
                        	<div class=consultReq>상담신청</div>
                        	<div class="consultReqNum">건</div>
                    	</div>
                	</c:when>
                		
                	<c:when test="${userPart == '교수' }">
                 		<div class=name>${userName } 님</div><div class="major">${userMajor } 교수</div>
                    	<div class="mail">
                         	<div class=mail_notRead>안 읽은 메일</div>
                        	<div class="mail_notReadNum">건</div>     
                    	</div>             		
                	</c:when>  
                </c:choose>
                </div>
                
                
                
                <div class="col-9 board" >게시판(학사/일반/장학)</div>
                
                <c:choose>
                	<c:when test="${userPart == '학생' }">
                		 <div class="col-3 subject">수강과목</div>
                	</c:when>
                	<c:when test="${userPart == '교수' }">
                		 <div class="col-3 subject">강의목록</div>
                	</c:when>
                </c:choose>
                
                <div class="col-3 calendar">달력</div>
                <div class="col-4 schedule">학사일정</div>
            </div>
            <div class="row right">
            <c:choose>
                	<c:when test="${userPart == '학생' }">
                		 <div class="col-6 classtimetable">수강시간표</div>  
                	</c:when>
                	<c:when test="${userPart == '교수' }">
                		 <div class="col-6 classtimetable">강의시간표</div>
                	</c:when>
            </c:choose>
            </div>
            
            <div class="row shortcutPart">
                <div class="col-2 shortcut">바로가기</div>
                <div class="col-2 toClassSche">학사일정</div>
                <div class="col-2 toBus">통학버스</div>
                <div class="col-2 toDomi">생활관안내</div>
                <div class="col-2 toReportBoard">건의게시판</div>
                <div class="col-2 toExAuth">인터넷증명</div>
            </div>
            
            <div class="row footerInfo">
                    <div class="col-4 info_personal" style="margin-left: 120px; ">개인정보처리방침</div>
                    <div class="col-4 info_infoOpen" >정보공개</div>
                    <div class="col-4 info_emailReject" >이메일수집거부</div>
            </div>
            <div class="row info_school">
                <div class="col-12">
               <img src="/resources/img/info/copyright.png" style="margin-left: 140px">
                </div>
            </div>
            
        
        
        
        </div>
     
</body>
</html>