package controller;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.PreparableStatement;

import models.Login;

import java.sql.Driver;
import java.sql.Connection;

public class controler {
	
	private String jdbcURL="jdbc:mysql://localhost:3306/doanweb";
	private  String jdbcUserName="root";
	private String jdbcPass="thanhquang2k1";
	private static final String select_member ="select id,FisrtName,LastName,Email,Phone,Description from Member where UserName = ? and Password= ?;";
	private static final String update_profile ="update Member set FisrtName=?,LastName= ?, Phone=? , Description=? where id=?;";
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPass);
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

    
    public boolean updateProfile(Login e) throws SQLException{
    	boolean rowUpdated;
    	 try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(update_profile);) {
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
    public Login selectMember(String a, String b) throws SQLException
    {	
    	System.out.println(a);
    	System.out.println(b);
    	Login member=null;
    	try(Connection connection= getConnection();
    		PreparedStatement preparedStatement=connection.prepareStatement(select_member);)
    	{
    		preparedStatement.setString(1, a);
    		preparedStatement.setString(2, b);
    		System.out.println(preparedStatement);
    		ResultSet rs=preparedStatement.executeQuery();
    		System.out.println(rs);
    		while(rs.next())
    		{	
    			String id=rs.getString("id");
    			System.out.println("FisrtName =" + id);
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
    			
    			member = new Login(id,FisrtName,LastName,Email,Phone,Description);
    		}
    		
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("firstname" + member.getFirstName());
    	return member;
    }
   
}
