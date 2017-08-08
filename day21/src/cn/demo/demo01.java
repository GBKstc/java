package cn.demo;

public class demo01 {

	public static void main(String[] args) throws ExceptionDemo {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			i = 11;
			
			int[] arr = {1,2,3};
			function(arr);
		} catch (ExceptionDemo e) {
			// TODO: handle exception
			System.out.println(e);
			//return ;
		} finally {
			System.out.println(i);
		}
		System.out.println(i);
	
	}
	
	public static void function(int[] arr) throws ExceptionDemo {
		if(arr.length<5) {
			throw new ExceptionDemo("错了");
 		}
		System.out.println(arr[5]);
	}

}
