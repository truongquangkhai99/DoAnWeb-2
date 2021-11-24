package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Editprofile;
import dao.DBContext;
public class EditprofileDAO {
	
	private static final String update_profile ="update Member set FisrtName=?,LastName= ?, Phone=? , Description=? where id=?;";
	private static final String select_editprofile ="select FisrtName,LastName,Email,Phone,Description from Member where id=?;";
    
    DBContext context   = new DBContext();
    public boolean updateProfile(Editprofile e) throws SQLException{
    	boolean rowUpdated;
    	System.out.println(e.getFirstName());
    	System.out.println(e.getLastName());
    	System.out.println(e.getPhone());
    	System.out.println(e.getDescription());
    	System.out.println(e.getID());
    	 try (Connection connection = context.getConnection(); PreparedStatement statement = connection.prepareStatement(update_profile);) {
             statement.setString(1,e.getFirstName());
             statement.setString(2,e.getLastName());
             statement.setString(3,e.getPhone());
             statement.setString(4,e.getDescription());
             statement.setString(5,e.getID());
         
             rowUpdated = statement.executeUpdate() >0;
    	 }
    	 System.out.println(rowUpdated);
    	return rowUpdated;
    }
    public Editprofile selectProfile(String a) throws SQLException
    {
    	Editprofile selectProfile =null;
    	try (Connection connection =context.getConnection();
    		PreparedStatement preparableStatement=connection.prepareStatement(select_editprofile);)
    	{
			preparableStatement.setString(1,a);
			ResultSet rs=preparableStatement.executeQuery();
			System.out.println(rs);
			while(rs.next())
			{
				String FisrtName=rs.getString("FisrtName");
    			System.out.println("FisrtName =" + FisrtName);
    			String LastName=rs.getString("LastName");
    			System.out.println("LastName = " + LastName);
    			String Email=rs.getString("Email");
    			System.out.println("Email = " + Email);
    			String Phone=rs.getString("Phone");
    			System.out.println("Phone = " + Phone);
    			String Description=rs.getString("Description");
    			System.out.println("Description = " + Description);
    			selectProfile = new Editprofile(FisrtName,LastName,Email,Phone,Description);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	System.out.println("firstname" + selectProfile.getFirstName());
    	return selectProfile;
    }

}
