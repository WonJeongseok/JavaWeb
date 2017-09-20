package com.newlecture.javaweb.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newlecture.javaweb.dao.MemberDao;
import com.newlecture.javaweb.dao.MemberRoleDao;
import com.newlecture.javaweb.entity.Member;
import com.newlecture.javaweb.entity.NoticeView;

public class JdbcMemberDao implements MemberDao {
	@Override
	public Member get(String id) {
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		Member m = null;
		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "SELECT * FROM Member where id = ?";
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			/*st.setString(1, "%"+title+"%");*/

			// 결과 가져오기
			ResultSet rs = st.executeQuery();

			// model
			// 결과 사용
			if (rs.next()) {
				m = new Member();
				m.setId(rs.getString("id"));
				m.setPwd(rs.getString("pwd"));
				m.setName(rs.getString("name"));
				m.setNicName(rs.getString("nicName"));
				m.setGender(rs.getString("gender"));
				m.setBirthday(rs.getString("birthday"));
				m.setLunar(rs.getInt("isLunar"));
				m.setPhone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
				
				
				
				
						/*rs.getString("id"), 
						rs.getString("pwd"), 
						rs.getString("name"), 
						rs.getString("nicName"), 
						rs.getString("gender"), 
						rs.getString("birthday"), 
						rs.getInt("isLunar"), 
						rs.getString("phone"), 
						rs.getString("email"));*/
			}
			

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
		return m;
	}

	@Override
	public int insert(String id, String pwd, String name, String nicName , String phone,
			String email) {
		return insert(new Member(id, pwd, name, nicName, null, null, 0, phone, email));
	}

	@Override
	public int insert(Member m) {
		int result=0;
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "INSERT INTO Member(id, pwd, name, nicName, gender, birthday, isLunar, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, m.getId());
			st.setString(2, m.getPwd());
			st.setString(3, m.getName());
			st.setString(4, m.getNicName());
			st.setString(5, m.getGender());
			st.setString(6, m.getBirthday());
			st.setInt(7, m.getIsLunar());
			st.setString(8, m.getPhone());
			st.setString(9, m.getEmail());

			/*st.setString(1, "%"+title+"%");*/

			// 결과 가져오기
			result = st.executeUpdate();
			//업데이트된 row 개수 알려줌
			
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

		
}
