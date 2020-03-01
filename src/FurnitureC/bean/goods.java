package FurnitureC.bean;

public class goods{
	private Integer id;
	private String goodsName;
	private String categoryID;
	private String picInfo;
	private String inPrice;
	private String quantity;
	private String detail;
	private String size;
	private String color;
	
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getgoodsName(){
		return goodsName;
	}
	public void setgoodsName(String goodsName){
		this.goodsName = goodsName;
	}
	public String getcategoryID(){
		return categoryID;
	}
	public void setcategoryID(String categoryID){
		this.categoryID = categoryID;
	}
	public String getpicInfo(){
		return picInfo;
	}
	public void setpicInfo(String picInfo){
		this.picInfo = picInfo;
	}
	public String getinPrice(){
		return inPrice;
	}
	public void setinPrice(String inPrice){
		this.inPrice = inPrice;
	}
	public String getquantity(){
		return quantity;
	}
	public void setquantity(String quantity){
		this.quantity = quantity;
	}
	public String getdetail(){
		return detail;
	}
	public void setdetail(String detail){
		this.detail = detail;
	}
	public String getsize(){
		return size;
	}
	public void setsize(String size){
		this.size = size;
	}
	public String getcolor(){
		return color;
	}
	public void setcolor(String color){
		this.color = color;
	}
}

