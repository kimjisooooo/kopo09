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

<!-- Bootstrap CSS -->
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
   rel="stylesheet"
   integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
   crossorigin="anonymous">
</head>
<body>
	<svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
    <symbol id="check-circle-fill" fill="currentColor"
			viewBox="0 0 16 16">
        <path
			d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z" />
    </symbol>
    <symbol id="info-fill" fill="currentColor" viewBox="0 0 16 16">
        <path
			d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z" />
    </symbol>
    <symbol id="exclamation-triangle-fill" fill="currentColor"
			viewBox="0 0 16 16">
        <path
			d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
    </symbol>
</svg>
	<!-- Display message if available -->
   <c:if test="${not empty Message}">
      <div class="alert alert-success d-flex align-items-center"
         role="alert">
         <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img"
            aria-label="Success:">
                <use xlink:href="#check-circle-fill" />
            </svg>
         <div>${Message}</div>
      </div>
   </c:if>
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

