package day8;

public class Demo {

	public static void main(String[] args) {
		System.out.println(AA("Hello World!"));
		System.out.println("Hello World");
		int[] ar = { 1, 2, 3, 4, 5, 6, 7 };
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
	}
	
	public static String AA(String value) {
		return value;
	}

}
