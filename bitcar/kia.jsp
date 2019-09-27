<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/test.css">
<link rel="stylesheet" href="./css/footer.css">


<head>
<meta charset="UTF-8">
<title>kia.jsp</title>
</head>
<body>

<%@ include file="common/header.jsp" %>
	
<div class="main">
	<div class="row">

  
 	<c:forEach var="data" items="${kiacarlist}">
  
  	<div class="column">
   		<div class="content">
    		<a href="detailCar.do?type=${data.type}"><img src="${data.img}" alt="${data.type}" style="width:100%"></a>
    		<h3>${data.type}</h3>
    	</div>
  	</div>
  
 	</c:forEach>
  
  
	</div>
</div>	

</body>
<%@ include file="common/footer.jsp" %>
</html>