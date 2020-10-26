package jdbc;

import kr.or.connect.jdbc.TodoDao;

public class test2 {

	public static void main(String[] args) {
		
		String title = "연습";
		String name = "정윤환";
		int sequence = 1;
		
		TodoDao dao = new TodoDao();
		
		int insertCount = 0;
		insertCount = dao.addTodo(title, name, sequence);
		
		System.out.println(insertCount);
		

	}

}
