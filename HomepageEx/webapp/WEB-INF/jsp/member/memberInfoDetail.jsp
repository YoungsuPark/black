<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/header.jspf"%>
<title>JavaP 회원정보</title>
</head>
<body>
	<article class="container">
		<div class="page-header">
			<h1>회원정보확인</h1>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<form action="/member/openModifyMemberContentView.do" method="post" name="reg_frm">
				<input type="hidden" id="index" name="INDEX" value="${memberInfo.index}"> 
				<input type="hidden" id="id" name="ID" value="${memberInfo.id}">
				<div class="form-group">
					<label for="id">아이디</label>
					<span id="id" class="label label-default"> ${memberInfo.id}</span>
				</div>
				<div class="form-group">
					<label for="userName">이름</label>
					<span id="userName" class="label label-default"> ${memberInfo.userName} </span>
				</div>
				<div class="form-group">
					<label for="age">나이</label>
					<span id="age" class="label label-default"> ${memberInfo.age} </span>
				</div>
				<div class="form-group">
					<label for="eMail">이메일 주소</label>
					<span id="eMail" class="label label-default"> ${memberInfo.eMail} </span>
				</div>
				<div class="form-group text-center">
					<button class="btn btn-info" type="submit"> 수정하러가기<i class="fa fa-check spaceLeft"></i></button>
					<button class="btn btn-warning" type="button" onclick="javascript:window.location='/'">돌아가기<i class="fa fa-times spaceLeft"></i></button>
				</div>
			</form>
			<form action="/member/deleteMember.do" method="POST">
				<input type="hidden" id="index" name="INDEX" value="${memberInfo.index}">
				<input type="hidden" id="id" name="ID" value="${memberInfo.id}">
				<button class="btn btn-warning" type="submit">회원탈퇴하기<i class="fa fa-times spaceLeft"></i></button>
			</form>
			<hr>
			<%@ include file="/WEB-INF/include/body_footer.jspf"%>
		</div>
	</article>
	<%@ include file="/WEB-INF/include/body_bottom.jspf"%>
</body>
</html>