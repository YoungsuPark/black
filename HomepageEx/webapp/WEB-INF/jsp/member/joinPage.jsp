<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/header.jspf"%>
<title>JavaP 회원가입</title>
</head>
<body>
	<article class="container">
		<div class="page-header">
			<h1>회원가입</h1>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<form action="/member/insertMember.do" method="post" name="reg_frm">
				<div class="form-group">
					<label for="id">아이디</label>
					<input class="form-control" id="id" name="ID" type="text" placeholder="아이디">
				</div>
				<div class="form-group">
					<label for="password">비밀번호</label>
					<input class="form-control" id="password" name="PASSWORD" type="password" placeholder="비밀번호">
				</div>
				<div class="form-group">
					<label for="password_check">비밀번호 확인</label> 
					<input class="form-control" id="password_check" type="password" placeholder="비밀번호 확인">
					<p class="help-block">비밀번호 확인을 위해 다시한번 입력 해 주세요</p>
				</div>
				<div class="form-group">
					<label for="userName">이름</label>
					<input class="form-control" id="userName" name="USERNAME" type="text" placeholder="이름을 입력해 주세요">
				</div>
				<div class="form-group">
					<label for="age">나이</label>
					<input class="form-control" id="age" name="AGE" type="text" placeholder="나이를 입력해 주세요">
				</div>
				<div class="form-group">
					<label for="eMail">이메일 주소</label>
					<input class="form-control" id="eMail" name="EMAIL" type="text" placeholder="이메일 주소">
				</div>

				<div class="form-group text-center">
					<button class="btn btn-info" type="button" onclick="infoConfirm()">
						회원가입<i class="fa fa-check spaceLeft"></i>
					</button>
					<button class="btn btn-warning" type="reset" onclick="javascript:window.location='/'">
						돌아가기<i class="fa fa-times spaceLeft"></i>
					</button>
				</div>
			</form>
			<hr>
			<%@ include file="/WEB-INF/include/body_footer.jspf"%>
		</div>
	</article>
	<%@ include file="/WEB-INF/include/body_bottom.jspf"%>
</body>
</html>