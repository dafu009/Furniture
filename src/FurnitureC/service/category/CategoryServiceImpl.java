package FurnitureC.service.category;

import java.util.List; 
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FurnitureC.bean.Category;
import FurnitureC.mapper.CategoryMapper;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
    private CategoryMapper categoryMapper;
	
	@Override
	public List<Category> ViewCategoryName(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.getAllWithCategoryName(category);
	}

	@Override
	public Map<String, Object> GetCatergoryName(int id) {
		// TODO Auto-generated method stub
		return categoryMapper.getWithCategoryName(id);
	}
	

}
