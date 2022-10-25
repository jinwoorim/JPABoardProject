<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/header.jsp"%>

<br><br>
<div class="container border">
	<br>
	<div>
		<h3>${post.title }</h3>
	</div>
	<br>
	<div>
		<div>${post.content }</div>
	</div>

	<br>
	<div>
		포스트 번호 : <span id = "id"><i>${post.id }</i></span><br>
		작성자 : <span><i>${post.user.username }</i></span>
	</div>
	
	<hr>
	<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
		<c:if test="${post.user.username == principal.username}">
			<a href="/post/updatePost/${post.id }" class="btn btn-warning">수정하기</a>
			<button id ="btn-delete" class="btn btn-danger">삭제하기</button> 
		</c:if>
	<br><br>
	
<c:if test="${!empty reply }">
	<div class="container mt-3">
	  <table class="table">
	     <thead> 
		      <tr>
		        <th style="text-align:left;">내용</th>
		        <th style="text-align:right;">작성자</th>
		        <th style="text-align:center;">삭제</th>
		      </tr>
	      </thead> 
	     
	      <tbody>
			<c:forEach var="reply" items="${reply }">
			
		      <tr>
		        <td>${reply.content }</td>
		        
		        <td style="text-align:right;">${reply.user.username}</td>
		        
		        <c:if test="${reply.user.username == principal.username }">
			        <form action="/deleteReply/${reply.id }" method="post">
			       		<td style="text-align:center;"><button id ="btn-deletereply" class="btn btn-outline-dark" style="WIDTH: 44pt; HEIGHT: 28pt">삭제</button></td>
			        </form>
		        </c:if>	        
		        <c:if test="${reply.user.username != principal.username }">
		       		<td></td>
		        </c:if>
		       </tr>		    
			  </c:forEach>
	        </tbody>    
	    </table>
	  </div>
</c:if>
	
	<form action="/insertReply/${post.id }" method="post"> 
	    <div>
	    	<textarea class="form-control" rows="1" name="content"></textarea>
	    </div> 
	    <div>
	    	<button type="submit" class="btn btn-secondary" style="float:right;">덧글등록</button>
	    </div>
	    <br><br>    
	</form>
</div>

<script src="/js/delete.js"></script>

<%@ include file="../layout/footer.jsp"%>