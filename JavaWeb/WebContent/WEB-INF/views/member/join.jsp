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
			<form action="join" method="post">
         <fieldset>
            <legend>회원정보</legend>
            <table>
               <tbody>
                  <tr>
                     <th><label>아이디</label></th>
                     <td>
                        <input name="id" value=""/>
                        <a href="check-id" target="_blank" >중복확인</a>                        
                        <span></span>
                     </td>
                  </tr>
                  <tr>
                     <th><label>비밀번호</label></th>
                     <td><input name="pwd" /></td>
                  </tr>
                  <tr>
                     <th><label>비밀번호 확인</label></th>
                     <td><input name="pwd" /></td>
                  </tr>
                  <tr>
                     <th><label>이름</label></th>
                     <td><input name="name"  value=""/></td>
                  </tr>
                  <tr>
                     <th><label>필명</label></th>
                     <td><input name="nicname" /></td>
                  </tr>
                  <tr>
                     <th><label>성별</label></th>
                     <td>
                        <select name="gender">
                           <option>선택</option>
                           <option value="남성">남성</option>
                           <option value="여성">여성</option>
                        </select>
                     </td>
                  </tr>
                  <tr>
                     <th><label>생년월일</label></th>
                     <td>
                        <input name="y" />년<input name="m" />월<input name="d" />일
                        <input type="radio" name = "is-lunar" value="no" />양력
                        <input type="radio" name = "is-lunar" value="yes" />음력
                     </td>
                  </tr>
                  <tr>
                     <th><label>핸드폰번호</label></th>
                     <td><input name="phone" /></td>
                  </tr>
                  <tr>
                     <th><label>이메일</label></th>
                     <td><input name="email" /></td>
                  </tr>
                  <tr>                     
                     <td><input type="submit" name="btn" value="확인" /></td>
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
