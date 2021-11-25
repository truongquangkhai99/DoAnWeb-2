package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ContentEdit;
import dao.ContentEditDAO;


@WebServlet("/EditContent")
public class ContentEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ContentEditDAO contentDAO = new ContentEditDAO();
 
    public ContentEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String id = request.getParameter("id");
				int idcontent =  Integer.parseInt(id);
				ContentEdit content = contentDAO.getContent(idcontent);
				request.setAttribute("st", content);
				RequestDispatcher rd = request.getRequestDispatcher("edit-content.tiles");
				rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			doGet(request, response);
			String title = request.getParameter("title");
			String brief = request.getParameter("brief");
			String content = request.getParameter("content");
			String id = request.getParameter("id");
			ContentEditDAO dao = new ContentEditDAO();
			dao.updateContent(title, brief, content,id);
			response.sendRedirect("edit-content.tiles");
	}

}
