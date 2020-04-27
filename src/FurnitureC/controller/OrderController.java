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
	 * ʵ��/addorder�Ķ�������
	 */
	@RequestMapping("/addOrder")
	@ResponseBody
	public Map<String,Object> addOrder(GetList paras,HttpServletRequest req){
//		System.out.println(paras.getId() + "/" + paras.getIdlist());
		List<Map<String,Object>> idlist = paras.getIdlist();
		Integer id = paras.getId();
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int code, flag;
		String state, message;
		try{
			if(id != 0 & !idlist.isEmpty()){
				GetRandomId randomId = new GetRandomId();
				String orderCode = randomId.getRandomFileName();
				Integer userID = id;
				Integer num1,num2 = null;
				Integer totalNum = null;
				double inPrice;
				double totalMoney = 0;
				double money1,money2 = 0;
				String strmoney1,strmoney2;
				//�̶�����ת����ʽ
				java.text.DecimalFormat format = new java.text.DecimalFormat("#0.00");
		
				if(idlist.size() == 1){
					num1 = Integer.parseInt(idlist.get(0).get("num").toString());
					inPrice = Double.parseDouble(idlist.get(0).get("inPrice").toString());
	//				strmoney1 = idlist.get(0).get("inPrice").toString();
	//				inPrice = Double.parseDouble(strmoney1);//ת����double����
					money1 = Double.parseDouble(format.format(inPrice));
					totalNum = num1;
					totalMoney = money1*num1;
				}else{
					for(int i = 0; i <idlist.size(); i++){
						num1 = Integer.parseInt(idlist.get(i).get("num").toString());
						inPrice = Double.parseDouble(idlist.get(i).get("inPrice").toString());
						money1 = Double.parseDouble(format.format(inPrice));
						for(int j = 0;j<idlist.size();j++){
							num2 = Integer.parseInt(idlist.get(j).get("num").toString());
							inPrice = Double.parseDouble(idlist.get(j).get("inPrice").toString());
							money2 = Double.parseDouble(format.format(inPrice));
							totalNum = num1+num2;
							totalMoney = money1 * num1 + money2 * num2;
	//						System.out.println(totalMoney);
							break;
						}
					}
				}
				Date date = new Date();
				SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
				String orderDate = formatDate.format(date);
				Integer ID = orderService.AddOrderForm(orderCode, userID, totalNum, totalMoney, orderDate);
				String orderFormID = ID.toString();
				
				
				for(int k =0; k<idlist.size();k++){
					String goodsID = idlist.get(k).get("goodsid").toString();
					String num = idlist.get(k).get("num").toString();
					String price = idlist.get(k).get("inPrice").toString();
					orderService.AddOrderItem(orderFormID, goodsID, num, price);
					//�ӹ��ﳵ���Ƴ�
					shoppingCartService.DeleteShoppingCartWithOrder(userID, goodsID);
				}
				flag = 1;
				message = "�ɹ�";
				result.put("flag", flag);
				result.put("message", message);
				code = 200;
				state = "success";
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", result);
	//			System.out.println(map);
				return map;	 
			}else{
				flag = 0;
				message = "ʧ��";
				result.put("flag", flag);
				result.put("message", message);
				code = 0;
				state = "fail";
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", result);
	//			System.out.println(map);
				return map;
			}
			
		}catch(Exception e){
			System.out.println(e);
			flag = 0;
			message = "ʧ��";
			result.put("flag", flag);
			result.put("message", message);
			code = 0;
			state = "fail";
			map.put("code", code);
			map.put("state", state);
			map.put("message", message);
			map.put("result", result);
	//		System.out.println(map);
			return map;
		}
		
	}
		
	
	
	/**
	 * ʵ��/order�ҵĶ�����ʾ
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
//					System.out.println(Itemlist);
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
				message = "ʧ��";
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
			message = "ʧ��";
			map.put("code", code);
			map.put("state", state);
			map.put("message", message);
			map.put("result", result);
//			System.out.println(map);
			return map;
		}
	}
	
	
	

}
