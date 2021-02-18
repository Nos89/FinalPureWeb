<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<!-- include summernote css/js -->
<!-- <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script> -->
<link rel="stylesheet" href="/resources/summernote/summernote-lite.css?ver=1">
<script src="/resources/summernote/summernote-lite.js"></script>
<script src="/resources/summernote/lang/summernote-ko-KR.js"></script>

<style>
	#summernote
	{
		width:100%;
	}
</style>

</head>
<body>
	<div class="container">
		<!-- 게시물 작성 페이지 -->
		<div class="row writerWrapper">
			<form action="/main/board.write?pageGroup=community&type=${type}" method="post" enctype="multipart/form-data">
				<div class="col-12">
					<textarea id="summernote" name="contents"></textarea>
				</div>
			</form>
		</div>
	</div>
	<script>
	function setData(str)
	{
		var a = str
		$('#summernote').summernote("code", a);
	}
	$(document).ready(function() {
		//여기 아래 부분
		$('#summernote').summernote({
			  height: 390,// 에디터 높이
			  minHeight: 390,             			// 최소 높이
			  maxHeight: 390,             			// 최대 높이
			  focus: true,                			// 에디터 로딩후 포커스를 맞출지 여부
			  lang: "ko-KR",						// 한글 설정
			  placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
			  toolbar : [
						// 글꼴 설정
						[ 'fontname', [ 'fontname' ]],
						// 글자 크기 설정
						[ 'fontsize', [ 'fontsize' ]],
						// 굵기, 기울임꼴, 밑줄, 취소 선, 서식지우기
						['style', ['bold','italic','underline','strikethrough','clear' ]],
						// 글자색
						['color', [ 'forecolor', 'color' ]],
						// 표만들기
						[ 'table', [ 'table' ]],
						// 글머리 기호, 번호매기기, 문단정렬
						['para', [ 'ul', 'ol', 'paragraph' ]],
						// 줄간격
						[ 'height', [ 'height' ]],
						// 그림첨부, 링크만들기, 동영상첨부
						['insert', [ 'picture', 'link' ]],
						// 코드보기, 확대해서보기, 도움말
						['view', [ 'codeview', 'help' ]]
					],
				// 추가한 글꼴
				fontNames : [ 'Arial','Arial Black','Comic Sans MS', 'Courier New', '맑은 고딕', '궁서', '굴림체', '굴림', '돋음체', '바탕체' ],
				// 추가한 폰트사이즈
				fontSizes : [ '8', '9', '10', '11', '12', '14', '16', '18', '20', '22', '24', '28', '30', '36', '50', '72' ],
				callbacks : { // 이미지를 첨부하는 부분
					onImageUpload : function(files) {
									console.log(files[0]);
									uploadSummernoteImageFile(files[0], this);
					},
					onPaste : function(e) {
						var clipboardData = e.originalEvent.clipboardData;
						if (clipboardData&& clipboardData.items&& clipboardData.items.length) {
								var item = clipboardData.items[0];
								if (item.kind === 'file'&& item.type.indexOf('image/') !== -1) {
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

			$("input[type=submit]").click(function() {
				let contents = $("#summernote").val();
				if (contents == null|| contents.length <= 0) {
					alert("내용을 입력 해주세요.");
					return false;
				} else {
					alert("게시글 작성!!")
				}
			})

		});
	
	</script>
</body>
</html>