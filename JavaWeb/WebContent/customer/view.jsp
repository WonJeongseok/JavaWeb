<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	Object _s = session.getAttribute("st");		//기본이 30분 지나면 철거됨
 	Object _a = application.getAttribute("st");
 	
 	String c = "";
 	String s = "";
 	String a = "";
 	
 	Cookie cookies[] = request.getCookies();
 	for(Cookie cookie : cookies)// 사용자를 위한 임시 저장소로 사용된다. 장바구니 같이. 근데 단일 문자열로만 저장이 가능하다.
 	//키값만 넣거나, 인토딩 방식을 다르게 한다.
 	{
 		if(cookie.getName().equals("st")){
 			c = cookie.getValue();
 			break;
 		}
 	}
 	if(_s !=null)
 		s = _s.toString();
 	if(_a != null)
 		a = _a.toString();
 	
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<ul>
	<li>sassion : <%=s %></li>
	<li>cookie :                          <%=c %></li>
	<li>application :<%=a %>
	</ul>
</div>
	<div>
	<a href="write.jsp">값을 저장하러 이동</a>
	</div>
</body>
</html>