package controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBContext;
import model.ContentAdd;
import dao.ContentAddDAO;
@WebServlet("/AddContent")
public class ContentAddController  extends HttpServlet{
	
	
	private ContentAddDAO memberserlet;
	
	public ContentAddController() {
        memberserlet = new ContentAddDAO();
    }
	
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			update_addCONTENT(req,resp);
		} catch (SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	

	private void  update_addCONTENT (HttpServletRequest request , HttpServletResponse response) 
			throws SQLException ,ServletException , IOException{
		
		HttpSession session=request.getSession();
		String title = request.getParameter("title");
		String brief= request.getParameter("brief");
		String content= request.getParameter("content");
		String id=session.getAttribute("id").toString();
		//String id= session.getAttribute("id").toString();
		System.out.println("id upadte ne" + id);
		System.out.println(title);
		ContentAdd ContentAdd = new ContentAdd(id,title,brief,content);	
		try {
			memberserlet.insertContent(ContentAdd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("/WebContent/ViewContent?pageid=1");
		
	}


	
}
