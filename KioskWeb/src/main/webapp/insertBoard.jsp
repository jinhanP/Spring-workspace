<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글등록</title>
<style>
* {
	margin: 0;
	padding: 0;
	list-style: none;
	box-sizing: border-box;
	font-family: Pretendard;
}

.flip {
	width: 220px;
	height: 280px;
	position: relative;
	perspective: 1100px;
	margin: 2rem;
}

.card {
	width: 100%;
	height: 100%;
	position: relative;
	transition: .4s;
	transform-style: preserve-3d;
}

.front, .back {
	position: absolute;
	width: 100%;
	height: 100%;
	backface-visibility: hidden;
	display: flex;
	justify-content: center;
	align-items: center;
}

.front {
	background: tomato;
}

.back {
	transform: rotateY(180deg);
}

.flip:hover .card {
	transform: rotateY(180deg);
}
form{
 border: 1px solid black;
 width: 400px;
}
</style>
</head>
<body>
	<div align="center">
		<h1>공지사항 등록</h1>
		<h3 align="right">
			<a href="logout.do">Log-out</a>
		</h3>
		<hr>
		<form action="insertBoard.do" method="post"
			enctype="multipart/form-data">


			<div border="1" cellpadding="0" cellspacing="0">

				<ul width="40">
					제목&nbsp;&nbsp;&nbsp;
					<td align="left"><input type="text" name="title"></td>
				</ul>

				<ul width="45">
					작성자
					<td align="left"><input type="text" name="writer"></td>
				</ul>

				<ul>
					내용
					<td align="left"><textarea name="content" rows="10" cols="40"></textarea></td>
					<br>
					<input type="submit" value="새글 등록">
			</div>
	</div>

	</div>
	</form>
	<div align="center">
		<a href="getBoardList.do">글 목록 가기</a>
	</div>
	</div>
</body>
</html>