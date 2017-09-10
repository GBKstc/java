package cn.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class MyTestMain {
	@Test
	public static void main(String[] args) {
		MyTestDemo mtd = new MyTestDemo();
		MyTest mt = (MyTest)Proxy.newProxyInstance(
				mtd.getClass().getClassLoader(),
				mtd.getClass().getInterfaces(),
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO Auto-generated method stub
						Object obj = method.invoke(mtd, args);
						return obj;
					}
					
				});
		mt.method1();
		String method2 = mt.method2();
		System.out.println(method2);
	}
}
