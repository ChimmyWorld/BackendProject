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
		<p><input class="expw" name="userpw" type="password" placeholder="exPW" required></p>
		<h6></h6>
		<p><input class="pwd1" name="newpw" type="password" placeholder="newPW" required></p>
		<h6></h6>
		<p><input class="pwd2" name="newpwCheck" type="password" placeholder="pwCheck" required></p>
		<h6></h6>
		<input name="idx" type="hidden" value="${user.idx }">
		<input name="jsfind" type="hidden" value="${user.userpw }">
		<p></p>
		<button>패스워드 변경</button>
	</form>
	
	<script type="text/javascript" src="${cpath }/resources/js/pwCheck.js"></script>
	<script type="text/javascript" src="${cpath }/resources/js/comparePW.js"></script>
	
</body>
</html>