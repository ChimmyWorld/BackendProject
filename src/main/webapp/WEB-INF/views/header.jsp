<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cpath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header.jsp</title>
</head>
<link rel="stylesheet" href="${cpath }/resources/css/header.css">
<body>

<header>
        <div class="logo">
            <img src="/Home/img/okky.png" height="80px" onclick="location.href='/home.html'" style="cursor: pointer;">
        </div>
        <nav class="menu">
            <ul>
                <li>&nbsp<a href="/Home/board/board1.html">자유게시판</a></li>&emsp;
                <li>&nbsp<a href="/Home/board/board2.html">Q&A</a></li>&emsp;
                <li>&nbsp<a href="/Home/board/board3.html">팁/정보게시판</a></li>&emsp;
                <li>&nbsp<a href="/Home/board/board4.html">스터디게시판</a></li>
            </ul>
        </nav>
        <div class="wn-btn">
            <button class="w-btn w-btn-blue" type="button" onclick="location.href='/Home/acclogin/login.html';" style="cursor: pointer;">
                로그인
            </button>
            <button class="n-btn n-btn-blue" type="button" onclick="location.href='/Home/acclogin/login.html';" style="cursor: pointer;">
                회원가입
            </button>
        </div>
    </header>

</body>
</html>