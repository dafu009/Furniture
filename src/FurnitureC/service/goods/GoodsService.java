package FurnitureC.service.goods;

import java.util.List;
import java.util.Map;

import FurnitureC.bean.goods;


public interface GoodsService {

	//获取家具详情
	Map<String,Object> GoodsDetail(goods Goods,Integer id);
	
	//用类别获取家具
	List<Map<String,Object>> GoodsTypeDetail(goods Goods , Integer id, Integer page, Integer pageSize);
	//获取所有的家具
	List<Map<String, Object>> GoodsTypeAll(goods Goods , Integer page, Integer pageSize);

	//获取全部家具
	List<goods> GoodsAll(goods Goods);
	
	//根据家具类别获取家具
	List<goods> GoodsType(goods Goods, Integer id);

	//根据家具编号获取家具信息
	Map<String, Object> GetGoods(Integer id);
	
	//模糊搜索
	List<Map<String, Object>> Searchgoods(Integer page, Integer pageSize, String content);
	
	List<Map<String, Object>> SearchgoodsAll(String content);
	
	//根据某家具驹编号获取家具信息
	Map<String, Object> GetGoodsInfo(Integer goodsID);
	
	//获取某家具的库存
	Map<String, Object> GetQuantity(Integer goodsID);
	

	//修改某家具库存（库存减少）
	void ChangeQuantity(Integer goodsID, Integer quantity);
	
	//库存增加
	void AddChangeQuantity(Integer goodsID, Integer quantity);
	
	//我的订单、完成订单猜你喜欢推荐书本详情
	List<goods> LikeRecGoods(goods Goods, long goodsID, Integer page, Integer pageSize);
	
	List<goods> LikeRecGoodsAll(goods Goods, long goodsID);
	
	//详情页推荐随机抽取除了那本书
	List<Map<String, Object>> RandomGoods(goods Goods, Integer goodsID, Integer page, Integer pageSize);

	List<Map<String, Object>> RandomAllGoods(goods Goods, Integer goodsID);
	

	//获取用户收藏其他的书详情
	List<Map<String, Object>> RecGoods(goods Goods, Integer recgoodsId, Integer page, Integer pageSize);

	List<Map<String, Object>> RecGoodsAll(goods Goods, Integer recgoodsId);
	
	//推荐随机抽取数据
	List<goods> RandomGoodsexc(goods Goods,Integer page, Integer pageSize);
}
