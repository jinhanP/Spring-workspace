<%@ page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#fFffff" text="#000000">
    <!-- 타이틀 시작 -->
    <table width="100%" border="1" cellspacing="0" cellpadding="0">
        <tr><td align="center" bgcolor="orange">
        <b>기본 에러 화면입니다.</b>
        </td>
        </tr>
    </table>
    <br>
    <!-- 에러 메시지 -->
    <table width="100%" border="1" cellspacing="0" cellpadding="0" align="center">
        <tr>
            <td align="center"><br>
            <br>
            <br>
            <br><br> Message: ${exception.message} <br><br>
                <br>
                <brxbr></td>
        </tr>
    </table>
    <a href="login.jsp"><input type="button" value="돌아가기"></a>
</body>
</html>
