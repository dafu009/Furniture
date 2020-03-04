package FurnitureC.controller;

import java.util.ArrayList;
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

import com.alibaba.fastjson.JSON;
import FurnitureC.bean.Collect;
import FurnitureC.bean.GetList;
import FurnitureC.service.goods.GoodsService;
import FurnitureC.service.collect.CollectService;


@Controller
public class CollectController {
	
	@Autowired
	@Qualifier("GoodsService")
	private GoodsService goodsService;
	@Autowired
	@Qualifier("CollectService")
	private CollectService collectService;
	
	/**
	 * 返回/mylike的收藏列表
	 */
	@RequestMapping("/getcollect")
	@ResponseBody
	
	public Map<String,Object> getcollect(Collect collect,Integer id){
		List<Map<String,Object>> CollectList =new ArrayList<Map<String, Object>>();
		Map<String, Object> goods;
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int code,goodsID = 0;
		
		String state, message;
		try{
			if(id != 0){
				
				Integer userID = id;
				CollectList = collectService.CollectList(collect, userID);
			
				for(int i = 0 ; i < CollectList.size();i++){
					
					String str = "goodsid";
					//Map.Entry是Map的一个内部接口，entrySet返回的是Set集合，相当于Map的一对值
					for(Entry<String,Object> key : CollectList.get(i).entrySet()){
						
						if(str.equals(key.getKey())){
							
							goodsID = Integer.parseInt((String) key.getValue());
		//					System.out.println(goodsID);
						}
					}
					goods = goodsService.GetGoods(goodsID);
//					System.out.println(JSON.toJSONString(goods));
					//putAll()可以结合两个Map，相同的key，后面的会覆盖前面的
					CollectList.get(i).putAll(goods);
//					System.out.println(CollectList(i));
				}
				result.put("goodsList", CollectList);
//				System.out.println(JSON.toJSONString(result));
				code = 200;
				state = "success";
				message = "成功";
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", result);
	//			System.out.println(map);
				return map;
			}else{
				code = 0;
				state = "fail";
				message = "失败";
				result.put("goodsList", CollectList);
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", result);
	//			System.out.println(map);
				return map;
			}
		}catch(Exception e){
			System.out.println(e);
			code = 0;
			state = "fail";
			message = "失败";
			result.put("goodsList", CollectList);
			map.put("code", code);
			map.put("state", state);
			map.put("message", message);
			map.put("result", result);
	//		System.out.println(map);
			return map;
		}
	}
	/**
	 * /mylike的删除
	 */
	@RequestMapping("/DeletelCollect")
	@ResponseBody
	public Map<String, Object> DeleteCollect(GetList paras,HttpServletRequest req) {
		
		List<Map<String,Object>> idlist = paras.getIdlist();
		Integer id = paras.getId();
		Integer likeid   = null;
		Map<String, Object> searchCollect = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int code, flag;
		String state, message;
		try{
			if(id != 0 & !idlist.isEmpty()){
				for(int i =0 ; i < idlist.size(); i++){
					likeid = Integer.parseInt(idlist.get(i).get("likeid").toString());
					searchCollect = collectService.SearchCollect(likeid);
					if(searchCollect != null){
						collectService.DeleteCollect(likeid);
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
				flag =0;
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
