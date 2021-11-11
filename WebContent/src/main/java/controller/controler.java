package controller;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

import models.Login;

import java.sql.Driver;
import java.sql.Connection;

public class controler {
	
	private String jdbcURL="jdbc:mysql://localhost:3306/doanweb";
	private  String jdbcUserName="root";
	private String jdbcPass="thanhquang2k1";
	private static final String select_member ="select FisrtName,LastName,Email,Phone,Description from Member where UserName = ? and Password= ?;";
	private static final String update_profile ="update Member set FisrtName=?,LastName= ? , UserName=? , Phone=? , Description=? where Email=?;";
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
    public boolean updateProfile(String a , String b, String c, String d, String e) throws SQLException{
    	boolean rowUpdated;
    	 try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(update_profile);) {
             statement.setString(1, a);
             statement.setString(2,	b);
             statement.setString(3, c);
             statement.setString(4, d);
             statement.setString(5, e);
             
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
    			String FisrtName=rs.getString("FisrtName");
    			System.out.println("member khi them" + FisrtName);
    			String LastName=rs.getString("LastName");
    			System.out.println("member khi them" + LastName);
    			String Email=rs.getString("Email");
    			System.out.println("member khi them" + Email);
    			String Phone=rs.getString("Phone");
    			System.out.println("member khi them" + Phone);
    			String Description=rs.getString("Description");
    			System.out.println("member khi them" + Description);
    			member = new Login(FisrtName,LastName,Email,Phone,Description);
    		}
    		
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			printSQLException(e);
		}
    	System.out.println("member khi them" + member.getFirstName());
    	return member;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
