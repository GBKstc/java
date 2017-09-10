package cn.demo.util;

public class MyThread implements Runnable{
	public static cn.demo.service.Transfer service  = new cn.demo.service.Transfer();
	@Override
	public void run() {
		
		service.transfer(2000.0,"张三","李四");
		
	}
	
}
