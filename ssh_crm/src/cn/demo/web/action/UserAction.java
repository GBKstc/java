package cn.demo.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.demo.domain.User;
import cn.demo.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user = new User();
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() throws Exception {
		User u = userService.getUserByCodePassword(user);
		ActionContext.getContext().getSession().put("user", u);
		return "toHome";
	}

	@Override
	public User getModel() {
		return user;
	}

	
}
