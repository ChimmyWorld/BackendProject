<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
p {
	margin: 16px 0 0 0;
}
h6 {
	margin: 0;
}
</style>
</head>
<body>
	<h1><a href="${cpath }/">Home</a></h1>
	<hr>
	
	<form method="POST">
		<p><input name="userid" placeholder="ID" required></p>
		<h6></h6>
		<p><input class="pwd1" name="userpw" type="password" placeholder="PW" required></p>
		<h6></h6>
		<p><input class="pwd2" name="pwcheck" type="password" placeholder="PW" required></p>
		<h6></h6>
		<p><input name="nick" placeholder="Nick" required></p>
		<h6></h6>
		<p><input name="email" type="email" placeholder="Email" required></p>
		<h6></h6>
		<p></p>
		<button>signUp</button>
	</form>
	
	<script type="text/javascript" src="${cpath }/resources/js/pwCheck.js"></script>
	<script type="text/javascript" src="${cpath }/resources/js/idCheck.js"></script>
	<script type="text/javascript" src="${cpath }/resources/js/nickCheck.js"></script>
	<script type="text/javascript" src="${cpath }/resources/js/emailCheck.js"></script>
	
</body>
</html>