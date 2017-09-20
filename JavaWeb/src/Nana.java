import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.newlecture.javaweb.entity.Notice;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/nana")
public class Nana extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; chatset=UTF-8");
		/*
		 * OutputStream os = response.getOutputStream(); PrintStream out = new
		 * PrintStream(os);
		 */
		PrintWriter out = response.getWriter(); // 문자 단위 특화

		String title = request.getParameter("title");

		List<Notice> list = null;
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";

		// JDBC 드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String sql = "SELECT * FROM Notice where title like ? order by regDate desc";
			Connection con = DriverManager.getConnection(url, "sist", "cclass");
			/* Statement st = con.createStatement(); */
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, String.format("%%%s%%", title));
			/*st.setString(1, "%"+title+"%");*/

			// 결과 가져오기
			ResultSet rs = st.executeQuery();

			// model
			list = new ArrayList<>();

			// 결과 사용
			while (rs.next()) {
				Notice n = new Notice();
				n.setId(rs.getString("id"));
				n.setTitle(rs.getString("title"));
				n.setContent(rs.getString("content"));
				n.setRegDate(rs.getDate("regDate"));
				n.setHit(rs.getInt("hit"));
				list.add(n);
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

		// view
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<form action=\"notice\" method=\"get\">");
		out.println("		<label>검색어</label>");
		out.println("		<input type = \"text\" name = \"title\"/>");
		out.println("		<input type =\"submit\"/>");
		out.println("	</form>");

		for (Notice n : list)
			out.println("id : " + n.getId() + " title: " + n.getTitle() + "<br />");
		out.println("</body>");
		out.println("</html>");

	}
}
