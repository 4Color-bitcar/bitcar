<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/search.css">
<link rel="stylesheet" href="./css/test.css">
<link rel="stylesheet" href="./css/footer.css">
<script type="text/javascript">
$()

</script>
<head>
<meta charset="UTF-8">
<title>search.jsp</title>

<style type="text/css">

a.tag{
	text-decoration: none;
	text-shadow: none;
	margin-left: 5%;
}

a.tag:hover{
	text-decoration: none;
	text-shadow: none;
	color: blue;
}

div.tag{
	margin-left: 25%;
}

img{
	padding-bottom: 10px;
}

</style>

</head>
<body>

<%@ include file="common/header.jsp" %>
	
	<div id="output">
	<form action="searchCar.do" method="get">
	
		<input type="text" id="keyword" name="keyword" >
		<br><br>
		<input type="submit" id="submit" value="Search">
		
	</form>
	</div>
	
	<div class="tag">
		<c:forEach var="data" items="${carlist}">
		<a href="detailCar.do?type=${data.type}" class="tag">#${data.type}</a>
		</c:forEach>
	</div>
	
	
	
	<div class="main">
		<div class="row">
	
		<c:forEach var="data" items="${searchlist}">
  
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