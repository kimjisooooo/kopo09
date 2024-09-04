<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/fragments/header.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시물 보기</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <header>
        <h1>게시물 보기</h1>
        <nav>
            <a href="${pageContext.request.contextPath}/sosick/list">목록으로 돌아가기</a>
        </nav>
    </header>
    <div class="container">
        <h1>${sosickEntity.title}</h1>
        <p>작성자: <span>${sosickEntity.author}</span></p>
        <p>작성일: <span>${sosickEntity.date}</span></p>
        <p>조회수: <span>${sosickEntity.viewCount}</span></p>
        <div>${sosickEntity.content}</div>

        <hr>

        <h2>댓글</h2>
        <ul>
            <c:forEach var="comment" items="${comments}">
                <li class="comment">
                    <p>${comment.author}</p>
                    <p>${comment.content}</p>
                    <form action="${pageContext.request.contextPath}/sosick/comment/delete/${comment.id}" method="post">
                        <input type="hidden" name="sosickId" value="${sosickEntity.id}">
                        <button type="submit">삭제</button>
                    </form>
                </li>
            </c:forEach>
        </ul>

        <hr>

        <h3>댓글 작성</h3>
        <form action="${pageContext.request.contextPath}/sosick/comment/${sosickEntity.id}" method="post">
            <label for="author">작성자:</label>
            <input type="text" id="author" name="author" required>
            <br>
            <label for="content">내용:</label>
            <textarea id="content" name="content" required></textarea>
            <br>
            <button type="submit">댓글 등록</button>
        </form>

        <br>
        <a href="${pageContext.request.contextPath}/sosick/edit/${sosickEntity.id}">수정</a>
        <form action="${pageContext.request.contextPath}/sosick/delete/${sosickEntity.id}" method="post" style="display:inline;">
            <button type="submit">삭제</button>
        </form>
        <br>
    </div>
</body>
</html>
