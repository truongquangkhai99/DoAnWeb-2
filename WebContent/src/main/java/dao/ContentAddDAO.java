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

import model.ContentAdd;

public class ContentAddDAO {
	private  String jdbcURL = "jdbc:mysql://localhost:3306/DoAnWeb";
	private  String jdbcUsername="root";
	private  String jdbcPassword="root";
	
	private static final String update_addCONTENT ="update Content set Title=?,Brief= ?, Content=? where id=?;";
	private static final String select_addCONTENT ="select Title,Brief,Content from Content where id=?;";
	
		
	protected Connection getConnection() {
	        Connection connection = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	            if(connection !=null)
	            {
	            System.out.println("thành công");
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            System.out.println("thất bại");
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            System.out.println("thất bạithất bạithất bại");
	        }
	        System.out.println(connection);
	        return connection;
	    }
	public boolean updateAdd(ContentAdd add) throws SQLException{
    	boolean rowUpdated;
    	System.out.println(add.getTitle());
    	System.out.println(add.getBrief());
    	System.out.println(add.getContent());
    	System.out.println(add.getId());
    	 try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(update_addCONTENT);) {
             statement.setString(1,add.getTitle());
             statement.setString(2,add.getBrief());
             statement.setString(3,add.getContent());
             statement.setLong(4,add.getId());
         
             rowUpdated = statement.executeUpdate() >0;
    	 }
    	 System.out.println(rowUpdated);
    	return rowUpdated;
    }
	
	public ContentAdd selectAdd(String a) throws SQLException
    {
		ContentAdd selectAdd =null;
    	try (Connection connection =getConnection();
    		PreparedStatement preparableStatement=connection.prepareStatement(select_addCONTENT);)
    	{
			preparableStatement.setString(1,a);
			ResultSet rs=preparableStatement.executeQuery();
			System.out.println(rs);
			while(rs.next())
			{
				String Title=rs.getString("Title");
    			System.out.println("Title =" + Title);
    			String Brief=rs.getString("Brief");
    			System.out.println("Brief = " + Brief);
    			String Content=rs.getString("Content");
    			System.out.println("Content = " + Content);
    			selectAdd = new ContentAdd(Title,Brief,Content);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	System.out.println("Title" + selectAdd.getTitle());
    	return selectAdd;
    }
}
