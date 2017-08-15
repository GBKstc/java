package cn.demo02;

import java.util.concurrent.Callable;

public class LotterDraw02 implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int i = (int)(Math.random()*100);
		System.out.println(i);
		return 1;
	}

	
}
