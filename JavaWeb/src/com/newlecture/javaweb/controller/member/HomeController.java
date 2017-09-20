package com.newlecture.javaweb.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newlecture.javaweb.dao.MemberRoleDao;
import com.newlecture.javaweb.dao.jdbc.JdbcMemberDao;
import com.newlecture.javaweb.dao.jdbc.JdbcMemberRoleDao;

@WebServlet("/member/home")
public class HomeController extends HttpServlet {

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//세션 에 저장된거 비워버림
		HttpSession session = request.getSession();
		
		Object _memberId = session.getAttribute("id");
		
		//1. 로그인 한적 없다면 로그인 하러 가기 reg처럼
		if(_memberId==null)
			response.sendRedirect("login?returnURL=home");//상대경로
		else {
			String memberId = _memberId.toString();
			MemberRoleDao memberRoleDao = new JdbcMemberRoleDao();
			
			String defaultRole = memberRoleDao.gerDefaultRoleId(memberId);
		
			if(defaultRole.equals("ROLE_ADMIN"))
			response.sendRedirect("../admin/index");
			else if(defaultRole.equals("ROLE_STUDENT"))
				response.sendRedirect("../student/index");
			else
				response.sendRedirect("../index");
		}
			/*{
			out.write("<script>alert('로그인이 필요한 요청입니다.');location.href='../../member/login';</script>");
			
		}*/
		
			
		/*response.sendRedirect("notice.jsp");*/
	}
	

}
