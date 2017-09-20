<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>베품</title>
<link href="../../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../../css/style.css" type="text/css" rel="stylesheet" />
<style>
</style>
</head>
<body>
	<jsp:include page="../../inc/header.jsp" />
	<jsp:include page="../inc/visual.jsp" />
	<div id="body">
		<div class="content-container clearfix">
			<jsp:include page="../inc/aside.jsp" />


			<main id="main">
			<h2>공지사항</h2>

			<br />
			<div>
				<ul>
					<li>home</li>
					<li>고객센터</li>
					<li>공지사항</li>
				</ul>
			</div>
			<br />

			<form method="post">
				<table class="table">
					<tr>
						<th>제목</th>
						<td class="text-left text-indent" colspan="3"><input name="title" value="${n.title}" /></a></td>
					</tr>
					<tr>
						<th>작성일</th>
						<td colspan="3">${n.regDate}</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>${n.writerId}</td>
						<th>조회수</th>
						<td>${n.hit}</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="3"></td>
					</tr>
					<tr>
						<td colspan="4"><textarea name="content">${n.content}</textarea></td>
					</tr>
				</table>
				<div>
					<input type="hidden" name="id" value="${n.id}" />
					<input type="submit" class="btn btn-default" value="저장" /> <a
						href="detail?id=${notice.id}" class="btn btn-default">취소</a>
				</div>
				</form>
		</div>

		</main>
	</div>
	</div>
	<jsp:include page="../../inc/footer.jsp" />
	<!-- <div id="floating">
		플로팅박스
		<div></div>
	</div> -->
	<!-- <div id="floating2">
		플로팅박스2
	</div> -->
</body>
</html>
