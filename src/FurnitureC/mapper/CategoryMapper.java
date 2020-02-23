package FurnitureC.mapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import FurnitureC.bean.Category;

public interface CategoryMapper {
	@Select("select id,categoryName from category")
    List<Category> getAllWithCategoryName(Category category);
	
	@Select("select categoryName from category where id=#{id}")
    Map<String, Object> getWithCategoryName(@Param("id")int id);
}
