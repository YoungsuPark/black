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
		<table class="board_view">
			<colgroup>
				<col width="20%"/>
				<col width="35%"/>
				<col width="20%"/>
				<col width="35%"/>
			</colgroup>
			<caption><caption><h2 style="text-align:center">상세보기</h2></caption></caption>
			<tbody>
				<tr>
					<th scope="row">글 번호</th>
					<td>${recordInfo.IDX }</td>
					<th scope="row">조회수</th>
					<td>${recordInfo.HIT_CNT }</td>
				</tr>
				<tr>
					<th scope="row">작성자</th>
					<td>${recordInfo.CREA_ID }</td>
					<th scope="row">작성시간</th>
					<td>${recordInfo.CREA_DTM }</td>
				</tr>
				<tr>
					<th scope="row">제목</th>
					<td colspan="3">${recordInfo.TITLE }</td>
				</tr>
				<tr>
					<td colspan="4">${recordInfo.CONTENTS }</td>
				</tr>
				<tr>
					<th scope="row">첨부파일</th>
					<td colspan="3">
					<c:choose>
						<c:when test="${fn:length(fileList) > 0 }">
						<c:forEach var="row" items="${fileList }">
							<input type="hidden" id="IDX" value="${row.IDX }">
							<a href="#this" name="file">${row.ORIGINAL_FILE_NAME }</a>
							(${row.FILE_SIZE }Kb)
						</c:forEach>
						</c:when>
						<c:otherwise>
							<p>첨부 파일이 없습니다.</p>
						</c:otherwise>
					</c:choose>
					</td>
				</tr>
			</tbody>
		</table>
		<br />
		<c:if test="${not empty deleteMessage}">
			<script type="text/javascript">
				alert("아이디와 비밀번호를 다시 한번 확인해주세요");
			</script>
		</c:if>
		<div>
		<a href="#this" class="btn" id="list">목록으로</a>
		<c:choose>
			<c:when test="${map.PARENT == -1}">
			</c:when>
			<c:otherwise>
				<a href="#this" class="btn" id="update">수정하기</a>
				<a href="#this" class="btn" id="delete">삭제하기</a>
				<a href="#this" class="btn" id="reply">답글쓰기</a>
			</c:otherwise>
		</c:choose>
		</div>
		<br /><hr>
		<%@ include file="/WEB-INF/include/include-body.jspf" %>
		<%@ include file="/WEB-INF/include/body_footer.jspf" %>
	</div>
	<%@ include file="/WEB-INF/include/body_bottom.jspf" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#list").on("click", function(e){ //목록으로 버튼
				e.preventDefault();
				fn_openBoardList();
			});
			
			$("#update").on("click", function(e){ //수정하기 버튼
				e.preventDefault();
				fn_openBoardUpdate();
			});
			
			$("#reply").on("click", function(e){ // 답변하기 버튼
				e.preventDefault();
				fn_openReplyWrite();
			});
			
			$("#delete").on("click", function(e){ //삭제하기 버튼
				e.preventDefault();
				fn_deleteBoard();
			});
			
			$("a[name='file']").on("click", function(e){ // 파일 첨부하기 버튼
				e.preventDefault();
				fn_downloadFile($(this));
			});
		});
		
		function fn_openBoardList(){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/memoboard/openMemoBoardList.do' />");
			comSubmit.submit();
		}
		
		function fn_openBoardUpdate(){
			var idx = "${recordInfo.IDX}";
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/memoboard/openMemoBoardUpdate.do' />");
			comSubmit.addParam("IDX", idx);
			comSubmit.submit();
		}
		function fn_openReplyWrite(){
			var idx = "${recordInfo.IDX}";
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/memoboard/openReplyWrite.do' />");
			comSubmit.addParam("IDX", idx);
			comSubmit.submit();
		}
		
		function fn_deleteBoard(){
			confirm("해당 게시물을 삭제하시겠습니까?")
			var idx = "${recordInfo.IDX}";
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/memoboard/deleteMemoBoard.do' />");
			comSubmit.addParam("IDX", idx);
			comSubmit.submit();
		}
		
		function fn_downloadFile(obj){
			var idx = obj.parent().find("#IDX").val();
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/file/downloadFile.do'/>");
			comSubmit.addParam("IDX", idx);
			comSubmit.submit();
		}
	</script>
</body>
</html>