package FurnitureC.service.collect;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FurnitureC.bean.goods;
import FurnitureC.bean.Collect;
import FurnitureC.mapper.CollectMapper;

@Service("CollectService")
public class CollectServiceImpl implements CollectService {

	@Autowired
    private CollectMapper collectMapper;
	
	@Override
	public void AddLike(String userID, String goodsID, String collectDate) {
		// TODO Auto-generated method stub
		Collect collect = new Collect();
		collect.setUserID(userID);
		collect.setgoodsID(goodsID);
		collect.setCollectDate(collectDate);
		collectMapper.addLike(collect);	
	}

	@Override
	public Map<String, Object> FindCollect(Integer userID, Integer goodsID) {
		// TODO Auto-generated method stub
		return collectMapper.findCollect(userID, goodsID);
	}

	@Override
	public List<Map<String, Object>> CollectList(Collect collect, Integer userID) {
		// TODO Auto-generated method stub
		return collectMapper.collectList(collect, userID);
	}

	@Override
	public Map<String, Object> SearchCollect(Integer likeid) {
		// TODO Auto-generated method stub
		return collectMapper.searchCollect(likeid);
	}

	@Override
	public void DeleteCollect(Integer likeid) {
		// TODO Auto-generated method stub
		collectMapper.deleteCollect(likeid);
	}

	@Override
	public List<Map<String, Object>> FindCollectWithgoodsId(Integer goodsID) {
		// TODO Auto-generated method stub
		return collectMapper.findCollectWithgoodsID(goodsID);
	}

	@Override
	public List<Map<String, Object>> GetUser(Integer userID, Integer goodsID) {
		// TODO Auto-generated method stub
		return collectMapper.getgoodsNot(userID, goodsID);
	}

}
