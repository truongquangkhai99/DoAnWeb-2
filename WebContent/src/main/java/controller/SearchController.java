package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import model.ContentView;
import dao.SearchDAO;

public class SearchController  extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtSearch = request.getParameter("search");
		int pageid=1;
		SearchDAO dao = new SearchDAO ();
		
		List<ContentView> list = dao.searchContents(txtSearch);
		int numRowPage=10;
		int numberpage = list.size();
		int tam=numRowPage*(pageid-1) ;
		List<ContentView> listContentViews = new ArrayList<ContentView>();
		for( int i =tam; i<numberpage+tam; i++)
		{
			listContentViews.add(list.get(i));
		}
		
		request.setAttribute("listContent", listContentViews);
		request.setAttribute("keysearch", txtSearch);
		RequestDispatcher rd = request.getRequestDispatcher("view-content.tiles");
		rd.forward(request, response);
		
		
	}
}
