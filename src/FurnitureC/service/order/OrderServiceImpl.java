package FurnitureC.service.order;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FurnitureC.bean.order;
import FurnitureC.bean.orderItem;
import FurnitureC.mapper.OrderMapper;
import FurnitureC.service.order.OrderService;

@Service("OrderService")

public class OrderServiceImpl implements OrderService {
	@Autowired
    private OrderMapper orderMapper;
	
	@Override
	public List<Map<String, Object>> ViewOrder(Integer userID) {
		// TODO Auto-generated method stub
		return orderMapper.viewOrder(userID);
	}

	@Override
	public List<Map<String, Object>> ViewOrderItem(Integer orderFormID) {
		// TODO Auto-generated method stub
		return orderMapper.viewOrderItem(orderFormID);
	}

	@Override
	public Integer AddOrderForm(String orderCode, Integer userID,
			Integer totalNum, double totalMoney, String orderDate) {
		// TODO Auto-generated method stub
		order Order = new order();
		Order.setOrderCode(orderCode);
		Order.setUserID(userID);
		Order.setTotalNum(totalNum);
		Order.setTotalMoney(totalMoney);
		Order.setOrderDate(orderDate);
		orderMapper.addOrder(Order);
		
		return Order.getId();
	}

	@Override
	public void AddOrderItem(String orderFormID, String goodsID, String num,
			String price) {
		// TODO Auto-generated method stub
		orderItem OrderItem = new orderItem();
		OrderItem.setOrderFormID(orderFormID);
		OrderItem.setgoodsID(goodsID);
		OrderItem.setNum(num);
		OrderItem.setPrice(price);
		orderMapper.addOrderItem(OrderItem);
	}

}
