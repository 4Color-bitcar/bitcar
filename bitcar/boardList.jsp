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
<title>boardList.jsp</title>
</head>
<body>

<%@ include file="common/header.jsp" %>
	
	<div class="tableoutline">
		<form action="deleteboard.do" method="get">
		<table class="tablea">
		<tr> 
			<th>글번호</th> <th>차종</th> <th>ID</th> <th class="tabletxt">내용</th> <th>등록날짜</th>
	 		<th> <input type="submit" id="del" value="삭제" onclick="return delcheck()"> </th>
		</tr>

		<c:forEach var="data" items="${boardlist}">

		<tr> 
	 		<td> ${data.no}</td> 
	 		<td> ${data.b_type}</td> 
	 		<td> ${data.b_id}</td> 
	 		<td class="tabletxt"> ${data.txt}</td> 
	 		<td> ${data.time}</td> 
	 		
	 		<c:set var="id1" value="${data.b_id}"/>
	 		<c:set var="id2" value="${loginUser.id}"/>
	 		
	 		<c:choose>
	 		
			<c:when test="${loginUser.role=='admin'}">
	 		<td> <input type="checkbox" name="no" value="${data.no}"> </td> 
	 		</c:when>
	 		
	 		<c:when test="${id2==id1}">
	 		<td><input type="checkbox" name="no" value="${data.no}"> </td> 
	 		</c:when>
	 		
	 		<c:otherwise>
	 		<td>권한없음</td> 
	 		</c:otherwise>
	 		
	 		</c:choose>
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