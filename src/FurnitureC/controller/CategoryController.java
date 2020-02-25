package FurnitureC.controller;


import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import FurnitureC.bean.Category;
import FurnitureC.service.category.CategoryService;

public class CategoryController {

	@Autowired
	@Qualifier("CategoryService")
	private CategoryService categoryService;
	
	/**
     * 返回/index的家具类别导航
     */		
	
    @RequestMapping("/getgoodsCategory")
    @ResponseBody
    public Map<String,Object> getgoodsCategory(Category category){
    	List<Category> GoodsCategoryList;
    	Map<String,Object> map = new HashMap<String,Object>();
    	int code;
    	String state,message;
    	try{
    	GoodsCategoryList = categoryService.ViewCategoryName(category);
    	code = 200;
    	state = "success";
    	message = "成功";
    	map.put("state", state);
    	map.put("code", code);
    	map.put("message", message);
    	map.put("resule", GoodsCategoryList);
		return map;
    	}catch(Exception e){
    		System.out.println(e);
    		code = 0;
    		state = "fail";
    		message = "失败";
    		map.put("state", state);
    		map.put("code", code);
    		map.put("message", message);
			map.put("result", null);
//			System.out.println(map);
			return map;
    	}
    	}
    }	
    	
    
	

