package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CartBean;
import bean.Product;
import model.AdminModel;
import model.CartDao;

/**
 * Servlet implementation class ViewCartCtl
 */
@WebServlet("/ViewCartCtl")
public class ViewCartCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCartCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CartDao cd = new CartDao();
		HttpSession hss = request.getSession();
		String user = (String) hss.getAttribute("email");
		
		if(user!=null){
			ArrayList<CartBean> i = cd.ViewCart(user);
			RequestDispatcher rd = request.getRequestDispatcher("ViewCart.jsp");
			request.setAttribute("data", i);
			rd.forward(request, response);
		}else if(user==null){

String ip = cd.ip();
ArrayList<CartBean> i = cd.ViewCart(ip);


	RequestDispatcher rd = request.getRequestDispatcher("ViewCart.jsp");
	request.setAttribute("data", i);
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
