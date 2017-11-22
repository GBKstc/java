package cn.demo.action;


import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.demo.bean.User;
import cn.demo.service.UserService;
import cn.demo.utils.SetResult;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 1L;
	
	private User user = new User();
	//验证码
	private String authCode ;
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}


	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//登陆接口
	public String Login() throws Exception {
		System.out.println(user);
//		System.out.println(authCode);
		String json=null ;
//		String reqCode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
//		System.out.println(reqCode);
//		if(StringUtils.isNotBlank(authCode)&&authCode.equals(reqCode)) {
			User obtainUser = userService.getUser(user);
//			System.out.println(obtainUser);
			if(obtainUser==null) {
				json = SetResult.sendErrorByCode("用户名不存在");
			}else if(!obtainUser.getPassword().equals(user.getPassword())){
				json = SetResult.sendErrorByCode("密码错误");
			}else {
				json = SetResult.setDefaultResult();
			}
			
//		}else {
//			json = SetResult.sendErrorByCode("验证码错误");
//			System.out.println(json);
//		}
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().write(json);
		
		return null;
	}


	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	
}
