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
 * Servlet implementation class RemoveCtl
 */
@WebServlet("/RemoveCtl")
public class RemoveCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ProductID= (String)request.getParameter("ProductId");
		HttpSession hs=request.getSession();
		String user=(String) hs.getAttribute("user");
		
		CartDao cdd = new CartDao();
	int x=	cdd.remove(ProductID,user);
	
	if(x!=0){
		System.out.println("asiff");
		RequestDispatcher rd = request.getRequestDispatcher("ViewCartCtl");
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
