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
import java.util.Scanner;
import java.io.File;

@WebServlet("/OdczytZPliku")
public class OdczytZPliku extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public OdczytZPliku() {
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
		File plik = new File("D:/Programowanie/bazaDoOdczytania.txt");
		Scanner odczyt = new Scanner(plik);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement st = conn.createStatement();
			
			while (odczyt.hasNextLine()) {
				String imie = odczyt.nextLine();
				String nazwisko= odczyt.nextLine();
				String w = odczyt.nextLine();
				int wiek = Integer.parseInt(w);
				String zapytanie = "insert into uczniowie (imie, nazwisko, wiek) values('" + imie + "', '" + nazwisko + "'," + wiek + ") ";
				st.executeUpdate(zapytanie);
				response.sendRedirect("dodanoUcznia.jsp");
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			System.out.println("cos nie pyklo");
		}
		odczyt.close();
	}
}
