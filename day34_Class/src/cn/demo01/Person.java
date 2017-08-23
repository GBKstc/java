package cn.demo01;

public class Person {
	
	private int age;
	private String name;
	@SuppressWarnings("unused")
	private Person(String name,int age,String work) {
		super();
		this.age = age;
		this.name = name;
	}
	
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void eat() {
		System.out.println("我在吃饭");
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	
}
