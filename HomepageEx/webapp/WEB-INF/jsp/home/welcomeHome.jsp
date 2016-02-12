<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/include/header.jspf" %>
<title>JavaP</title>
</head>
<body>
	<%@ include file="/WEB-INF/include/body_nav.jspf" %>
	<div class="jumbotron">
		<div class="container">
			<h2><c:out value="${sessionScope.sessionId}" /> 님 안녕하세요. </h2>
			<p>스프링 프레임워크를 이용한 웹 페이지 연습중입니다.</p>
			<c:if test="${not empty errorMessage }">
				<p><c:out value="${errorMessage}"></c:out></p>
			</c:if>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<h2>안부 게시판</h2>
				<p>서로 친하게 지내요~!</p>
				<p><a class="btn btn-default" onclick="javascript:window.location='/memoboard/openMemoBoardList.do'" role="button"> 안부 게시판으로 이동 &raquo;</a></p>
			</div>
			<div class="col-md-4">
				<h2>Spring FrameWork</h2>
				<p>스프링이란!</p>
				<p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
			</div>
		</div>
		<hr>
	<%@ include file="/WEB-INF/include/body_footer.jspf" %>	
	</div>
	<%@ include file="/WEB-INF/include/body_bottom.jspf" %>
</body>
</html>