package kr.or.connect.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.jdbc.TodoDao;
import kr.or.connect.jdbc.TodoDto;


@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public AddServlet() {
		super();
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 
         String title = request.getParameter("title");
         String name = request.getParameter("name");
         int sequence = Integer.parseInt(request.getParameter("sequence"));
          
         TodoDao dao = new TodoDao();
         dao.addTodo(title, name, sequence);
     
         response.sendRedirect("main");
         
	}

}
