package FurnitureC.bean;

public class shoppingcart {
	
	private Integer id;
	private String userID;
	private String goodsID;
	private String num;
	private String shoppingDate;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getgoodsID() {
		return goodsID;
	}
	public void setgoodsID(String goodsID) {
		this.goodsID = goodsID;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getShoppingDate() {
		return shoppingDate;
	}
	public void setShoppingDate(String shoppingDate) {
		this.shoppingDate = shoppingDate;
	}

}
