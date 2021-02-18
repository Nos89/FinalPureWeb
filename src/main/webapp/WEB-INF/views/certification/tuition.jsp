<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교육비납입증명서</title>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<style>
* {
	box-sizing: border-box;
}

.container {
	border: 1px solid black;
	width: 180mm;
	height: 250mm;
}

.header {
	background-color: #9dc2e1;
	height: 20mm;
	line-height: 20mm;
	text-align: right;
}

.main {
	border: 1px solid black;
	margin-top: 20px;
	margin-left: 5mm;
	width: 170mm;
	height: 200mm;
	box-shadow: 4px 4px 4px 4px gray;
}

.head {
	height: 50mm;
	text-align: center;
	line-height: 50mm;
}

.title {
	font-size: 50px;
}

.info {
	letter-spacing: 70px;
	padding-left: 50px;
	height: 30px;
	width: 250px;
}

.body {
	height: 70mm;
}

.name {
	display: flex;
	height: 40px;
}

.my {
	letter-spacing: 10px;
}

.number {
	letter-spacing: 10px;
	padding-left: 50px;
	width: 250px;
}

.contents {
	text-align: center;
	font-weight: 800;
	height: 170px;
	font-size: 20px;
}

.foot {
	text-align: center;
	height: 130px;
}

.day {
	height: 60px;
}

.bottom {
	text-align: center;
	height: 90px;
	line-height: 90px;
}

#print {
	cursor: pointer;
	background-color: #9dc2e1;
	border: none;
	width: 65px;
	height: 65px;
	margin-right: 50px;
	text-align: center;
	margin-top: 5px;
}

#print:hover {
	outline: none;
	opacity: 0.3;
}

#print:visited {
	opacity: 1;
}

#img {
	padding-right: 5px;
	width: 60px;
	height: 60px;
}

#img2 {
	width: 100%;
	height: 600px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="header">
			<button id="print">
				<img id="img" src="/resources/img/certification/print.png">
			</button>
		</div>
		<div class="main">

			<div class="img">
				<img id="img2" src="/resources/img/certification/tuition.jpg">
			</div>
			<div class="foot">
				<div class="day">${today}</div>
				<div class="school">K H 대 학 교 총 장</div>
			</div>
		</div>

		<div class="bottom">
			<button class="close">닫기</button>
		</div>
	</div>
	
	<script>
		$('.close').click(function(e) {
			window.close();
		});
		
		/** 프린트 버튼 클릭 시 이벤트 */
		$("#print").click(function () {
		    let $container = $(".main").clone()    // 프린트 할 특정 영역 복사
		    let cssText = ""                            // 스타일 복사
		    for (const node of $("style")) {
		        cssText += node.innerHTML
		    }
		    /** 팝업 */
		    let innerHtml = $container[0].innerHTML
		    let popupWindow = window.open("", "_blank", "width=700,height=800")
		    popupWindow.document.write("<!DOCTYPE html>"+
		      "<html>"+
		        "<head>"+
		        "<style>"+cssText+"</style>"+
		        "</head>"+
		        "<body>"+innerHtml+"</body>"+
		      "</html>")
		   
		    popupWindow.document.close()
		    popupWindow.focus()

		    /** 1초 지연 */
		    setTimeout(() => {
		        popupWindow.print()         // 팝업의 프린트 도구 시작
		        popupWindow.close()         // 프린트 도구 닫혔을 경우 팝업 닫기
		    }, 1000)
		});
	</script>
</body>
</html>