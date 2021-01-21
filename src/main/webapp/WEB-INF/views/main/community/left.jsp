<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col-2">
	<div class="row text-center leftMenu">
		<div class="col-12"><p>커뮤니티</p></div>
		<div class="col-12">
			<ul class="list-group">
			  <li class="list-group-item"><a href="/main?pageGroup=community&type=freeBoard">자유 게시판</a></li>
			  <li class="list-group-item"><a href="/main?pageGroup=community&type=anonymBoard">대나무숲</a></li>
			  <li class="list-group-item"><a href="/main?pageGroup=community&type=reportBoard">건의 게시판</a></li>
			  <li class="list-group-item"><a href="/main?pageGroup=community&type=notice">공지사항</a></li>
			  <li class="list-group-item"><a href="/main?pageGroup=community&type=promoteBoard">홍보 게시판</a></li>
			  <li class="list-group-item"><a href="/main?pageGroup=community&type=eventBoard">행사 게시판</a></li>
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
	for( let i = 0; i < arrType.length; i++ ){
		if( "${type}" == arrType[i] ){
			$(".list-group-item").eq(i).addClass("active");
		}
	}
})
</script>