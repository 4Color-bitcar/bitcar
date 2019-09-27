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
<title>carList.jsp</title>
</head>
<body>

<%@ include file="common/header.jsp" %>
	
	<div class="tableoutline">
		<form action="deleteCar.do" method="get">
		<table class="tablea">
		<tr> 
			<th>brand</th> <th>type</th> <th>year</th> <th>history</th> <th>km</th> <th>price</th>
			<th> <input type="submit" id="del" value="삭제" onclick="return delcheck()"> </th>

		</tr>

		<c:forEach var="data" items="${carlist}">

		<tr> 
	 		<td> ${data.brand}</td> 
	 		<td> ${data.type}</td> 
	 		<td> ${data.year}</td> 
	 		<td> ${data.history}</td> 
	 		<td> ${data.km}</td> 
	 		<td> ${data.price}</td> 
	 		<td> <input type="checkbox" name="type" value="${data.type},${data.img}"> </td> 
		</tr>
		
		<input type="hidden" name="img" value="${data.img}"/>

		</c:forEach>
		</table>
		</form>
	</div>
	
	<jsp:include page="/paging.jsp">
    <jsp:param value="${paging.currentPage}" name="page"/>
    <jsp:param value="${paging.beginPage}" name="beginPage"/>
    <jsp:param value="${paging.endPage}" name="endPage"/>
    <jsp:param value="${paging.prev}" name="prev"/>
    <jsp:param value="${paging.next}" name="next"/>
    </jsp:include>
    
	
	<div id="dinsert">
		<a href="insertCar.jsp" id="insert"> 등록 </a>
	</div>

</body>
<%@ include file="common/footer.jsp" %>

<script>

	function delcheck() {
		return confirm("삭제하시겠습니까?")
	}

</script>

</html>