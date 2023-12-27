<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>free.jsp</title>
<style type="text/css">
	.profile {
		width: 20px;
		height: 20px;
</style>
<link rel="stylesheet" href="${cpath }/resources/css/header.css">

</head>

<body>
	
	<h1>자유게시판</h1>
	<table>
		<tr>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>댓글수</th>
			<th>추천수</th>
		</tr>
		<c:forEach var="row" items="${freeList }">
			<tr>
				<td><a href="${cpath }/articles/${row.idx }"> ${row.title }
				</a></td>
				<td>
					${row.writer }
					<c:if test="${row.profile_img == 'default.jpg'}">
					<img src="${cpath}/profileImg/default.jpg" class="profile">
					</c:if>
					<c:if test="${row.profile_img != 'default.jpg'}">
					<img src="${cpath}/profileImg/${row.u_idx}/${row.profile_img}" class="profile">
					</c:if>
				</td>
				<td>${row.write_date }</td>
				<td>${row.view_count }</td>
				<td>${row.reply_count }</td>
				<td>${row.recommend_score }</td>
			</tr>
		</c:forEach>
	</table>

	<c:if test="${not empty user }">
		<a href="${cpath }/free/new">글쓰기</a>
	</c:if>

	<ul>
		<c:if test="${p.prev}">
			<li><a href="${cpath}/free?page=${p.begin - 1}">이전</a></li>
		</c:if>

		<c:forEach var="i" begin="${p.begin}" end="${p.end}">
			<li><a href="${cpath}/free?page=${i}">${i}</a></li>
		</c:forEach>

		<c:if test="${p.next}">
			<li><a href="${cpath}/free?page=${p.end + 1}">다음</a></li>
		</c:if>
	</ul>
	
	<ul>
		<li><a href="${cpath }/free?order=idx">최신순</a></li>
		<li><a href="${cpath }/free?order=view_count">조회순</a></li>
		<li><a href="${cpath }/free?order=reply_count">댓글순</a></li>
		<li><a href="${cpath }/free?order=recommend_score">추천순</a></li>
	</ul>

	<div>
		<form>
			<select name="keyword">
				<option value="title">제목</option>
				<option value="writer">작성자</option>
				<option value="contents">내용</option>
			</select>
	
			<input name="search">
		
			<button>검색</button>
		</form>
	</div>
</body>
</html>