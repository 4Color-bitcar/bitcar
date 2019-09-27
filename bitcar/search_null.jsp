<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#msg1{
	color: red;
	text-align: center;
	margin-top: 5%;
}
#back{
	margin-left: 50%;
	width: 100px;
	height: 30px;
	color: white;
	border: 2px solid green;
	border-radius: 2px;
	background-color: green;
	cursor: pointer;
}
</style>
<script type="text/javascript">

function goBack() {
    window.history.back();
}


</script>

<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/footer.css">
<meta charset="UTF-8">
<title> search_null.jsp </title>
</head>
<body>
<%@ include file="common/header.jsp" %>
<div id="output">
<section>

<h3 id="msg1">검색 결과가 없습니다.</h3><br>
<input type="button" id="back" value="되돌아가기" onclick="goBack()">

</section>
</div>

</body>
<%@ include file="common/footer.jsp" %>
</html>