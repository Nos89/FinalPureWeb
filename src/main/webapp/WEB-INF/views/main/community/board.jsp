<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/jsp/head.jsp" %>
<%@ include file="../header.jsp" %>
<div class="row body mt-3">
	<!-- Body 부분 입니다. 왼쪽 메뉴, 메인 컨텐츠 부분 넣어주세요. -->
	<%@ include file="left.jsp" %>
	<div class="col-10">
		<div class="row">
			<div class="col-12 subTitle mb-5">
				${ type == 'free'? '자유게시판' : 
				type == 'anonym'? '대나무숲' : 
				type == 'report'? '건의게시판' : 
				type == 'notice'? '공지사항' :
				type == 'promote'? '홍보게시판' :
				type == 'event'? '행사게시판' : 
				type == 'archive'? '학사자료실' : '미확인'}
			</div>
			<div class="col-12">
				<c:if test="${ list == true }">
					<%@ include file="boardList.jsp" %>
				</c:if>
				
				<c:if test="${write != null && write == true }">
					<%@ include file="boardWrite.jsp" %>
				</c:if>
				
				<c:if test="${view != null && view == true }">
				<!-- 게시글 보기 -->
					<%@ include file="boardView.jsp" %>
				</c:if>
				
				<c:if test="${modify != null && modify == true }">
					<%@ include file="boardModify.jsp" %>
				</c:if>
			</div>
		</div>
	</div>
</div>
<%@ include file="../footer.jsp" %>