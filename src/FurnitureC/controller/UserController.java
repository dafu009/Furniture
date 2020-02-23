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
	 * 实现/login用户登录
     */	
	
	@PostMapping("/userLogin")
	@ResponseBody  //@responseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML
	public Map<String, Object> userLogin(String username, String pwd, HttpSession session) {
//		System.out.println(userName+","+pwd);
		Map<String, Object> user;
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int code, flag;
		String state,message;					
        try{
        	if(username!=null & pwd!=null){
        		user = userService.Login(username, pwd);	 
        		if(user!=null){
        			session.setAttribute("user", user);//保存user数据
        			Integer id = Integer.parseInt(user.get("id").toString());
        			String userName = user.get("userName").toString();
        			flag = 1;
    				message = "成功";
    				result.put("flag", flag); //保存值
    				result.put("message", message);
    				result.put("id", id);
    				result.put("username", userName);
                	code=200;
        			state="success";
        			message="成功";
        			map.put("code", code);
        			map.put("state", state);	
        			map.put("message", message);
        			map.put("result", result);
//        			System.out.println(JSON.toJSONString(map));
            		return map;
        		}else{
        			flag = 0;
    				message = "失败";
    				result.put("flag", flag);
    				result.put("message", message);
                	code=0;
        			state="fail";
        			message="失败";
        			map.put("code", code);
        			map.put("state", state);	
        			map.put("message", message);
        			map.put("result", result);
//        			System.out.println(map);
            		return map;
        		}
        	}else{
        		flag = 0;
				message = "失败";
				result.put("flag", flag);
				result.put("message", message);
            	code=0;
    			state="fail";
    			message="失败";
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
			message = "失败";
			result.put("flag", flag);
			result.put("message", message);
        	code=0;
			state="fail";
			message="失败";
			map.put("code", code);
			map.put("state", state);	
			map.put("message", message);
			map.put("result", result);
//			System.out.println(map);
    		return map;
        }  		
	}
	
	/**
     * 处理/register请求
*/	
	
	@PostMapping("/userRegister")
	@ResponseBody 
	public Map<String, Object> userRegister(String username, String pwd, String telephone, String address, String realname) {
		Map<String, Object> searchUserName = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		int code, flag;
		String state, message;	
		try{
			if(username != null & pwd != null){
				searchUserName = userService.SearchUserName(username); //判断用户名是否已存在
				if(searchUserName == null){
					Date date = new Date();
					SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String creatDate = formatDate.format(date);
					userService.Register(username, realname, pwd, address, telephone, creatDate);
					
					flag=1;
					message = "成功";
    				result.put("flag", flag);
    				result.put("message", message);

                	code=200;
        			state="success";
        			message="成功";
        			map.put("code", code);
        			map.put("state", state);	
        			map.put("message", message);
        			map.put("result", result);
//        			System.out.println(JSON.toJSONString(map));
            		return map;
					
				}else{ 
					flag=0;
					message = "用户名已存在！";
					result.put("flag", flag);
					result.put("message", message);
					code=0;
					state="fail";
					message="失败！";
					map.put("code", code);
        			map.put("state", state);	
        			map.put("message", message);
        			map.put("result", result);
//	    			System.out.println(JSON.toJSONString(map));
        			return map;
				}
			}else{
				flag = 0;
				message = "失败";
				result.put("flag", flag);
				result.put("message", message);
            	code=0;
    			state="fail";
    			message="失败";
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
			message = "失败";
			result.put("flag", flag);
			result.put("message", message);
        	code=0;
			state="fail";
			message="失败";
			map.put("code", code);
			map.put("state", state);	
			map.put("message", message);
			map.put("result", result);
//			System.out.println(map);
    		return map;
			
		}
		}
		
	/**
	 * 处理/myself个人资料显示
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
				message = "成功";
				map.put("code", code);
				map.put("state", state);
				map.put("message", message);
				map.put("result", searchUser);
// 				System.out.println(JSON.toJSONString(map));
				return map;
			}else{
				code = 0;
				state = "fail";
				message = "失败";
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
			message = "失败";
			map.put("code", code);
			map.put("state", state);
			map.put("message", message);
			map.put("result", searchUser);
//			System.out.println(map);
			return map;
		}
		
	
	}
	
	
	/**
	 * 处理/myself个人密码修改 
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
				if(searchUserPwd.get("pwd").equals(oldpwd)){ //与旧密码相比较，相同执行下面的语句
					userService.PwdReset(id, newpwd);
					flag = 1;
					message = "成功";
					result.put("flag", flag);
					result.put("message", message);
	            	code=200;
	    			state="success";
	    			message="成功";
	    			map.put("code", code);
	    			map.put("state", state);	
	    			map.put("message", message);
	    			map.put("result", result);
//	    			System.out.println(JSON.toJSONString(map));
	        		return map;
				}else{
					flag = 0;
					message = "旧密码输入错误！";
					result.put("flag", flag);
					result.put("message", message);
	            	code=0;
	    			state="fail";
	    			message="失败";
	    			map.put("code", code);
	    			map.put("state", state);	
	    			map.put("message", message);
	    			map.put("result", result);
//	    			System.out.println(map);
	        		return map;
					
				}
				
			}else{
				flag = 0;
				message = "失败";
				result.put("flag", flag);
				result.put("message", message);
            	code=0;
    			state="fail";
    			message="失败";
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
		message = "失败";
		result.put("flag", flag);
		result.put("message", message);
    	code=0;
		state="fail";
		message="失败";
		map.put("code", code);
		map.put("state", state);	
		map.put("message", message);
		map.put("result", result);
//		System.out.println(map);
		return map;
	}
		
	}	
	}
	


