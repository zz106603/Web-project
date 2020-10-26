package kr.or.connect.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.connect.jdbc.TodoDao;

@WebServlet("/type")
public class TypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TypeServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 
        int id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
      
        
        TodoDao dao = new TodoDao();
        if(type.equals("TODO")) {
        	String temp = "DOING";
        	dao.updateTodo(temp, id);
        }else if(type.equals("DOING")) {
        	String temp = "DONE";
        	dao.updateTodo(temp, id);
        }
        
       
        response.sendRedirect("main");
        
	}


	
}
