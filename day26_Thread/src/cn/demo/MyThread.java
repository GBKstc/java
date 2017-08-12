package cn.demo;

public class MyThread extends Thread{
	
	public void run() {
        // compute primes larger than minPrime
        for(int i=0;i<50;i++) {
        	System.out.println(i+"...MyThread");
        }
    }
}
