<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/howto.css">
<link rel="stylesheet" href="./css/footer.css">


<head>
<meta charset="UTF-8">
<title>howto.jsp</title>
</head>
<body>

<%@ include file="common/header.jsp" %>
	
<div class="timeline">

  <div class="container left">
    <div class="content">
      <h2>Step 1</h2>
      <p> 회 원 가 입 </p>
      <p> 저희 B I T - C A R 는 회원가입 후 이용이 가능합니다.</p>
    </div>
  </div>
  
  <div class="container right">
    <div class="content">
      <h2>Step 2</h2>
      <p> Main 창에서 Hyundai 또는 KIA 회사 선택 </p>
      <p> B I T - C A R 가 엄선한 국산차 입니다. </p>
    </div>
  </div>
  
  <div class="container left2">
    <div class="content">
      <h2>Step 3</h2>
      <p> 원하는 차종 선택! </p>
      <p> 제일 저렴한 B I T - C A R 에서 선택하세요.  </p>
    </div>
  </div>
  
  <div class="container right2">
    <div class="content">
      <h2>Step 4</h2>
      <p> B I T - C A R 의 신뢰로 구매하세요.</p>
      <p> 글 하단부에 댓글을 남겨주세요. </p>
    </div>
  </div>
  
</div>

</body>
<%@ include file="common/footer.jsp" %>
</html>