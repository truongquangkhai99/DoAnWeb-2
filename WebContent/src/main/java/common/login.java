package common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class login  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a= req.getParameter("UserName");
		HttpSession session=req.getSession();
		session.setAttribute("id", a);
		System.out.println(a);
		RequestDispatcher dispatcher = req.getRequestDispatcher("viewContents.tiles");
		dispatcher.forward(req, resp);
	}
}
