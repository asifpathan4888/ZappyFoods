package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Product;
import bean.RegisterBean;


public class AdminModel {
	public int checkLogin(String u, String p) {

		if (u.equals("asif") && p.equals("1234")) {
			return 1;
		} else {
			return 0;
		}
	}

	public int insertAddProduct(Product e) {
		int x = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy", "root", "root");
			PreparedStatement ps = con.prepareStatement(
					"insert into addproduct(ProductName,Category,ProductPrice,Weight,Description,Image) values(?,?,?,?,?,?)");
			System.out.println("YO");
			//ps.setString(1, e.getProductid());
			ps.setString(1, e.getProductname());
			ps.setString(2, e.getCategory());
			ps.setString(3, e.getProductprice());
			ps.setString(4, e.getWeight());
			ps.setString(5, e.getDescription());
			ps.setString(6, e.getImage());

			x = ps.executeUpdate();

			if (x != 0) {
				return x;
			}

			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return x;
	}
	
	
	
	
	public int delete(String pid){
		try {	
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy", "root", "root");
		        PreparedStatement ps=con.prepareStatement("delete from addproduct where ProductId=?");
			   ps.setInt(1, Integer.parseInt(pid));
			  int x = ps.executeUpdate();
		         if(x!=0){
		        	 return x;
		         }
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return 0;
	}
	
	public int UpdateAddProduct(Product e,String pid) {
		int x = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy", "root", "root");
			PreparedStatement ps = con.prepareStatement(
					"update addproduct set ProductName=?,Category=?,ProductPrice=?,Weight=?,Description=?,Image=? where ProductId=? ");
			System.out.println("YO");
			//ps.setString(1, e.getProductid());
			ps.setString(1, e.getProductname());
			ps.setString(2, e.getCategory());
			ps.setString(3, e.getProductprice());
			ps.setString(4, e.getWeight());
			ps.setString(5, e.getDescription());
			ps.setString(6, e.getImage());
			ps.setString(7, pid);
			x = ps.executeUpdate();

			if (x != 0) {
				return x;
			}

			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return x;
	}
	
	
	public int updateImage(String filename,String pid)
	{
		int x= 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy", "root", "root");
			PreparedStatement ps = con.prepareStatement(
					"update addproduct set Image=? where ProductId=? ");
			
			ps.setString(1, filename);
			ps.setString(2, pid);
			
			x = ps.executeUpdate();

			if (x != 0) {
				return x;
			}

		}catch(Exception e ){
			
		}
		return 0;
	}
	
	
	
	public ArrayList<Product>  getAllProductData()
	{
		ArrayList<Product> ar=new ArrayList<Product>();
		
		try {	
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy", "root", "root");
		        PreparedStatement ps=con.prepareStatement("select * from addproduct");
			   ResultSet rs=ps.executeQuery();
			   
			   while(rs.next())
			   {   
		           Product e=new Product();	
		           e.setProductId(rs.getInt("ProductId"));
		          
				   e.setProductname(rs.getString("ProductName"));
				   e.setCategory(rs.getString("Category"));
				   e.setProductprice(rs.getString("ProductPrice"));
				   e.setWeight(rs.getString("Weight"));
				   e.setDescription(rs.getString("Description"));
				   e.setImage(rs.getString("Image"));
				 
			  ar.add(e);
			   
		     		   
			   }	   
		}catch(Exception e)
		{
			System.out.println(e);
		}
	
		return ar;
		
	}
	
	
	
	public ArrayList<RegisterBean>  getAllRegisteredData()
	{
		ArrayList<RegisterBean> ar=new ArrayList<RegisterBean>();
		
		try {	
			   Class.forName("com.mysql.jdbc.Driver");
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy", "root", "root");
		        PreparedStatement ps=con.prepareStatement("select * from register");
			   ResultSet rs=ps.executeQuery();
			   
			   while(rs.next())
			   {   
		           RegisterBean e=new RegisterBean();	
		         
				 e.setFname(rs.getString("fname"));
				 e.setLname(rs.getString("lname"));
				 e.setMobile(rs.getString("mobile"));
				 e.setEmail(rs.getString("email"));
				 e.setPassword(rs.getString("password"));
			  ar.add(e);
			   
		     		   
			   }	   
		}catch(Exception e)
		{
			System.out.println(e);
		}
	
		return ar;
		
	}
	
	
	

}
