<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.user.login.title" /></title>
</head>
<body>
<center>
<h1> <spring:message code="message.user.login.title" /></h1>
   <a href="login.do?language=en"><spring:message code="message.user.login.language.en"/></a> &nbsp;&nbsp;
    <a href="login.do?language=ko"><spring:message code="message.user.login.language.ko"/></a>
<hr>
<form action="login.do" method="post" >
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td><spring:message code="message.user.login.id" /></td>
		<td><input type="text" name="id" value="${user.id}"></td>
	</tr>
	<tr>
		<td><spring:message code="message.user.login.password" /></td>
		<td><input type="password" name="password" value="${user.password}" ></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input type="submit" value="<spring:message code="message.user.login.loginBtn" />">
			<a href="join.jsp" ><input type="button" value="회원가입"></a>
			<a href="update.jsp"><input type="button" value="정보수정"></a>
			<a href="delete.jsp"><input type="button" value="회원탈퇴"></a>
		</td>
	</tr>
</table>
</form>
</center>
</body>
</html>