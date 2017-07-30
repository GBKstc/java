package cn.demo01;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person p1 = new Person("张三",24);
		Person p2 = p1;
		//Person p2 = new Person("张三",24);
		System.out.println(p1.equals(p2));
		
		System.out.println("a".isEmpty());
		System.out.println("A".toLowerCase());
		System.out.println("a".toUpperCase());
		System.out.println("aAAAAAA".replace("a", "v"));
		System.out.println("aAAAAAA".replace("AA", "v"));
		System.out.println("   aAAAAAA    ".trim());
		System.out.println(Person.getPropertyGetMethodName("西瓜"));
		
		String[] arr = {"010","3223","666","7890987","123123"};
		int j = 0;
		for(int i = 0;i<arr.length;i++) {
			if(Person.isSymmetry(arr[i])) {
				j++;
			}
		}
		System.out.println(j);
		
	}

}
