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


public class ContentViewDAO {

	private  String jdbcURL = "jdbc:mysql://localhost:3306/DoAnWeb?useSSL=false";
	private  String jdbcUsername="root";
	private  String jdbcPassword="D@c12345";
	

	private static final String SELECT_ALL_CONTENT = "SELECT id,Title,Brief,CreatedDate FROM content;";
	private static final String DELETE_CONTENT_BY_ID = "DELETE FROM content WHERE ID =?;";
	
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
		
	//Delete Content
	public boolean deleteContent(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CONTENT_BY_ID);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public int getCountPage(int numberPerPage) {
		String query = "select count(*) from content;";
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int total = rs.getInt(1);
				int countPage = 0;
				countPage = total/numberPerPage;
				if(total %numberPerPage !=0) {
					countPage++;
				}
				return countPage;
			}
			
		}catch (Exception e ) {
			
		}
		return 0;
	}
	
	//Select all content
		public List<ContentView> selectAllContents(int start, int numberget) 
		{
			String query = "SELECT id,Title,Brief,CreatedDate FROM content limit "+(start-1)+","+numberget+";";

			List<ContentView> contents = new ArrayList<>();
			// Step 1: Establishing a Connection
			try (Connection connection = getConnection();

					// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("Title");
					String brief = rs.getString("Brief");
					
					Timestamp timestamp = rs.getTimestamp("CreatedDate");
					java.util.Date date=timestamp;  
					String  timeStamp = new SimpleDateFormat("dd-MM-Y HH:mm").format(date);
					timeStamp = timeStamp.replace('-', '/');	
					contents.add(new ContentView(id, title, brief, timeStamp));
				}
			} catch (SQLException e) {
				e.printStackTrace();//(e);
			}
			return contents;
		}
		

	
}
