import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/ServletExample")
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public MyServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter print = response.getWriter();
		
		String title = "Welcome!";
		
		print.println("<html>");
		print.println("<body>");
		print.println("<h1>Welcome!</h1>");
        print.println("<form action=\"sTest\" method=\"POST\">");
        print.println("<label for=\"date\"Enter today's date:</label>");
        print.println("<input type=\"text\" name=\"date\">");
        print.println("<input type=\"submit\" value=\"Enter\">");
        print.println("</form>");
        print.println("</body>");
        print.println("</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter print = response.getWriter();
		
		print.println("<html>");
		print.println("<body>");
		print.println("<h2>Today's date is </h2>");
		print.println("<p> " + request.getParameter("date") + " </p>");
		print.println("</body>");
        print.println("</html>");
	}
}
