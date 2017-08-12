package cn.demo;

public class MyRunnable implements Runnable{
	
	public void run() {
		 for(int i=0;i<50;i++) {
	        System.out.println(i+"...MyRunnable");
	     }
	 }
	 
	
}
