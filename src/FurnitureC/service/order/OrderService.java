package FurnitureC.service.order;
import java.util.List;
import java.util.Map;

public interface OrderService {
	//订单显示
	List<Map<String,Object>> ViewOrder(Integer userID);

	List<Map<String, Object>> ViewOrderItem(Integer orderFormID);
	
	//订单添加
	Integer AddOrderForm(String orderCode,Integer userID,Integer totalNum,double totalMoney,String orderDate);
	void AddOrderItem(String orderFormID, String goodsID, String num,String price);
	

}
