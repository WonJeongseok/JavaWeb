<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<h2 class="main title">공지사항</h2>

			<br />
			<div>
				<ul>
					<li>home</li>
					<li>고객센터</li>
					<li>공지사항</li>
				</ul>
			</div>
			<br />

			<div>
				공지사항 검색 폼
				<form action="" method="get">
					<label>검색어</label> <input type="text" name="title" /> <input
						type="submit" />
				</form>
			</div>
			<br />
			<div>
				<table class="table table-list">
					<tr>
						<th class="w60">번호</th>
						<th>제목</th>
						<th class="w100">작성일</th>
						<th class="w100">작성자</th>
						<th class="w60">조회수</th>
					</tr>
					<c:forEach var="n" items="${list}">
						<tr>
							<td>${n.id}</td>
							<td class="title text-left text-indent"><a
								href="./detail?no=${n.id}">${n.title}[${n.countCmt}]</a></td>
							<td>${n.regDate}</td>
							<td>${n.writerId}</td>
							<td>${n.hit}</td>
						</tr>
					</c:forEach>
				</table>

				<c:set var="page" value="${param.p}" />
				<c:set var="startNum" value="${page-(page-1)%5}" />
				<c:set var="lastNum"
					value="${fn:substringBefore((count%10 == 0 ? (count/10) : (count/10)+1), '.')}" />
				${page}
				${page == null}
				<div>
					<div>
						<c:if test="${startNum<=5 || startNum == null}">
							<a href="">이전</a>
						</c:if>
						<c:if test="${startNum>5}">
							<a href="?p=${startNum-5}">이전</a>
						</c:if>
					</div>
					<ul>
						<%-- <c:forEach varStatus="page" begin="1" end="5">
						<li><a href="?p=${page.current}">${page.current}</a></li>
					</c:forEach> --%>

						<c:forEach var="i" begin="0" end="4">
							<c:set var="strong" value="" />
							<c:if test="${(startNum+i) == page || (page == null && i == 0)}">
								<c:set var="strong" value="text-strong" />
							</c:if>

							<c:if test="${startNum + i <= lastNum}">
								<li><a class="${strong}" href="?p=${startNum+i}">${startNum+i}</a></li>
							</c:if>
							<c:if test="${startNum + i > lastNum}">
								<li>${startNum+i}</li>
							</c:if>
						</c:forEach>
					</ul>
					<div>
						<c:if test="${lastNum >= startNum+5}">
							<a href="?p=${startNum+5}">다음</a>
						</c:if>
						<c:if test="${lastNum < startNum+5}">
							<a href="">다음</a>
						</c:if>
					</div>
				</div>
				1/1 pages
			</div>
			<a class="btn btn-default" href="reg">글쓰기</a> <a href=""
				class="btn-img btn-cancel">취소</a>
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
