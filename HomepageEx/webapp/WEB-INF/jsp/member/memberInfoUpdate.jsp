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
			<h1>개인정보 변경하기</h1>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<form id="frm" name="frm">
				<input type="hidden" name="IDX" value="${memberInfo.IDX }" >
				<div class="form-group">
					<label for="name">이름</label> 
					<input class="form-control" id="name" name="NAME" type="text" placeholder="이름을 입력해 주세요">
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
					<div class="input-group">
						<input id="email" name="EMAIL" type="text" class="form-control" placeholder="이메일 주소" aria-describedby="basic-addon2">
						<span class="input-group-addon" id="basic-addon2">@gmail.com</span>
					</div>
				</div>
				<div class="form-group">
					<label for="password">비밀번호</label>
					<input class="form-control" id="password" name="PASSWORD" type="password" placeholder="현재 비밀번호를 입력해주세요">
				</div>
			</form><br /><hr>
			<div class="left">
				<a href="#this" class="btn" id="infoUpdate">개인정보변경하기</a>
				<a href="#this" class="btn" id="return">홈으로</a>
			</div><br /><br />
			<hr>
		</div>
	</article>
	<%@ include file="/WEB-INF/include/body_footer.jspf"%>
	<%@ include file="/WEB-INF/include/body_bottom.jspf"%>
	<script type="text/javascript">
	$(document).ready(function(){
		
		$("#infoUpdate").on("click", function(e){
			e.preventDefault();
			fn_memberInfoUpdate();
		});
		
		$("#return").on("click", function(e){
			e.preventDefault();
			fn_returnMainHome();
		});
	});
	
	function fn_memberInfoUpdate(){
		var comSubmit = new ComSubmit("frm");
		comSubmit.setUrl("<c:url value='/member/memberInfoUpdate.do' />");
		comSubmit.submit();
	}
	
	function fn_returnMainHome(){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/home/mainHome.do' />");
		comSubmit.submit();
	}
	</script>
	<%@ include file="/WEB-INF/include/include-body.jspf"%>
</body>
</html>

