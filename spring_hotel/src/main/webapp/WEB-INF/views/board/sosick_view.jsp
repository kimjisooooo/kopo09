<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/views/fragments/header.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시물 보기</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<center>

		<table border="1">
			<tr>
				<td>제목</td>
				<td>${sosickEntity.title}</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td><fmt:formatDate value="${sosickEntity.date}"
						pattern="yyyy년 MM월 dd일" /></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea readonly>${sosickEntity.content}</textarea></td>
			</tr>
		</table>
		<table border="1">
		<thead>
			<tr>
               <th>사용자 id</th>
               <th>사용자 이름</th>
               <th>내용</th>
            </tr>
         </thead>
         <tbody>
            <!-- 댓글과 대댓글을 재귀적으로 출력 -->
            <c:forEach var="comment" items="${sosickCommentDto}">
               <tr>
                  <td>${comment.user_id}</td>
                  <td>${comment.name }</td>
                  <td>
                     <!-- 깊이에 따른 들여쓰기 --> <c:if
                        test="${comment.depth != null && comment.depth > 0}">
                        <c:forEach var="i" begin="0" end="${comment.depth - 1}">
                            &nbsp;&nbsp;
                        </c:forEach>
                        ↳
                    </c:if> ${comment.content}
                  </td>
                  <td>
                        <form
                           action="${pageContext.request.contextPath}/comment_to_board"
                           method="post">
                           <input type="hidden" name="articleid" value="${id}">
                           <input type="hidden" name="id" value="${userId}"> <input
                              type="hidden" name="parentCommentId" value="${comment.id}">
                           <input type="text" name="title" placeholder="대댓글 입력"> <input
                              type="submit" value="대댓글 추가">
                        </form>
                   </td>
               </tr>
               </c:forEach>
               </tbody>
		</table>

		<br> <a
			href="${pageContext.request.contextPath}/sosick/edit/${sosickEntity.id}">수정</a>
		<form
			action="${pageContext.request.contextPath}/sosick/delete/${sosickEntity.id}"
			method="post" style="display: inline;">
			<button type="submit">삭제</button>
		</form>
		<form
            action="${pageContext.request.contextPath}/comment_to_board"
            method="post">
            <input type="hidden" name="articleid" value="${id}">
            <input type="hidden" name="id" value=3>
            <table>
               <tr>
                  <td>${userNickName}</td>
                  <td><input type="text" name="title" placeholder="댓글을 입력하세요"></td>
                  <td><input type="submit" value="댓글 추가"></td>
               </tr>
            </table>
         </form>
		<br>
		<a href="${pageContext.request.contextPath}/list">목록으로 돌아가기</a>
	</center>
</body>
</html>
