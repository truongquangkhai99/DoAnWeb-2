package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.ContentView;
public class SearchDAO {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	DBContext context = new DBContext();
	public List<ContentView> searchContents(String txtSearch){
		List<ContentView> list = new ArrayList<>();
		String query = "select * from content where title like ? or content like ? or brief like ?";
		try {
			conn = context.getConnection();
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
