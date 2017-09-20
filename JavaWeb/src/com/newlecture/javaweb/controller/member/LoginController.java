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
		else	//������ ���� ���� ���
		{		//���� ������� ���� ������ �����ϴ� �����. �Լ������� �����ϰ� ���� �������� �����
				//���� ����� ���� �ڿ� 	-
				request.getSession().setAttribute("id", id);
				//��Ű ����� ��Ʈ��ũ �ڿ� - ���ȿ� ���? but https:// ���� �͵��� ����
				
				//����url�� ������ �ִ� ���
				if(returnURL!=null)
				response.sendRedirect(returnURL);
				else
				response.sendRedirect("../index");
			
				//��� ������� ���� ������ �����ϴ� �����
		}
		
	}
}
