package bean;

public class CartBean {
	
	String cid;
	String ProductId;
	String ProductName;
	String ProductPrice;
	String weight;
	String quantity;
	String user;
	String Image;
	
	
	
	
	@Override
	public String toString() {
		return "CartBean [cid=" + cid + ", ProductId=" + ProductId + ", ProductName=" + ProductName + ", ProductPrice="
				+ ProductPrice + ", weight=" + weight + ", quantity=" + quantity + ", user=" + user + ", Image=" + Image
				+ ", getImage()=" + getImage() + ", getCid()=" + getCid() + ", getProductId()=" + getProductId()
				+ ", getProductName()=" + getProductName() + ", getProductPrice()=" + getProductPrice()
				+ ", getWeight()=" + getWeight() + ", getQuantity()=" + getQuantity() + ", getUser()=" + getUser()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(String productPrice) {
		ProductPrice = productPrice;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
	
}
