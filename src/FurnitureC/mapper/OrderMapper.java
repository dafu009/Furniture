package FurnitureC.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import FurnitureC.bean.order;
import FurnitureC.bean.orderItem;

public interface OrderMapper {
	
	@Select("select id,orderCode,totalMoney,orderDate from orderform where userID = #{userID} order by orderDate desc")
	List<Map<String, Object>> viewOrder(@Param("userID")Integer userID);

	@Select("select * from orderitem where orderFormID=#{orderFormID}")
	List<Map<String, Object>> viewOrderItem(@Param("orderFormID")Integer orderFormID);

	@Insert("insert into orderform(orderCode,userID,totalNum,totalMoney,orderDate) values (#{orderCode},#{userID},#{totalNum},#{totalMoney},#{orderDate})")
	@SelectKey(before = false, keyProperty = "id", resultType = int.class, statement = {"SELECT LAST_INSERT_ID() as id"})
	Integer addOrder(order Order);//需要返回值

	@Insert("insert into orderitem(orderFormID,goodsID,num,price) values (#{orderFormID},#{goodsID},#{num},#{price})")
	void addOrderItem(orderItem OrderItem);
}
