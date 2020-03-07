package FurnitureC.service.recommend;

import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import FurnitureC.bean.Recommend;

public interface RecommendService {

	
	List<RecommendedItem> LikeRecommend(Integer userId) throws IOException, TasteException;

	List<Recommend> SizeOfRecommend(Integer userId);
}
