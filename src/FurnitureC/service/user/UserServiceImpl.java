package FurnitureC.service.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FurnitureC.mapper.UserMapper;
import FurnitureC.service.user.UserService;


@Service("UserService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	//�û���¼
	@Override
	public Map<String, Object> Login(String username, String pwd) {
		return userMapper.userLogin(username, pwd);
	}
	
	//�û�ע��
	@Override
	public Map<String, Object> SearchUserName(String username) {
		return userMapper.usersearchName(username);
	}

	@Override
	public void Register(String username, String realname, String pwd,
			String address, String telephone, String creatDate) {
		// TODO Auto-generated method stub
		userMapper.userRegister(username, realname, pwd, address, telephone, creatDate);
	}
	//�û���������
	@Override
	public Map<String, Object> SearchUser(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.userSelf(id);
		}
	//�û����������޸�
	@Override
	public void UserReset(Integer id, String realname, String addr,
			String telephone) {
		// TODO Auto-generated method stub
		userMapper.userReset(id, realname, addr, telephone);
	}
	
	//�û����������޸�
	@Override
	public Map<String, Object> searchUserPwd(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.userPwd(id);
	}

	@Override
	public void PwdReset(Integer id, String newpwd) {
		// TODO Auto-generated method stub
		userMapper.pwdReset(id, newpwd);
	}
	
	
	
}
