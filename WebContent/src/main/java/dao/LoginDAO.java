package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import model.Member;

public class LoginDAO {
	
	Connection conn = null;	
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public static void main(String[] args) {
	}
	
	public Member checkLogin(String emailin, String passwordin ) {
		String query = "select * from member where Email =? and Password =? ";

		try {
			new DBContext();
			conn = DBContext.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, emailin);
			ps.setString(2, passwordin);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				int id = rs.getInt(1);
				String firstname = rs.getString(2);
				String lastname = rs.getString(3);
				String username = rs.getString(4);
				String email = rs.getString(5);
				String password = rs.getString(6);
				String phone = rs.getString(7);
				String description = rs.getString(8);
				Date createdate = rs.getDate(9);
				Date updatetime = rs.getDate(10);
				
				return new Member(id,firstname,lastname,username,email,password,phone,description,createdate,updatetime);
			}
		}
		catch(Exception e) {
		}
		return null;
	}
}
