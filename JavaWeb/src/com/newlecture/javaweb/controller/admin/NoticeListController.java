package com.newlecture.javaweb.controller.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.javaweb.dao.MemberRoleDao;
import com.newlecture.javaweb.dao.NoticeDao;
import com.newlecture.javaweb.dao.jdbc.JdbcMemberRoleDao;
import com.newlecture.javaweb.dao.jdbc.JdbcNoticeDao;
import com.newlecture.javaweb.entity.Notice;

/*@WebServlet("/admin/notice/list")*/
public class NoticeListController /*extends HttpServlet*/ {
	
	protected String service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인증정보 확인 !! 없으면 로그인 페이지로
		
		//인증정보 확인 역할이 ROLE_ADMIN이 있는지 확인
		String id;
		MemberRoleDao memberRoleDao = new JdbcMemberRoleDao();
		boolean roleHas = memberRoleDao.hasRole(id,"ROLE_ADMIN");
		//없으면 에러-권한 없음 페이지로 간다.
		String _title = request.getParameter("title");
		String _page = request.getParameter("p");
		
		int page = 1;
		if (_page != null && !(_page.equals("")))
			page = Integer.parseInt(_page);
		
		String title = "";
		if (_title != null && !(_title.equals("")))
			title = _title;
		
		
		NoticeDao noticeDao = new JdbcNoticeDao(); //context.getDao("noticedao");
		
		request.setAttribute("list", noticeDao.getList(page,title));
		request.setAttribute("count", noticeDao.getCount());
		
		return "/WEB-INF/views/admin/notice/list.jsp";
		/*response.sendRedirect("notice.jsp");*/
		/*request.getRequestDispatcher("/WEB-INF/views/admin/notice/list.jsp").forward(request, response);*/
	}	
}
