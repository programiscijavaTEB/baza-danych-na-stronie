import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SprLogowania")
public class SprLogowania extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SprLogowania() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("ISO-8859-2");
		String login = request.getParameter("login");
		String haselo = request.getParameter("haslo");
		String url = "jdbc:mysql://localhost:3306/java";
		String user = "java";
		String password = "java";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement st = conn.createStatement();
			String zapytanieOlog = "SELECT user, password FROM 'mysql.user' ";
			st.executeUpdate(zapytanieOlog);
			if ((login.equals("java")) && (haselo.equals("java"))) {
				response.sendRedirect("wybor.jsp");
			} else {
				response.sendRedirect("nieprawidlowe.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}