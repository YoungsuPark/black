<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/header.jspf" %>
</head>
<body>
<%@ include file="/WEB-INF/include/body_nav.jspf" %>
	<div class="container">
		<h2 style="text-align:center">알림 게시판</h2>
		<table class="board_list" >
			<colgroup>
				<col width="10%"/>
				<col width="*"/>
				<col width="15%"/>
				<col width="20%"/>
			</colgroup>
			<thead>
				<tr>
					<th scope="col" style="text-align:center">글번호</th>
					<th scope="col" style="text-align:center">제목</th>
					<th scope="col" style="text-align:center">조회수</th>
					<th scope="col" style="text-align:center">작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${fn:length(list) > 0}">
						<c:forEach items="${list}" var="row">
							<tr>
								<td>${row.IDX}</td>
								<td class="title">
									<a href="#this" name="title">${row.TITLE}</a>
									<input type="hidden" id="IDX" value="${row.IDX}">
								</td>
								<td>${row.HIT_CNT}</td>
								<td>${row.CREA_DTM}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="4">조회된 결과가 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<br/>
		<div class="text-right">
			<a href="#this" class="btn" id="write">글쓰기</a>
		</div>
		<hr>
		<div class="text-center">
			<ul class="pagination">
				<c:if test="${startPageNumPerGroup > pagesPerGroup }">
					<li><a href = "/memoboard/openMemoBoardList.do?page=${startPageNumPerGroup-5}">&laquo;</a></li>
				</c:if>
				<c:forEach begin="${startPageNumPerGroup}" end="${endPageNumPerGroup}" var="i">
					<c:choose>
						<c:when test="${currentPage eq i}">
					 		<li class="active" ><a>${i}</a></li>
						</c:when>
						<c:otherwise>
						 	<li><a href = "/memoboard/openMemoBoardList.do?page=${i}">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${endPageNumPerGroup - startPageNumPerGroup eq pagesPerGroup-1 }">
					<li><a href = "/memoboard/openMemoBoardList.do?page=${startPageNumPerGroup+5}">&raquo;</a></li>
				</c:if>
			</ul>
		</div>	
		<br/>	
		<%@ include file="/WEB-INF/include/include-body.jspf" %>
		<%@ include file="/WEB-INF/include/body_footer.jspf" %>
	</div>
	<%@ include file="/WEB-INF/include/body_bottom.jspf" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#write").on("click", function(e){ //글쓰기 버튼
				e.preventDefault();
				fn_openBoardWrite();
			});	
			
			$("a[name='title']").on("click", function(e){ //제목 
				e.preventDefault();
				fn_openBoardDetail($(this));
			});
		});		
		function fn_openBoardWrite(){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/memoboard/openMemoBoardWrite.do' />");
			comSubmit.submit();
		}	
		function fn_openBoardDetail(obj){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/memoboard/openMemoBoardDetail.do' />");
			comSubmit.addParam("IDX", obj.parent().find("#IDX").val());
			comSubmit.submit();
		}
	</script>	
</body>
</html>