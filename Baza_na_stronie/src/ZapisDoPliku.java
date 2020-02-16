import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ZapisDoPliku")
public class ZapisDoPliku extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ZapisDoPliku() {
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
		PrintWriter out = response.getWriter();
		PrintWriter zapis = new PrintWriter("D:/Programowanie/zapisana baza danych.xls");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement st = conn.createStatement();
			String zapytanie;
			zapytanie = "select * from uczniowie";
			ResultSet rs = st.executeQuery(zapytanie);
			while (rs.next()) {
				int lp = rs.getInt("lp");
				String imie = rs.getString("imie");
				String nazwisko = rs.getString("nazwisko");
				int wiek = rs.getInt("wiek");
				zapis.println(lp+";"+imie+";"+nazwisko+";"+wiek);
			} 
			zapis.close();
			response.sendRedirect("zapisano.jsp");
		} catch (Exception exc) {
			exc.printStackTrace();
			System.out.println("cos nie pyklo");
		}
	}
}
