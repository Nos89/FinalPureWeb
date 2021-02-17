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
	#summernote{width: 100%;}
	select{width:10%;}
	input.title{width: 89%; height: 30px;}
</style>

</head>
<body>
	<div class="container">
		<!-- 게시물 작성 페이지 -->
		<div class="row writerWrapper">
			<form action="/main/board.write?pageGroup=community&type=${type}" method="post" enctype="multipart/form-data">
				<div class="col-12">
					<select name="category" class="category">
						<option value="학사">학사</option>
						<option value="장학">장학</option>
						<option value="입학">입학</option>
						<option value="채용">채용</option>
						<option value="입찰">입찰</option>
						<option value="일반">일반</option>
					</select>
					<input type="text" placeholder="제목을 입력하세요" name="noti_title" class="title">
				</div>
				<div class="col-12">
					<textarea id="summernote" name="noti_contents"></textarea>
				</div>
				<div class="col-12">
					<div class="row mt-3">
						<div class="col-9">
							<div class="row">
								<div class="col-2">
									<button type="button" class="btnFile">파일 추가</button>
								</div>
								<div class="col-10"></div>
								<div class="col-12 inputFileWrapper">
							
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script>
	$(document).ready(function() {
		//여기 아래 부분
		$('#summernote').summernote({
			  height: 350,                			// 에디터 높이
			  minHeight: null,             			// 최소 높이
			  maxHeight: null,             			// 최대 높이
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

			$(".btnFile").click(function() {
				let inputFile = $("input[type=file]");
				if (inputFile.length <= 5) {
					let row = $("<div></div>");
					row.addClass("row");
					let div = $("<div></div>");
					div.addClass("col-12");
					div.append("<input type=file name=inputFile>");
					div.append("<button type=button class=delFile>X</button>");
					row.append(div);
					$(".inputFileWrapper").append(row);
				} else {
					alert("최대 5개의 파일만 업로드 가능합니다.");
				}
			})
			$(".inputFileWrapper").on("click", ".delFile", function() {
				$(this).parent().parent().remove();
			})

			$(".inputFileWrapper").on('change',"input[type=file]",function(e) {
				if (!$(this).val()) return;

				let f = this.files[0];
				let size = f.size || f.fileSize;
				let limit = 10000000;
					
				if (size > limit) {
					alert('파일용량은 10mb 를 넘을수 없습니다.');
					$(this).val('');
					return;
				}
				$(this).parent().find('input[type=text]').val($(this).val());
			})
		});
	
	function getTitle(){
		return $('.title').val();
	}
	
	function getContents(){
		return $('#summernote').summernote('code');
	}
	
	function getCategory(){
		return $(".category option:selected").text();
	}
	</script>
</body>
</html>