<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href ="../css/reset.css" type ="text/css" rel ="stylesheet">
<link href ="../css/style.css" type ="text/css" rel ="stylesheet">
</head>
<body>   
	<!-- header부분 -->
	<jsp:include page="../../inc/header.jsp"/>
	<!-- visual부분 -->
	<jsp:include page="../../customer/inc/visual.jsp"/>
	
	<div id="body" class="clearfix">
		<div class="content-container">
		
		<!-- aside부분 -->
		<jsp:include page="../../customer/inc/aside.jsp"/>
		
		

		<form  method="post">	<!-- 저장방식은 get방식과 post방식 2가지  action="notice-edit"라고 써야하지만 같은 경우는 쓰지 않아도 된다.
 -->		<table class="table">	<!--키가 반드시 있어야 한다.-->
				<tr>
					<th>제목</th>
					<td class="text-left" colspan="3"><input name="title" value="${notice.title}"></td>
				</tr>
				<tr> 
					<th>작성일</th>
					<td colspan="3">${notice.regDate}</td>
				</tr>
				<tr>
					<th >작성자</th>
					<td>${notice.writerId}</td>
					<th>조회수</th>
					<td>${notice.hit}</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="4">
					<textarea name="content">
		${notice.content}
		</textarea>
					</td>
				</tr> 
				
				
				</table>
				
				<div><!--get요청은 추가 옵션이 필요하다. 그럴떄는? 뒤에 넘길 값을 받을 것 get요청의 전달 값 = 쿼리스트링 id=${notice.id } 프로그램이 문서를 ㅁ나듦-->
					<input type="hidden" name="id" value="${notice.id}">
					<input type="submit" class="btn btn-default" value="저장">
					<a href="notice-detail?id=${notice.id }" class="btn btn-default">취소</a>
				</div>
		</form>
		

	</div>
	</div>
	<!-- footer부분 -->
	<jsp:include page="../../inc/footer.jsp"/>

</body>
</html>