package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.ContentEdit;
import model.ContentView;

public class ContentEditDAO {
	
	private  String jdbcURL = "jdbc:mysql://localhost:3306/DoAnWeb?useSSL=false";
	private  String jdbcUsername="root";
	private  String jdbcPassword="D@c12345";
	
	protected  Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return connection;
	}
	
	public ContentEdit getContent(int idcontent) 
	{
		String query = "SELECT id,Title,Brief,CreatedDate FROM content where id ="+idcontent+ ";";

		ContentEdit content =null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			
			// Step 4: Process the ResultSet object.
			int id = rs.getInt("id");
			String title = rs.getString("Title");
			String brief = rs.getString("Brief");	
			Date date = rs.getDate("CreatedDate");
			content= new ContentEdit(id, title, brief, date);
		} catch (SQLException e) {
			e.printStackTrace();//(e);
		}
		return content;
	}
	
	public void updateContent (String title, String brief, String content,String id)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		String query = "update Content set Title =?,Brief=? ,Content=? where id= ?";
		try {
			conn = getConnection();// mở kết nối với mysql
			ps = conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, brief);
			ps.setString(3, content);
			ps.setString(4, id);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.printf("loi");
		}
	}
}
