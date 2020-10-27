package jdbc;

import kr.or.connect.jdbc.TodoDao;

public class test3 {

	public static void main(String[] args) {

		int id = 10;
		
		TodoDao dao = new TodoDao();
		
		int update = dao.updateTodo(id);
		System.out.println(update);

	}

}
