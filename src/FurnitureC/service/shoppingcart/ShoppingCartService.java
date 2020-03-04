package FurnitureC.service.shoppingcart;

import java.util.List; 
import java.util.Map;

import FurnitureC.bean.shoppingcart;

public interface ShoppingCartService {
	
	//购物车列表
	//遍历List<Map<String,Object>>数据结构，map中所有的key和value
	List<Map<String,Object>> ShoppingCartList(shoppingcart shoppingCart,int id);
	
	//删除购物车
	void DeleteShoppingCart(int carid);
	
	//根据购物车编号搜索
	Map<String,Object> SearchShoppingCart(int carid);
	
	//更改购物车物品数量
	void ChangeGoodsNum(Integer carid, Integer num);
	
	void ChangeCarNum(Integer carid, Integer num , String shoppingDate);
	
	//加入购物车
	void AddCart(Integer userID, Integer goodsID, Integer num, String shoppingDate);
	
	//查找某条购物车记录
	Map<String,Object> FindShoppingCart(int userID, int goodsID);
	
	//删除某条购物车记录
	void DeleteShoppingCartWithOrder(Integer userID, String goodsID);
	
	
	
	
	
	
	
}
