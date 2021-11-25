package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContentView;
import dao.ContentViewDAO;
import dao.SearchDAO;

@WebServlet("/ViewContent")
public class ContentViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContentViewDAO contentDAO;

    public ContentViewServlet() {
        this.contentDAO =new ContentViewDAO();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			deleteContent(request, response);
		}catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			listContent(request, response);
		}catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void listContent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, ServletException, IOException {
		
		String spageid = request.getParameter("pageid");
		int pageid =  Integer.parseInt(spageid);
		int numRowPage = 10;
		
		int numberpage = contentDAO.getCountPage(numRowPage);
		List<ContentView> listContent = new ArrayList<ContentView>();
		listContent = contentDAO.selectAllContents(numRowPage*(pageid-1)+1,numRowPage);
			
	
		
		request.setAttribute("pageid",pageid );
		request.setAttribute("numberpage",numberpage );
		request.setAttribute("listContent", listContent);

		RequestDispatcher rd = request.getRequestDispatcher("view-content.tiles");
		rd.forward(request, response);
		
	}
	private void deleteContent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		contentDAO.deleteContent(id);

	}

}
