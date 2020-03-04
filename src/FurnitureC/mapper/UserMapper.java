package FurnitureC.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import FurnitureC.bean.User;

public interface UserMapper {
	
	//�û���¼
	@Select("select * from users where userName=#{username} and pwd=#{pwd}")
	Map<String,Object> userLogin(@Param("username")String username,@Param("pwd")String pwd);
	
	//�û�ע��
	@Select("select * from users where userName=#{username}")
	Map<String,Object> usersearchName(@Param("username")String username);
	
	@Insert("insert into users(userName,pwd,addr,phone) values (#{username},#{pwd},#{address},#{telephone})")
	void userRegister (@Param("username")String username, @Param("pwd")String pwd, @Param("address")String address, @Param("telephone")String telephone);
	
	//�û���������
	@Select("select * from users where id=#{id}")
	Map<String, Object> userSelf(@Param("id")Integer id);
	
	//�û����������޸�
	@Update("update users set addr=#{addr},phone=#{phone} where id=#{id}")
	void userReset(@Param("id")Integer id,@Param("addr")String addr, @Param("phone")String phone);
	
	//�û����������޸�
	@Select("select pwd from users where id=#{id}")
	Map<String, Object> userPwd(@Param("id")Integer id);

	@Update("update users set pwd=#{newpwd} where id=#{id}")
	void pwdReset(@Param("id")Integer id, @Param("newpwd")String newpwd);
}
