import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formularz")
public class Formularz extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Formularz() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String url = "jdbc:mysql://localhost:3306/java";
		String user = "java";
		String password = "java";
		String imie = request.getParameter("imie");
		String nazwisko = request.getParameter("nazwisko");
		String wiek = request.getParameter("wiek");
		int w = Integer.parseInt(wiek);

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement st = conn.createStatement();
			String zapytanie = "insert into uczniowie (imie, nazwisko, wiek) values('" + imie + "', '" + nazwisko + "',"
					+ w + ") ";
			st.executeUpdate(zapytanie);
			System.out.println("ok");
			response.sendRedirect("dodanoUcznia.jsp");
			conn.close();

		} catch (Exception exc) {
			exc.printStackTrace();
			System.out.println("cos nie pyklo");
		}
	}

}
