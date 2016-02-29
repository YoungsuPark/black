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
		<form id="frm" name="frm" enctype="multipart/form-data">
			<table class="board_list">
				<colgroup>
					<col width="15%">
					<col width="*"/>
				</colgroup>
				<caption><h2 style="text-align:center">글쓰기</h2></caption>
				<tbody>
					<tr>
						<th scope="row" style="text-align:center">Title</th>
						<td><input type="text" id="TITLE" name="TITLE" class="wdp_90"></input></td>
					</tr>
					<tr>
						<td colspan="2" class="view_text">
							<textarea rows="20" cols="100" title="내용" id="CONTENTS" name="CONTENTS"></textarea>
						</td>
					</tr>
				</tbody>
			</table><br />
			<div class="panel panel-default">
				<div class="panel-heading">
					<strong>Upload Files</strong>
				</div>
				<div class="panel-body">
					<div class="form-inline">
						<div id="fileDiv" class="form-group">
							<p>
								<input id="file" type="file" name="file_0" multiple>
								<a href="#this" class="btn" id="delete" name="delete">삭제</a>
							</p>
						</div>
					</div>
<!-- 					<h4>Or drag and drop files below</h4>
					<div class="upload-drop-zone" id="drop-zone">
						Just drag and drop files here
					</div> -->
<!-- 					Progress Bar
	          		<div class="progress">
	          			<div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
	           				<span class="sr-only">60% Complete</span>
	            		</div>
	         		</div> -->
<!-- 	         		Upload Finished
					<div class="js-upload-finished">
	           		<h3>Processed files</h3>
	            		<div class="list-group">
	             			<a href="#" class="list-group-item list-group-item-success"><span class="badge alert-success pull-right">Success</span>image-01.jpg</a>
	              			<a href="#" class="list-group-item list-group-item-success"><span class="badge alert-success pull-right">Success</span>image-02.jpg</a>
	          			</div>
					</div> -->
				</div>
			</div>
		</form>	
		<div class="left">
			<a href="#this" class="btn" id="addFile">파일추가하기</a>
			<a href="#this" class="btn" id="write">작성하기</a>
			<a href="#this" class="btn" id="list">목록으로</a>
		</div>
		<br />
	</div>
	<%@ include file="/WEB-INF/include/include-body.jspf" %>
	<%@ include file="/WEB-INF/include/body_footer.jspf" %>
	<%@ include file="/WEB-INF/include/body_bottom.jspf" %>
	<script type="text/javascript">
		var gfv_count = 1;
		
		$(document).ready(function() {
			$("#list").on("click", function(e) { //목록으로 버튼
				e.preventDefault();
				fn_openBoardList();
			});

			$("#write").on("click", function(e) { //작성하기 버튼
				e.preventDefault();
				fn_insertBoard();
			});

			$("a[name='delete']").on("click", function(e) { //삭제 버튼
				e.preventDefault();
				fn_deleteFile($(this));
			});

			$("#addFile").on("click", function(e) { //파일 추가 버튼
				e.preventDefault();
				fn_addFile();
			});

			$("a[name='delete']").on("click", function(e) { //삭제 버튼
				e.preventDefault();
				fn_deleteFile($(this));
			});
		});
		function fn_openBoardList() {
			var comSubmit = new ComSubmit();
			comSubmit
					.setUrl("<c:url value='/memoboard/openMemoBoardList.do' />");
			comSubmit.submit();
		}
		function fn_insertBoard() {
			var comSubmit = new ComSubmit("frm");
			comSubmit.setUrl("<c:url value='/memoboard/insertMemoBoard.do' />");
			comSubmit.submit();
		}

		function fn_addFile() {
			var str = "<p><input type='file' name='file_" + (gfv_count++)
					+ "'><a href='#this' class='btn' name='delete'>삭제</a></p>";
			$("#fileDiv").append(str);
			$("a[name='delete']").on("click", function(e) { //삭제 버튼
				e.preventDefault();
				fn_deleteFile($(this));
			});
		}

		function fn_deleteFile(obj) {
			obj.parent().remove();
		}
		/* 		function($) {
		 'use strict';
		 var dropZone = document.getElementById('drop-zone');
		 var uploadForm = document.getElementById('js-upload-form');

		 var startUpload = function(files) {
		 console.log(files)
		 }

		 uploadForm.addEventListener('submit', function(e) {
		 var uploadFiles = document.getElementById('js-upload-files').files;
		 e.preventDefault()

		 startUpload(uploadFiles)
		 })

		 dropZone.ondrop = function(e) {
		 e.preventDefault();
		 this.className = 'upload-drop-zone';

		 startUpload(e.dataTransfer.files)
		 }

		 dropZone.ondragover = function() {
		 this.className = 'upload-drop-zone drop';
		 return false;
		 }

		 dropZone.ondragleave = function() {
		 this.className = 'upload-drop-zone';
		 return false;
		 }
		 } */
	</script>
</body>
</html>
