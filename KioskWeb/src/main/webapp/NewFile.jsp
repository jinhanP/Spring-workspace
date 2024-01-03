<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KIOSK</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
.container {
	border: 1px solid black;
}

header {
	border: 1px solid black;
	height: 50px
}

.login {
	margin-top: -50px;
}

.login>button {
	border: none;
}

.login>button>a {
	color: black;
}

nav {
	border: 1px solid black;
	margin-top: 5px;
	margin-bottom: 20px;
}

.nav-item {
	margin-right: 75px; /* 원하는 간격 값으로 조절하세요 */
}

img {
	width: 255px;
}

.image-container {
	display: flex;
	justify-content: space-around;
}

main {
	border: 1px solid black;
	margin: 5px;
}

.menu {
	border: 1px solid black;
}
</style>
</head>
<body>
	<div class="container">
		<header>
			<h1>KIOSK</h1>
			<div class="login" align="right">
				<button>
					<a href="login.do" style="text-decoration-line: none;">로그인</a>
				</button>
				&nbsp;
				<button>
					<a href="CartList.jsp" id="cart"
						style="text-decoration-line: none;">장바구니</a>
				</button>
			</div>

		</header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">메뉴</a>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#" onclick="showFriedMenu()">인기메뉴</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#" onclick="showFriedMenu()">후라이드</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#" onclick="showFriedMenu()">양념</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#" onclick="showFriedMenu()">사이드</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								이벤트 </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="#">Action</a></li>
								<li><a class="dropdown-item" href="#">Another action</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="#">Something else
										here</a></li>
							</ul></li>
					</ul>
					<form class="d-flex">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</div>
		</nav>


		<div class="menu">
			<form action=""></form>
			<h4>후라이드</h4>
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<th width="150">메뉴</th>
					<td><a type="text" name="title">${cart.title}</a></td>
				</tr>
				<tr>
					<th width="150">가격</th>
					<td><a type="text" name="price">${cart.price}</a></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="장바구니 담기"> <a
				href="insertCart.jsp">새 상품 등록</a>
		</div>

	</div>
</body>
</html>