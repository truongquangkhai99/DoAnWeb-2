package controller;
import model.Member;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.RegisterDAO;
@WebServlet(urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		
		if(!password.equals(repassword)) {
			response.sendRedirect("register.jsp");
		}
		else {
			RegisterDAO dao = new RegisterDAO();
			Member member = dao.checkMemberExist(username, email);
			if(member == null)
			{
				dao.register(username, email, password);
				response.sendRedirect("login.jsp");
			}
			else 
			{
				String err ="Tai khoan da ton tai";
				request.setAttribute("err", err);
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}
	}

}
