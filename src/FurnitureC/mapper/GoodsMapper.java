package FurnitureC.mapper;

import java.util.List; 
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import FurnitureC.bean.goods;

public interface GoodsMapper {
	
	@Select("select * from goods where id=#{id}")
	Map<String,Object> GetGoodsDetail(goods Goods ,@Param("id") Integer id);
	
	@Select("select * from goods where categoryID=#{id} limit #{page},#{pageSize}")//limit子句可以被用于强制 SELECT 语句返回指定的记录数
	List<Map<String,Object>> GetTypeDetail(goods Goods,@Param("id")Integer id,@Param("page")Integer page,@Param ("pageSize")Integer pageSize);
	
	@Select("select * from goods limit #{page},#{pageSize}")
	List<Map<String,Object>> GetGoodsTypeAll(goods Goods,@Param("page")Integer page,@Param ("pageSize")Integer pageSize);
	
	@Select("select * from goods")
	List<goods> GetGoodsAll(goods Goods);
	
	@Select("select * from goods where categoryID = #{id} ")
	List<goods> GetGoodsType(goods Goods,@Param("id")Integer id);
	
	@Select("select goodsName,picInfo,inPrice,color from goods where id=#{id}")
	Map<String,Object> getgoods(@Param("id")Integer id);
	
	@Select("select * from goods where goodsName like #{content} or color like #{content} limit #{page},#{pageSize}")
	List<Map<String,Object>> getsearchgoods(@Param("page")Integer page, @Param("pageSize")Integer pageSize, @Param("content")String content);
	
	@Select("select * from goods where goodsName like #{content} or color like #{content}")
	List<Map<String,Object>> getsearchgoodsAll (@Param("content")String content);
	
	@Select("select goodsName,picInfo,color from goods where id = #{goodsID}")
	Map<String,Object> getgoodsInfo(@Param("goodsID")Integer goodsID);
	
	@Select("select quantity from goods where id = #{goodsID}")
	Map<String,Object> getQuantity(@Param("goodsID") Integer goodsID);
			
	@Update("update goods set quantity = #{quantity} where id = #{goodsID}")
	void changeQuantity (@Param("goodsID")Integer goodsID,@Param("quantity")Integer quantity);
	
	//我的订单、完成订单猜你喜欢推荐书本详情
	@Select("select * from goods where id = #{goodsID} limit #{page},#{pageSize}")
	List<goods> getLikeRecGoods(goods Goods, @Param("goodsID")long goodsID, @Param("page")Integer page, @Param("pageSize")Integer pageSize);

	@Select("select * from goods where id = #{goodsID}")
	List<goods> getLikeRecGoodsAll(goods Goods, @Param("goodsID")long goodsID);
	
	//详情页推荐随机抽取除了那本书
	@Select("select * from goods where id <> #{goodsID} order by rand() limit #{page},#{pageSize}")
	List<Map<String, Object>> randomGoods(goods Goods, @Param("goodsID")Integer goodsID, @Param("page")Integer page, @Param("pageSize")Integer pageSize);

	@Select("select * from goods where id <> #{goodsID}")
	List<Map<String, Object>> randomAllGoods(goods Goods, @Param("goodsID")Integer goodsID);
	
	//获取用户收藏其他的书详情
	@Select("select * from goods where id = #{recgoodsId} limit #{page},#{pageSize}")
	List<Map<String, Object>> getRecGoods(goods Goods, @Param("recgoodsId")Integer recgoodsId, @Param("page")Integer page, @Param("pageSize")Integer pageSize);

	@Select("select * from goods where id = #{recgoodsId}")
	List<Map<String, Object>> getRecGoodsAll(goods Goods, @Param("recgoodsId")Integer recgoodsId);
	
	@Select("select * from goods order by rand() limit #{page},#{pageSize}")
	List<goods> randomGoodsexc(goods Goods, @Param("page")Integer page, @Param("pageSize")Integer pageSize);

}
