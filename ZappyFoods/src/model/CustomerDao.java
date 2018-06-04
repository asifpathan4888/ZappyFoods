package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.RegisterBean;



public class CustomerDao {
	
	

public String login(String email,String password){
	
	
	
	int x = 0;

	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy", "root", "root");
		PreparedStatement ps = con.prepareStatement("select * from register where email=? and password=? ");
		System.out.println("YO");
		
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
	if (rs.next()) {
			String name=rs.getString("fname");
			
			return name;
		}
	} catch (Exception ex) {
		System.out.println(ex);
	}
	return null;

	
}	
	

	public int insertregister(RegisterBean e) {
		int x = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy", "root", "root");
			PreparedStatement ps = con.prepareStatement(
					"insert into register(fname,lname,mobile,email,password) values(?,?,?,?,?)");
			System.out.println("YO");
			
			ps.setString(1, e.getFname());
			ps.setString(2, e.getLname());
			ps.setString(3, e.getMobile());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getPassword());
			

			x = ps.executeUpdate();

			if (x != 0) {
				return x;
			}

			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return x;
	}
	
	public int ChangePassword(String email,String oldpass,String newpass) {
       
		int x = 0;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy", "root", "root");
	        PreparedStatement ps = con.prepareStatement("Select * from register where email=? and password=? ");
         
	             ps.setString(1, email);
	             ps.setString(2, oldpass);
	             
	             ResultSet rs =ps.executeQuery();
	                
	        if(rs.next()){
	        	PreparedStatement ps1 = con.prepareStatement("update register set password = ? where email =?");
		        
		        ps1.setString(1, newpass);
		        ps1.setString(2, email);
		        
		       
		      x=  ps1.executeUpdate();     
	  	
	        	System.out.println("Your Password Change Successfully");
	        	
		}else{
	        	System.out.println("Enter your Email id");
	        }
	        	
		} catch ( Exception e) {
			System.out.println(e);
		}
		return x;
		
}

	
	
	public String ForgetPassword(String Email){
				
		int x = 0;
		
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy", "root", "root");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy", "root", "root");
			
			PreparedStatement ps = con.prepareStatement("select password from register where email= ?");
			
			ps.setString(1, Email);
			
			
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				String pass = rs.getString("password");
				return pass;
			}
			
			
			if(x!=0){
				
			System.out.println("your password forget");
			
			}else{
				System.out.println("Enter your Emailid");
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			    System.out.println(e);
		}
		return null;
}
}