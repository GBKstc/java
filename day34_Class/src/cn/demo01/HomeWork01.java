package cn.demo01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class HomeWork01 {
	
	public static void main(String[] args) throws Exception {
		
//		Class c = Class.forName("cn.demo01.Person");
//		for(Constructor cr:c.getDeclaredConstructor(String.class,int.class,String.class)) {
//			System.out.println(c.getDeclaredConstructor(String.class,int.class,String.class));
//		}
//		System.out.println(c.getConstructors());
//		Constructor con = c.getConstructor(int.class,String.class);
//		System.out.println(con.newInstance(25,"西瓜"));
//		for(Method fd:c.getMethods()) {
//			System.out.println(fd);
//		}
//		Object obj = c.newInstance();
//		Method method = c.getMethod("eat");
//		method.invoke(obj);
		
		List<String> arr = new ArrayList<String>();
		Class arrcla = arr.getClass();
		arr.add("sdasdf");
		Method method = arrcla.getMethod("add", Object.class);
		method.invoke(arr, 123);
		for(Object obj:arr) {
			System.out.println(obj);
		}
	}

}
