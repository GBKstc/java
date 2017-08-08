package cn.demo;

import java.io.File;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		function();
		function_1();
		function_2();
	}

	private static void function_2() {
		// TODO Auto-generated method stub
//		File file = new File("F:\\Java\\java\\day22\\File");
		File file = new File("F:\\Java\\java\\day22\\File.txt");
		boolean b = file.delete();
		System.out.println(b);
	}

	private static void function_1() {
		// TODO Auto-generated method stub
		File file = new File("F:\\Java\\java\\day22\\File");
		boolean b = file.mkdir();
		System.out.println(b);
	}

	private static void function() {
		// TODO Auto-generated method stub
//		File file = new File("F:\\Java\\java\\day22\\File.txt");
//		boolean b = file.createNewFile();
//		System.out.println(file.createNewFile());
	}

	
}
