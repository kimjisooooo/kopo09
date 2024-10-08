<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/fragments/header.jsp" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시물 목록</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <header>
        <h1>게시물 목록</h1>
        <nav>
            <a href="${pageContext.request.contextPath}/sosick/new">새 글 작성</a>
        </nav>
    </header>
    <div class="container">
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>날짜</th>
                    <th>조회수</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="sosick" items="${items}">
                    <tr>
                        <td>${sosick.id}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/sosick/view/${sosick.id}">${sosick.title}</a>
                        </td>
                        <td>${sosick.author}</td>
                        <td>${sosick.date}</td>
                        <td>${sosick.viewCount}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="pagination">
            <c:if test="${prevPageGroup > 0}">
                <a href="${pageContext.request.contextPath}/sosick/list?page=${prevPageGroup}&searchType=${searchType}&keyword=${keyword}">이전</a>
            </c:if>
            <c:forEach var="i" begin="${startPage}" end="${endPage}">
                <a href="${pageContext.request.contextPath}/sosick/list?page=${i}&searchType=${searchType}&keyword=${keyword}">${i}</a>
            </c:forEach>
            <c:if test="${nextPageGroup <= totalPage}">
                <a href="${pageContext.request.contextPath}/sosick/list?page=${nextPageGroup}&searchType=${searchType}&keyword=${keyword}">다음</a>
            </c:if>
        </div>
    </div>
</body>
</html>
