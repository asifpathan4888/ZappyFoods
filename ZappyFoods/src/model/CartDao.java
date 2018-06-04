package model;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.CartBean;

public class CartDao {

	
	public static Connection start() { // FOR ESTAIBLISH THE CONNECTION
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zappy", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	

	public int cart(String ProductId, String quantity, String user) {

		Connection con = CartDao.start();
		int x = 0;
		try {
			PreparedStatement ps = con.prepareStatement("insert into cart(ProductId,quantity,user) values(?,?,?)");
			ps.setString(1, ProductId);
			ps.setString(2, quantity);
			ps.setString(3, user);

			x = ps.executeUpdate();
			if(x!=0)
				return x;

		} catch (SQLException e) {
			System.out.println(e);
		}

		return x;
	}
	
	
	
	public String ip() {
		InetAddress ipAddr = null;
		try {
			ipAddr = InetAddress.getLocalHost();
			System.out.println(ipAddr.getHostAddress());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		String ip = ipAddr.toString();
		return ip;
	}


	
	public int addingCart(String ProductId, String quantity, String user) {
		Connection con = CartDao.start();
		int x = 0;
		try {
			PreparedStatement ps = con.prepareStatement("select * from cart where user=?");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();

			int p = 0;
			while (rs.next()) {
				if (rs.getString("ProductId").equals(ProductId)) {
					p = Integer.parseInt(rs.getString("quantity"));
					p++;
				}
			}
			if (p != 0) {
				PreparedStatement ps1 = con
						.prepareStatement("update cart set quantity = ? where user =? and pid=?");
				ps1.setString(2, user);
				ps1.setInt(1, p);
				ps1.setString(3, ProductId);
				ps1.executeUpdate();
				x++;
				return x;
			} else {
				PreparedStatement ps1 = con.prepareStatement("insert into cart(ProductId,quantity,user) values(?,?,?)");
				ps1.setString(3, user);
				ps1.setString(2, quantity);
				ps1.setString(1, ProductId);
				ps1.executeUpdate();
				x++;
				return x;
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return x;

	}

	
	public ArrayList<CartBean> ViewCart(String user) {
		ArrayList<CartBean> al = new ArrayList<>();
		Connection con = CartDao.start();
		int x = 0;
		try {
			PreparedStatement ps = con.prepareStatement("select ProductName,ProductPrice,Weight,quantity,user,Image,cart.ProductId from addproduct INNER JOIN cart ON addproduct.ProductId=cart.ProductId where cart.user=?");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CartBean b = new CartBean();	
			b.setProductName(rs.getString("ProductName"));
			b.setProductPrice(rs.getString("ProductPrice"));
			b.setWeight(rs.getString("Weight"));
			b.setQuantity(rs.getString("Quantity"));
			b.setUser(rs.getString("User"));
			b.setImage(rs.getString("Image"));
			b.setProductId(rs.getString("ProductId"));
			
				System.out.println(b);
				al.add(b);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return al;
	}

	
	
	public int count(String user) {

		Connection con = CartDao.start();
		try {
			PreparedStatement ps = con.prepareStatement("select COUNT(user) FROM cart where user=?");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int x = rs.getInt(1);
				return x;
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

		return 0;
	}

	public int remove(String ProductId, String user) {
		Connection con = CartDao.start();
		int x = 0;
		System.out.println(ProductId);
		System.out.println(user);
		try {
			PreparedStatement ps = con.prepareStatement("delete from cart where ProductId=? and user=?");
			ps.setString(1, ProductId);
			ps.setString(2, user);

			x = ps.executeUpdate();
			if (x != 0) {
				
				
				System.out.println(ProductId);
			}

		} catch (Exception e) {
			System.out.println(e);

		}
		return x;
	}

	

	
}
