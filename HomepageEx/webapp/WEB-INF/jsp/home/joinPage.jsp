<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
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
			<form id="frm" name="frm">
				<div class="form-group">
					<label for="ID">아이디</label>
					<input class="form-control" id="ID" name="ID" type="text" placeholder="아이디">
				</div>
				<div class="form-group">
					<label for="PASSWORD">비밀번호</label>
					<input class="form-control" id="PASSWORD" name="PASSWORD" type="password" placeholder="비밀번호">
				</div>
				<div class="form-group">
					<label for="password_check">비밀번호 확인</label> 
					<input class="form-control" id="password_check" type="PASSWORD" placeholder="비밀번호 확인">
					<p class="help-block">비밀번호 확인을 위해 다시한번 입력 해 주세요</p>
				</div>
				<div class="form-group">
					<label for="EMAIL">이메일 주소</label>
					<input class="form-control" id="EMAIL" name="EMAIL" type="text" placeholder="이메일 주소">
				</div>
			</form><br /><hr>
			<div class="text-center">
				<a href="#this" class="btn" id="join">가입하기</a>
				<a href="#this" class="btn" id="return">홈으로</a>
			</div><br /><br />
			<%@ include file="/WEB-INF/include/body_footer.jspf"%>
		</div>
	</article>
	<%@ include file="/WEB-INF/include/body_bottom.jspf"%>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#join").on("click", function(e){ // 회원가입 버튼
				e.preventDefault();
				fn_insertMember();
			});
			$("#return").on("click", function(e){ // 홈 버튼
				e.preventDefault();
				fn_openMainHome();
			});		
		});
		
		function fn_insertMember(){
			infoConfirm(); 
		};
		
		function fn_openMainHome(){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/home/mainHome.do' />")
			comSubmit.submit();
		};
	</script>
	<%@ include file="/WEB-INF/include/include-body.jspf" %>
</body>
</html>