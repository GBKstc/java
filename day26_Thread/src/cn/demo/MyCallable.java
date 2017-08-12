package cn.demo;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer>{
	
	int i;
	
	public MyCallable(Integer j) {
		super();
		this.i = j;
		// TODO Auto-generated constructor stub
	}

	public Integer call() {
		int a = 0;
		System.out.println(i);
		for (;i>0;i--) {
			System.out.println(i);
			a = a+i;
		}
		return a;
	}
	
}
