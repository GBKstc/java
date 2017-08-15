package cn.demo02;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;

public class HomeWork02 {
	
	public static  void main(String[] args) throws InterruptedException, ExecutionException{
		// TODO Auto-generated method stub
		Integer[] list = {10,5,20,50,100,200,500,800,2,80,300};
		
		LotteryDraw01 ld1 = new LotteryDraw01(list,"一号奖池",0);
		LotteryDraw01 ld2 = new LotteryDraw01(list,"二号奖池",1);
		Thread td1 = new Thread(ld1);
		Thread td2 = new Thread(ld2);
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.submit(td1);
		es.submit(td2);
		es.submit(td1);
		es.submit(td2);
		es.submit(td2);
		es.submit(td2);
		es.submit(td2);
		es.submit(td1);
	}

}
