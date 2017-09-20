package com.newlecture.javaweb.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.javaweb.dao.MemberDao;
import com.newlecture.javaweb.dao.jdbc.JdbcMemberDao;
import com.newlecture.javaweb.entity.Member;

@WebServlet("/member/join")
public class JoinController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String[] pwds = request.getParameterValues("pwd");
		String isLunar = request.getParameter("is-lunar");
		String name = request.getParameter("name");
		String nicName = request.getParameter("nicname");
		String gender = request.getParameter("gender");
		String y = request.getParameter("y");
		String m = request.getParameter("m");
		String d = request.getParameter("d");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		
		String birthday = null;
		
		birthday =y + "-" + m + "-" + d;
				
		if(!pwds[0].equals(pwds[1]))
			response.sendRedirect("?error=1");
		
		int lunar = 1;
		if(isLunar.equals("no"))
			lunar = 0;
		
		
		MemberDao memberDao = new JdbcMemberDao();
		/*int result = memberDao.insert(id, pwds[0], name,nicName, gender, birthday, phone, email);*/
		
		Member member = new Member(id, pwds[0], name, nicName, gender, birthday, lunar, phone, email);
		int result = memberDao.insert(member);
		
		if(result > 0)
			response.sendRedirect("confirm");
		else
			response.sendRedirect("../error?code=1234");
		
		//response.sendRedirect("confirm");
		//response.sendRedirect("join");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(request, response);
	}
}
