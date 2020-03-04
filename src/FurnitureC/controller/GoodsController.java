package FurnitureC.controller;


import java.util.HashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import FurnitureC.bean.goods;
import FurnitureC.service.goods.GoodsService;
import FurnitureC.service.category.CategoryService;

@Controller
public class GoodsController {
	@Autowired
	@Qualifier("GoodsService")
	private GoodsService goodsService;
	@Autowired
	@Qualifier("CategoryService")
	private CategoryService categoryService;
	
	/**
     * 返回/goodsdetail的家具内容
     */
	@RequestMapping("/getgoodsDetail")
	@ResponseBody  
	public Map<String,Object> getgoodsDetail(goods Goods,Integer id){
//		Map<String, Object> goodsDetail;
//		Map<String, Object> category;
		Map<String, Object> goodsDetailMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int code;
		String state, message;
		try{
			if( id != 0){
				goodsDetailMap = goodsService.GoodsDetail(Goods, id);
	         	code=200;
	    		state="success";
	    		message="成功";
	    		map.put("code", code);
	    		map.put("state", state);	
	    		map.put("message", message);
	    		map.put("result", goodsDetailMap);
//	    		System.out.println(map);
	        	return map;
				
			}else{
				code=0;
    			state="fail";
    			message="失败";
    			map.put("code", code);
    			map.put("state", state);	
    			map.put("message", message);
    			map.put("result", goodsDetailMap);
//    			System.out.println(map);
        		return map;
			}
			
			
		}catch(Exception e){
			System.out.println(e);
        	code=0;
			state="fail";
			message="失败";
			map.put("code", code);
			map.put("state", state);	
			map.put("message", message);
			map.put("result", goodsDetailMap);
//			System.out.println(map);
    		return map;
		}
	}
	
	/**
     * 返回/goodsType的列表 
     */
	
	@RequestMapping("/goodsTypeDetail")
	@ResponseBody  
	public Map<String, Object> getBookTypeDetail(goods Goods, Integer id, Integer page, Integer pageSize) { 
//		System.out.println(id+"/"+page+"/"+pageSize);
		List<Map<String, Object>> AllgoodsTypeDetailList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> goodsTypeDetailList = new ArrayList<Map<String, Object>>();
		Map<String, Object> category;
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int code,nCount;
		String state, message;
		try{
			if( id == 0){ //全部商品
				AllgoodsTypeDetailList = goodsService.GoodsTypeAll(Goods, page, pageSize);
				List<goods> GoodsAllList = goodsService.GoodsAll(Goods);
				nCount=GoodsAllList.size();
//            	System.out.println(nCount);
            	result.put("nCount", nCount);
            	result.put("goodsList", AllgoodsTypeDetailList);
            	code=200;
    			state="success";
    			message="成功";
    			map.put("code", code);
    			map.put("state", state);	
    			map.put("message", message);
    			map.put("result", result);
//    			System.out.println(map);
        		return map;  
			}else{
				//拿某类型商品  
				goodsTypeDetailList = goodsService.GoodsTypeDetail(Goods, id, page, pageSize);
				category = categoryService.GetCatergoryName(id);
				
				if(goodsTypeDetailList.isEmpty()){
					nCount = 0;
				}else{
					List<goods> goodsDetail  = goodsService.GoodsType(Goods, id);
					nCount = goodsDetail.size();
				}
				for (int i = 0 ; i < goodsTypeDetailList.size(); i++){
					goodsTypeDetailList.get(i).putAll(category);
//					System.out.println(goodsTypeDetailList.get(i));	
				}
				result.put("nCount", nCount);
            	result.put("bookList", goodsTypeDetailList);
//            	System.out.println(JSON.toJSONString(result));
            	        		       		        		        		   	       		
            	code=200;
    			state="success";
    			message="成功";
    			map.put("code", code);
    			map.put("state", state);	
    			map.put("message", message);
    			map.put("result", result);
//    			System.out.println(map);
        		return map;   	
			}
		}catch(Exception e ){
			System.out.println(e);
        	code=0;
			state="fail";
			message="失败";
			nCount=0;
			result.put("nCount", nCount);
        	result.put("bookList", goodsTypeDetailList);
			map.put("code", code);
			map.put("state", state);	
			map.put("message", message);
			map.put("result", result);
//			System.out.println(map);
    		return map;
		}
	
	}
	/**
     * 返回/search的搜索结果
     */	
	@RequestMapping("/getsearchGoods")
	@ResponseBody  
	public Map<String, Object> getsearchGoods(goods Goods, Integer page, Integer pageSize, String content) {
//		System.out.println(page+"/"+pageSize+"/"+content);
		List<Map<String, Object>> searchGoodsList = new ArrayList<Map<String, Object>>();
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int code,nCount;
		String state, message;
		try{
			searchGoodsList = goodsService.Searchgoods(page, pageSize, content);
			List<Map<String, Object>> searchgoodsAll = goodsService.SearchgoodsAll(content);
			nCount = searchgoodsAll.size();
//        	System.out.println(nCount);
			result.put("nCount", nCount);
        	result.put("goodsList", searchGoodsList);
//        	System.out.println(result);
        	code=200;
			state="success";
			message="成功";
			map.put("code", code);
			map.put("state", state);	
			map.put("message", message);
			map.put("result", result);
//			System.out.println(map);
    		return map;
		}catch(Exception e){

    		System.out.println(e);
        	code=0;
			state="fail";
			message="失败";
			nCount=0;
			result.put("nCount", nCount);
        	result.put("bookList", searchGoodsList);
			map.put("code", code);
			map.put("state", state);	
			map.put("message", message);
			map.put("result", result);
//			System.out.println(map);
    		return map;	
			
		}
	
	}
	

}
