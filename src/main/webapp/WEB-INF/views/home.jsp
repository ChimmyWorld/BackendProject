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
<h1>홈</h1>

<ul>
		<c:if test="${empty user }">
			<li><a href="${cpath }/login">login</a></li>
			<li><a href="${cpath }/signUp">signUp</a></li>
		</c:if>
		<c:if test="${not empty user }">
			<li><a href="${cpath }/logout">logout</a></li>
			<li><a href="${cpath }/myPage/info">myPage</a></li>
		</c:if>
		<li>${user.nick }</li>
	</ul>

	<h3>자유 게시판</h3>
	<a href="${cpath }/free">더보기</a>
	<table>
		<tr>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="row" items="${freePreview }">
		<tr>
			<td><a href="${cpath }/articles/${row.idx }">
			${row.title }
			</a></td>
			<td>${row.writer }</td>
			<td>${row.write_date }</td>
			<td>${row.view_count }</td>
		</tr>
		</c:forEach>
	</table>
	
	<h3>팁/정보 게시판</h3>
	<a href="${cpath }/info">더보기</a>
	<table>
		<tr>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="row" items="${infoPreview }">
		<tr>
			<td><a href="${cpath }/articles/${row.idx }">
			${row.title }
			</a></td>
			<td>${row.writer }</td>
			<td>${row.write_date }</td>
			<td>${row.view_count }</td>
		</tr>
		</c:forEach>
	</table>
	
	<h3>스터디</h3>
	<a href="${cpath }/study">더보기</a>
	<table>
		<tr>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="row" items="${studyPreview }">
		<tr>
			<td><a href="${cpath }/articles/${row.idx }">
			${row.title }
			</a></td>
			<td>${row.writer }</td>
			<td>${row.write_date }</td>
			<td>${row.view_count }</td>
		</tr>
		</c:forEach>
	</table>
	
	<h3>QnA 게시판</h3>
	<a href="${cpath }/qna">더보기</a>
	<table>
		<tr>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="row" items="${qnaPreview }">
		<tr>
			<td><a href="${cpath }/qna/${row.idx }">
			${row.title }
			</a></td>
			<td>${row.writer }</td>
			<td>${row.write_date }</td>
			<td>${row.view_count }</td>
		</tr>
		</c:forEach>
	</table>
	

</body>
</html>