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
					<col width="15%">
					<col width="*"/>
				</colgroup>
				<caption><h2 style="text-align:center">답글쓰기</h2></caption>
				<tbody>
					<tr>
						<th scope="row" style="text-align:center">Reply</th>
						<td><input type="text" id="TITLE" name="TITLE" class="wdp_90"></input></td>
					</tr>
					<tr>
						<td colspan="2" class="view_text">
							<textarea rows="20" cols="100" title="내용" id="CONTENTS" name="CONTENTS"></textarea>
						</td>
					</tr>
				</tbody>
			</table>
			
		</form>	
		<br />
		<div class="left">
			<a href="#this" class="btn" id="write">작성하기</a>
			<a href="#this" class="btn" id="list">목록으로</a>
		</div>
		<br />
	</div>
	<%@ include file="/WEB-INF/include/include-body.jspf" %>
	<%@ include file="/WEB-INF/include/body_footer.jspf" %>
	<%@ include file="/WEB-INF/include/body_bottom.jspf" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#list").on("click", function(e){ //목록으로 버튼
				e.preventDefault();
				fn_openBoardList();
			});
			
			$("#write").on("click", function(e){ //작성하기 버튼
				e.preventDefault();
				fn_insertBoard();
			});
		});
		function fn_openBoardList(){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/memoboard/openMemoBoardList.do' />");
			comSubmit.submit();
		}
		function fn_insertBoard(){
			var idx = "${recordInfo.IDX}";
			var family = "${recordInfo.FAMILY}";
			var depth = "${recordInfo.DEPTH}";
			var indent = "${recordInfo.INDENT}";
			var comSubmit = new ComSubmit("frm");
			comSubmit.setUrl("<c:url value='/memoboard/insertReply.do' />");
			comSubmit.addParam("IDX", idx);
			comSubmit.addParam("FAMILY", family);
			comSubmit.addParam("DEPTH", depth);
			comSubmit.addParam("INDENT", indent);
			comSubmit.submit();
		}
	</script>
</body>
</html>