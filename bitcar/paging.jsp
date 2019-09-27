<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<style type="text/css">

@media screen and (max-width:1000px){
    body{
      background-color: #a1adcf;
    }
 }
 
 @media screen and (max-width:600px){
    body{
      background-color: #f9bff4;
    }
 }
 
body{
  text-align: center;
}
 
</style>



</head>
<body>
<div id="paging">
<!-- 1~10까지 페이 -->

<c:url var="action" value="/listCar.do"/>
<c:if test="${param.prev}">
  <a href="${action}?page=${param.beginPage -1}">prev</a>
</c:if>
<c:forEach begin="${param.beginPage}" end="${param.endPage}" step="1" var="index">
    <c:choose>
        <c:when test="${param.currentPage==index}">
            ${index}
        </c:when>
        <c:otherwise>
            <a href="${action}?page=${index}">${index}</a>
        </c:otherwise>
    </c:choose>
</c:forEach>
<c:if test="${param.next}">
    <a href="${action}?page=${param.endPage+1}">next</a>
</c:if>
</div>


</body>
</html>