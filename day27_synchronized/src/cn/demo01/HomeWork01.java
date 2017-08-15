package cn.demo01;

public class HomeWork01 {
	
	public static void main(String[] args) throws InterruptedException {
		
//		System.out.println(HomeWork01.class);
		Thread td1 = new Thread(new MyThread01());
		Thread td2 = new Thread(new MyThread02());
	
		td1.start();
		//HomeWork01.class.notify();
		td2.start();
	}
	
}
