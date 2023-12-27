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
<body onload="window_onload()">

	<h4>그동안 활동해주셔셔 감사합니다.</h4>
	
	<script>
		function window_onload() {
			setTimeout('go_url()', 5000);
		}
		
		function go_url() {
			location.href = '${cpath}/logout';
		}
	</script>

</body>
</html>