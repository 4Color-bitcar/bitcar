<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


	<header>
		<hgroup>
			<c:if test="${empty loginUser}">
		    <h3 id="login"><a href="login.jsp"> Login </a> </h3>
		    </c:if>
			
			<c:if test="${!empty loginUser}">
		    <h3 id="logout"> [ ${loginUser.id} 님 ] <a href="logout.do">Logout</a></h3>
		    </c:if>
		      
			<h1 id="title"><a href="index.jsp"> BIT-CAR </a></h1>
		</hgroup>
	</header>
	
	<nav>
		<ul class="menubar">
			<li><a href="company.jsp"> Company </a></li>
			<li><a href="howto.jsp"> How to </a></li>
			<li><a href="./hyundaiCar.do"> Hyundai </a></li>
			<li><a href="./kiaCar.do"> K I A </a></li>
			<li><a href="./listCar2.do"> Search </a></li>
			
			<c:if test="${loginUser.role=='user'}">
			<li><a href="mypage.jsp"> My-Page </a></li>
			</c:if>
			
			<c:if test="${!empty loginUser}">
			<li><a href="./listboard.do">Board</a></li>
			</c:if>
			
			<c:if test="${loginUser.role=='admin'}">
			<div class="dropdown">
			<li>
				<a href="./listCar.do" class="dropdown-menu"> Manage</a>
					<div class="dropdown-content">
						<a href="./listCar.do" >Car-List</a>
						<a href="insertCar.jsp" >Insert-Car</a>
						<a href="./listImg.do">Image-List</a>
						<a href="./listUser.do">User-List</a>
						
					</div>
			</li>
			</div>	
			</c:if>
			
		</ul>
	</nav>
	<br>