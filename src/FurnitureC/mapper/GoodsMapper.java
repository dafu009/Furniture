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
	
	@Select("select * from goods where categoryID=#{id} limit #{page},#{pageSize}")//limit�Ӿ���Ա�����ǿ�� SELECT ��䷵��ָ���ļ�¼��
	List<Map<String,Object>> GetTypeDetail(goods Goods,@Param("page")Integer page,@Param ("pageSize")Integer pageSize);
	
	@Select("select * from goods limit #{page},#{pageSize}")
	List<Map<String,Object>> GetGoodsTypeAll(goods Goods,@Param("page")Integer page,@Param ("pageSize")Integer pageSize);
	
	@Select("select * from goods")
	List<goods> GetGoodsAll(goods Goods);
	
	@Select("select * from goods where categoryID = #{id} ")
	List<goods> GetGoodsType(goods Goods,@Param("id")Integer id);
	

}
