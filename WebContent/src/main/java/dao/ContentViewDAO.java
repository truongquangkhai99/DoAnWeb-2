package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

import model.ContentView;


public class ContentViewDAO {


	

	private static final String DELETE_CONTENT_BY_ID = "DELETE FROM content WHERE ID =?;";
	DBContext context= new DBContext();
	
	//Delete Content
	public boolean deleteContent(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = context.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CONTENT_BY_ID);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public int getCountPage(int numberPerPage) {
		String query = "select count(*) from content;";
		try {
			Connection connection = context.getConnection();
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
			try (Connection connection = context.getConnection();

					// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int id = rs.getInt("id");
					String title = rs.getString("Title");
					String brief = rs.getString("Brief");
					
					Timestamp timestamp = rs.getTimestamp("CreatedDate");
					Date date=timestamp;  
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
