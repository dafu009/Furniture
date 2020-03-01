package FurnitureC.mapper;

import java.util.List; 
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;

import FurnitureC.bean.Collect;

public interface CollectMapper {
	@Insert("insert into collect(userID,bookID,collectDate) values (#{userID},#{bookID},#{collectDate})")
	void addLike(Collect collect);//不需要返回值，只用调用数据库
	
	//查找收藏列表
	@Select("select * from collect where userID=#{userID} and goodsID=#{goodsID}")
	Map<String, Object> findCollect(@Param("userID")Integer userID, @Param("goodsID")Integer goodsID);
	
	//根据用户查找收藏
	@Select("select id,goodsID as goodsid from collect where userID = #{userID} order by collectDate desc")
	List<Map<String, Object>> collectList(Collect collect, @Param("userID")Integer id);
	
	//根据收藏编号返回收藏记录
	@Select("select * from collect where id = #{likeid}")
	Map<String, Object> searchCollect(@Param("likeid")Integer likeid);
	
	//删除某条收藏记录
	@Delete("delete from collect where id=#{likeid}")
	void deleteCollect(@Param("likeid")int likeid);	
	
	//查询收藏家具的用户
	@Select("select userID from collect where goodsID=#{goodsID}")
	List<Map<String, Object>> findCollectWithgoodsID(@Param("goodsID")Integer goodsID);
	
	//拿到某个人除这件物品外其余的物品
	@Select("select goodsID as goodsid from collect where userID = #{userID} and goodsID <> #{goodsID} ")
	List<Map<String, Object>> getgoodsNot(@Param("userID")Integer userID, @Param("goodsID")Integer goodsID);
	
	
}
