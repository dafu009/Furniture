package FurnitureC.service.collect;

import java.util.List;
import java.util.Map;
import FurnitureC.bean.Collect;

public interface CollectService {
	//加入收藏
	void AddLike(String userID,String goodsID,String collectDate);
	
	//查询收藏记录
	Map<String,Object> FindCollect(Integer userID, Integer goodsID);
	
	//根据用户编号返回收藏列表
	List<Map<String,Object>> CollectList(Collect collect,Integer userID); 
	
	//根据收藏编号返回收藏
	Map<String,Object> SearchCollect(Integer likeid);
	
	//删除某条收藏记录
	void DeleteCollect(Integer likeid);
	
	//查询收藏这个家具的用户
	List<Map<String,Object>> FindCollectWithgoodsId(Integer goodsID);
	
	List<Map<String,Object>> GetUser(Integer userID,Integer goodsID);
	
	
	
	
	
	
}
