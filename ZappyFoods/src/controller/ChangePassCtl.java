package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CustomerDao;

/**
 * Servlet implementation class ChangePassCtl
 */
@WebServlet("/ChangePassCtl")
public class ChangePassCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

int x = 0;

String newpass=request.getParameter("newpass");
String oldpass=request.getParameter("oldpass");
String email=request.getParameter("eid");

System.out.println(email);
System.out.println(oldpass);
System.out.println(newpass);

CustomerDao cd = new CustomerDao();
	x = cd.ChangePassword(email, oldpass, newpass);


if(x!=0){
	RequestDispatcher rd = request.getRequestDispatcher("ChangePassword.jsp");
			rd.forward(request, response);
}

	}

}
