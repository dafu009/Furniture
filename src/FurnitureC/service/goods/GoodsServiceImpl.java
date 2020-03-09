package FurnitureC.service.goods;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FurnitureC.bean.goods;
import FurnitureC.bean.Collect;
import FurnitureC.mapper.GoodsMapper;

@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {

	@Autowired
    private GoodsMapper goodsMapper;

	@Override
	public Map<String, Object> GoodsDetail(goods Goods, Integer id) {
		// TODO Auto-generated method stub
		return goodsMapper.GetGoodsDetail(Goods, id);
	}

	@Override
	public List<Map<String, Object>> GoodsTypeDetail(goods Goods, Integer id,
			Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		page=(page-1)*pageSize;
		
		return goodsMapper.GetTypeDetail(Goods, id,page, pageSize);
	}

	@Override
	public List<Map<String, Object>> GoodsTypeAll(goods Goods, Integer page,
			Integer pageSize) {
		// TODO Auto-generated method stub
		page=(page-1)*pageSize;
		return goodsMapper.GetGoodsTypeAll(Goods, page, pageSize);
	}

	@Override
	public List<goods> GoodsAll(goods Goods) {
		// TODO Auto-generated method stub
		return goodsMapper.GetGoodsAll(Goods);
	}

	@Override
	public List<goods> GoodsType(goods Goods, Integer id) {
		// TODO Auto-generated method stub
		return goodsMapper.GetGoodsType(Goods, id);
	}

	@Override
	public Map<String, Object> GetGoods(Integer id) {
		// TODO Auto-generated method stub
		return goodsMapper.getgoods(id);
	}

	@Override
	public List<Map<String, Object>> Searchgoods(Integer page,
			Integer pageSize, String content) {
		// TODO Auto-generated method stub
		page=(page-1)*pageSize;
		content="%"+content+"%"; //Ä£ºý²éÑ¯
		return goodsMapper.getsearchgoods(page, pageSize, content);
	}

	@Override
	public List<Map<String, Object>> SearchgoodsAll(String content) {
		// TODO Auto-generated method stub
		content="%"+content+"%";
		return goodsMapper.getsearchgoodsAll(content);
	}

	@Override
	public Map<String, Object> GetGoodsInfo(Integer goodsID) {
		// TODO Auto-generated method stub
		return goodsMapper.getgoodsInfo(goodsID);
	}

	@Override
	public Map<String, Object> GetQuantity(Integer goodsID) {
		// TODO Auto-generated method stub
		return goodsMapper.getQuantity(goodsID);
	}

	@Override
	public void ChangeQuantity(Integer goodsID, Integer quantity) {
		// TODO Auto-generated method stub
		quantity = quantity-1;
		goodsMapper.changeQuantity(goodsID, quantity);
	}

	@Override
	public void AddChangeQuantity(Integer goodsID, Integer quantity) {
		// TODO Auto-generated method stub
		quantity = quantity+1;
		goodsMapper.changeQuantity(goodsID, quantity);
		
	}

	@Override
	public List<goods> LikeRecGoods(goods Goods, long goodsID, Integer page,
			Integer pageSize) {
		// TODO Auto-generated method stub
		return goodsMapper.getLikeRecGoods(Goods, goodsID, page, pageSize);
	}

	@Override
	public List<goods> LikeRecGoodsAll(goods Goods, long goodsID) {
		// TODO Auto-generated method stub
		return goodsMapper.getLikeRecGoodsAll(Goods, goodsID);
	}

	@Override
	public List<Map<String, Object>> RandomGoods(goods Goods, Integer goodsID,
			Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		return goodsMapper.randomGoods(Goods, goodsID, page, pageSize);
	}

	@Override
	public List<Map<String, Object>> RandomAllGoods(goods Goods, Integer goodsID) {
		// TODO Auto-generated method stub
		return goodsMapper.randomAllGoods(Goods, goodsID);
	}

	@Override
	public List<Map<String, Object>> RecGoods(goods Goods, Integer recgoodsId,
			Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		page=(page-1)*pageSize;
		return goodsMapper.getRecGoods(Goods, recgoodsId, page, pageSize);
	}

	@Override
	public List<Map<String, Object>> RecGoodsAll(goods Goods, Integer recgoodsId) {
		// TODO Auto-generated method stub
		return goodsMapper.getRecGoodsAll(Goods, recgoodsId);
	}

	@Override
	public List<goods> RandomGoodsexc(goods Goods, 
			Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		return goodsMapper.randomGoodsexc(Goods,page, pageSize);
	}
	


}
