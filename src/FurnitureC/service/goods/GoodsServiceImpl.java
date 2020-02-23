package FurnitureC.service.goods;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FurnitureC.bean.goods;
import FurnitureC.bean.Collect;
import FurnitureC.mapper.GoodsMapper;

@Service("BookService")
public class GoodsServiceImpl implements GoodsService {

	@Autowired
    private GoodsMapper goodsMapper;

	@Override
	public Map<String, Object> GoodsDetail(goods Goods, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> GoodsTypeDetail(goods Goods, Integer id,
			Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> GoodsTypeAll(goods Goods, Integer page,
			Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<goods> GoodsAll(goods Goods) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<goods> GoodsType(goods Goods, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> GetGoods(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> Searchgoods(Integer page,
			Integer pageSize, String content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> SearchgoodsAll(String content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> GetGoodsInfo(Integer goodsID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> GetQuantity(Integer goodsID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ChangeQuantity(Integer goodsID, Integer quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ChangeQuantityReturn(Integer goodsID, Integer quantity) {
		// TODO Auto-generated method stub
		
	}
	



}
