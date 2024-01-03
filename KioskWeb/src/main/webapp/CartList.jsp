<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>
	<div align="center">
	<h1>장바구니</h1>
	<table border="1" cellpadding="0" cellspacing="0" width="700">
		<tr>
		<td width="100">메뉴</td>
		<td width="100">가격</td>
		</tr>
		<c:forEach items="${CartList}" var="cart">
				<tr>
					<td><a type="text" name="title">${cart.title}</a></td>
					<td><a type="text" name="price">${cart.price}</a></td>
				</tr>
			</c:forEach>
	</table>
	</div>
</body>
</html>