<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
<style>
* {
	margin: 0;
	padding: 0;
	list-style: none;
	box-sizing: border-box;
	font-family: Pretendard;
}

nav {
	border: 1px solid black;
	display: flex;
	justify-content: space-around;
}

header {
	border: 1px solid black;
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
</style>
</head>
<body>

	<header>
		<div align="center">
			<h1>
				<spring:message code="message.board.list.mainTitle" />
			</h1>

			<h3>
				<spring:message code="message.board.list.welcomeMsg" />
			</h3>
			<h3 align="right">
				<a href="insertBoard.jsp"><spring:message
						code="message.board.list.link.Registration" /></a>&nbsp;|&nbsp;<a
					href="logout.do">Log-out</a>
			</h3>
		</div>
	</header>

	<div align="center">
		<!-- 검색 시작 -->
		<form action="getBoardList.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="400">
				<tr>
					<td align="right"><select name="searchCondition">
							<option value="TITLE"><spring:message
									code="message.board.list.search.condition.title" />
							<option value="CONTENT"><spring:message
									code="message.board.list.search.condition.content" />
					</select> <input name="searchKeyword" type="text"> <input
						type="submit"
						value="<spring:message code="message.board.list.search.condition.btn"/>"></td>
				</tr>
			</table>
		</form>
	</div>
	<nav>
		<c:forEach items="${boardList}" var="board" begin="1" end="1">
			<div class="flip">
				<div class="card">
					<!-- 앞면 -->
					<div class="front">
						<h1>관리자</h1>
					</div>
					<!-- 뒷면 -->
					<div class="back">

						<div border="1" cellpadding="0" cellspacing="0">

							<ul style="width: 40">
								<spring:message code="message.board.list.table.head.title" />
								:
								<li align="left"><a type="text" name="title"
									href="getBoard.do?seq=${board.seq}"></a></li>


								<li width="45"><spring:message
										code="message.board.list.table.head.writer" /> :
								<li align="left"></li>

								<li><spring:message
										code="message.board.list.search.condition.content" /> :
								<li align="left"><progress name="content" rows="10"
										cols="40"></progress></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>

	</nav>
	<div align="center">
		<h1>
			<spring:message code="message.board.list.link.review" />
		</h1>
	</div>
	<nav>
		<!-- 검색 종료 -->
		<c:forEach items="${boardList}" var="board" begin="0" end="4">
			<div class="flip">
				<div class="card">
					<!-- 앞면 -->
					<div class="front">
						<h1>사용자</h1>
					</div>
					<!-- 뒷면 -->
					<div class="back">

						<div border="1" cellpadding="0" cellspacing="0">

							<ul width="40">
								<spring:message code="message.board.list.table.head.title" />
								:
								<td align="left"><a type="text" name="title">${board.title}</a></td>
								<ul width="45">
									<spring:message code="message.board.list.table.head.writer" />
									:
									<td align="left">${board.writer}</td>
								</ul>

								<ul>
									<spring:message
										code="message.board.list.search.condition.content" />
									:
									<td align="left"><textarea name="content" rows="10"
											cols="40">${board.content}</textarea></td>
								</ul>
						</div>
					</div>
				</div>
				<a href="getBoard.do?seq=${board.seq}">글수정</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="deleteBoard.do?seq=${board.seq}">글삭제</a>
			</div>
		</c:forEach>

	</nav>


</body>
</html>