package FurnitureC.mapper;

import java.util.List; 
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;

import FurnitureC.bean.Collect;

public interface CollectMapper {
	@Insert("insert into collect(userID,bookID,collectDate) values (#{userID},#{bookID},#{collectDate})")
	void addLike(Collect collect);//����Ҫ����ֵ��ֻ�õ������ݿ�
	
	//�����ղ��б�
	@Select("select * from collect where userID=#{userID} and goodsID=#{goodsID}")
	Map<String, Object> findCollect(@Param("userID")Integer userID, @Param("goodsID")Integer goodsID);
	
	//�����û������ղ�
	@Select("select id,goodsID as goodsid from collect where userID = #{userID} order by collectDate desc")
	List<Map<String, Object>> collectList(Collect collect, @Param("userID")Integer id);
	
	//�����ղر�ŷ����ղؼ�¼
	@Select("select * from collect where id = #{likeid}")
	Map<String, Object> searchCollect(@Param("likeid")Integer likeid);
	
	//ɾ��ĳ���ղؼ�¼
	@Delete("delete from collect where id=#{likeid}")
	void deleteCollect(@Param("likeid")int likeid);	
	
	//��ѯ�ղؼҾߵ��û�
	@Select("select userID from collect where goodsID=#{goodsID}")
	List<Map<String, Object>> findCollectWithgoodsID(@Param("goodsID")Integer goodsID);
	
	//�õ�ĳ���˳������Ʒ���������Ʒ
	@Select("select goodsID as goodsid from collect where userID = #{userID} and goodsID <> #{goodsID} ")
	List<Map<String, Object>> getgoodsNot(@Param("userID")Integer userID, @Param("goodsID")Integer goodsID);
	
	
}
