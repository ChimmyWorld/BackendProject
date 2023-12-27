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
	.profile {
		width: 20px;
		height: 20px;
	}
	.replyDate {
		font-size: 12px;
	}
</style>
</head>
<body>
	<h1>게시글</h1>
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
			<td>
				${row.writer }
				<c:if test="${row.profile_img == 'default.jpg'}">
				<img src="${cpath}/profileImg/default.jpg" class="profile">
				</c:if>
				<c:if test="${row.profile_img != 'default.jpg'}">
				<img src="${cpath}/profileImg/${row.u_idx}/${row.profile_img}" class="profile">
				</c:if>
			</td>
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
		<a href="${cpath }/articles/${row.idx }/edit"><button>수정</button></a>
		<a href="${cpath }/articles/${row.idx }/delete"><button>삭제</button></a>
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

	<h5>댓글 | 총 ${reply }개</h5>
	<hr>

	<table>
		<c:forEach var="re" items="${replys }">
			<tr>
				<td>
					${re.writer }
					<c:if test="${re.profile_img == 'default.jpg'}">
					<img src="${cpath}/profileImg/default.jpg" class="profile">
					</c:if>
					<c:if test="${re.profile_img != 'default.jpg'}">
					<img src="${cpath}/profileImg/${re.u_idx}/${re.profile_img}" class="profile">
					</c:if>
					<div class="replyDate">${re.write_date }</div>
				</td>
			</tr>
			<tr class="commentRow" id="commentRow_${re.idx}">
				<td>
					<pre class="commentContent">
${re.contents }
					</pre>
					<c:if test="${user.nick == re.writer }">
						<button class="editButton" onclick="editComment(${re.idx})">수정하기</button>
            <a href="${cpath }/reply/${re.idx }/delete"><button>삭제</button></a>
					</c:if>
				</td>
			</tr>
			<tr class="editForm" id="editForm_${re.idx}" style="display: none">
				<td>
					<form onsubmit="saveComment(${re.idx}); return false;">
						<textarea class="editTextArea">${re.contents}</textarea>
						<br>
			            <button type="submit">수정하기</button>
			            <button type="button" onclick="cancelEdit(${re.idx})">취소</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<script type="text/javascript" src="${cpath }/resources/js/recommend.js"></script>
	<script type="text/javascript" src="${cpath }/resources/js/replyEdit.js"></script>
</body>
</html>