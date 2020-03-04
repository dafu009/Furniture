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
	
	//用户登录
	@Override
	public Map<String, Object> Login(String username, String pwd) {
		return userMapper.userLogin(username, pwd);
	}
	
	//用户注册
	@Override
	public Map<String, Object> SearchUserName(String username) {
		return userMapper.usersearchName(username);
	}

	@Override
	public void Register(String username,  String pwd,
			String address, String telephone) {
		// TODO Auto-generated method stub
		userMapper.userRegister(username, pwd, address, telephone);
	}
	//用户个人资料
	@Override
	public Map<String, Object> SearchUser(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.userSelf(id);
		}
	//用户个人资料修改
	@Override
	public void UserReset(Integer id, String addr,
			String phone) {
		// TODO Auto-generated method stub
		userMapper.userReset(id, addr, phone);
	}
	
	//用户个人密码修改
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
