package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import model.AdminModel;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		String pname=request.getParameter("productname");
		String cate=request.getParameter("category");
		String pp=request.getParameter("productprice");
		String w=request.getParameter("weight");
		String des=request.getParameter("description");
		//String pid =request.getParameter("ProductId");
		HttpSession hs =request.getSession();
		String pid =(String)hs.getAttribute("pid");
		AdminModel a = new AdminModel();
		Product e = new Product();
		
		e.setProductname(pname);
		e.setCategory(cate);
		e.setProductprice(pp);
		e.setWeight(w);
		e.setDescription(des);
		
		int x = a.UpdateAddProduct(e, pid);
		if(x!=0){
		 
		RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
		rd.forward(request, response);
		}
	}
	}


