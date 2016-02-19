<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@ include file="/WEB-INF/include/header.jspf" %>
</head>
<body>
<%@ include file="/WEB-INF/include/body_nav.jspf" %>
	<div class="container"><br/>
		<h2 style="text-align:center">알림 게시판</h2>
		<table id="example" class="display" cellspacing="0" width="100%">
	        <thead>
	            <tr>
	                <th>글번호</th>
	                <th>제목</th>
	                <th>조회수</th>
	                <th>작성일</th>
	            </tr>
	        </thead>
			<tbody>
				<c:choose>
					<c:when test="${fn:length(list) > 0}">
						<c:forEach items="${list}" var="row">
							<tr>
								<td>${row.IDX}</td>
								<td class="title">
									<c:forEach begin="1" end="${row.INDENT}">
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									</c:forEach>	
									<c:if test="${row.INDENT != 0}">
										ㄴ
									</c:if>
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
	    </table><br />
		<div class="text-right">
			<a href="#this" class="btn" id="write">글쓰기</a>
		</div>
		<%@ include file="/WEB-INF/include/body_footer.jspf" %>
	</div>
		<%@ include file="/WEB-INF/include/include-body.jspf" %>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/common.js" charset="utf-8"></script>
	<script src="/js/members.js" charset="utf-8"></script>
	<script type="text/javascript">
	
	    $(document).ready(function() {
	        $('#example').DataTable();
	    } );
	    
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