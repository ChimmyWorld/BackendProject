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
	<h1>수정</h1>
	
	<form method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<th>제목</th>
				<td><input name="title" value="${row.title }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input name="contents" value="${row.contents }"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${row.writer }</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${row.view_count }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${row.write_date }</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td><input name="upload" type="file"  accept="image/*"></td>
			</tr>
		</table>
		
		<button>수정</button>
	</form>
</body>
</html>