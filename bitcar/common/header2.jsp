<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


	<header>
		<hgroup>
			<c:if test="${empty loginUser}">
		    <h3 id="login"><a href="login.jsp"> Login </a> </h3>
		    </c:if>
			<c:if test="${!empty loginUser}">
		    <h3 id="login">[ ${loginUser.id} 님 ] <a href="logout.do">Logout </a> </h3>
		    </c:if>
		</hgroup>
	</header>
