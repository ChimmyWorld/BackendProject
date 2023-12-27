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
	<h1><a href="${cpath }/">Home</a></h1>
	
	<ul>
		<li><a href="${cpath }/myPage/info">내 정보</a></li>
		<li><a href="${cpath }/myPage/articles">내 활동</a></li>
		<li><a href="${cpath }/myPage/settings">* 계정관리</a></li>
	</ul>
	
	<h4>비밀번호</h4>
	
	<button onclick="location.href='${cpath}/myPage/pwChange'">비밀번호 변경</button>
	
	<h4>계정삭제</h4>
	
	<form action="#">
		<input type="checkbox" name="agreement" onclick="agreeCheck(this.form)">계정 삭제에 관한 정책을 읽고 이에 동의합니다.
		
		<button class="Button" type="button" onclick="location.href='${cpath}/myPage/withdraw'" disabled>회원 탈퇴</button>
	</form>
	
	<script>
		let button = document.getElementsByClassName('Button')[0];
	
		function agreeCheck(form) {
			if (button.disabled == true) {
				button.disabled = false;
			}
			else {
				button.disabled = true;
			}
		}
	</script>
	
</body>
</html>