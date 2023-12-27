<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.good {
		color: blue;
	}
	.bad {
		color: red;
	}
</style>
</head>
<body>
	<h1>QnA</h1>
	<table>
		<tr>
			<th class="rowInt" data-idx="${row.idx }">제목</th>
			<td>${row.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<c:if test="${not empty row.article_img}">
       		 	<td><img src="${cpath}/boardImg/${row.idx}/${row.article_img}"></td>
    		</c:if>
			<td>${row.contents }</td>
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
	</table>

	<c:set var="isCheck" value="0"></c:set>

	<div class="recommend">
		<button class="${recommend.isCheck == 1 ? 'good' : ''}">
			∧
		</button>
		<div class="recCount"></div>
		<button class="${recommend.isCheck == 2 ? 'bad' : ''}">
			∨
		</button>
	</div>

	<c:if test="${row.writer == user.nick }">
		<a href="${cpath }/qna/${row.idx }/edit"><button>수정</button></a>
		<a href="${cpath }/qna/${row.idx }/delete"><button>삭제</button></a>
	</c:if>

	<form method="POST">
		<c:if test="${row.type == 100 }">
			<input name="type" type="hidden" value="101">
		</c:if>
		<c:if test="${row.type == 200 }">
			<input name="type" type="hidden" value="201">
		</c:if>
		<c:if test="${row.type == 300 }">
			<input name="type" type="hidden" value="301">
		</c:if>
		<c:if test="${row.type == 400 }">
			<input name="type" type="hidden" value="401">
		</c:if>

		<input name="writer" type="hidden" value="${user.nick }">

		<p>
			<textarea name="contents" placeholder="바른말을 사용합시다" required></textarea>
		</p>

		<button>댓글 작성</button>
	</form>

	<h5>답변 | 총 ${reply }개</h5>
	<hr>

	<table>
		<c:forEach var="re" items="${replys }">
			<tr>
				<td><pre>			
${re.writer } | ${re.write_date } 	
	<c:if test="${re.writer == user.nick }">
		<a href="${cpath }/reply/${re.idx }/delete"><button>삭제</button></a>
	</c:if>
${re.contents }     
</pre></td>

			<tr>
		</c:forEach>
	</table>
	
	<script type="text/javascript" src="${cpath }/resources/js/recommend.js"></script>

</body>
</html>