package cn.demo01;

public class Person {
	
	
	private String name;
	private int age;
	
	public static String getPropertyGetMethodName(String property) {
		
		return "get"+property;
	}
	public static Boolean isSymmetry(String property) {
		//String oldStr = property;
		int sl = property.length();
		while(sl>=2) {
			String s = property.substring(0, 1);
			String l = property.substring(sl-1, sl);
			property = property.substring(1,sl-1);
			sl = sl-2;
			if(s.equals(l)) {
				continue;
			}else {
				return false;
			}
		}
		
		return true;
	
		
	}
	public Person() {
		System.out.println("请传入参数");
	}
	
	public Person(String name,int age) {
		super();
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
