package FurnitureC.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import FurnitureC.bean.shoppingcart;

public interface ShoppingCartMapper {
	@Select("select id,goodsID,num from shoppingcart where userID = #{id} order by shoppingDate desc")
	List<Map<String,Object>> shoppingCartList(shoppingcart shoppingCart,@Param("id")int id); 
	@Delete("Delete * from shoppingCart where userID = #{carid}")
	void deleteShoppingCart(@Param("id")int carid);
	
	@Select("select * from shoppingcart where id = #{carid}")
	Map<String,Object> searchShoppingCart(@Param("carid")int carid);
	@Update("update shoppingcart set num = #{num} where id = #{carid}")
	void changeCarGoodsNum(@Param("num")Integer num,@Param("carid")Integer carid);
	@Insert("insert into shoppingcart(userID,goodsID,num,shoppingDate) values (#{userID},#{goodsID},#{num},#{shoppingDate})")
	void addCart(@Param("userID")Integer userID, @Param("goodsID")Integer goodsID, @Param("num")Integer num, @Param("shoppingDate")String shoppingDate);
	
	
	@Select("select * from shoppingcart where userID=#{userID} and goodsID=#{goodsID}")
	Map<String, Object> findShoppingCart(@Param("userID")int userID, @Param("goodsID")int goodsID);
	@Update("update shoppingcart set num = #{num},shoppingDate = #{shoppingDate} where id = #{carid}")
	void changeCarNum(@Param("num")Integer num,@Param("carid")Integer carid,@Param("shoppingDate")String shoppingDate);
	@Delete("delete from shoppingcart where userID=#{userID} and goodsID=#{goodsID}")
	void delShoppingCartWithOrder(@Param("userID")Integer userID, @Param("goodsID")String goodsID);
}
