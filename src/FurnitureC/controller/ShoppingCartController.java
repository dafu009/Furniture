package FurnitureC.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import FurnitureC.bean.Collect;
import FurnitureC.bean.shoppingcart;
import FurnitureC.bean.GetList;
import FurnitureC.service.goods.GoodsService;
import FurnitureC.service.collect.CollectService;
import FurnitureC.service.shoppingcart.ShoppingCartService;

@Controller
public class ShoppingCartController {
	
	@Autowired
	@Qualifier("ShoppingCartService")
	private ShoppingCartService shoppingCartService;
	@Autowired
	@Qualifier("GoodsService")
	private GoodsService goodsService;
	@Autowired
	@Qualifier("CollectService")
	private CollectService collectService;
	
	
	/**
	 * 返回/shoppingcart的购物车列表
	 */
	@RequestMapping("/getshoppingCart")
	@ResponseBody
	
	public Map<String,Object> getshoppingCart(shoppingcart shoppingCart , Integer id){
		List<Map<String, Object>> shoppingCartList = new ArrayList<Map<String, Object>>();
		Map<String, Object> goods;
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int code, goodsID = 0;
		String state, message;
		try{
			if(id != 0 ){
				shoppingCartList = shoppingCartService.ShoppingCartList(shoppingCart, id);
				
				for(int i =0; i < shoppingCartList.size(); i++){
					String str = "goodsid";
					
					for(Entry<String,Object> key: shoppingCartList.get(i).entrySet()){
//						System.out.println(key);
						if(str.equals(key.getKey())){
							goodsID = Integer.parseInt((String) key.getValue());
//							System.out.println(goodsID);
						}
					}
					goods = goodsService.GetGoods(goodsID);
					
					shoppingCartList.get(i).putAll(goods);
				}
				result.put("goodsList", shoppingCartList);
//				System.out.println(JSON.toJSONString(result));

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
				code = 0;
				state = "fail";
				message = "失败";
				result.put("goodsList", shoppingCartList);
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", result);
//				System.out.println(map);
				return map;
			}
		}catch(Exception e){
			System.out.println(e);
			code = 0;
			state = "fail";
			message = "失败";
			result.put("goodsList", shoppingCartList);
			map.put("code", code);
			map.put("state", state);
			map.put("message", message);
			map.put("result", result);
//			System.out.println(map);
			return map;
		}
	}
	
	/**
	 * 返回/shoppingcart的移去收藏夹
	 */
	@RequestMapping("/movetoCollect")
	@ResponseBody
	public Map<String, Object> MovetoCollect(Integer id, Integer carid, Integer goodsid) {
//		System.out.println(id + "/" + carid + "/" + goodsid);
		Map<String,Object> ListShoppingCart = new HashMap<String,Object>();
		Map<String, Object> findCollect = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int code, flag;
		String state, message;
		try{
			if(id != 0 & goodsid != 0 & carid != 0){
				ListShoppingCart = shoppingCartService.SearchShoppingCart(carid);
//				System.out.println(ListShoppingCart);
				if(!ListShoppingCart.isEmpty()){
					Integer userID = id;
					Integer goodsID = goodsid;
					findCollect = collectService.FindCollect(userID, goodsID);
					if(findCollect == null){
						Date date = new Date();
						SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String collectDate = formatDate.format(date);
						collectService.AddLike(userID.toString(), goodsID.toString(), collectDate);
						shoppingCartService.DeleteShoppingCart(carid);

					}else{
						flag = 0;
						message = "失败";
						result.put("flag", flag);
						result.put("message", "您的书本已经在收藏夹等您啦！");
						code = 0;
						state = "fail";
						map.put("code", code);
						map.put("state", state);
						map.put("message", message);
						map.put("result", result);
//						System.out.println(map);
						return map;
					}
							
				}
				flag = 1;
				message = "成功";
				result.put("flag", flag);
				result.put("message", message);
				code = 200;
				state = "success";
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", result);
//				System.out.println(map);
				return map;				
			}else{
				flag = 0;
				message = "失败";
				result.put("flag", flag);
				result.put("message", message);
				code = 0;
				state = "fail";
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", result);
//				System.out.println(map);
				return map;
			}
			
			
			
		}
		catch(Exception e){
			System.out.println(e);
			flag = 0;
			message = "失败";
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
		
	}
	
	
	/**
	 * 返回/shoppingcart的删除
	 */
	
	@RequestMapping("/DeleteShoppingCart")
	@ResponseBody
	
	public Map<String, Object> DeleteShoppingCart(GetList paras,HttpServletRequest req) {
//		System.out.println(paras.getId() + "/" + paras.getIdlist());
		List<Map<String, Object>> idlist = paras.getIdlist();
		Integer id = paras.getId();
		Map<String, Object> goodsQuantity = new HashMap<String, Object>();
		Map<String, Object> ListShoppingCart = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int code, flag;
		String state, message;
		try{
			if(id != 0 & !idlist.isEmpty()){
				String goodsid= "goodsID";
				Integer goodsID = 0;
				Integer quantity = 0;
				for(int i =0; i < idlist.size();i++){
					Integer carid = Integer.parseInt(idlist.get(0).get("carid").toString());
					ListShoppingCart = shoppingCartService.SearchShoppingCart(carid);
					if(ListShoppingCart != null){
						shoppingCartService.DeleteShoppingCart(carid);
//						System.out.println(ListShoppingCart);
						for(Entry<String,Object> key : ListShoppingCart.entrySet()){
//							System.out.println(goodsid.equals(key.getKey()));
							if(goodsid.equals(key.getKey())){
								goodsID = Integer.parseInt(key.getValue().toString());
								
					}	
						}
						goodsQuantity = goodsService.GetQuantity(goodsID);
						quantity = Integer.parseInt(goodsQuantity.get("quantity").toString());
//						System.out.println(quantity);
						goodsService.ChangeQuantity(goodsID, quantity);
					}
				}
				flag = 1;
				message = "成功";
				result.put("flag", flag);
				result.put("message", message);
				code = 200;
				state = "success";
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
			    map.put("result", result);
//				System.out.println(map);
				return map;
				
				
			}else{
				flag = 0;
				message = "失败";
				result.put("flag", flag);
				result.put("message", message);
				code = 0;
				state = "fail";
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", result);
//				System.out.println(map);
				return map;
			}		
		}catch(Exception e){
			System.out.println(e);
			flag = 0;
			message = "失败";
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
	
	}
	
	/**
	 * 返回/shoppingcart的更改购物车图书数量
	 */
	@RequestMapping("/changegoodsNum")
	@ResponseBody
	public Map<String, Object> ChangegoodsNum(Integer id, Integer carid, Integer num) {
		Map<String, Object> ListShoppingCart = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int code, flag;
		String state, message;
		try{
			ListShoppingCart = shoppingCartService.SearchShoppingCart(carid);
			if(id != 0 & carid != 0 & num != null){
				if(ListShoppingCart != null){
					shoppingCartService.ChangeGoodsNum(carid, num); //直接改变物品数量Num
				}
				flag = 1;
				message = "成功";
				result.put("flag", flag);
				result.put("message", message);
				code = 200;
				state = "success";
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", result);
//				System.out.println(map);
				return map;
			}else{
				flag = 0;
				message = "失败";
				result.put("flag", flag);
				result.put("message", message);
				code = 0;
				state = "fail";
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", result);
//				System.out.println(map);
				return map;
			}
		}catch (Exception e){
			System.out.println(e);
			flag = 0;
			message = "失败";
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
	}
	/**
	 * 加入收藏与购物车
	 */
	@RequestMapping("/addLikeCart")
	@ResponseBody
	public Map<String, Object> addLikeCart(Integer id, Integer sign, Integer goodsid) {
//		System.out.println(id+"/"+mark+"/"+goodsid);
		Map<String, Object> goodsQuantity = new HashMap<String, Object>();
		Map<String, Object> findShoppingCart = new HashMap<String, Object>();
		Map<String, Object> findCollect = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int code, flag;
		String state, message;
		try{
			if(id != 0 & goodsid != 0){
				Integer userID = id;
				Integer goodsID = goodsid;
				Integer num = 1;
				Date date = new Date();
				SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String shoppingDate = formatDate.format(date);
				//加入购物车
				if(sign == 1){
					
					findShoppingCart = shoppingCartService.FindShoppingCart(userID, goodsID);
					//没有goodsID的家具时
					if(findShoppingCart == null){
						Integer quantity;
						shoppingCartService.AddCart(userID, goodsID, num, shoppingDate);
						goodsQuantity = goodsService.GetQuantity(goodsID);
						quantity = Integer.parseInt(goodsQuantity.get("quantity").toString());
//						System.out.println(quantity);
						goodsService.ChangeQuantity(goodsID, quantity);
					}else{
						//有goodsID的家具时，直接改变num值以及加入时间
						String strid = "id";
						String strnum = "num";
						String strquantity = "quantity";
						Integer carid = 0;
						Integer quantity = 0;
						for(Entry<String,Object> key :findShoppingCart.entrySet() ){
							if(strid.equals(key.getKey())){
								carid = Integer.parseInt(key.getValue().toString()) ;	
							if(strnum.equals(key.getKey())){
								num = Integer.parseInt(key.getValue().toString());
							}
							}
//							System.out.println(key);
						}
//						carid = Integer.parseInt(findShoppingCart.get("carid").toString());
//						num = Integer.parseInt(findShoppingCart.get("num").toString());
//						System.out.println(carid+"/"+num+"/"+shoppingDate);	
						
						shoppingCartService.ChangeCarNum(carid, num, shoppingDate);//直接改变数量Num以及时间
						goodsQuantity = goodsService.GetQuantity(goodsID);
						for(Entry<String, Object> key1 : goodsQuantity.entrySet()) {
							if (strquantity.equals(key1.getKey())) {
								quantity = Integer.parseInt(key1.getValue().toString()) ;	
							}
							
						}
//						quantity = Integer.parseInt(bookQuantity.get("quantity").toString());
						goodsService.ChangeQuantity(goodsID, quantity);
//						System.out.println("next");
//						System.out.println(quantity)
					}
					
				}else if(sign == 0){
					findCollect = collectService.FindCollect(userID, goodsID);
					//加入收藏
					if(findCollect == null){
						String collectDate = formatDate.format(date);
						collectService.AddLike(userID.toString(), goodsID.toString(), collectDate);
					}else{
						flag = 0;
						message = "失败";
						result.put("flag", flag);
						result.put("message", "您已经收藏过此书啦，去收藏夹看看把！");
						code = 0;
						state = "fail";
						map.put("code", code);
						map.put("state", state);
						map.put("message", message);
						map.put("result", result);
//						System.out.println(map);
						return map;
					}
				}
				flag = 1;
				message = "成功";
				result.put("flag", flag);
				result.put("message", message);
				code = 200;
				state = "success";
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", result);
//				System.out.println(map);
				return map;	
				
			}else{
				flag = 0;
				message = "失败";
				result.put("flag", flag);
				result.put("message", message);
				code = 0;
				state = "fail";
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", result);
//				System.out.println(map);
				return map;
			}
		}catch(Exception e){
			System.out.println(e);
			flag = 0;
			message = "失败";
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
		
	}

}
