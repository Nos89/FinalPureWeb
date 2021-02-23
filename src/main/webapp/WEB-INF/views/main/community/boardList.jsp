<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 게시물 목록 페이지 -->
<div class="row">
	<div class="col-12 boardWrapper">
		<div class="row">
			<c:if test="${type == 'notice'}">
			<div class="col-12">
				<div class="row mb-2">
					<div class="col-11">
						<div class="boardTitleWrapper">
							<div class="btn btn-light">학사</div>
							<div class="btn btn-light">일반</div>
							<div class="btn btn-light">장학</div>
							<div class="btn btn-light">입학</div>
						</div>
					</div>
					<div class="col-1"></div>
				</div>
			</div>
			</c:if>
			<div class="col-12 headerWrapper">
				<div class="row text-center">
					<div class="col-1 boardSeq">번호</div>
					<c:if test="${type=='notice' }">
						<div class="col-2 category">분류</div>
					</c:if>
					<div class="col-6 boardTitle">제목</div>
					<c:if test="${type != 'notice' }">
						<div class="col-2 boardWriter">작성자</div>
					</c:if>
					<div class="col-3 boardDate">작성날짜</div>
				</div>
			</div>
			<div class="col-12 bodyWrapper">
				<c:forEach var="i" items="${cont.list}">
				<div class="row">
					<div class="col-1 boardSeq text-center">${i.seq}</div>
					<c:if test="${type=='notice' }">
						<div class="col-2 category">${i.category}</div>
					</c:if>
					<div class="col-6 boardTitle">
						<a href="/main/board.view?
								pageGroup=${pageGroup}
								&type=${type}
								&seq=${i.seq}
								&page=${page}
								&purp=view
								${ search != null ? '&search=' : '' }${search!=null?search:''}
								${ category != null ? '&category=' : ''}${category != null ? category : ''}">
								${i.title}</a>
					</div>
					<c:if test="${type != 'notice' }">
						<div class="col-2 boardWriter text-center">
							${ type == 'notice'? '관리자': type == 'anonym'? '익명' : i.writer}
						</div>
					</c:if>
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
					<c:if test="${type != 'notice' }">
					<option value="writer">작성자</option>
					</c:if>
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
		
		<c:if test="${type == 'notice'}">
		
		$(".boardTitleWrapper").children("div").hover(function(){
			$(this).removeClass("btn-light");
			$(this).addClass("btn-primary");
		}, function(){
			if( !$(this).hasClass("active") ){
				$(this).removeClass("btn-primary");
				$(this).addClass("btn-light");
			}
		})
		
		let arrNotice = ['학사', '일반', '장학', '입학', '채용'];
		
		if( "${category}" != "" ){
			let cat = $(".boardTitleWrapper").children("div").eq(arrNotice.indexOf("${category}"));
			cat.removeClass("btn-light");
			cat.addClass("btn-primary");
			cat.addClass("active");
		}
		
		$(".boardTitleWrapper").children("div").click(function(){
			$(this).siblings(".active").removeClass("btn-primary");
			$(this).siblings(".active").addClass("btn-light");
			$(this).siblings(".active").removeClass("active");
			$(this).removeClass("btn-light");
			$(this).addClass("btn-primary");
			$(this).addClass("active");
			
			location.href="/main/board.list?pageGroup=community&type=notice&category="+$(this).html();
		})
		</c:if>
	})
</script>

