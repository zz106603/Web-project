package kr.or.connect.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {

	
	private static String url = "jdbc:mariadb://localhost:3306/connectdb";
	private static String user = "connectuser";
	private static String password = "connect123!@#";
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	

	public List<TodoDto> getTodos(String type) {
		
		List<TodoDto> list = new ArrayList<TodoDto>();
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT id, title, name, sequence, type, regdate FROM todo";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				if(type.equals(rs.getString(5))) {
					int id = rs.getInt(1);
					String title = rs.getString(2);
					String name = rs.getString(3);
					int sequence = rs.getInt(4);
					String temptype = rs.getString(5);
					String regdate = rs.getString(6);
					regdate = regdate.substring(0, 10);
					
					list.add(new TodoDto(id,title,name,sequence,temptype,regdate));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
				
		return list;
	}
	
	
	public int addTodo(String title, String name, int sequence) {
		int insertCount = 0;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "INSERT INTO todo(title, name, sequence) VALUES (?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, name);
			ps.setInt(3, sequence);
			
			insertCount = ps.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return insertCount;
		
	}
	
	
	public int updateTodo(String type, int id) {
		int updateCount = 0;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			
			String sql = "UPDATE todo SET type=? WHERE id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			ps.setInt(2, id);
			
			updateCount = ps.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return updateCount;
		
	}
}
