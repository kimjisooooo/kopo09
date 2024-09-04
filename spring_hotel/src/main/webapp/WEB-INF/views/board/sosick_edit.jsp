<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/fragments/header.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시물 수정</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <header>
        <h1>게시물 수정</h1>
        <nav>
            <a href="${pageContext.request.contextPath}/sosick/list">목록으로 돌아가기</a>
        </nav>
    </header>
    <div class="container">
        <form action="${pageContext.request.contextPath}/sosick/edit/${sosickEntity.id}" method="post">
            <label for="title">제목:</label>
            <input type="text" id="title" name="title" value="${sosickEntity.title}" required>
            <br>
            <label for="author">작성자:</label>
            <input type="text" id="author" name="author" value="${sosickEntity.author}" required>
            <br>
            <label for="content">내용:</label>
            <textarea id="content" name="content" required>${sosickEntity.content}</textarea>
            <br>
            <button type="submit">수정하기</button>
        </form>
        <c:if test="${not empty errorMessage}">
            <p class="error-message">${errorMessage}</p>
        </c:if>
    </div>
</body>
</html>
