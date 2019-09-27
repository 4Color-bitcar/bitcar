<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/insertCar.css">
<link rel="stylesheet" href="./css/footer.css">


<head>
<meta charset="UTF-8">
<title>insertCar.jsp</title>
</head>
<body>

<%@ include file="common/header.jsp" %>
	
	<div id="output">
		
	<form method="post" action="insertCar.do" enctype="multipart/form-data">

		<fieldset id="outline">
			<legend> 등 록 정 보 입 력 </legend><br>
			<label class="content">브랜드</label>
			<select name="brand" id="brand" class="input">
			<option value="kia">KIA</option>
			<option value="hyundai">HYUNDAI</option>
			</select>
			<br><br>
			<label for="type" class="content">차 종</label>
			<input type="text" name="type" class="input"><br><br>
			<label for="year" class="content">연 식</label>
			<input type="text" name="year" class="input"><br><br>
			<label for="history" class="content">사고이력</label>
			<span id="radio">
			<input type="radio" class="rd" name="history" value="1">있음&ensp;
			<input type="radio" class="rd" name="history" value="0">없음
			</span><br><br>
			<label for="km" class="content">주행거리</label>
			<input type="text" name="km" class="input"><br><br>
			<label for="price" class="content">가 격</label>
			<input type="text" name="price" class="input"><br><br>
			<label for="img" class="content">메인사진</label>
			<input type="file" name="img" multiple="multiple"><br><br>
		</fieldset><br>
		
		<span>
			<input type="submit" name="submit" value="등 록 하 기 " id="submit"><br><br>
			<input type="reset" name="reset" value="초 기 화" id="reset"> 
		</span>
	</form>

	</div>

</body>
<%@ include file="common/footer.jsp" %>
</html>