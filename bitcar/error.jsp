<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/footer.css">


<head>
<meta charset="UTF-8">
<title>error.jsp</title>
</head>
<body>

<%@ include file="common/header.jsp" %>
	
	<h3> Error page </h3>
	<h4 style="color:red;"> 서버 점검 중 입니다.</h4>
	<hr>
	
	<div style="color:red;">${exception}</div>

</body>
<%@ include file="common/footer.jsp" %>
</html>