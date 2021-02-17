<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
<!-- BootStrap 및 Jquery -다른 jsp 만들때 가져가주세요 -->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/resources/summernote/summernote-lite.css?ver=1">
<script src="/resources/summernote/summernote-lite.js"></script>
<script src="/resources/summernote/lang/summernote-ko-KR.js"></script>

<style>
	.postWrapper{
		width: 800px;
		margin: auto;
		padding-top: 10px;
	}
	.summernote{
		min-height: 270px;
		height:auto;
	}
	.articleTitle, .articleCategory, .articleWriteDate{
		border-bottom: 1px solid #6c757d;
	}
	div[class^="article"]{padding:5px 0px;}
</style>

</head>
<body>
	<div class="row postWrapper">
		<div class="col-2 mb-4 articleCategory"><b>${article.category}</b></div>
		<div class="col-8 mb-4 articleTitle">${article.noti_title}</div>
		<div class="col-2 mb-4 articleWriteDate">${article.noti_writeDate}</div>
		<div class="col-12 summernote">${article.noti_contents}</div>
		<div class="col-12">
			<div class="row mt-3">
				<div class="col-8">
					<div class="row">
						<div class="col-12 inputFileWrapper">
							<c:forEach var="i" items="${files}">
							<div class="row">
								<div class="col-12">
									<a href="/boardFiles/${i.savedName}" target="_blank">${i.oriName}</a>
								</div>
							</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row mt-3 commentWrapper">
			<div class="col-12">
				<div class="row border border-secondary rounded px-3 pt-3 mt-3 commentsList">
					<c:if test="${comments.list[0].seq != null }">
						<c:forEach var="i" items="${comments.list}">
						<div class="col-2 mb-3">
							<div class="row">
								<c:if test="${type != 'anonym' }">
									<div class="col-12 commentsWriter">${i.writer}</div>
								</c:if>
								<div class="col-12">${i.reg_date}</div>
							</div>
						</div>
						<div class="col-9 mb-3">${i.contents}</div>
						<div class="col-1 mb-3 commentsBtnWrapper">
							<input type="hidden" name="comSeq" class="comSeq" value="${i.seq}">
						</div>
						</c:forEach>
					</c:if>
					<c:if test="${comments.list[0].seq == null}">
						<div class="col-12 text-center pb-3">
							댓글이 없습니다.
						</div>
					</c:if>
					</div>
					<div class="row p-2 mt-3 rounded commentNaviWrapper">
						<div class="col-12 text-center">
							<div class="row">
								<div class="col-3"></div>											
								<div class="col-6">
									<div class="row text-center commentsNavi">
										<div class="col-1"></div>
										<c:forEach var="i" begin="${comments.navi.startNavi}" end="${comments.navi.endNavi}">
											<div class="col-1 commentPage"><a href="/main/board.view?pageGroup=${pageGroup}&type=${type}&seq=${article.noti_seq}&purp=view&commentPage=${i}">${i}</a></div>
										</c:forEach>
										<div class="col-1"></div>
									</div>
								</div>											
								<div class="col-3"></div>											
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
<script>
$(document).ready(function(){
	

	if( "${comments.list[0].seq}" != "" ){
		$(".commentNaviWrapper").addClass("border border-secondary");
	}
	
	$(".btnInputComment").click(function(){
		$.ajax({
			url: "/main/insert.comments",
			type: "post",
			data: {
				parent_code : "${noti_seq}",
				writer : "${loginID}",
				contents : $(".inputComment").val()
			},
			success: function(data){
				ajaxComments(data);
			}
		}).done(function(){
			alert("댓글 입력 완료!!");
			showComDel();
			eventComDel();
			if( "${commentPage}" != 1 ){
				location.href="/main/board.view?pageGroup=${pageGroup}&type=${type}&seq=${noti_seq}&page=${page}&purp=view&commentPage=1";
			}
			if( "${comments.list[0].seq}" != "" ){
				$(".commentNaviWrapper").addClass("border border-secondary");
			}
		})
	})
	
	// 댓글 삭제 버튼 보이기
	showComDel();
	eventComDel();
	
	// 현재 댓글 페이지 표시
	console.log("${commentPage}");
	console.log($(".commentPage").length);
	for( let i = 0; i < $(".commentPage").length; i++ ){
		console.log($(".commentPage").eq(i).children().html());
		if( $(".commentPage").eq(i).children().html() == "${commentPage}"){
			$(".commentPage").eq(i).children().css("color", "blue");
			$(".commentPage").eq(i).children().css("font-weight", "bold");
		}
	}
})

// 댓글 삭제 버튼 보이기
let showComDel = function(){
	for( let i = 0; i < $(".commentsWriter").length; i++ ){
		console.log($(".realCommentsWriter").eq(i).html());
		if( "${loginID}" == $(".commentsWriter").eq(i).html() && "${type}" != "anonym" ){
			$(".commentsBtnWrapper").eq(i).append("<button type=button class='btn btn-outline-danger btnComDel'>삭제</button>");
		} else if( "${loginID}" == $(".realCommentsWriter").eq(i).html() && "${type}" == "anonym" ){
			$(".commentsBtnWrapper").eq(i).append("<button type=button class='btn btn-outline-danger btnComDel'>삭제</button>");
		}
	}
}

// 댓글 삭제 버튼 이벤트
let eventComDel = function(){
	$(".btnComDel").click(function(){
		$.ajax({
			url: "/main/delete.comments",
			type: "post",
			data: {
				parent_code : "${noti_seq}",
				seq : $(this).siblings(".comSeq").val(),
				commentPage : "${commentPage}"
			},
			success: function(data){
				if( (JSON.parse(JSON.parse(data)[1])) == "" ){
					$(".commentsList").html("");
					$(".commentsList").append(
						'<div class="col-12 text-center pb-3">'+
							'댓글이 없습니다.'+
						'</div>'		
					);
					$(".commentsNavi").html("");
					$(".commentNaviWrapper").removeClass("border border-secondary");
				} else {
					ajaxComments(data);
				}
			}
		}).done(function(){
			showComDel();
			eventComDel();
		})
	})
}

// ajax 댓글 불러와서 붙혀넣기
let ajaxComments = function(data){
	data = JSON.parse(data);
	
	let responseComments = JSON.parse(data[1]);
	$(".commentsList").html("");
	for( let i = 0; i < responseComments.length; i++ ){
		$(".commentsList").append(
				'<div class="col-2 mb-3">'+
					'<div class="row">'+
						'<div class="col-12 commentsWriter">'+responseComments[i].writer+'</div>'+
						'<div class="col-12">'+responseComments[i].reg_date+'</div>'+
					'</div></div>'+
				'<div class="col-9 mb-3">'+responseComments[i].contents+'</div>'+
				'<div class="col-1 mb-3 commentsBtnWrapper">'+
					'<input type="hidden" name="comSeq" class="comSeq" value="'+responseComments[i].seq+'">'+
				'</div>');
	}
	let ajaxNavi = JSON.parse(data[0]);
	$(".commentsNavi").html("");
	$(".commentsNavi").append('<div class="col-1"></div>');
	for( let i = ajaxNavi.startNavi; i <= ajaxNavi.endNavi; i++ ){
		$(".commentsNavi").append('<div class="col-1 commentPage"><a href="/main/board.view?pageGroup=${pageGroup}&type=${type}&seq=${article.noti_seq}&purp=view&commentPage='+i+'">'+i+'</a></div>');
	}
	$(".commentsNavi").append('<div class="col-1"></div>');
	
	if( responseComments != "" ){
		$(".commentNaviWrapper").addClass("border border-secondary");
	}
}
</script>
</body>
</html>