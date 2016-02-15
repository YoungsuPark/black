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
			<h1>JavaP</h1>
			<h2>웹 페이지 학습을 위한 공간 입니다.</h2><br />
			<c:if test="${ not empty sessionScope.sessionId}">
				<p><c:out value="${sessionScope.sessionId}" /> 님 안녕하세요. </p>
			</c:if>
			<p>현재 1기 수강생들을 모집 중이오니 자세한 내용은 알림 게시판을 참고해 주시기 바랍니다.</p>   
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<h2>알림 게시판</h2>
				<p>업데이트 정보 확인</p>
				<p><a class="btn btn-default" onclick="javascript:window.location='/memoboard/openMemoBoardList.do'" role="button"> 새로운 소식 확인 &raquo;</a></p>
			</div>
			<div class="col-md-4">
				<h2>자바(JAVA)</h2>
				<p>자바 학습하기</p>
				<p><a class="btn btn-default" href="#" role="button">JAVA STUDY START &raquo;</a></p>
			</div>
			<div class="col-md-4">
				<h2>JSP&SERVLET</h2>
				<p>JSP&SERVLET 학습하기</p>
				<p><a class="btn btn-default" href="#" role="button">JSP&SERVLET STUDY START &raquo;</a></p>
			</div>
			<div class="col-md-4">
				<h2>스프링(Spring Framework)</h2>
				<p>스프링 프레임워크 학습하기</p>
				<p><a class="btn btn-default" href="#" role="button">SPRING STUDY START &raquo;</a></p>
			</div>
		</div>
		<hr>
	<%@ include file="/WEB-INF/include/body_footer.jspf" %>	
	</div>
	<%@ include file="/WEB-INF/include/body_bottom.jspf" %>
</body>
</html>