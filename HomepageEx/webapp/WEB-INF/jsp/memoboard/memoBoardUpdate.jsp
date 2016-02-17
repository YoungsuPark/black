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
		<form id="frm">
			<table class="board_view">
				<colgroup>
					<col width="15%"/>
					<col width="35%"/>
					<col width="15%"/>
					<col width="35%"/>
				</colgroup>
				<caption><caption><h2 style="text-align:center">수정하기</h2></caption></caption>
				<tbody>
					<tr>
						<th scope="row">글 번호</th>
						<td>
							${map.IDX }
							<input type="hidden" id="IDX" name="IDX" value="${map.IDX }">
						</td>
						<th scope="row">조회수</th>
						<td>${map.HIT_CNT }</td>
					</tr>
					<tr>
						<th scope="row">작성자</th>
						<td>${map.CREA_ID }</td>
						<th scope="row">작성시간</th>
						<td>${map.CREA_DTM }</td>
					</tr>
					<tr>
						<th scope="row">제목</th>
						<td colspan="3">
							<input type="text" id="TITLE" name="TITLE" class="wdp_90" value="${map.TITLE }"/>
						</td>
					</tr>
					<tr>
						<td colspan="4" class="view_text">
							<textarea rows="20" cols="100" title="내용" id="CONTENTS" name="CONTENTS">${map.CONTENTS }</textarea>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<br />
		<a href="#this" class="btn" id="list">목록으로</a>
		<a href="#this" class="btn" id="update">저장하기</a>
		<a href="#this" class="btn" id="delete">삭제하기</a>
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
			
			$("#update").on("click", function(e){ //저장하기 버튼
				e.preventDefault();
				fn_updateBoard();
			});
			
			$("#delete").on("click", function(e){ //삭제하기 버튼
				e.preventDefault();
				fn_deleteBoard();
			});
		});
		
		function fn_openBoardList(){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/memoboard/openMemoBoardList.do' />");
			comSubmit.submit();
		}
		
		function fn_updateBoard(){
			var comSubmit = new ComSubmit("frm");
			comSubmit.setUrl("<c:url value='/memoboard/updateMemoBoard.do' />");
			comSubmit.submit();
		}
		
		function fn_deleteBoard(){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/memoboard/deleteMemoBoard.do' />");
			comSubmit.addParam("IDX", $("#IDX").val());
			comSubmit.submit();
		}
	</script>
</body>
</html>