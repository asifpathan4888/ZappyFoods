package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CartDao;

/**
 * Servlet implementation class Addtocart
 */
@WebServlet("/CartCtl")
public class CartCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartCtl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession hs = request.getSession();
		String pid = request.getParameter("pid");
		String productname=request.getParameter("productname");
		String quantity = request.getParameter("quantity");
		String user = (String) hs.getAttribute("email");
		String pagename=request.getParameter("pagename");
		System.out.println(pid+"  "+productname+"  "+quantity);
		CartDao md = new CartDao();
		if (user != null) {
			int x = md.cart(pid, quantity, user);
			if (x != 0) {

				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				request.setAttribute("cart", "product added To cart");
				rd.forward(request, response);
			}

	 
		
		}
		
		if (user == null) {
			String ip = md.ip();
			int x = md.cart(pid, quantity, ip);
			if (x != 0) {

				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				request.setAttribute("cart", "product added To cart");
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
