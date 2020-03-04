package FurnitureC.service.user;

import java.util.Map;

public interface UserService {

	//用户登录
	Map<String, Object> Login(String username, String pwd);
    

	//用户注册
    Map<String, Object> SearchUserName(String username);

	void Register(String username,  String pwd, String address, String telephone);

	//用户个人资料
	Map<String, Object> SearchUser(Integer id);

	//用户个人资料修改
	void UserReset(Integer id,  String addr, String phone);

	//用户个人密码修改
	Map<String, Object> searchUserPwd(Integer id);

	void PwdReset(Integer id, String newpwd);

}
