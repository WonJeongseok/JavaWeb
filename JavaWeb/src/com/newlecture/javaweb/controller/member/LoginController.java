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

@WebServlet("/member/login")
public class LoginController extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String returnURL = request.getParameter("returnURL");
		MemberDao memberDao = new JdbcMemberDao();
		
		Member member = memberDao.get(id);
		if(member == null)
			response.sendRedirect("login?error");
		else if(!member.getPwd().equals(pwd))
			response.sendRedirect("login?error");
		else	//인증이 성공 했을 경우
		{		//현재 사용자의 상태 정보를 저장하는 저장소. 함수단위로 실행하고 다음 서블릿에는 사라짐
				//세션 저장소 서버 자원 	-
				request.getSession().setAttribute("id", id);
				//쿠키 저장소 네트워크 자원 - 보안에 취약? but https:// 같은 것들이 나옴
				
				//리턴url을 가지고 있는 경우
				if(returnURL!=null)
				response.sendRedirect(returnURL);
				else
				response.sendRedirect("../index");
			
				//모든 사용자의 상태 정보를 저장하는 저장소
		}
		
	}
}
