<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
		<form action="DeleteImg.do" method="get">
		<table class="tablea">
		<tr> 
			<th>type</th> <th> I m g 1 </th> <th> I m g 2 </th> <th> I m g 3 </th>
			<th> <input type="submit" id="del" value="삭제" onclick="return delcheck()"> </th>
		</tr>

		<c:forEach var="data" items="${imglist}">

		<tr> 
	 		<td> ${data.img_type}</td> 
	 		<td>
	 			<c:if test="${data.img_path1!=null}">
	 			<img src="${data.img_path1}" alt="${data.img_type}" style="width:80px">
	 			</c:if>
	 			<c:if test="${data.img_path1==null}">
	 			<a href="./insertImg.jsp?img_type=${data.img_type},1" id="insert"> <input type="button" name="type" value="이미지추가"> </a>
	 			</c:if>
	 		</td> 
	 		<td> 
	 			<c:if test="${data.img_path2!=null}">
	 			<img src="${data.img_path2}" alt="${data.img_type}" style="width:80px">
	 			</c:if>
	 			<c:if test="${data.img_path2==null}">
	 			<a href="./insertImg.jsp?img_type=${data.img_type},2" id="insert"> <input type="button" name="type" value="이미지추가"> </a>
	 			</c:if>
	 		</td> 
	 		<td> 
	 			<c:if test="${data.img_path3!=null}">
	 			<img src="${data.img_path3}" alt="${data.img_type}" style="width:80px">
	 			</c:if>
	 			<c:if test="${data.img_path3==null}">
	 			<a href="./insertImg.jsp?img_type=${data.img_type},3" id="insert"> <input type="button" name="type" value="이미지추가"> </a>
	 			</c:if>
	 		</td> 
	 		<td> <input type="checkbox" name="type" value="${data.img_type},${data.img_path1},${data.img_path2},${data.img_path3}"> </td> 
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