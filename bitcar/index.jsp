<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="./css/index.css">
<head>
<meta charset="UTF-8">
<title>index.jsp</title>

<script>

$(function() {
	$('#hyundai').click(function() {
		location.href="./hyundaiCar.do";
	});
	
	$('#kia').click(function() {
		location.href="./kiaCar.do";
	});
});

</script>


</head>
<body>
<!-- 헤 더 로 그 인  -->
<div class="dropdown">
  <button class="dropbtn">Dropdown</button>
  <div class="tri"></div>
  <div class="dropdown-content">
    	<a href="company.jsp"> Company </a>
      	<a href="howto.jsp"> How-to </a>
      	<a href="./hyundaiCar.do"> Hyundai </a>
      	<a href="./kiaCar.do"> KIA </a>
      	<a href="./listCar2.do"> Search </a>
      	<c:if test="${loginUser.role=='user'}"><a href="mypage.jsp"> My-PAGE </a></c:if>
		<c:if test="${loginUser.role=='admin'}"><a href="./listCar.do"> Manage </a></c:if>
  </div>
</div>
<%@ include file="common/header2.jsp" %>

	<div id="hyundai">
		<p id="ph"> H Y U N D A I 
		<p class="p1"> Lifetime partner in automobiles and beyond</p>
	</div>

	<div id="kia">
		<p id="pk"> K I A </p>
		<p class="p1">Amplify Your Joy with Emotive Driving</p>
	</div>

</body>
</html>