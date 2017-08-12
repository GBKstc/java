package cn.demo;

public class HomeWork01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread mt = new MyThread();
		MyRunnable mr = new MyRunnable();
		System.out.println(Thread.currentThread().getName());
		mt.start();
		new Thread(mr).start();
		for(int i=0;i<50;i++) {
        	System.out.println(i+"...main");
        }
	}

}
