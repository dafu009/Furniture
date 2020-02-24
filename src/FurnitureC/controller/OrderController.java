package FurnitureC.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import FurnitureC.bean.GetList;
import FurnitureC.bean.GetRandomId;
import FurnitureC.bean.order;
import FurnitureC.service.goods.GoodsService;
import FurnitureC.service.category.CategoryService;
import FurnitureC.service.order.OrderService;
import FurnitureC.service.shoppingcart.ShoppingCartService;

@Controller
public class OrderController {
	@Autowired
	@Qualifier("OrderService")
	private OrderService orderService;
	
	@Autowired
	@Qualifier("ShoppingCartService")
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	@Qualifier("GoodsService")
	private GoodsService goodsService;
	
	@Autowired
	@Qualifier("CategoryService")
	private CategoryService categoryService;
	
	
	/**
	 * 实现/addorder的订单增加
	 */
	@RequestMapping("/addOrder")
	@ResponseBody
	public Map<String,Object> addOrder(GetList paras,HttpServletRequest req){
		return null;
		
	}
	
	
	
	
	
	/**
	 * 实现/order我的订单显示
	 */
	@RequestMapping("/viewOrder")
	@ResponseBody
	public Map<String, Object> viewOrder(Integer id) {
		List<Map<String, Object>> Itemlist = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> orderlists = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> ALLorder = new ArrayList<Map<String, Object>>();
		Map<String, Object> goodsInfo = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Integer orderID,orderFormID,goodsID;
		int code;
		String state, message;
		try{
			if(id != 0){
				Integer userID = id;
				orderlists = orderService.ViewOrder(userID);
				for (int i = 0 ; i <orderlists.size(); i++){
					orderFormID = Integer.parseInt(orderlists.get(i).get("id").toString());
					Itemlist = orderService.ViewOrderItem(orderFormID);
//					System.out.println(orderFormID);
//					System.out.println(orderItemlist);
					for(int j = 0; j < Itemlist.size(); j++){
						goodsID = Integer.parseInt(Itemlist.get(j).get("goodsID").toString());
						goodsInfo = goodsService.GetGoodsInfo(goodsID);
						Itemlist.get(j).putAll(goodsInfo);
					}
					orderID = Integer.parseInt(Itemlist.get(0).get("orderFormID").toString());
//					System.out.println(orderFormID);
//					System.out.println("hi");
//					System.out.println(orderID);
					if(orderID == orderFormID){
						orderlists.get(i).put("itemList", Itemlist);
						ALLorder.add(orderlists.get(i));	
					}
//					System.out.println(orderlist);
				}
				result.put("orderlist", ALLorder);
				code = 200;
				state = "success";
				message = "成功";
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", result);
//				System.out.println(map);
				return map;	 
				
			}else{
				result.put("orderlist", ALLorder);
				code = 0;
				state = "fail";
				message = "失败";
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", result);
//				System.out.println(map);
				return map;
			}
			
		}catch(Exception e){
			System.out.println(e);			
			result.put("orderlist", ALLorder);
			code = 0;
			state = "fail";
			message = "失败";
			map.put("code", code);
			map.put("state", state);
			map.put("message", message);
			map.put("result", result);
//			System.out.println(map);
			return map;
		}
	}
	
	
	

}
