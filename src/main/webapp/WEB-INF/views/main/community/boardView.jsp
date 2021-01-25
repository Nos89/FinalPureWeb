<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div class="row writerWrapper">
		<div class="col-8 mb-4 articleTitle">${article.title}</div>
		<div class="col-2 mb-4 articleWriter">${ type == 'anonym'? '익명' : article.writer}</div>
		<div class="col-2 mb-4 articleWriteDate">${article.writeDate}</div>
		<div class="col-12 summernote">
			${article.contents}
		</div>
		<div class="col-12">
			<div class="row mt-3 text-center">
				<c:if test="${loginID != article.writer}">
				<div class="col-10"></div>
				</c:if>
				<c:if test="${loginID == article.writer}">
				<div class="col-8"></div>
				<div class="col-1"><button class="btn btn-outline-success btnModify" type="button">수정</button></div>
				<div class="col-1"><button class="btn btn-outline-danger btnDelete" type="button">삭제</button></div>
				</c:if>
				<div class="col-2"><button class="btn btn-outline-success btnList" type="button">목록으로</button></div>
			</div>
			<div class="row mt-3 commentWrapper">
				<div class="col-12">
					<div class="row">
						<div class="col-10 p-0">
							<textarea name="inputComment" class="inputComment p-2" placeholder="댓글을 입력해주세요."></textarea>
						</div>
						<div class="col-2 text-center p-0">
							<button type="button" class="btn btn-outline-success rounded-pill btnInputComment">댓글입력</button>
						</div>
					</div>
					<div class="row border border-secondary rounded px-3 pt-3 mt-3 commentsList">
					<c:if test="${comments.list[0].seq != null }">
						<c:forEach var="i" items="${comments.list}">
						<div class="col-2 mb-3">
							<div class="row">
								<c:if test="${type != 'anonym' }">
								<div class="col-12 commentsWriter">${i.writer}</div>
								</c:if>
								<c:if test="${type == 'anonym' }">
								<div class="col-12 commentsWriter">${loginID == i.writer? '작성자':'익명' }</div>
								<div class="realCommentsWriter">${i.writer}</div>								
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
											<div class="col-1 commentPage"><a href="/main/board.view?pageGroup=${pageGroup}&type=${type}&seq=${article.seq}&purp=view&commentPage=${i}">${i}</a></div>
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
</div>
<script>
$(document).ready(function(){
	$(".btnList").click(function(){
		location.href="/main/board.list?pageGroup=${pageGroup}&type=${type}&page=${page}${ search != null ? '&search=' : '' }${search!=null?search:''}";
	})
	
	// 게시글 수정
	$(".btnModify").click(function(){
			location.href="/main/board.view?pageGroup=${pageGroup}&type=${type}&seq=${article.seq}&purp=modify";
		})	
	// 게시글 삭제
	$(".btnDelete").click(function(){
		let flag = confirm("게시글을 삭제하시겠습니까?");
		if(flag){
			alert("게시글이 삭제 됐습니다.");
			location.href="/main/board.delete?pageGroup=${pageGroup}&type=${type}&seq=${article.seq}";
		}
	})
	
	if( "${comments.list[0].seq}" != "" ){
		$(".commentNaviWrapper").addClass("border border-secondary");
	}
	
	$(".inputComment").summernote({
		height: 80,                 // 에디터 높이
		minHeight: 80,             // 최소 높이
		maxHeight: 80,             // 최대 높이
		focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		lang: "ko-KR",					// 한글 설정
		placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
		toolbar: [
		    // 글꼴 설정
		    ['fontname', ['fontname']],
		    // 글자 크기 설정
		    ['fontsize', ['fontsize']],
		    // 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기
		    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
		    // 글자색
		    ['color', ['forecolor','color']],
		    // 표만들기
		    ['table', ['table']],
		    // 글머리 기호, 번호매기기, 문단정렬
		    ['para', ['ul', 'ol', 'paragraph']],
		    // 코드보기
		    ['view', ['codeview']]
		  ],
		  // 추가한 글꼴
		fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'],
		 // 추가한 폰트사이즈
		fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
		  callbacks: {	//여기 부분이 이미지를 첨부하는 부분
				onImageUpload : function(files) {
					console.log(files[0]);
					uploadSummernoteImageFile(files[0],this);
				},
				onPaste: function (e) {
					var clipboardData = e.originalEvent.clipboardData;
					if (clipboardData && clipboardData.items && clipboardData.items.length) {
						var item = clipboardData.items[0];
						if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
							e.preventDefault();
						}
					}
				}
			}
	});
	
	function uploadSummernoteImageFile(file, editor) {
		data = new FormData();
		data.append("file", file);
		$.ajax({
			data : data,
			type : "POST",
			url : "/main/uploadSummernoteImageFile",
			contentType : false,
			processData : false,
			success : function(data) {
				data = data;
				console.log(data.url)
            	//항상 업로드된 파일의 url이 있어야 한다.
				$(editor).summernote('insertImage', data.url);
			}
		});
	}
	
	$(".btnInputComment").click(function(){
		$.ajax({
			url: "/main/insert.comments",
			type: "post",
			data: {
				parent_code : "${seq}",
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
				location.href="/main/board.view?pageGroup=${pageGroup}&type=${type}&seq=${seq}&page=${page}&purp=view&commentPage=1";
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
				parent_code : "${seq}",
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
	//alert("댓글 입력!!");
	$(".inputComment").summernote("reset");
	data = JSON.parse(data);
	
	let responseComments = JSON.parse(data[1]);
	$(".commentsList").html("");
	for( let i = 0; i < responseComments.length; i++ ){
		if( "${type}" != "anonym" ){
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
		} else if( "${type}" == "anonym" ){
			let writer = "익명";
			if( "${loginID}" == responseComments[i].writer ){
				writer = "작성자";
			}
			$(".commentsList").append(
					'<div class="col-2 mb-3">'+
						'<div class="row">'+
							'<div class="col-12 commentsWriter">'+writer+'</div>'+
							'<div class=realCommentsWriter>'+responseComments[i].writer+'</div>'+
							'<div class="col-12">'+responseComments[i].reg_date+'</div>'+
						'</div></div>'+
					'<div class="col-9 mb-3">'+responseComments[i].contents+'</div>'+
					'<div class="col-1 mb-3 commentsBtnWrapper">'+
						'<input type="hidden" name="comSeq" class="comSeq" value="'+responseComments[i].seq+'">'+
					'</div>');
		}
	}
	let ajaxNavi = JSON.parse(data[0]);
	$(".commentsNavi").html("");
	$(".commentsNavi").append('<div class="col-1"></div>');
	for( let i = ajaxNavi.startNavi; i <= ajaxNavi.endNavi; i++ ){
		$(".commentsNavi").append('<div class="col-1 commentPage"><a href="/main/board.view?pageGroup=${pageGroup}&type=${type}&seq=${article.seq}&purp=view&commentPage='+i+'">'+i+'</a></div>');
	}
	$(".commentsNavi").append('<div class="col-1"></div>');
	
	if( responseComments != "" ){
		$(".commentNaviWrapper").addClass("border border-secondary");
	}
}
</script>