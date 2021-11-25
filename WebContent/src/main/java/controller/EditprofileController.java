package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EditprofileDAO;
import model.Editprofile;
@WebServlet("/editprofile")
public class EditprofileController extends HttpServlet {
	private EditprofileDAO memberserlet ;
	 
    public EditprofileController() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init()
    {
    	memberserlet = new EditprofileDAO();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			try {
				select_profile(request,response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			update_profile(req,resp);
		} catch (SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private  void select_profile(HttpServletRequest request, HttpServletResponse response) 
	throws SQLException,ServletException,IOException {
		HttpSession session =request.getSession();
		String id =session.getAttribute("id").toString();
		System.out.println("Id session" +id);
		Editprofile result=null;
		try {
			result=memberserlet.selectProfile(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("email", result.getEmail());
		request.setAttribute("firstName", result.getFirstName());
		request.setAttribute("lastName", result.getLastName());
		request.setAttribute("Phone", result.getPhone());
		request.setAttribute("description", result.getDescription());
		RequestDispatcher dispatcher = request.getRequestDispatcher("Editprofile.tiles");
		dispatcher.forward(request, response);
	}
	
	private void  update_profile (HttpServletRequest request , HttpServletResponse response) 
			throws SQLException ,ServletException , IOException{
		
		HttpSession session=request.getSession();
		String firstName = request.getParameter("firstName");
		String lastName= request.getParameter("lastName");
		String phone= request.getParameter("phone");
		String description= request.getParameter("description");
		String email=request.getParameter("email");
		String id=session.getAttribute("id").toString();
		//String id= session.getAttribute("id").toString();
		System.out.println("id upadte ne" + id);
		System.out.println(firstName);
		System.out.println(lastName);
		Editprofile login = new Editprofile(id,firstName,lastName,email,phone,description);
		request.setAttribute("email", login.getEmail());
		request.setAttribute("firstName", login.getFirstName());
		request.setAttribute("lastName", login.getLastName());
		request.setAttribute("Phone", login.getPhone());
		request.setAttribute("description", login.getDescription());
		
		
		try {
			memberserlet.updateProfile(login);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text");
        response.getWriter().write("update Thành công");
       
		
	}
	

}
