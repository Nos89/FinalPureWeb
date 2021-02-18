<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 게시물 목록 페이지 -->
<div class="row">
	<div class="col-12 boardWrapper">
		<div class="row">
			<div class="col-12 headerWrapper">
				<div class="row text-center">
					<div class="col-1 boardSeq">번호</div>
					<div class="col-6 boardTitle">제목</div>
					<div class="col-2 boardWriter">작성자</div>
					<div class="col-3 boardDate">작성날짜</div>
				</div>
			</div>
			<div class="col-12 bodyWrapper">
				<c:forEach var="i" items="${cont.list}">
				<div class="row">
					<div class="col-1 boardSeq text-center">${i.seq}</div>
					<div class="col-6 boardTitle">
						<a href="/main/board.view?pageGroup=${pageGroup}&type=${type}&seq=${i.seq}&page=${page}&purp=view${ search != null ? '&search=' : '' }${search!=null?search:''}">${i.title}</a>
					</div>
					<div class="col-2 boardWriter text-center">
						${ type == 'notice'? '관리자': type == 'anonym'? '익명' : i.writer}
					</div>
					<div class="col-3 boardDate text-center">${i.writeDate}</div>
				</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<div class="col-12 mt-4 text-center">
		<c:forEach var="i" begin="${cont.navi.startNavi}" end="${cont.navi.endNavi}">
			<a href="/main/board.list?pageGroup=${pageGroup}&type=${type}&page=${i}">${i}</a>						
		</c:forEach>
	</div>
	<div class="col-2 mt-4"></div>
	<div class="col-8 mt-4 searchWrapper">
		<div class="row">
			<div class="col-2">
				<select class="searchType" name="searchType">
					<option value="title">제목</option>
					<option value="writer">작성자</option>
				</select>
			</div>
			<div class="col-8"><input type="text" class="searchText p-2" name="searchText" placeholder="검색어를 입력 해주세요"></div>
			<div class="col-2"><button type="button" class="btn btn-outline-primary btnSearch">검색</button></div>
		</div>
	</div>
	<c:if test="${type != 'notice' && type != 'promote' && type != 'event'}">
	<div class="col-2 mt-4"><button type="button" class="btn btn-outline-primary btnFreeWrite">글쓰기</button></div>
	</c:if>
</div>
<script>
	$(document).ready(function(){
		$(".btnFreeWrite").click(function(){
			if( "${loginID}" == "" ){
				alert("로그인을 해주세요.");
				location.href = "/info";
			} else {
				location.href = "/main/board?pageGroup=${pageGroup}&type=${type}";
			}
		})
		
		$(".btnSearch").click(function(){
			let searchType = $("select[name=searchType]").val();
			let search = $(".searchText").val();
			search = searchType+"-"+search;
			location.href ="/main/board.search?pageGroup=${pageGroup}&type=${type}&search="+search;
		})
	})
</script>

