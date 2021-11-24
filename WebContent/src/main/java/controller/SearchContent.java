package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SearchDAO;
import model.ContentView;

@WebServlet("/SearchContent")
public class SearchContent extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtSearch = request.getParameter("search");
		
		SearchDAO dao = new SearchDAO ();
		
		List<ContentView> list = dao.searchContents(txtSearch);
		
		request.setAttribute("listsearch", list);
		request.setAttribute("keysearch", txtSearch);
		
		request.getRequestDispatcher("/views/view-contents.jsp").forward(request, response);
	}
 
}