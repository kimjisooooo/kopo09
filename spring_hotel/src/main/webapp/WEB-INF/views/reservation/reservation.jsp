<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/views/fragments/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script>
	
</script>
</head>
<body>
	<center>
		${date} <br> <br> ${roomType}
		<form action="/try_reservation">
			<table border="1">
				<tr>
					<td>성명</td>
					<td><input type="text" name="user_name" placeholder="입력해주세요"></td>
				</tr>
				<tr>
					<td>체크인 날짜</td>
					<td><input type="text" name="check_in_date"
						placeholder="입력해주세요"
						value="<fmt:formatDate value="${date}" pattern="yyyy-MM-dd" />"></td>
				</tr>
				<tr>
					<td>예약의 타입</td>
					<td><select name="room_type">
						<c:if test="${roomType == 2}">
							<option value="2" selected>일반룸</option>
							<option value="3">얼리버드</option>
						</c:if>
						<c:if test="${roomType == 3}">
							<option value="2">일반룸</option>
							<option value="3" selected>얼리버드</option>
						</c:if>
					</select></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" placeholder="주소를 입력해주세요"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="phone" placeholder="ex)01011112222"></td>
				</tr>
				<tr>
					<td>입금자명</td>
					<td><input type="text" name="who" placeholder="입금자명은 꼭 적어주세요"></td>
				</tr>
				<tr>
					<td>남기실말</td>
					<td><input type="text" name="content" placeholder="비워둬도 괜찬습니다."></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="입력"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>