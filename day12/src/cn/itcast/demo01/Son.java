package cn.itcast.demo01;

public class Son extends Father {
	
	public int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Son() {
		System.out.println("子类构造器");
	}
	
}
