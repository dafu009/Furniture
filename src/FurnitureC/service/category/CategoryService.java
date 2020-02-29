package FurnitureC.service.category;

import java.util.List;
import java.util.Map;
import FurnitureC.bean.Category;

public interface CategoryService {
	List<Category> ViewCategoryName(Category category);
	Map<String,Object> GetCatergoryName(int categoryID);

}
