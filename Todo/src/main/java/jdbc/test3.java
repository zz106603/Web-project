package jdbc;

import kr.or.connect.jdbc.TodoDao;

public class test3 {

	public static void main(String[] args) {
		String type = "DOING";
		int id = 3;
		
		TodoDao dao = new TodoDao();
		
		int update = dao.updateTodo(type, id);
		System.out.println(update);

	}

}
