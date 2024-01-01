<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

.image-container{
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
			<h4>후라이드</h4> 
		 <table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th width="100">번호</th>
				<th width="200">이름</th>
				<th width="150">상품</th>
				<th width="150">가격</th>
			</tr>

			<c:forEach items="${CartList}" var="cart">
				<tr>
					<td>${cart.seq}</td>
					<td>${cart.name}</td>
					<td>${cart.title}</td>
					<td>${cart.price}</td>
				</tr>
			</c:forEach>
		</table>
				<input type="submit" value="장바구니 담기">
		</div> 
		
	</div>
</body>
<script>
	function showFriedMenu() {
		// 'fried-menu'라는 ID를 가진 요소를 찾아 스타일을 변경하여 보이도록 함
		var friedMenu = document.getElementById('fried-menu');
		friedMenu.style.display = 'block';

		// 기존에 보이던 다른 메뉴들은 숨김 처리
		// 이 부분은 실제 프로젝트에 따라 동작을 변경할 수 있습니다.
		var otherMenus = document.querySelectorAll('.menu');
		otherMenus.forEach(function(menu) {
			if (menu !== friedMenu) {
				menu.style.display = 'none';
			}
		});
	}

	// JavaScript로 구현된 함수
	function addToCart() {
	
		// 선택된 이미지를 찾기 위해 모든 체크박스를 가져옴
		var checkboxes = document.getElementsByName('selectedImages');

		// 선택된 이미지들을 담기 위한 배열
		var selectedImages = [];

		// 각 체크박스를 확인하고 선택된 이미지를 배열에 추가
		for (var i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].checked) {
				selectedImages.push(checkboxes[i].value);
			}
		}

		// 선택된 이미지에 대한 처리 (여기에서는 간단한 알림창)
		if (selectedImages.length > 0) {
			alert('선택된 이미지가 장바구니에 추가되었습니다:\n' + selectedImages.join(', '));
		} else {
			alert('이미지를 선택해주세요.');
		}
	}
</script>
</body>
</html>