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
			<form id="frm" name="frm">
				<input type="hidden" name="IDX" value="${memberInfo.IDX }">
				<div class="form-group">
					<label for="name">이름</label>
					<h4><span id="name" class="label label-default"> ${memberInfo.NAME} </span></h4>
				</div>
				<div class="form-group">
					<label for="id">아이디</label>
					<h4><span id="id" class="label label-default"> ${memberInfo.ID} </span></h4>
				</div>
				<div class="form-group">
					<label for="creat_dtm">가입일</label> 
					<h4><span id="creat_dtm" class="label label-default"> ${memberInfo.CREATE_DTM} </span></h4>
				</div>
				<div class="form-group">
					<label for="email">이메일 주소</label>
					<h4><span id="email" class="label label-default"> ${memberInfo.EMAIL} @gmail.com </span></h4>
				</div>
			</form><br /><hr>
			<div class="left">
				<a href="#this" class="btn" id="infoUpdate">개인정보변경하기</a>
				<a href="#this" class="btn" id="pwUpdate">비밀번호변경하기</a>
				<a href="#this" class="btn" id="return">홈으로</a>
			</div><br /><br />
			<hr>
		</div>
	</article>
	<%@ include file="/WEB-INF/include/body_footer.jspf"%>
	<%@ include file="/WEB-INF/include/body_bottom.jspf"%>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#infoUpdate").on("click", function(e){ // 개인정보변경하기 버튼
				e.preventDefault();
				fn_openMemberInfoUpdate();
			});
			
			$("#pwUpdate").on("click", function(e){ // 비밀번호변경하기 버튼
				e.preventDefault();
				fn_openPasswordUpdate();
			});
			
			$("#return").on("click", function(e){ // 홈으로 버튼
				e.preventDefault();
				fn_returnMainHome();
			});
		});
		
		function fn_openPasswordUpdate(){
			var comSubmit = new ComSubmit("frm");
			comSubmit.setUrl("<c:url value='/member/openPasswordUpdate.do' />")
			comSubmit.submit();
		}		
		function fn_openMemberInfoUpdate(){
			var comSubmit = new ComSubmit("frm");
			comSubmit.setUrl("<c:url value='/member/openMemberInfoUpdate.do' />");
			comSubmit.submit();
		}
		
		function fn_returnMainHome(){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/home/mainHome.do' />");
			comSubmit.submit();
		}
	</script>
	<%@ include file="/WEB-INF/include/include-body.jspf" %>
</body>
</html>