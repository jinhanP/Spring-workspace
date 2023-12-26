<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="deleteUser.do" method="post">
<center>
	<h1>탈퇴하시겠습니까?</h1>
	<tr>
		<td>
		<td>아이디</td>&nbsp;&nbsp;
		<td>
			<input type="text" name="id" id="id" placeholder="아이디" size="30" 
			 onfocus="idCheck()"
			onblur="patternIdCheck()" >  
			<p id="idCheck"></p>
		</td>
	</tr>
	<br>
	<tr>
		<td>
		<td>비밀번호</td>
		<td>
			<input type="password"  name="password" id="password" placeholder="영문자 소문자대문자특수문자 8~16자리" size="30" maxlength="16"
			onfocus="pwCheck()"
			onblur="patternPwCheck()" >  
			<p id="pwCheck"></p>
		</td>
	</tr>
		<br>
	<tr>
		<td>
		<%-- <a href="deleteUser.do?id=${user.id}"> --%>
		<input type="submit" value="탈퇴">
		</td>
	</tr>
	<tr>
		<td>
		<a href="login.jsp"><input type="button" value="취소"></a>
		</td>
	</tr>
</center>
</form>
</body>
</html>