<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/style.css" type="text/css" rel="stylesheet" />
<style>
</style>
</head>
<body>
	<jsp:include page="../inc/header.jsp" />
	<jsp:include page="inc/visual.jsp" />
	<div id="body">
		<div class="content-container clearfix">
			<jsp:include page="inc/aside.jsp" />
			<main id="main">
			<form method="post">
				<fieldset>
					<legend>회원정보</legend>
					<table>
						<tbody>
							<tr>
								<th><label>아이디</label></th>
								<td><input name="id" value="" /> <span></span></td>
							</tr>
							<tr>
								<th><label>비밀번호</label></th>
								<td><input name="pwd" /></td>
							</tr>

							<tr>
								<td><input type="submit" name="btn" value="로그인" /></td>
							</tr>
						</tbody>
					</table>
				</fieldset>
			</form>
			</main>
		</div>
	</div>
	<jsp:include page="../inc/footer.jsp" />
	<!-- <div id="floating">
		플로팅박스
		<div></div>
	</div> -->
	<!-- <div id="floating2">
		플로팅박스2
	</div> -->
</body>
</html>
