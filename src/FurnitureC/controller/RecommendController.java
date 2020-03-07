package FurnitureC.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import FurnitureC.bean.Collect;
import FurnitureC.bean.goods;
import FurnitureC.bean.Recommend;
import FurnitureC.service.goods.GoodsService;
import FurnitureC.service.collect.CollectService;
import FurnitureC.service.recommend.RecommendService;

@Controller
public class RecommendController {

	@Autowired
	@Qualifier("CollectService")
	private CollectService collectService;
	@Autowired
	@Qualifier("GoodsService")
	private GoodsService goodsService;
	@Autowired
	@Qualifier("RecommendService")
	private RecommendService recommendService;
	
	/**
	 * 返回/goodsdetail详情推荐
    */	
	@PostMapping("/recommendGoodsDetail")
	@ResponseBody
	public Map<String, Object> recommendGoodsDetail(goods Goods , Integer userid, Integer goodsid,Integer page, Integer pageSize) {
//		System.out.println(userid+","+goodsid+","+page+","+pageSize);	
		List<Map<String,Object>> GoodsList = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> GoodsListRandom = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> AllGoodsList = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> GoodsListCount = null;
		List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();	
		List<Map<String, Object>> recgoodsList = new ArrayList<Map<String, Object>>();	

		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int code,total;
		String state,message;
		try{
			if(userid != null &page != 0 & pageSize != 0){
				if(userid == 0){
					GoodsList = goodsService.RandomGoods(Goods, goodsid, page, pageSize);
					GoodsListCount = goodsService.RandomAllGoods(Goods, goodsid);
				}else{
					userList = collectService.FindCollectWithgoodsId(goodsid); //获取收藏这件商品的所有userID
					if(userList == null){
						GoodsList = goodsService.RandomGoods(Goods, goodsid, page, pageSize);
						GoodsListCount = goodsService.RandomAllGoods(Goods, goodsid);
					}else{
						Integer userID = null;
						Integer recommendgoodsID = null;
						for (int i =0 ; i <userList.size(); i++){
							userID = Integer.parseInt(userList.get(i).get("userID").toString()); //获取userID
						
							if(userID != userid){
								recgoodsList = collectService.GetUser(userID, goodsid); //获取某人收藏除了这件商品外的其他商品
								int num =10;
								if(recgoodsList.size() <= 10){ //当推荐数量不够10条时候
									Integer Randompage = 10 - recgoodsList.size();
									for(int j = 0; j <recgoodsList.size(); j++){
										recommendgoodsID = Integer.parseInt(recgoodsList.get(j).get("goodsID").toString()); //获取可推荐商品的goodsID
										
										GoodsList = goodsService.RecGoods(Goods, recommendgoodsID, page, recgoodsList.size()); //根据ID获取详情
	//									System.out.println(GoodsList);	
										AllGoodsList.addAll(j, GoodsList);
									}
									GoodsListRandom = goodsService.RandomGoods(Goods, goodsid, page, Randompage); //随机获取除此商品外的其他商品
									AllGoodsList.addAll(GoodsListRandom);
									GoodsList = AllGoodsList;
									total = GoodsList.size();
									result.put("total", total);
									result.put("GoodsList", GoodsList);
									code = 200;
									state = "success";
									message = "成功";
									map.put("code", code);
									map.put("state", state);
									map.put("message", message);
									map.put("result", result);
	//				    			System.out.println(map);
									return map;
								}else{
									for(int k = 0; k<recgoodsList.size(); k++){
										recommendgoodsID = Integer.parseInt(recgoodsList.get(k).get("goodsID").toString()); //获取可推荐商品的goodsID
										
										GoodsList = goodsService.RecGoods(Goods, recommendgoodsID, page, pageSize);
										GoodsListCount = goodsService.RecGoodsAll(Goods, recommendgoodsID);
									}
									total = GoodsListCount.size();
									result.put("total", total);
									result.put("GoodsList", GoodsList);
									code = 200;
									state = "success";
									message = "成功";
									map.put("code", code);
									map.put("state", state);
									map.put("message", message);
									map.put("result", result);
	//				    			System.out.println(map);
									return map;
									}
		
							}else{
								GoodsList = goodsService.RandomGoods(Goods, goodsid, page, pageSize);
								GoodsListCount = goodsService.RandomAllGoods(Goods, goodsid);
								
								total = GoodsListCount.size();
								result.put("total", total);
								result.put("GoodsList", GoodsList);
								code = 200;
								state = "success";
								message = "成功";
								map.put("code", code);
								map.put("state", state);
								map.put("message", message);
								map.put("result", result);
//				    			System.out.println(map);
								return map;
							}
					}
						
					}
					total = GoodsListCount.size();
					result.put("total", total);
					result.put("GoodsList", GoodsList);
					code = 200;
					state = "success";
					message = "成功";
					map.put("code", code);
					map.put("state", state);
					map.put("message", message);
					map.put("result", result);
//				    			System.out.println(map);
					return map;
				}
				total = GoodsListCount.size();
				result.put("total", total);
				result.put("GoodsList", GoodsList);
				code = 200;
				state = "success";
				message = "成功";
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", result);
//				    			System.out.println(map);
				return map;
			}else{
				total = 0;
				result.put("total", total);
				result.put("GoodsList", GoodsList);
				code = 0;
				state = "fail";
				message = "失败";
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", result);
//    			System.out.println(map);
				return map;
			}
		}catch(Exception e){
			System.out.println(e);
			total = 0;
			result.put("total", total);
			result.put("GoodsList", GoodsList);
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
