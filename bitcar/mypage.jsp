<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/mypage.css">
<link rel="stylesheet" href="./css/footer.css">


<head>
<meta charset="UTF-8">
<title>mypage.jsp</title>
</head>
<body>

<%@ include file="common/header.jsp" %>
	
	<div id="output">
		
	<form method="post" action="UpdateUser.do" onsubmit="return check()">				
					
	<fieldset id="outline">				
		<legend> 회 원 정 보 수 정 </legend><br>			
		<label for="id" class="content">아이디</label>			
		<input type="text" name="id" id="id" class="input" value="${loginUser.id}" required="required"><br><br>			
		<label for="pw" class="content">현재 패스워드</label>			
		<input type="password" name="pw" class="input" value="${loginUser.pw}" required="required"><br><br>			
		<label for="pw2" class="content">새로운 패스워드</label>			
		<input type="password" id="pw2" name="pw2" class="input" pattern="(^[a-z0-9])+([a-z0-9]).{3,}"><br><br>			
	</fieldset><br>				
					
					
		<span>			
			<input type="submit" name="submit" value="수 정 하 기 " id="submit"><br><br><br>		
			<input type="reset" name="reset" value="초 기 화" id="reset"> &nbsp;		
			<input type="submit" name="withdrawal" value="회 원 탈 퇴 " id="withdrawal"><br><br><br>		
		</span>			
	</form>				
					
	</div>				
					
<%@ include file="common/footer.jsp" %>					
					
					
<script>					
					
function check() { //현재 아이디와 비밀번호가 입력값과 일치하면 비밀번호 수정 가능하게 하는 함수.					
	let updatedpw2 = $('#pw2').value;				
	console.log(updatepw2);
	console.log($('#pw2').value);
	if(updatedpw2 == null || updatedpw2 == ""){				
		alert("새로운 패스워드를 입력하세요~~ " + $('#pw2').value);			
		return false;			
	}else {				
		alert("입력완료" + $('#pw2').value);			
		return true;			
	}				
					
					
}					
					
					
</script>					


</body>
<%@ include file="common/footer.jsp" %>
</html>