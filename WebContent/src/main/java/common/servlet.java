package common;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Login;
import controller.controler;
/**
 * Servlet implementation class servlet
 */
@WebServlet("/login")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private controler memberserlet ;
 
    public servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init()
    {
    	memberserlet = new controler();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a=request.getParameter("UserName");
		String b=request.getParameter("Password");
		Login result = null;
		try {
			result = memberserlet.selectMember(a, b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result.getEmail());
		request.setAttribute("member",result);
		request.setAttribute("email", result.getEmail());
		request.setAttribute("firstName", result.getFirstName());
		request.setAttribute("lastName", result.getLastName());
		request.setAttribute("Phone", result.getPhone());
		request.setAttribute("description", result.getDescription());
		RequestDispatcher dispatcher = request.getRequestDispatcher("Editprofile.tiles");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
