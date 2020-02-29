package FurnitureC.bean;

import java.text.SimpleDateFormat; //时间格式化
import java.util.Date; 
import java.util.Random;//产生随机数

public class GetRandomId {

	public static String getRandomFileName() {

		SimpleDateFormat simpleDateFormat;
		simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		Date date = new Date();
		String str = simpleDateFormat.format(date);

		Random random = new Random();
		int rannum = (int) (random.nextDouble() * (99999999 - 10000000 + 1)) + 10000000;// 获取5位随机数

		return  str + rannum;// 当前时间
	}

//	public static String main(String[] args) {
//		String fileName = GetRandomId.getRandomFileName();
//		return fileName;// 8835920140307
//	}

}
