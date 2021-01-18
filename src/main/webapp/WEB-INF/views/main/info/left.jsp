<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col-2">
	<div class="row text-center leftMenu">
		<div class="col-12"><p>학사 안내</p></div>
		<div class="col-12">
			<ul class="list-group">
			  <li class="list-group-item">학사 안내 </li>
			  <li class="list-group-item"><a href="#">교과 과정</a></li>
			  <li class="list-group-item"><a href="#">수업</a></li>
			  <li class="list-group-item"><a href="#">학적</a></li>
			  <li class="list-group-item"><a href="#">등록</a></li>
			  <li class="list-group-item"><a href="#">졸업</a></li>
			  <li class="list-group-item"><a href="#">대학 ROAD-MAP</a></li>
			  <li class="list-group-item"><a href="#">증명서 발급</a></li>
			</ul>
		</div>
	</div>
</div>
<script>
$(document).ready(function(){
	let listLength = $(".list-group-item").length;
	let arrType = [];
	for( let i = 0; i < listLength; i++ ){
		let href = $(".list-group-item").eq(i).children().attr("href");
		arrType[i] = href.substring( href.indexOf("type=") + 5, href.length );
	}
	console.log(arrType);
	for( let i = 0; i < arrType.length; i++ ){
		if( "${type}" == arrType[i] ){
			$(".list-group-item").eq(i).addClass("active");
		}
	}
})
</script>