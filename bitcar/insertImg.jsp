<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/insertCar.css">
<link rel="stylesheet" href="./css/footer.css">


<head>
<meta charset="UTF-8">
<title>insertImg.jsp</title>
</head>
<body>

<%
String type = request.getParameter("img_type");
String[] name = type.split(",");
String name1 = name[0];
String name2 = name[1];
%>

<%@ include file="common/header.jsp" %>
	
	<div id="output">
	
	<%if(name2.equals("1")) {%>
	<form method="post" action="InsertImg1.do" enctype="multipart/form-data">

		<fieldset id="outline">
			<legend> 등 록 정 보 입 력 </legend><br>
			<label for="car_type" class="content">차 종</label>
			<input type="text" name="car_type" class="input" value="<%=name1%>"><br><br>
			<label for="img" class="content">사 진 <%=name2%></label>
			<input type="file" name="img" multiple="multiple"><br><br>
			
		</fieldset><br>
		
		<span>
			<input type="submit" name="submit" value="등 록 하 기 " id="submit"><br><br>
			<input type="reset" name="reset" value="초 기 화" id="reset"> 
		</span>
	</form>
	<% } %>
	
	<%if(name2.equals("2")) {%>
	<form method="post" action="InsertImg2.do" enctype="multipart/form-data">

		<fieldset id="outline">
			<legend> 등 록 정 보 입 력 </legend><br>
			<label for="car_type" class="content">차 종</label>
			<input type="text" name="car_type" class="input" value="<%=name1%>"><br><br>
			<label for="img" class="content">사 진 <%=name2%></label>
			<input type="file" name="img" multiple="multiple"><br><br>
			
		</fieldset><br>
		
		<span>
			<input type="submit" name="submit" value="등 록 하 기 " id="submit"><br><br>
			<input type="reset" name="reset" value="초 기 화" id="reset"> 
		</span>
	</form>
	<% } %>
	
	<%if(name2.equals("3")) {%>
	<form method="post" action="InsertImg3.do" enctype="multipart/form-data">

		<fieldset id="outline">
			<legend> 등 록 정 보 입 력 </legend><br>
			<label for="car_type" class="content">차 종</label>
			<input type="text" name="car_type" class="input" value="<%=name1%>"><br><br>
			<label for="img" class="content">사 진 <%=name2%></label>
			<input type="file" name="img" multiple="multiple"><br><br>
			
		</fieldset><br>
		
		<span>
			<input type="submit" name="submit" value="등 록 하 기 " id="submit"><br><br>
			<input type="reset" name="reset" value="초 기 화" id="reset"> 
		</span>
	</form>
	<% } %>
	
	</div>

</body>
<%@ include file="common/footer.jsp" %>
</html>