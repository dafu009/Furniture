package FurnitureC.service.shoppingcart;

import java.util.List; 
import java.util.Map;

import FurnitureC.bean.shoppingcart;

public interface ShoppingCartService {
	
	//���ﳵ�б�
	//����List<Map<String,Object>>���ݽṹ��map�����е�key��value
	List<Map<String,Object>> ShoppingCartList(shoppingcart shoppingCart,int id);
	
	//ɾ�����ﳵ
	void DeleteShoppingCart(int carid);
	
	//���ݹ��ﳵ�������
	Map<String,Object> SearchShoppingCart(int carid);
	
	//���Ĺ��ﳵ��Ʒ����
	void ChangeGoodsNum(Integer carid, Integer num);
	
	void ChangeCarNum(Integer carid, Integer num , String shoppingDate);
	
	//���빺�ﳵ
	void AddCart(Integer userID, Integer goodsID, Integer num, String shoppingDate);
	
	//����ĳ�����ﳵ��¼
	Map<String,Object> FindShoppingCart(int userID, int goodsID);
	
	//ɾ��ĳ�����ﳵ��¼
	void DeleteShoppingCartWithOrder(Integer userID, String goodsID);
	
	
	
	
	
	
	
}
