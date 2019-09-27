<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/footer.css">
<head>
<meta charset="UTF-8">
<title>comingsoon.jsp</title>

<style type="text/css">

#comingsoon{
  position: relative;
  max-width: 1200px;
  margin: 0 auto;
  height: 15cm;
  background-image: url('img/service.jpg');
  background-size: 100%;
}

</style>

</head>
<body>

<%@ include file="common/header.jsp" %>
	
	<div id="comingsoon" OnClick="location.href ='./search.jsp'" style="cursor:pointer;"></div>

</body>
<%@ include file="common/footer.jsp" %>
</html>