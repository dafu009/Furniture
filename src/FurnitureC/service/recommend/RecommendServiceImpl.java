package FurnitureC.service.recommend;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.*;  
import org.apache.mahout.cf.taste.impl.recommender.*;  
import org.apache.mahout.cf.taste.impl.similarity.*;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.*;
import org.apache.mahout.cf.taste.recommender.*;  
import org.apache.mahout.cf.taste.similarity.*;  
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import FurnitureC.bean.Collect;
import FurnitureC.bean.Recommend;
import FurnitureC.mapper.RecommendMapper;
import FurnitureC.service.recommend.RecommendService;

@Service("RecommendService")
public class RecommendServiceImpl implements RecommendService {

	@Autowired
    private RecommendMapper recommendMapper;

	//����Ƽ�
	
	@Override
	public List<Recommend> SizeOfRecommend(Integer userid) {
		
		return recommendMapper.sizeOfRecommend(userid);
	}
//    final static int RECOMMENDER_NUM = 3;
    //������Ʒ��Эͬ�����Ƽ�
    public List<RecommendedItem> LikeRecommend(Integer userid) throws IOException, TasteException{
    	try{
    		//����MySQL
	        MysqlDataSource dataSource = new MysqlDataSource();
	        dataSource.setServerName("localhost");
	        dataSource.setUser("root");
	        dataSource.setPassword("");
	        dataSource.setDatabaseName("furniture");
	        
	        //��ȡ����ģ��
	        JDBCDataModel dataModel = new MySQLJDBCDataModel(dataSource, "recommend", "userID", "goodsID", "num", null);
	        DataModel model = dataModel;	 
	        
	        //������Ʒ���ƶȣ�����Ƥ��ѷ���ϵ���������ƶȣ�
	        ItemSimilarity similarity = new PearsonCorrelationSimilarity(model); 
	        
	        //�Ƽ� ������Ʒ���ƶȽ����Ƽ�
	        Recommender recommender = new GenericItemBasedRecommender(model, similarity);// ���������Ʒ�Ƽ�����
	        
	        List<RecommendedItem> recommendations = recommender.recommend(userid, 3);//Ϊ�û��Ƽ�3����Ʒ
    		
	        for (RecommendedItem recommendation : recommendations) {
	        	System.out.println(recommendation);
	        }
	        System.out.println();
			return recommendations;	
	        
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }

    

}

