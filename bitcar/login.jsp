<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> login </title>

<link rel="stylesheet" href="./css/login.css">

</head>


<body>
	<header>
		<hgroup>
			<h1 id="title"><a href="index.jsp"> BIT-CAR </a></h1>
		</hgroup>
	</header>
	
<div id="output">
<section>

<form action="Login.do" method="post" onsubmit="return check()">
	<table>
	<tr>
		<td> <input type="text" id="id" name="id" value="${id}" placeholder="ID"/>	</td>
	</tr>
	
	<tr>
		<td><br> <input type="password" id="pw" name="pw" value="" placeholder="PW"/>	</td>
	</tr>
	
	<tr>
		<td> 
		<br><input type="submit" id="submit" value="로 그 인" >
		<br><br><input type="reset" id="reset" value="취 소">
		<a href="register.jsp" id="join"> 회원 가입 </a>
		<span style="color: white; text-shadow: 2px 1px orange;">${msg}</span>
	</td>
	</tr>
	</table>
</form>


</section>
</div>

<script>
	function check() {
		let id = document.querySelector('#id');
		let pw = document.querySelector('#pw');
		
		if(id.value.trim().length <5 ){
			alert("ID 5글자 이상 입력하세요");
			id.focus();
			return false;
		}
		return true;
	}


</script>

</body>
</html>