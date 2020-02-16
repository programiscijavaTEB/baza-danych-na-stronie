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

@WebServlet("/Max")
public class Max extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Max() {
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
		String maxImie=null;
		String maxNazwisko=null;
		int maxWiek = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement st = conn.createStatement();
			String zapytanie = "select * from uczniowie";
			ResultSet rs = st.executeQuery(zapytanie);
			
			while (rs.next()) {
				String imie = rs.getString("imie");
				String nazwisko = rs.getString("nazwisko");
				int wiek = rs.getInt("wiek");
				if(wiek>maxWiek){
					maxWiek = wiek;
					maxImie = imie;
					maxNazwisko = nazwisko;
				}				
			}		
		} catch (Exception exc) {
			exc.printStackTrace();
			System.out.println("cos nie pyklo");
		}
		out.println(maxImie+ " " + maxNazwisko + " " + maxWiek);
	}
}
