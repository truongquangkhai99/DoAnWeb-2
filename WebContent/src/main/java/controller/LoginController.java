package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import model.Member;
@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("msg","");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			LoginDAO dao = new LoginDAO();
			Member member = dao.checkLogin(email, password);			
			if(member != null)
			{				
				String username = member.getUserName();
				int id = member.getId();
				HttpSession session = request.getSession(false);
				// set attribute for new session
				session.setAttribute("id", id);
				session.setAttribute("em", email);
				session.setAttribute("pwd", password);
				session.setAttribute("us", username);
				// set timeout session (seconds)
				/* session.setMaxInactiveInterval(60); */
				// login success
				response.sendRedirect("/WebContent/ViewContent?pageid=1");
					
			}else {			
				// login failed
				
				request.setAttribute("msg","Email or password is incorrect!");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
