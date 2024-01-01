<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>상품 등록</h1>
		<h3 align="right">
			<a href="logout.do">Log-out</a>
		</h3>
		<hr>
		<form action="insertCart.do" method="post"
			enctype="multipart/form-data">


			<div border="1" cellpadding="0" cellspacing="0">
			
				
				<ul width="40">
					회사명&nbsp;&nbsp;&nbsp;
					<td align="left"><input type="text" name="name"></td>
				</ul>

				<ul width="45">
					상품
					<td align="left"><input type="text" name="title"></td>
				</ul>

				<ul>
					가격
					<td align="left"><input type="text" name="price"></td>
					<br>
					<input type="submit" value="새상품 등록">
			</div>
	</div>

	</div>
	</form>
	<div align="center">
		<a href="NewFile.jsp">상품 목록 가기</a>
	</div>
	</div>
</body>
</html>