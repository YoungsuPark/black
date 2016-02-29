<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/header.jspf"%>

<title>javap</title>
</head>
<body>

<body>
	<%@ include file="/WEB-INF/include/body_nav.jspf" %>
	<div class="jumbotron">
		<div class="container">
			<h2>문제가 발생했습니다.</h2><br />
			<h2>서비스 이용 중 불편을 끼쳐드려서 대단히 죄송합니다.</h2><br />
			<p>내용 : ${ExceptionMessage }</p>
		</div>
	</div>
	<%@ include file="/WEB-INF/include/body_bottom.jspf" %>
</body>
</html>