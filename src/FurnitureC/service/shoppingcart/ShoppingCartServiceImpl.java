package FurnitureC.service.shoppingcart;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FurnitureC.bean.shoppingcart;
import FurnitureC.mapper.ShoppingCartMapper;

@Service("ShoppingCartService")
public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Autowired
    private ShoppingCartMapper shoppingCartMapper;
	
	
	@Override
	public List<Map<String, Object>> ShoppingCartList(
			shoppingcart shoppingCart, int id) {
		// TODO Auto-generated method stub
		return shoppingCartMapper.shoppingCartList(shoppingCart, id);
	}

	@Override
	public void DeleteShoppingCart(int carid) {
		// TODO Auto-generated method stub
		shoppingCartMapper.deleteShoppingCart(carid);
	}

	@Override
	public Map<String, Object> SearchShoppingCart(int carid) {
		// TODO Auto-generated method stub
		return shoppingCartMapper.searchShoppingCart(carid);
	}

	@Override
	public void ChangeGoodsNum(Integer carid, Integer num) {
		// TODO Auto-generated method stub
		shoppingCartMapper.changeCarGoodsNum(num, carid);
	}

	@Override
	public void ChangeCarNum(Integer carid, Integer num, String shoppingDate) {
		// TODO Auto-generated method stub
		num = num + 1;
		shoppingCartMapper.changeCarNum(num, carid, shoppingDate);
	}

	@Override
	public void AddCart(Integer userID, Integer goodsID, Integer num,
			String shoppingDate) {
		// TODO Auto-generated method stub
		shoppingCartMapper.addCart(userID, goodsID, num, shoppingDate);
	}

	@Override
	public Map<String, Object> FindShoppingCart(int userID, int goodsID) {
		// TODO Auto-generated method stub
		return shoppingCartMapper.findShoppingCart(userID, goodsID);
	}

	@Override
	public void DeleteShoppingCartWithOrder(Integer userID, String goodsID) {
		// TODO Auto-generated method stub
		shoppingCartMapper.delShoppingCartWithOrder(userID, goodsID);
	}
	
}