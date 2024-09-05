<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/fragments/header.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>홈페이지 테스트</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
	position: relative;
	height: 100vh;
	background: none; /* 기본 배경 제거 */
}

.background-image {
	position: absolute;
	top: 100px; /* 메뉴 아래로 이미지를 배치하기 위해 위치 조정 */
	left: 0;
	width: 100%;
	height: 90vh; /* 화면의 60% 높이만큼 설정 */
	background-size: cover; /* 비율에 상관없이 영역을 가득 채움 */
	background-position: center;
	background-repeat: no-repeat;
	transition: background-image 1s ease-in-out;
	z-index: -1; /* 배경 이미지가 다른 요소들 뒤에 위치하도록 설정 */
}
</style>
<script type="text/javascript">
        var images = ['image1.jpg', 'image2.jpg', 'image3.jpg', 'image4.jpg']; // 교차할 이미지 파일들
        var currentIndex = 0;

        function changeBackgroundImage() {
            currentIndex = (currentIndex + 1) % images.length; // 다음 이미지로 전환
            document.querySelector('.background-image').style.backgroundImage = `url(${images[currentIndex]})`;
        }

        window.onload = function() {
            setInterval(changeBackgroundImage, 3000); // 3초마다 이미지 변경
        };
    </script>
</head>
<body>
	<div class="background-image"
		style="background-image: url('image1.jpg');"></div>
</body>
</html>
