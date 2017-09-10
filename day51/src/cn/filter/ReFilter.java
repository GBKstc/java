package cn.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("Filter");	
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpServletRequest requestProxy = (HttpServletRequest) Proxy.newProxyInstance(
				request.getClass().getClassLoader(), 
				request.getClass().getInterfaces(), 
				new InvocationHandler() {
	
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						if("get".equals(request.getMethod())){
							if("getParameter".equals(method.getName())) {
								String value = (String)method.invoke(request, args);
								return new String(value.getBytes("iso8859-1"));
							}
						}
						return null;
					}
				});
		arg2.doFilter(requestProxy, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
