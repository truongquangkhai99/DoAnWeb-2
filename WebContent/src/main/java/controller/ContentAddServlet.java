package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ContentAdd;
import dao.ContentAddDAO;

@WebServlet("/AddContent")
public class ContentAddServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ContentAddDAO contentDAO;
	private ContentAddDAO memberserlet;
	
	public ContentAddServlet() {
        this.setContentDAO(new ContentAddDAO());
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			select_addCONTENT(request,response);
		} catch (SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			update_addCONTENT(req,resp);
		} catch (SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private  void select_addCONTENT(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException,ServletException,IOException {
				HttpSession session =request.getSession();
				String id =session.getAttribute("id").toString();
				System.out.println("Id  selet" +id);
				ContentAdd result=null;
				try {
					result=memberserlet.selectAdd(id);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("title", result.getTitle());
				request.setAttribute("brief", result.getBrief());
				request.setAttribute("content", result.getContent());
				RequestDispatcher dispatcher = request.getRequestDispatcher("Addcontent.tiles");
				dispatcher.forward(request, response);
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
		ContentAdd ContentAdd = new ContentAdd(title,brief,content);
		request.setAttribute("title", ContentAdd.getTitle());
		request.setAttribute("brief", ContentAdd.getBrief());
		request.setAttribute("content", ContentAdd.getContent());
		
		try {
			memberserlet.updateAdd(ContentAdd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewContents.tiles");
		dispatcher.forward(request, response);
		
	}

	public ContentAddDAO getContentDAO() {
		return contentDAO;
	}

	public void setContentDAO(ContentAddDAO contentDAO) {
		this.contentDAO = contentDAO;
	}
	

			
			
}
