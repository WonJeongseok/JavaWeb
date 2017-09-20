<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<c:set var = "p" value="${pageContext.request.contextPath}"/>	

	<header id="header">
	<div class="content-container">
		<h1 id="logo">
			<a href="${p}/index.html"><img src="${p}/images/logo.png" alt="뉴렉처사이트" /></a>
		</h1>
		<section>
		<h2 class="hidden">머릿말</h2>

		<nav id="main-menu" class="hr-list main-menu">
		<h1 class="hidden">메인 메뉴</h1>
		<ul>
			<li><a href="#">학습가이드</a></li>
			<li><a href="#">뉴렉과정</a></li>
			<li><a href="">강좌선택</a></li>
		</ul>
		</nav> <section id="search-form" class="search-form-container">
		<h3 class="hidden">강좌 검색 폼</h3>
		<form>
			<label>과정검색</label> <input type="text" /> <input
				type="submit" value="검색" class="btn btn-img  btn-search" />
		</form>
		</section> <nav id="member-menu" class="hr-list member-menu">
		<h1 class="hidden">회원 메뉴</h1>
		<ul>
			<li><a href="${p}/index">Home</a></li>
			<c:if test="${empty sessionScope.id }">
			<li><a href="${p}/member/login">로그인</a>
			</c:if>
			<c:if test="${not empty sessionScope.id }">
			<a href="${p}/member/logout">로그아웃</a></li>
			</c:if>
			<li><a href="${p}/member/agree">회원가입</a></li>
		</ul>
		</nav> <nav id="customer-menu" class="hr-list">
		<h1 class="hidden">고객메뉴</h1>
		<ul>
			<li><a href="${p}/member/home"><img src="${p}/images/txt-mypage.png"
					alt="마이페이지" /></a></li>
			<li><a href="${p}/customer/notice-list"><img src="${p}/images/txt-customer.png"
					alt="고객센터" /></a></li>
		</ul>
		</nav> </section>
	</div>
	</header>
