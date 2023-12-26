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
}

.image-box {
	width: 380px;
	height: 220px;
	overflow: hidden;
}

.image-thumbnail {
	width: 100%;
	height: 100%;
	object-fit: cover;
}

main {
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
					<a href="join.jsp" style="text-decoration-line: none;">회원가입</a>
				</button>
			</div>
		</header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">메뉴</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="#" onclick="showFriedMenu()">후라이드</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-bs-toggle="dropdown" aria-expanded="false">
								Dropdown </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="#">Action</a></li>
								<li><a class="dropdown-item" href="#">Another action</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="#">Something else
										here</a></li>
							</ul></li>
						<li class="nav-item"><a class="nav-link disabled" href="#"
							tabindex="-1" aria-disabled="true">Disabled</a></li>
					</ul>
					<form class="d-flex">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</div>
		</nav>
		<main class="image-box">
			<a href="#"><input type="image" class="image-thumbnail"
				src="hulaideu.jpg"></a>
		</main>
	</div>
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
	</script>
</body>
</html>