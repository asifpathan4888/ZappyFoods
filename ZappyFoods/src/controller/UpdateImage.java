package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bean.Product;
import model.AdminModel;

/**
 * Servlet implementation class UpdateImage
 */

@WebServlet("/UpdateImage")
public class UpdateImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String filePath;
	private int maxFileSize = 1000 * 4096;
	private int maxMemSize = 1000 * 4096;
	private File file;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * request.getParameter("productname");
		 * request.getParameter("category");
		 * request.getParameter("productprice"); request.getParameter("weight");
		 * request.getParameter("description"); request.getParameter("image");
		 */
		int productid = 0;
		String productname = null;
		String category = null;
		String productprice = null;
		String weight = null;
		String description = null;

		String filename = null;
		HttpSession hs = request.getSession();
		String pid = (String) hs.getAttribute("pid");
System.out.println(pid);
		PrintWriter out = response.getWriter();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (!isMultipart) {
			return;
		}

		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);
		// Location to save data that is larger than maxMemSize.
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);

		try {

			// Parse the request to get file items.
			List fileItems = upload.parseRequest(request);

			// Process the uploaded file items
			Iterator i = fileItems.iterator();

			while (i.hasNext()) {

				FileItem fi = (FileItem) i.next();
				if (fi.isFormField()) {
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();

					if (fieldName.equals("productid")) {
						productid = Integer.parseInt(fi.getString());
						System.out.println(productid);
					}

					if (fieldName.equals("productname")) {
						productname = fi.getString();
						System.out.println(productname);
					}

					if (fieldName.equals("category")) {
						category = fi.getString();
						System.out.println(category);
					}

					if (fieldName.equals("productprice")) {
						productprice = fi.getString();
						System.out.println(productprice);
					}

					if (fieldName.equals("weight")) {
						weight = fi.getString();
						System.out.println(weight);
					}

					if (fieldName.equals("description")) {
						description = fi.getString();
						System.out.println(description);
					}

				} else {
					String fieldName = fi.getFieldName();

					if (fieldName.equals("filename")) {
						ServletConfig sc = getServletConfig();
						// String field=fi.getString();
						// String contentType = fi.getContentType();
						filename = fi.getName();
						// boolean isInMemory = fi.isInMemory();
						// long sizeInBytes = fi.getSize();

						// create folder
						File f = new File(sc.getServletContext().getRealPath("/") + "imgupload/");
						if (!f.exists())
							f.mkdir();
						// Write the file
						file = new File(sc.getServletContext().getRealPath("/") + "imgupload/" + filename);
						fi.write(file);
						out.println("Uploaded Filename: " + filename + "<br>");
						System.out.println("PATH=" + file.getPath());
					}

				}
			}

			Product ap = new Product();
			ap.setProductId((productid));
			ap.setProductname(productname);
			ap.setCategory(category);
			ap.setProductprice(productprice);
			ap.setWeight(weight);
			ap.setDescription(description);
			ap.setImage(filename);

			AdminModel am = new AdminModel();
			int x = am.updateImage(filename, pid);
			if (x != 0) {
				RequestDispatcher rd = request.getRequestDispatcher("ViewAllProduct");
				request.setAttribute("msg", "Image Updated Successfully");
				rd.forward(request, response);

			} else {
				out.println("UnSuccess");
				System.out.println("Unsuccess");
			}

		} catch (Exception e) {

		}
	}

}
