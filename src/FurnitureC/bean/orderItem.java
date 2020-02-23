package FurnitureC.bean;

public class orderItem {
	
	private Integer id;
	private String orderFormID;
	private String goodsID;
	private String num;
	private String price;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderFormID() {
		return orderFormID;
	}
	public void setOrderFormID(String orderFormID) {
		this.orderFormID = orderFormID;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}	

}
