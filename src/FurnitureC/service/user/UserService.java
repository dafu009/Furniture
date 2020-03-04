package FurnitureC.service.user;

import java.util.Map;

public interface UserService {

	//�û���¼
	Map<String, Object> Login(String username, String pwd);
    

	//�û�ע��
    Map<String, Object> SearchUserName(String username);

	void Register(String username,  String pwd, String address, String telephone);

	//�û���������
	Map<String, Object> SearchUser(Integer id);

	//�û����������޸�
	void UserReset(Integer id,  String addr, String phone);

	//�û����������޸�
	Map<String, Object> searchUserPwd(Integer id);

	void PwdReset(Integer id, String newpwd);

}
