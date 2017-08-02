package cn.demo01;

public class Test {
	
	public static void main(String[] args) {
		String a = "[1-9][0-9]{4,9}";
		String QQ = "12345678";
		Boolean aa = QQ.matches(a);
		System.out.println(aa);
		String[] arr = QQ.split("");
	    for (int i = 0; i < arr.length; i++) {
	    	System.out.println(arr[i]);
		}
	    
	    String str = "Hello5646123World234234!";
	    System.out.println(str.replaceAll("[0-9]+", " "));
	    String em = ".+//@.+//.[com]";
	    System.out.println("271677538@qq.com".matches(em));
		
	}

}
