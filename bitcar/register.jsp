<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title> register.jsp </title>

<link rel="stylesheet" href="./css/register.css">

</head>


<body>

	<header>
		<hgroup>
			<h1 id="title"><a href="index.jsp"> BIT-CAR </a></h1>
		</hgroup>
	</header>
	
<div id="page-wrap">

<form method="post" action="SignUp.do" name="userid" onsubmit="return pwcheck()">

<fieldset id="outline">
	<legend> 회 원 정 보 입 력 </legend><br>
	<label class="content">아이디</label>
	<input type="text" name="id" id="id" class="input" pattern="([a-z]).{4,}">
	<input type="button" id="btn1" value="중 복 확 인" onclick="idcheck()"><br><br>
	<label for="pw" class="content">패스워드</label>
	<input type="password" name="pw" id="pw" class="input" placeholder="5글자이상 입력해주세요." pattern="(^[a-z0-9])+([a-z0-9]).{3,}"><br><br>
	<label for="pw2" class="content">패스워드 확인</label>
	<input type="password" name="pw2" id="pw2" class="input" pattern="(^[a-z0-9])+([a-z0-9]).{3,}"><br><br>
	<label for="name" class="content">이름</label>
	<input type="text" name="name" id="name" class="input"><br><br>
	<label for="phone" class="content">전화번호</label>
	<input type="text" name="phone" id="phone" class="input"><br>
</fieldset><br>
	<span>
	<input type="submit" name="submit" value="가 입 하 기 " id="submit"><br><br>
	<input type="reset" name="reset" value="초 기 화" id="reset"> 
	</span>
</form>
</div>

<script >

function idcheck() {
	$.ajax({
		url:'json/idcheck.jsp',
		dataType:'json',
		data : {
			
			id:$('#id').val()
		},
		success:function(data){
			if(id.value.trim().length <5){
				alert("ID를 5글자 이상 입력하세요")
				id.focus()
			}
			
			if(data.id == undefined){
				alert('사용가능한 id입니다.')
			}else{
				alert('사용 중인 id 입니다.')
				$('#id').val('');
			}
		},
		error:function(e){
			alert("error" + e);
		}
		});
}

function pwcheck() {
	if($('#pw').val()!=$('#pw2').val()){
		
		alert("비밀번호가 일치하지 않습니다.")
		
		$('#pw').val('');
		$('#pw2').val('');
		
		return false;
			
	}else{
		return true;
	}
}
 
 
</script>

</body>
</html>