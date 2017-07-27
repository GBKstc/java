package cn.itcast.demo01;

public class Car {

	private String color ;
	
	int count ;
	
	public void run() {
		
		System.out.println("跑"+" "+color+" "+count+"号跑车");
		
	}
	
	public void setColor(String value) {
		
		color = value;
		
	}
	
}
