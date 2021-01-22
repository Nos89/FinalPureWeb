<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/head.jsp" %>
<%@ include file="../header.jsp" %>
<div class="row body mt-3">
	<!-- Body 부분 입니다. 왼쪽 메뉴, 메인 컨텐츠 부분 넣어주세요. -->
	<%@ include file="left.jsp" %>
	<div class="col-10">
		<div class="row">
			<div class="col-12 subTitle mb-5">자유 게시판</div>
			<div class="col-12">
				<!-- 게시물 목록 페이지 -->
				<c:if test="${ list == true }">
				<%@ include file="boardList.jsp" %>
				</c:if>
				
				<!-- 게시물 작성 페이지 -->
				<c:if test="${write != null && write == true }">
				<div class="row writerWrapper">
					<form action="/main/board.write?pageGroup=community&type=freeBoard" method="post">
						<div class="col-12"><input type="text" placeholder="제목을 입력하세요" name="title" class="title"></div>
						<div class="col-12">
							<textarea id="summernote" name="contents"></textarea>
						</div>
						<div class="col-12">
							<div class="row mt-3 text-center">
								<div class="col-9"></div>
								<div class="col-1"><input type="submit" value="작성하기"></div>
								<div class="col-2"><button class="btnList" type="button">목록으로</button></div>
							</div>
						</div>
					</form>
				</div>
				<script>
				$(document).ready(function() {
					//여기 아래 부분
					$('#summernote').summernote({
						  height: 300,                 // 에디터 높이
						  minHeight: 600,             // 최소 높이
						  maxHeight: null,             // 최대 높이
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
							    // 줄간격
							    ['height', ['height']],
							    // 그림첨부, 링크만들기, 동영상첨부
							    ['insert',['picture','link']],
							    // 코드보기, 확대해서보기, 도움말
							    ['view', ['codeview', 'help']]
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
					
					$("input[type=submit]").click(function(){
						let title = $(".title").val();
						let contents = $("#summernote").val();
						if( title == null || title.length <= 0 ){
							alert("제목을 입력 해주세요.");
							return false;
						} else
						if( contents == null || contents.length <= 0){
							alert("내용을 입력 해주세요.");
							return false;
						} else {
							alert("게시글 작성!!")
						}
					})
					
					$(".btnList").click(function(){
						location.href="/main/board.list?pageGroup=${pageGroup}&type=${type}&page=${page}";
					})
				});
				</script>
				</c:if>
				
				<!-- 게시글 보기 -->
				<c:if test="${view != null && view == true }">
				<div class="row writerWrapper">
						<div class="col-8 mb-4 articleTitle">${article.title}</div>
						<div class="col-2 mb-4 articleWriter">${article.writer}</div>
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
								<div class="col-1"><button class="btnModify" type="button">수정</button></div>
								<div class="col-1"><button class="btnDelete" type="button">삭제</button></div>
								<script>
								$(document).ready(function(){
									$(".btnModify").click(function(){
										location.href="/main/board.view?pageGroup=${pageGroup}&type=${type}&seq=${article.seq}&purp=modify";
									})	
									$(".btnDelete").click(function(){
										let flag = confirm("게시글을 삭제하시겠습니까?");
										if(flag){
											alert("게시글이 삭제 됐습니다.");
											location.href="/main/board.delete?pageGroup=${pageGroup}&type=${type}&seq=${article.seq}";
										}
									})
								})
								</script>
								</c:if>
								<div class="col-2"><button class="btnList" type="button">목록으로</button></div>
							</div>
							<div class="row mt-3 commentWrapper">
								<div class="col-12">
									<div class="row">
										<div class="col-10">
											<textarea name="inputComment" class="inputComment p-2" placeholder="댓글을 입력해주세요."></textarea>
										</div>
										<div class="col-2">
											<button type="button" class="btnInputComment">댓글입력</button>
										</div>
									</div>
								</div>
							</div>
							<script>
							$(document).ready(function(){
								
							})
							</script>
						</div>
				</div>
				<script>
				$(document).ready(function(){
					$(".summernote").summernote({
						airMode: true
					})
					
					$(".btnList").click(function(){
						location.href="/main/board.list?pageGroup=${pageGroup}&type=${type}&page=${page}";
					})
				})
				</script>
				</c:if>
				
				<!-- 게시글 수정 -->
				<c:if test="${modify != null && modify == true }">
				<div class="row writerWrapper">
					<form action="/main/board.modify?pageGroup=community&type=freeBoard&page=${page}&seq=${article.seq}" method="post">
						<div class="col-12">
							<input type="text" placeholder="제목을 입력하세요" name="title" class="title" value="${article.title}">
						</div>
						<div class="col-12">
							<textarea id="summernote" name="contents">${article.contents}</textarea>
						</div>
						<div class="col-12">
							<div class="row mt-3 text-center">
								<div class="col-9"></div>
								<div class="col-1"><input type="submit" value="수정하기"></div>
								<div class="col-2"><button class="btnView" type="button">취소</button></div>
							</div>
						</div>
					</form>
				</div>
				<script>
				$(document).ready(function() {
					//여기 아래 부분
					$('#summernote').summernote({
						height: 300,                 // 에디터 높이
						minHeight: 600,             // 최소 높이
						maxHeight: null,             // 최대 높이
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
						    // 줄간격
						    ['height', ['height']],
						    // 그림첨부, 링크만들기, 동영상첨부
						    ['insert',['picture','link']],
						    // 코드보기, 확대해서보기, 도움말
						    ['view', ['codeview', 'help']]
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
					
					$("input[type=submit]").click(function(){
						let title = $(".title").val();
						let contents = $("#summernote").val();
						if( title == null || title.length <= 0 ){
							alert("제목을 입력 해주세요.");
							return false;
						} else
						if( contents == null || contents.length <= 0){
							alert("내용을 입력 해주세요.");
							return false;
						} else {
							alert("게시글 수정!!")
						}
					})
					
					$(".btnView").click(function(){
						location.href="/main/board.view?pageGroup=${pageGroup}&type=${type}&page=${page}&seq=${article.seq}&purp=view";
					})
				});
				</script>
				</c:if>
			</div>
		</div>
	</div>
</div>
<%@ include file="../footer.jsp" %>