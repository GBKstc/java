package cn.demo01;

public class MyThread02 implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (HomeWork01.class) {
			try {
//				while(true) {
					System.out.println("MyThread02");
//				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
