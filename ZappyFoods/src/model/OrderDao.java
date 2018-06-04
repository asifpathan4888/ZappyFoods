package model;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.CartBean;
import bean.OrderBean;
import bean.PlacedOrderBean;
import bean.Product;
import model.OrderDao;
import DB.DBOperation;

public class OrderDao {

	public String order(String user, String amount) {

		Connection con = DBOperation.connect();
		System.out.println("Sdvxcbv" + amount);
		int x = 0;
		int y = 0;
		long oid = System.currentTimeMillis();
		String od = oid + " ";
		String orderid = "OD-I" + od.substring(9);
		String address = null;
		int gtotal = 0;
		try {
			PreparedStatement ps = con.prepareStatement(
					"SELECT quantity,cart.ProductId,ProductPrice FROM cart INNER JOIN addproduct ON cart.ProductId=addproduct.ProductId WHERE USER = ? ");
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String quantity = rs.getString(1);
				String pid = rs.getString(2);
				String price = rs.getString(3);
				int unit = Integer.parseInt(quantity);
				int rate = Integer.parseInt(price);
				int total = unit * rate;
				gtotal = gtotal + total;

				PreparedStatement ps1 = con.prepareStatement(
						"INSERT INTO order_list(food_Id,food_Name,quantity,USER,price) VALUE(?,?,?,?,?)");
				ps1.setString(1, pid);
				ps1.setString(2, orderid);
				ps1.setString(3, quantity);
				ps1.setString(4, user);
				ps1.setInt(5, total);

				PreparedStatement ps2 = con.prepareStatement("delete from cart where ProductId=? and user=?");
				ps2.setString(1, pid);
				ps2.setString(2, user);
				con.setAutoCommit(false);
				y = ps2.executeUpdate();
				x = ps1.executeUpdate();
				con.commit();
			}
			con.setAutoCommit(true);
			PreparedStatement ps3 = con.prepareStatement("insert into placedorder(id,amount,user) value(?,?,?)");
			ps3.setString(1, orderid);
			ps3.setInt(2, gtotal);
			ps3.setString(3, user);

			System.out.println(orderid + " " + " " + address + " " + gtotal);
			int z = ps3.executeUpdate();
			if (x != 0 && y != 0 && z != 0) {
				System.out.println(z + " asif");
				return orderid;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return orderid;
	}

	public ArrayList<PlacedOrderBean> placedorder(String email, String id) {
		ArrayList<PlacedOrderBean> al = new ArrayList<PlacedOrderBean>();
		Connection con = DBOperation.connect();
		try {
			PreparedStatement ps = con.prepareStatement("select * from placedorder where user = ? and id = ?");
			ps.setString(1, email);
			ps.setString(2, id);
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				PlacedOrderBean p = new PlacedOrderBean();
				p.setId(rs.getString("id"));
				p.setStatus(rs.getString("status"));
				p.setAmount(rs.getString("amount"));
				p.setDate(rs.getString("date"));
				al.add(p);
				return al;
			}
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return al;
	}
	
	
	
	

	public String ip() {
		InetAddress ipAddr = null;
		try {
			ipAddr = InetAddress.getLocalHost();
			System.out.println(ipAddr.getHostAddress());
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
		}
		String ip = ipAddr.toString();
		return ip;
	}

	public int count(String user) {

		Connection con = DBOperation.connect();
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

	public static ArrayList<OrderBean> viewAllOrderHistory() {

		ArrayList<OrderBean> list = new ArrayList<>();

		try (Connection con = DBOperation.connect()) {

			PreparedStatement ps = con.prepareStatement("select * from order_list ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				OrderBean bean = new OrderBean();

				bean.setFoodID(rs.getInt("food_ID"));
				bean.setOrder_id(rs.getString("order_id"));
				bean.setCreationdate(rs.getString("created_date"));
				bean.setUser(rs.getString("user"));
				bean.setQuantity(rs.getInt("quantity"));
				bean.setPrice(rs.getDouble("price"));
				bean.setStatus(rs.getInt("status"));
				
				
				

				list.add(bean);

			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public static ArrayList<PlacedOrderBean> viewCurrentOrders() {
		System.out.println("m in view current");

		ArrayList<PlacedOrderBean> list = new ArrayList<>();

		try (Connection con = DBOperation.connect()) {

			PreparedStatement ps = con.prepareStatement("SELECT * FROM placedorder  WHERE STATUS=0  ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				PlacedOrderBean bean = new PlacedOrderBean();
				
				bean.setId(rs.getString("id"));
				bean.setStatus(rs.getString("status"));
				
				
				bean.setDate(rs.getString("date"));
				bean.setAmount(rs.getString("amount"));
				bean.setUser(rs.getString("user"));
				
				

				list.add(bean);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public static int makeNotAvailable(String id) {
		int x = 0;

		try (Connection con = DBOperation.connect()) {

			PreparedStatement ps = con.prepareStatement("update placedorder set status = 2  where id=? ");
			
			ps.setString(1, id);
System.out.println(id+" make not vaiable");			
			x = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);// TODO Auto-generated catch block
		
		}
		return x;

	}

	public static int makeOrderDispatch(String id) {
		int x = 0;

		try (Connection con = DBOperation.connect()) {

			PreparedStatement ps = con.prepareStatement("update placedorder set status =? where id=? ");
			ps.setInt(1, 1);
			ps.setString(2, id);
			x = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}

}
