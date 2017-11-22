package cn.demo.action.filter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class CrossDomain extends MethodFilterInterceptor{


	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		final Object action = invocation.getAction();  
		final ActionContext context = invocation.getInvocationContext();  
		HttpServletResponse response = (HttpServletResponse) context.get(ServletActionContext.HTTP_RESPONSE);
		HttpServletResponse res = (HttpServletResponse) response;

		res.setContentType("text/html;charset=UTF-8");

		   res.setHeader("Access-Control-Allow-Origin", "*");

		   res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");

		   res.setHeader("Access-Control-Max-Age", "0");

		   res.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");

		   res.setHeader("Access-Control-Allow-Credentials", "true");

		   res.setHeader("XDomainRequestAllowed","1");
		return  invocation.invoke();
	}

}
