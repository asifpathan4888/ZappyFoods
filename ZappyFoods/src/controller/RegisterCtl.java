package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.RegisterBean;
import model.CustomerDao;

/**
 * Servlet implementation class RegisterCtl
 */
@WebServlet("/RegisterCtl")
public class RegisterCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCtl() {
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
		
		
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String mobile = request.getParameter("mobile");
		String email= request.getParameter("email");
		String password = request.getParameter("password");
		
		
		
		
		RegisterBean rb= new RegisterBean();
		rb.setFname(fname);
		rb.setLname(lname);
		rb.setMobile(mobile);
		rb.setEmail(email);
		rb.setEmail(email);
		rb.setPassword(password);
		
		
		
		
		CustomerDao cd = new CustomerDao();
int x =cd.insertregister(rb);
if (x!=0){
	RequestDispatcher rd =  request.getRequestDispatcher("AdminHome.jsp");
	request.setAttribute("msg", "Registered successfull");
	rd.forward(request, response);
}	
		

		
	}

}
