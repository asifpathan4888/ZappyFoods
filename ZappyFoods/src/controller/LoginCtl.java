package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartBean;
import model.CustomerDao;

/**
 * Servlet implementation class LoginCtl
 */
@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		/*
		 * String user =(String)hss.getAttribute("user");
		 * 
		 * 
		 * if(user!=null){
		 * 
		 * ArrayList<CartBean> i = cd.ViewCart(user);
				RequestDispatcher rd = request.getRequestDispatcher("ViewCart.jsp");
		request.setAttribute("data", i);
		rd.forward(request, response);
		 * 
		 * }else{
		 * ArrayList<CartBean> i = cd.ViewCart(ip);
				RequestDispatcher rd = request.getRequestDispatcher("ViewCart.jsp");
		request.setAttribute("data", i);
		rd.forward(request, response);
		 * }
		 * 
		 * 
		 * */
		
		
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		HttpSession hs =request.getSession();
	
		
		System.out.println(email+ "  "+pass);
		
		CustomerDao cd=new CustomerDao();
		String name=cd.login(email,pass);
		if(name!=null){
			hs.setAttribute("user", name);
			hs.setAttribute("email", email);
			response.sendRedirect("index.jsp");
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			request.setAttribute("msg", "Login Failed Try Again");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
