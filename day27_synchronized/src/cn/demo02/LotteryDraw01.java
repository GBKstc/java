package cn.demo02;

//import java.util.*;
//import java.util.concurrent.Callable;

public class LotteryDraw01 implements Runnable{
	Integer[] list;
	String name;
	Integer num;
	private static Integer j = 0;
	public LotteryDraw01() {
		super();
	}
	
	public LotteryDraw01(Integer[] list,String name,Integer num) {
		super();
		this.list = list;
		this.name = name;
		this.num = num;
//		this.j = j;
	}

	@Override
	public void run(){
		// TODO Auto-generated method stub
		int i = 0;
		//int j = 0;
		synchronized (list) {
			while(true) {
				if(j%2==num) {
					try {
						list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				j++;
				System.out.println(j);
				i = (int)(Math.random()*11);
				System.out.println(this.name+"..."+list[i]);
				list.notify();
			}
		}
		
		
	}
	

}
