package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrderDao;

/**
 * Servlet implementation class NotAvailableCtl
 */
@WebServlet("/NotAvailableCtl")
public class NotAvailableCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotAvailableCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		System.out.println(id);
		
		int x = OrderDao.makeNotAvailable(id);
		
		if(x!=0){
			
			request.setAttribute("success", "Status Changed to Not available ");
			RequestDispatcher rd = request.getRequestDispatcher("PendingOrder.jsp");
			rd.forward(request, response);
		}
		else{
			
			request.setAttribute("failedNotAvailable", "Making order not available unsuccessfull ");
			
			RequestDispatcher rd = request.getRequestDispatcher("PendingOrder.jsp");
			
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
