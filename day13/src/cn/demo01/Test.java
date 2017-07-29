package cn.demo01;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Demo d = new Demo();
		d.out();
		//d.a = 3;
		System.out.println(Demo.a);
		
		Demo.DemoU dd = new Demo().new DemoU();
		
		System.out.println(dd.u);
	}

}
