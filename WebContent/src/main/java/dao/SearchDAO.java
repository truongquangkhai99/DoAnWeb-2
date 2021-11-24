package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;



import model.ContentView;
public class SearchDAO {
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
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<ContentView> searchContents(String txtSearch){
		List<ContentView> list = new ArrayList<>();
		String query = "select * from content \r\n"
				+ "where title like ? or content like ? or brief like ?";
		try {
			Connection conn = getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,"%" + txtSearch + "%");
			ps.setString(2,"%" + txtSearch + "%");
			ps.setString(3,"%" + txtSearch + "%");
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new ContentView(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (Exception e) {
			
		}
		return list;
	}
}
