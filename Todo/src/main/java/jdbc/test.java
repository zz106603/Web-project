package jdbc;

import java.util.ArrayList;
import java.util.List;

import kr.or.connect.jdbc.TodoDao;
import kr.or.connect.jdbc.TodoDto;

public class test {

	public static void main(String[] args) {
		
		TodoDao dao = new TodoDao();
		List<TodoDto> dto = new ArrayList<>(); 
		dto = dao.getTodos();
		
		System.out.println(dto);

	}

}
