<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>articles.jsp</title>
</head>
<body>
	<h1>
		<a href="${cpath }/">Home</a>
	</h1>
	
	<ul>
		<li><a href="${cpath }/myPage/info">내 정보</a></li>
		<li><a href="${cpath }/myPage/articles">* 내 활동</a></li>
		<li><a href="${cpath }/myPage/settings">계정관리</a></li>
	</ul>
	
	<ul>
	<li><a href="${cpath }/myPage/articles">내가 쓴 게시글</a></li>
	<li><a href="${cpath }/myPage/replies">내가 쓴 댓글</a></li>
	</ul>
	
	<h1>내가 쓴 댓글</h1>
	<table>
		<tr>
			<th>댓글</th>
			<th>작성일</th>
			<th>분류</th>
		</tr>
		<c:forEach var="row" items="${myReplyList }">
			<tr>
				<td><a href="${cpath }/articles/${row.board_idx }">
						${row.contents } </a></td>
				<td>${row.write_date }</td>
				<td>
					<c:choose>
						<c:when test="${row.type == 101}">
                       	 자유게시판
                    </c:when>
						<c:when test="${row.type == '201'}">
                                                 정보게시판
                    </c:when>
						<c:when test="${row.type == '301'}">
                                                 스터디게시판
                    </c:when>
						<c:when test="${row.type == '401'}">
                                                 질문게시판
                    </c:when>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<ul>
		<c:if test="${p.prev}">
			<li><a href="${cpath}/myPage/replies?page=${p.begin - 1}">이전</a></li>
		</c:if>

		<c:forEach var="i" begin="${p.begin}" end="${p.end}">
			<li><a href="${cpath}/myPage/replies?page=${i}">${i}</a></li>
		</c:forEach>

		<c:if test="${p.next}">
			<li><a href="${cpath}/myPage/replies?page=${p.end + 1}">다음</a></li>
		</c:if>
	</ul>

	<ul>
		<li><a href="${cpath }/myPage/replies?order=idx">최신순</a></li>
	</ul>

	<div>
		<form>
			<select name="keyword">
				<option value="contents">내용</option>
			</select>
	
			<input name="search">
		
			<button>검색</button>
		</form>
	</div>
