package bean;

public class OrderBean {

	
	
	
		
		
		String id;
		int foodID;
		String Order_id;
		String foodName;
		String creationdate;
		String user;
		int quantity;
		double price;
		double total;
		int status;
		int amount;
		String date;
		
		
	
		
	
		public String getOrder_id() {
			return Order_id;
		}
		public void setOrder_id(String order_id) {
			Order_id = order_id;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		
		public int getFoodID() {
			return foodID;
		}
		public void setFoodID(int foodID) {
			this.foodID = foodID;
		}
		public String getFoodName() {
			return foodName;
		}
		public void setFoodName(String foodName) {
			this.foodName = foodName;
		}
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public double getTotal() {
			return total;
		}
		public void setTotal(double total) {
			this.total = total;
		}
		public String getCreationdate() {
			return creationdate;
		}
		public void setCreationdate(String creationdate) {
			this.creationdate = creationdate;
		}
		
		
	}

	

