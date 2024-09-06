<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>홈페이지 헤더</title>
    <style type="text/css">
        .header-logo {
            position: absolute;
            top: 10px; /* 로고 위치를 상단으로 올림 */
            left: 50px;
        }

        .header-logo img {
            height: 100px;
            cursor: pointer;
        }

        table {
            width: 750px;
            margin: 0 auto;
            padding-top: 30px; /* 메뉴와 컨텐츠 사이에 여백 추가 */
        }

        td {
            font-size: 12px;
            text-align: center;
            position: rerative;
        }

        a {
            text-decoration: none;
            color: #000000;
        }

        a:hover {
            color: #ff0000;
        }

        a:active {
            color: #ff0000;
        }

    </style>
    <script type="text/javascript">
        var muCnt = 5;

        function fncShow(pos) {
            for (var i = 0; i < muCnt; i++) {
                var obj = document.getElementById("menu" + i);
                var obj2 = document.getElementById("m" + i);
                if (i == pos) {
                    obj.style.display = '';
                    obj2.style.color = "#ff0000";
                } else {
                    obj.style.display = 'none';
                    obj2.style.color = "#000000";
                }
            }
        }
    </script>
</head>
<body>
    <a href="/hotel" class="header-logo">
        <img src="logo.jpg" alt="리조트 로고">
    </a>
    <div class="container">
        <center>
            <table cellpadding='0' cellspacing='0' border='0' width='750'>
                <tr height='30'>
                    <td width='200' onmouseenter='fncShow(0);' id='m0'><b>리조트소개</b></td>
                    <td width='200' onmouseenter='fncShow(1);' id='m1'><b>찾아오기</b></td>
                    <td width='200' onmouseenter='fncShow(2);' id='m2'><b>주변여행지</b></td>
                    <td width='200' onmouseenter='fncShow(3);' id='m3'><b>예약하기</b></td>
                    <td width='200' onmouseenter='fncShow(4);' id='m4'><b>리조트소식</b></td>
                </tr>
                <tr height='30'>
                    <td colspan='5'>
                        <div id='menu0' style='display: none;'>
                            <a href='/main' target='_self'>리조트</a> |
                            <a href='a_01' target='_self'>VIP룸</a> |
                            <a href='a_02' target='_self'>일반룸</a> |
                            <a href='a_03' target='_self'>얼리버드</a>
                        </div>
                        <div id='menu1' style='display: none;'>
                            <a href='b_01' target='_self'>찾아오는길</a> |
                            <a href='b_02' target='_self'>대중교통이용</a> |
                            <a href='b_03' target='_self'>자가용이용</a>
                        </div>
                        <div id='menu2' style='display: none;'>
                            <a href='c_01' target='_self'>한라산</a> |
                            <a href='c_02' target='_self'>해수욕장</a> |
                            <a href='c_03' target='_self'>온천</a>
                        </div>
                        <div id='menu3' style='display: none;'>
                            <a href='d_01' target='_self'>예약상황&예약하기</a> |
                            <a href='d_02' target='_self'>관리자페이지</a> |
                            <a href='d_03' target='_self'>관리자로그아웃</a>
                        </div>
                        <div id='menu4' style='display: none;'>
                            <a href='/list' target='_self'>리조트소식</a> |
                            <a href='/hoogi' target='_self'>이용후기</a>
                        </div>
                    </td>
                </tr>
            </table>
        </center>
    </div>
</body>
</html>
