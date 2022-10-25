<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
	<form>
		<div class="mb-3">
			<label for="title">Title:</label> 
			<input type="text" class="form-control" id="title" placeholder="Enter title">
		</div>
		<div class="mb-3">
			<label for="content">Content:</label> 
			<textarea class="form-control" rows="5" id="content"></textarea>
		</div>
	</form>
	
	<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
	<button id="btn-update" class="btn btn-warning">포스트수정</button> 
</div>

<script>
$(document).ready(function () {
    $("#content").summernote({
        height: 300
    });
});
</script>

<script src="/js/update.js"></script>

<%@ include file="../layout/footer.jsp"%>