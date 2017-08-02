package cn.demo;

import java.math.BigInteger;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int i = 0;
		System.out.println(function(100));
	}
	
	public static BigInteger function(int num) {
		BigInteger a1 = new BigInteger("1");
		BigInteger a2 = new BigInteger("1");
		System.out.println(num);
		if(num == 1) {
			return a1;
		}
		a1.add(a2);
		for(int i=0;i<num;i++) {
			a1 = a1.add(a2);
			a2 = a1;
		}
		//System.out.println(a1);
		return a1;
		
	}

}
