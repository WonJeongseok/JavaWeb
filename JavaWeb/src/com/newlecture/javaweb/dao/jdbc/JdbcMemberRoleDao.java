package com.newlecture.javaweb.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newlecture.javaweb.dao.MemberRoleDao;
import com.newlecture.javaweb.entity.NoticeView;

public class JdbcMemberRoleDao implements MemberRoleDao {

	@Override
	public String gerDefaultRoleId(String memberId) {
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		String defaultRole;
		// JDBC ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "select roleId from MemberRole where memberId=? and defaultRole=1;";
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, memberId);
			

			// ��� ��������
			ResultSet rs = st.executeQuery();

			// model
			// ��� ���
			if (rs.next()) 
				defaultRole = rs.getString("roleId");
		
			

			

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return defaultRole;
	}

	@Override
	public boolean hasRole(String id, String string) {
		// TODO Auto-generated method stub
		return false;
	}

}
