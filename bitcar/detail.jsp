<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/footer.css">
<link rel="stylesheet" href="./css/sell_style.css">
<script type="text/javascript" src="sell.js"></script>
<head>
<meta charset="UTF-8">
<title>datail_${datailcar.type}.jsp</title>
</head>

<body>
<%@ include file="common/header.jsp" %>

<div class="container">
 <img src="${datailcar.img}" alt="${datailcar.type}" class="image">
  <div class="overlay">${datailcar.type}</div>
</div>

	<div class="column">
		<fieldset id="sellinput"> 
			<legend> 등 록 정 보 </legend><br>
			<li class="content"><span> 브 랜 드</span> : ${datailcar.brand}</li><br>
			<li for="type" class="content"><span>차 종</span> ${datailcar.type} </li><br>
			<li for="year" class="content"><span>연 식</span> ${datailcar.year} 년</li><br>
			<li for="history" class="content"><span>사 고 이 력</span> : 
				<c:if test="${datailcar.history=='0'}"> 없음 </c:if>
				<c:if test="${datailcar.history=='1'}"> 있음 </c:if>
			</li><br>
			<li for="km" class="content"><span>주 행 거 리</span> : ${datailcar.km} km</li><br>
			<li for="price" class="content"><span>가 격</span> : ${datailcar.price} 원</li><br>
		</fieldset>
	</div>
	
<div class="row">
	<div class="img-magnifier-container">
  		<img id="myimage" src="${datailcar.subimg1}" width="600" height="400" alt="${datailcar.type}">
	</div>
 	<div class="column">
  		<img id="image1" src="${datailcar.subimg2}" width="600" height="400" alt="${datailcar.type}">
	</div>
 	<div class="column">
 		<img id="image2" src="${datailcar.subimg3}" width="600" height="400" alt="${datailcar.type}">
	</div>
</div>

<%@ include file="common/board.jsp" %>
</body>
<%@ include file="common/footer.jsp" %>

<script type="text/javascript">
magnify("myimage", 3);
</script>

</html>