<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script type="text/javascript">

window.onload = function(){
	$('form').hide()
};

$(document).ready(function(){
	$("#btn1").click(function(){
	    $("form").show();
	  });  
	$("#btn2").click(function(){
	    $("form").hide();
	  });
});

</script>
<head>

<style type="text/css">

.board{
	margin: 0 auto;
	text-align: center;
	vertical-align: bottom;
}

.pageform{
	color: black;
	font-size: 15px;
  	text-decoration: none;
  	display: inline-block;
  	padding: 8px 16px;
}

a:hover {
 	background-color: #ddd;
  	color: black;
}

</style>

<meta charset="UTF-8">
<title>board.jsp</title>
</head>
<body>
<div class="board">
	<div id="wrap">
	
<!-- 댓 글 쓰 기 버 튼 부분 -->
	<br><br>
		<c:if test="${!empty loginUser}">
		<button id="btn1" style="background-color: orange; color: white; border: 2px solid orange;"> 댓 글 쓰 기 </button>
		<button id="btn2" style="background-color: olive; color: white; border: 2px solid olive;"> close </button>
		</c:if>
	<br><br>

		<form method="post" action="addboard.do">

			<input type="hidden" id="b_type" name="b_type" value="${datailcar.type}">
			<input type="hidden" id="b_id" name="b_id" value="${loginUser.id}">
			<textarea id="txt" id="txt" name="txt" style="resize:none" cols="80" rows="10" placeholder="write here" required="required"></textarea>
			<div class="btn">
			<br>
				<input type="submit" value="등록" style="background-color: orange; color: white; border: 2px solid orange;">
				<input type="reset" value="작성취소" style="background-color: olive; color: white; border: 2px solid olive;">
			</div>		
		</form>
		
	</div>	
	
</div>


</body>
</html>