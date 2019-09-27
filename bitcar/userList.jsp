<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/footer.css">
<link rel="stylesheet" href="./css/carList_table.css">

<head>
<meta charset="UTF-8">
<title>userList.jsp</title>
</head>
<body>

<%@ include file="common/header.jsp" %>
	
	<div class="tableoutline">
		<form action="DeleteUser.do" method="get">
		<table class="tablea">
		<tr> 
			<th>id</th> <th>pw</th> <th>name</th> <th>phone</th> <th>role</th>
			<th> <input type="submit" id="del" value="삭제" onclick="return delcheck()"> </th>

		</tr>

		<c:forEach var="data" items="${userlist}">

		<tr> 
	 		<td> ${data.id}</td> 
	 		<td> ${data.pw}</td> 
	 		<td> ${data.name}</td> 
	 		<td> ${data.phone}</td> 
	 		<td> ${data.role}</td> 
	 		<td> <input type="checkbox" name="id" value="${data.id}"> </td> 
		</tr>
		

		</c:forEach>
		</table>
		</form>
	</div>
	

</body>
<%@ include file="common/footer.jsp" %>

<script>

	function delcheck() {
		return confirm("삭제하시겠습니까?")
	}


</script>


</html>