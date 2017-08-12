package cn.demo;

import java.util.concurrent.ExecutionException;
//import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import java.util.concurrent.Future;

public class HomeWork02 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(2);
//		es.submit(new MyRunnable());
//		es.submit(new MyRunnable());
//		es.shutdown();
		Integer aa = es.submit(new MyCallable(100)).get();
		System.out.println(aa);
	}
	
}
