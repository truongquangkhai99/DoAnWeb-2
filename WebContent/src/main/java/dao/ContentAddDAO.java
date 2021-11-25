package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.ContentAdd;

public class ContentAddDAO {
	
	private static final String insert_content =" insert into content(Title,Brief,Content,CreatedDate,AuthorId)  values (?,?,?,?,?);";
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	  Date date = new Date();
	  DBContext context = new DBContext();
	public boolean insertContent(ContentAdd add) throws SQLException{
    	boolean rowUpdated;

    	 try (Connection connection = DBContext.getConnection(); PreparedStatement statement = connection.prepareStatement(insert_content);) {
             statement.setString(1,add.getTitle());
             statement.setString(2,add.getBrief());
             
             statement.setString(3,add.getContent());
             statement.setString(4,dateFormat.format(date));
             statement.setString(5,add.getAuthorId());
         
             rowUpdated = statement.executeUpdate() >0;
    	 }
    	 System.out.println(rowUpdated);
    	return rowUpdated;
    }
	
	
}
