package FurnitureC.service.collect;

import java.util.List;
import java.util.Map;
import FurnitureC.bean.Collect;

public interface CollectService {
	//�����ղ�
	void AddLike(String userID,String goodsID,String collectDate);
	
	//��ѯ�ղؼ�¼
	Map<String,Object> FindCollect(Integer userID, Integer goodsID);
	
	//�����û���ŷ����ղ��б�
	List<Map<String,Object>> CollectList(Collect collect,Integer userID); 
	
	//�����ղر�ŷ����ղ�
	Map<String,Object> SearchCollect(Integer likeid);
	
	//ɾ��ĳ���ղؼ�¼
	void DeleteCollect(Integer likeid);
	
	//��ѯ�ղ�����Ҿߵ��û�
	List<Map<String,Object>> FindCollectWithgoodsId(Integer goodsID);
	
	List<Map<String,Object>> GetUser(Integer userID,Integer goodsID);
	
	
	
	
	
	
}
