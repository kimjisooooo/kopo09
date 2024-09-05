<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="/WEB-INF/views/fragments/header.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>예약 상태</title>
</head>
<body>
	<center>
		<table border="1">
			<tr>
				<th>날짜</th>
				<th>VIP룸</th>
				<th>일반룸</th>
				<th>얼리버드</th>
			</tr>
			<c:forEach var="entry" items="${reservationStatus}">
				<tr>
					<td><fmt:formatDate value="${entry.key}"
							pattern="yyyy-MM-dd (E)" /></td>
					<!-- 날짜 형식 지정 -->
					<c:forEach var="roomType" items="${entry.value}">
						<c:choose>
							<c:when test="${roomType.key == 1}">
								<td><c:choose>
										<c:when test="${roomType.value == '예약가능'}">
											<a
												href="${pageContext.request.contextPath}/reservationPage?date=<fmt:formatDate value="${entry.key}"
                        pattern="yyyy-MM-dd (E)" />&roomType=1">예약가능</a>
										</c:when>
										<c:otherwise>
											<c:out value="${roomType.value}" />
										</c:otherwise>
									</c:choose></td>
							</c:when>
							<c:when test="${roomType.key == 2}">
								<td><c:choose>
										<c:when test="${roomType.value == '예약가능'}">
											<a
												href="${pageContext.request.contextPath}/reservationPage?date=<fmt:formatDate value="${entry.key}"
                        pattern="yyyy-MM-dd (E)" />&roomType=2">예약가능</a>
										</c:when>
										<c:otherwise>
											<c:out value="${roomType.value}" />
										</c:otherwise>
									</c:choose></td>
							</c:when>
							<c:when test="${roomType.key == 3}">
								<td><c:choose>
										<c:when test="${roomType.value == '예약가능'}">
											<a
												href="${pageContext.request.contextPath}/reservationPage?date=<fmt:formatDate value="${entry.key}"
                        pattern="yyyy-MM-dd (E)" />&roomType=3">예약가능</a>
										</c:when>
										<c:otherwise>
											<c:out value="${roomType.value}" />
										</c:otherwise>
									</c:choose></td>
							</c:when>
						</c:choose>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>

