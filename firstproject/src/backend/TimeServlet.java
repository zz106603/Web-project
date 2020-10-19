package backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TimeServlet
 */
@WebServlet("/time")
public class TimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String str = String.valueOf(LocalDateTime.now());
		out.print(str);
		
		out.println("<html>");
		out.println("<head><title></title></head>");
		out.println("<body>");
		
		
		out.println("<h2><a href=\"index.html\">메인화면</a><h2>");
		
		out.println("<div style=\"text-align:center\">");
		out.println("<h2>현재시간 : " +str+ "<h2>");
		out.println("</div>");
		
		
		out.println("</body>");
		out.println("</html>");
	}

	
	

}
