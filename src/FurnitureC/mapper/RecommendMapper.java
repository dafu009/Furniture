package FurnitureC.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import FurnitureC.bean.Recommend;

public interface RecommendMapper {

	
	@Select("select * from recommend where userID = #{userid}")
	List<Recommend> sizeOfRecommend(@Param("userid")Integer userid);

}
