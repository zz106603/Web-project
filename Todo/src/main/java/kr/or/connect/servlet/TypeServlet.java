package kr.or.connect.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.jdbc.TodoDao;
import kr.or.connect.jdbc.TodoDto;

@WebServlet("/type")
public class TypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TypeServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
 
        
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
		response.setCharacterEncoding("utf-8");
		// 응답으로 보낼 데이터 타입을 json으로 설정
		response.setContentType("application/json");
		
		// 클라이언트에서 보낸 데이터를 받음
		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		
		// id와 일치하는 할 일의 type을 변경
		TodoDao dao = new TodoDao();
		dao.updateTodo(id);
		
		List<TodoDto> list = dao.getTodos();
		List<TodoDto> jsonList = new ArrayList<TodoDto>();
		
		// 변경된 할 일 목록을 list에 저장
		for(TodoDto dto : list) {
			if(type.equals("TODO") && dto.getType().equals("DOING")) {
				jsonList.add(dto);
			}
			else if(type.equals("DOING") && dto.getType().equals("DONE")) {
				jsonList.add(dto);
			}
		}
		
		// list를 json형식으로 변경하기 위해 ObjectMapper 객체 생성
		ObjectMapper ob = new ObjectMapper();
		String json = ob.writeValueAsString(jsonList);
		
		// json 파일을 전송
		PrintWriter out = response.getWriter();
		out.println(json);
		out.close();
        
	}


	
}
