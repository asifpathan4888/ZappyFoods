package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.OrderDao;


/**
 * Servlet implementation class Order
 */
@WebServlet("/Order")
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession hs = request.getSession();
		String amount  = request.getParameter("amount");
		String user=(String)hs.getAttribute("email");
		System.out.println(user + "my email id");
		System.out.println("amount "+amount);
		OrderDao md = new OrderDao();
		if(user!=null) {
		String id = md.order(user, amount);
		System.out.println("M name is mustafa");
		if(id!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("PlaceOrder");
			request.setAttribute("id", id);
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("CartCtl");
			request.setAttribute("msg", "Cart Must Have Atleast 1 item");
			rd.forward(request, response);
		}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("pagename1", "CartCtl");
			rd.forward(request, response);
		}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	
	}
		
	}


