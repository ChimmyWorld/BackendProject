<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>회원 탈퇴 시 아래와 같이 처리됩니다.</h4>
	
	<div>
		<button onclick="history.back()">취소</button>
		
		<form method="POST">
			<input name="idx" type="hidden" value="${user.idx }">
			
			<button>예, 탈퇴하겠습니다.</button>
		</form>
	</div>

</body>
</html>