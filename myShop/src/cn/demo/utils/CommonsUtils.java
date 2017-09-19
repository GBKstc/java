package cn.demo.utils;

import java.util.UUID;

import javax.servlet.http.Cookie;

public class CommonsUtils {

	//生成uuid方法
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}
	
	public static String getCookieValue(Cookie[] cookies,String key) {
		for(Cookie cookie : cookies){
			//获得cookie的名称
			String cookieName = cookie.getName();
			if(cookieName.equals(key)){
				//获得该cookie的值
				return cookie.getValue();
			}
		}
		return null;
	}
	
}
