package FurnitureC.service.goods;

import java.util.List;
import java.util.Map;

import FurnitureC.bean.goods;


public interface GoodsService {

	//��ȡ�Ҿ�����
	Map<String,Object> GoodsDetail(goods Goods,Integer id);
	
	//������ȡ�Ҿ�
	List<Map<String,Object>> GoodsTypeDetail(goods Goods , Integer id, Integer page, Integer pageSize);
	//��ȡ���еļҾ�
	List<Map<String, Object>> GoodsTypeAll(goods Goods , Integer page, Integer pageSize);

	//��ȡȫ���Ҿ�
	List<goods> GoodsAll(goods Goods);
	
	//���ݼҾ�����ȡ�Ҿ�
	List<goods> GoodsType(goods Goods, Integer id);

	//���ݼҾ߱�Ż�ȡ�Ҿ���Ϣ
	Map<String, Object> GetGoods(Integer id);
	
	//ģ������
	List<Map<String, Object>> Searchgoods(Integer page, Integer pageSize, String content);
	
	List<Map<String, Object>> SearchgoodsAll(String content);
	
	//����ĳ�Ҿ߾Ա�Ż�ȡ�Ҿ���Ϣ
	Map<String, Object> GetGoodsInfo(Integer goodsID);
	
	//��ȡĳ�ҾߵĿ��
	Map<String, Object> GetQuantity(Integer goodsID);
	

	//�޸�ĳ�Ҿ߿�棨�����٣�
	void ChangeQuantity(Integer goodsID, Integer quantity);
	
	//�������
	void AddChangeQuantity(Integer goodsID, Integer quantity);
	
	//�ҵĶ�������ɶ�������ϲ���Ƽ��鱾����
	List<goods> LikeRecGoods(goods Goods, long goodsID, Integer page, Integer pageSize);
	
	List<goods> LikeRecGoodsAll(goods Goods, long goodsID);
	
	//����ҳ�Ƽ������ȡ�����Ǳ���
	List<Map<String, Object>> RandomGoods(goods Goods, Integer goodsID, Integer page, Integer pageSize);

	List<Map<String, Object>> RandomAllGoods(goods Goods, Integer goodsID);
	

	//��ȡ�û��ղ�������������
	List<Map<String, Object>> RecGoods(goods Goods, Integer recgoodsId, Integer page, Integer pageSize);

	List<Map<String, Object>> RecGoodsAll(goods Goods, Integer recgoodsId);
	
	//�Ƽ������ȡ����
	List<goods> RandomGoodsexc(goods Goods,Integer page, Integer pageSize);
}
