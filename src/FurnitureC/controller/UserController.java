package FurnitureC.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map; 
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import FurnitureC.bean.User;
import FurnitureC.service.user.UserService;

@Controller
public class UserController {
	@Autowired
    @Qualifier("UserService")
    private UserService userService;
	
	/**
	 * ʵ��/login�û���¼
     */	
	
	@PostMapping("/userLogin")
	@ResponseBody  //@responseBodyע��������ǽ�controller�ķ������صĶ���ͨ���ʵ���ת����ת��Ϊָ���ĸ�ʽ֮��д�뵽response�����body����ͨ����������JSON���ݻ�����XML
	public Map<String, Object> userLogin(String username, String pwd, HttpSession session) {
//		System.out.println(username+","+pwd);
		Map<String, Object> user;
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int code, flag;
		String state,message;					
        try{
        	if(username!=null & pwd!=null){
        		user = userService.Login(username, pwd);	 
        		if(user!=null){
        			session.setAttribute("user", user);//����user����
        			Integer id = Integer.parseInt(user.get("id").toString());
        			String userName = user.get("userName").toString();
        			flag = 1;
    				message = "�ɹ�";
    				result.put("flag", flag); //����ֵ
    				result.put("message", message);
    				result.put("id", id);
    				result.put("username", userName);
                	code=200;
        			state="success";
        			message="�ɹ�";
        			map.put("code", code);
        			map.put("state", state);	
        			map.put("message", message);
        			map.put("result", result);
//        			System.out.println(map);
            		return map;
        		}else{
        			flag = 0;
    				message = "ʧ��";
    				result.put("flag", flag);
    				result.put("message", message);
                	code=0;
        			state="fail";
        			message="ʧ��";
        			map.put("code", code);
        			map.put("state", state);	
        			map.put("message", message);
        			map.put("result", result);
//        			System.out.println(map);
            		return map;
        		}
        	}else{
        		flag = 0;
				message = "ʧ��";
				result.put("flag", flag);
				result.put("message", message);
            	code=0;
    			state="fail";
    			message="ʧ��";
    			map.put("code", code);
    			map.put("state", state);	
    			map.put("message", message);
    			map.put("result", result);
//    			System.out.println(map);
        		return map;
        	}      	
        }catch(Exception e){
        	System.out.println(e);
        	flag = 0;
			message = "ʧ��";
			result.put("flag", flag);
			result.put("message", message);
        	code=0;
			state="fail";
			message="ʧ��";
			map.put("code", code);
			map.put("state", state);	
			map.put("message", message);
			map.put("result", result);
//			System.out.println(map);
    		return map;
        }  		
	}
	
	/**
     * ����/register����
*/	
	
	@PostMapping("/userRegister")
	@ResponseBody 
	public Map<String, Object> userRegister(String username, String pwd, String telephone, String address) {
		Map<String, Object> searchUserName = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int code, flag;
		String state, message;	
		try{
			if(username != null & pwd != null){
				searchUserName = userService.SearchUserName(username); //�ж��û����Ƿ��Ѵ���
				if(searchUserName == null){
				
					userService.Register(username, pwd, address, telephone);
					
					flag=1;
					message = "�ɹ�";
    				result.put("flag", flag);
    				result.put("message", message);

                	code=200;
        			state="success";
        			message="�ɹ�";
        			map.put("code", code);
        			map.put("state", state);	
        			map.put("message", message);
        			map.put("result", result);
//        			System.out.println(JSON.toJSONString(map));
            		return map;
					
				}else{ 
					flag=0;
					message = "�û����Ѵ��ڣ�";
					result.put("flag", flag);
					result.put("message", message);
					code=0;
					state="fail";
					message="ʧ�ܣ�";
					map.put("code", code);
        			map.put("state", state);	
        			map.put("message", message);
        			map.put("result", result);
//	    			System.out.println(JSON.toJSONString(map));
        			return map;
				}
			}else{
				flag = 0;
				message = "ʧ��";
				result.put("flag", flag);
				result.put("message", message);
            	code=0;
    			state="fail";
    			message="ʧ��";
    			map.put("code", code);
    			map.put("state", state);	
    			map.put("message", message);
    			map.put("result", result);
//    			System.out.println(map);
        		return map;
			}
		}catch(Exception e){
			System.out.println(e);
			flag=0;
			message = "ʧ��";
			result.put("flag", flag);
			result.put("message", message);
        	code=0;
			state="fail";
			message="ʧ��";
			map.put("code", code);
			map.put("state", state);	
			map.put("message", message);
			map.put("result", result);
//			System.out.println(map);
    		return map;
			
		}
		}
		
	/**
	 * ����/myself����������ʾ
	 */
	
	@PostMapping("/userSelf")
	@ResponseBody
	public Map<String,Object> userSelf(Integer id){
//		System.out.println(id);
		Map<String,Object> searchUser = new HashMap<String,Object>();
		Map<String,Object> map = new HashMap<String,Object>();
		int code;
		String message,state;
		try{
			if(id != null){
				searchUser = userService.SearchUser(id);
// 				System.out.println(searchUserId);
				code=200;
				state = "success";
				message = "�ɹ�";
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", searchUser);
// 				System.out.println(JSON.toJSONString(map));
				return map;
			}else{
				code = 0;
				state = "fail";
				message = "ʧ��";
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", searchUser);
//				System.out.println(map);
				return map;
			}
		}catch(Exception e){
			System.out.println(e);
			code = 0;
			state = "fail";
			message = "ʧ��";
			map.put("code", code);
			map.put("state", state);
			map.put("message", message);
			map.put("result", searchUser);
//			System.out.println(map);
			return map;
		}
		
	
	}
	
	
	/**
	 * ����/myself���������޸� 
	 */
	
	@PostMapping("/userPwdReset")
	@ResponseBody
	public Map<String,Object> userPwdReset(Integer id,String oldpwd,String newpwd){
		Map<String, Object> searchUserPwd = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int code, flag;
		String state, message;
		try{
			if(id != null){
				searchUserPwd = userService.searchUserPwd(id);
				if(searchUserPwd.get("pwd").equals(oldpwd)){ //���������Ƚϣ���ִͬ����������
					userService.PwdReset(id, newpwd);
					flag = 1;
					message = "�ɹ�";
					result.put("flag", flag);
					result.put("message", message);
	            	code=200;
	    			state="success";
	    			message="�ɹ�";
	    			map.put("code", code);
	    			map.put("state", state);	
	    			map.put("message", message);
	    			map.put("result", result);
//	    			System.out.println(JSON.toJSONString(map));
	        		return map;
				}else{
					flag = 0;
					message = "�������������";
					result.put("flag", flag);
					result.put("message", message);
	            	code=0;
	    			state="fail";
	    			message="ʧ��";
	    			map.put("code", code);
	    			map.put("state", state);	
	    			map.put("message", message);
	    			map.put("result", result);
//	    			System.out.println(map);
	        		return map;
					
				}
				
			}else{
				flag = 0;
				message = "ʧ��";
				result.put("flag", flag);
				result.put("message", message);
            	code=0;
    			state="fail";
    			message="ʧ��";
    			map.put("code", code);
    			map.put("state", state);	
    			map.put("message", message);
    			map.put("result", result);
//    			System.out.println(map);
        		return map;
			}
		
	}catch(Exception e){
		System.out.println(e);
		flag = 0;
		message = "ʧ��";
		result.put("flag", flag);
		result.put("message", message);
    	code=0;
		state="fail";
		message="ʧ��";
		map.put("code", code);
		map.put("state", state);	
		map.put("message", message);
		map.put("result", result);
//		System.out.println(map);
		return map;
	}
		
	}	
	
	/**
	 * ����/myself���������޸�
	 */
	@PostMapping("/userSelfReset")
	@ResponseBody
	public Map<String, Object> userSelfReset(Integer id, String username, String addr, String phone) {
//		System.out.println(id+","+username+","+addr+","+phone);
		Map<String, Object> searchUser = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int code;
		String state, message;
		try {
			if (id != null) {
				searchUser = userService.SearchUser(id);
// 				System.out.println(searchUserId);
				if(searchUser != null) {
					String realname = username;
	        		userService.UserReset(id, addr, phone); 
					
					message = "�ɹ�";
					result.put("message", message);
	            	code=200;
	    			state="success";
	    			message="�ɹ�";
	    			map.put("code", code);
	    			map.put("state", state);	
	    			map.put("message", message);
	    			map.put("result", result);
//	    			System.out.println(JSON.toJSONString(map));
	        		return map;
				}else {
	
					message = "�Ҳ������û���";
					result.put("message", message);
	            	code=0;
	    			state="fail";
	    			message="ʧ��";
	    			map.put("code", code);
	    			map.put("state", state);	
	    			map.put("message", message);
	    			map.put("result", result);
//	    			System.out.println(map);
	        		return map;
				}	
			} else {

				message = "ʧ��";
				result.put("message", message);
            	code=0;
    			state="fail";
    			message="ʧ��";
    			map.put("code", code);
    			map.put("state", state);	
    			map.put("message", message);
    			map.put("result", result);
//    			System.out.println(map);
        		return map;
			}
		} catch (Exception e) {
			System.out.println(e);
			message = "ʧ��";
			result.put("message", message);
        	code=0;
			state="fail";
			message="ʧ��";
			map.put("code", code);
			map.put("state", state);	
			map.put("message", message);
			map.put("result", result);
//			System.out.println(map);
    		return map;
		} 
	}
	}


