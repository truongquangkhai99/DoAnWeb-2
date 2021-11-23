package common;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.controler;
@WebServlet("/login")
public class login  extends HttpServlet{
	private controler memberserlet ;
	public void init()
    {
    	memberserlet = new controler();
    }
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			editProFile(req, resp);
		} catch (SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void  editProFile (HttpServletRequest request , HttpServletResponse response) 
			throws SQLException ,ServletException , IOException {
				String a=request.getParameter("UserName");
				String b=request.getParameter("Password");
				String result = null;
				try {
					result = memberserlet.selectID(a,b);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				HttpSession session =request.getSession();
				session.setAttribute("id", result);
				RequestDispatcher dispatcher = request.getRequestDispatcher("viewContents.tiles");
				dispatcher.forward(request, response);
			}
}
