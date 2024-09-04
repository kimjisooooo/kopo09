<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/fragments/header.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>삭제 확인</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>삭제 확인</h1>
        <p>정말로 이 게시물을 삭제하시겠습니까?</p>
        <form action="${pageContext.request.contextPath}/sosick/delete/${sosickId}" method="post">
            <button type="submit" class="button button-danger">삭제</button>
            <a href="${pageContext.request.contextPath}/sosick/list" class="button">취소</a>
        </form>
    </div>
</body>
</html>
