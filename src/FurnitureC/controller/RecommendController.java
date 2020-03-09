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
	 * ����/goodsdetail�����Ƽ�
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
					userList = collectService.FindCollectWithgoodsId(goodsid); //��ȡ�ղ������Ʒ������userID
					if(userList.size() == 0){
						GoodsList = goodsService.RandomGoods(Goods, goodsid, page, pageSize);
						GoodsListCount = goodsService.RandomAllGoods(Goods, goodsid);
					}else{
						Integer userID = null;
						Integer recommendgoodsID = null;
						for (int i =0 ; i <userList.size(); i++){
							userID = Integer.parseInt(userList.get(i).get("userID").toString()); //��ȡuserID
						
							if(userID != userid){
								recgoodsList = collectService.GetUser(userID, goodsid); //��ȡĳ���ղس��������Ʒ���������Ʒ
//								int num =10;
								if(recgoodsList.size() <= 10){ //���Ƽ���������10��ʱ��
									Integer Randompage = 10 - recgoodsList.size();
									for(int j = 0; j <recgoodsList.size(); j++){
										recommendgoodsID = Integer.parseInt(recgoodsList.get(j).get("goodsID").toString()); //��ȡ���Ƽ���Ʒ��goodsID
										
										GoodsList = goodsService.RecGoods(Goods, recommendgoodsID, page, recgoodsList.size()); //����ID��ȡ����
	//									System.out.println(GoodsList);	
										AllGoodsList.addAll(j, GoodsList);
									}
									GoodsListRandom = goodsService.RandomGoods(Goods, goodsid, page, Randompage); //�����ȡ������Ʒ���������Ʒ
									AllGoodsList.addAll(GoodsListRandom);
									GoodsList = AllGoodsList;
									total = GoodsList.size();
									result.put("total", total);
									result.put("GoodsList", GoodsList);
									code = 200;
									state = "success";
									message = "�ɹ�";
									map.put("code", code);
									map.put("state", state);
									map.put("message", message);
									map.put("result", result);
	//				    			System.out.println(map);
									return map;
								}else{
									for(int k = 0; k<recgoodsList.size(); k++){
										recommendgoodsID = Integer.parseInt(recgoodsList.get(k).get("goodsID").toString()); //��ȡ���Ƽ���Ʒ��goodsID
										
										GoodsList = goodsService.RecGoods(Goods, recommendgoodsID, page, pageSize);
										GoodsListCount = goodsService.RecGoodsAll(Goods, recommendgoodsID);
									}
									total = GoodsListCount.size();
									result.put("total", total);
									result.put("GoodsList", GoodsList);
									code = 200;
									state = "success";
									message = "�ɹ�";
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
								message = "�ɹ�";
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
					message = "�ɹ�";
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
				message = "�ɹ�";
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", result);
//				System.out.println(map);
				return map;
			}else{
				total = 0;
				result.put("total", total);
				result.put("GoodsList", GoodsList);
				code = 0;
				state = "fail";
				message = "ʧ��";
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
			message = "ʧ��";
			map.put("code", code);
			map.put("state", state);
			map.put("message", message);
			map.put("result", result);
//			System.out.println(map);
			return map;
		}
	}
	
	/**
	 * ����/okbuy_yes��/myorder�Ĳ���ϲ���Ƽ�
    */	
	@PostMapping("/getRecommendGoodsLike")
	@ResponseBody
	public Map<String, Object> getRecommendGoodsLike(goods Goods, Integer userid,Integer page, Integer pageSize) {
//		System.out.println(userId+","+page+","+pageSize);			
		List<goods> GoodsList = new ArrayList<goods>();
		List<goods> GoodsListRandom = new ArrayList<goods>();
		List<goods> AllGoodsList = new ArrayList<goods>();
		List<goods> GoodsListcount = new ArrayList<goods>();
		List<Recommend> SizeOfRecommend = new ArrayList<Recommend>();
		List<RecommendedItem> recommendations = new ArrayList<RecommendedItem>();
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int code,total;
		String state,message;
		try{
			if(userid != null & page != 0 & pageSize != 0){
				if(userid == 0){ //δ��¼ʱ,�����ȡ�����Ƽ�
					GoodsList = goodsService.RandomGoodsexc(Goods, page, pageSize);
				}else{
					SizeOfRecommend = recommendService.SizeOfRecommend(userid);
					if(SizeOfRecommend.size()==0){ //����userIDδ����Ʒ����ʱ��������Ƽ�
						GoodsList = goodsService.RandomGoodsexc(Goods, page, pageSize);
						GoodsListcount = goodsService.GoodsAll(Goods); // ��ȡȫ����Ʒ����
					}else{ //������л�����Ʒ���Ƽ�
						recommendations = recommendService.LikeRecommend(userid);
						long goodsID = 0;
						if(recommendations.size()<= 10){ //һ���Ƽ�10�����ݣ���������Ʒ�Ƽ���������С��10ʱ
							Integer Randompage = 10 - recommendations.size();
							for(RecommendedItem recommendation : recommendations){
								goodsID = recommendation.getItemID(); //��ȡ���ݿ��е�goodsID���л�����Ʒ�Ƽ�
								GoodsList = goodsService.LikeRecGoods(Goods, goodsID, page, Randompage); 
								AllGoodsList.addAll(GoodsList);
							}
							//��ʣ�����������������Ƽ�
							GoodsListRandom = goodsService.RandomGoodsexc(Goods, page, Randompage);
							AllGoodsList.addAll(GoodsListRandom);
							GoodsList = AllGoodsList; 
							
						}else{ //������������10��ʱ,ֱ�ӻ�����Ʒ�Ƽ�
							for (RecommendedItem recommendation : recommendations) {
								goodsID = recommendation.getItemID();
								
							}
							GoodsList = goodsService.LikeRecGoods(Goods, goodsID, page, pageSize);
							GoodsListcount = goodsService.LikeRecGoodsAll(Goods, goodsID);
						}
					}
				}
				total=GoodsListcount.size();
//        		System.out.println(nCount);
            	result.put("total", total);
            	result.put("GoodsList", GoodsList);
            	code=200;
    			state="success";
    			message="�ɹ�";
    			map.put("code", code);
    			map.put("state", state);	
    			map.put("message", message);
    			map.put("result", result);
//    			System.out.println(map);
        		return map;
			}else{
				total=0;
				result.put("total", total);
            	result.put("GoodsList", GoodsList);
            	code=0;
    			state="fail";
    			message="ʧ��";
    			map.put("code", code);
    			map.put("state", state);	
    			map.put("message", message);
    			map.put("result", result);
//    			System.out.println(map);
        		return map;
			}
		}catch(Exception e){
			System.out.println(e);
			total=0;
			result.put("total", total);
        	result.put("GoodsList", GoodsList);
        	code=0;
			state="fail";
			message="ʧ��";
			map.put("code", code);
			map.put("state", state);	
			map.put("message", message);
			map.put("result", result);
//			System.out.println(map);
    		return map;
		}
	}
}
