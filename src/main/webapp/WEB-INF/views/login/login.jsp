<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1><a href="${cpath }/">Home</a></h1>
	
	<hr>
	
	<form method="POST">
		<p><input name="userid" placeholder="ID" required value="${cookie.userid.value}"></p>
		<p><input name="userpw" type="password" placeholder="PW" required></p>
		<p><input type="checkbox" name="saveId" value="yes">아이디 저장</p>
		
		<button>login</button>
	</form>
	
	<hr>
	
	<div>
		<a href="${cpath }/findId">ID 찾기</a>
		<a href="${cpath }/findPw">PW 찾기</a>
		<a href="${cpath }/signUp">회원가입</a>
	</div>
</body>
</html>