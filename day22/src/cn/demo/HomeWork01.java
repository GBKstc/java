package cn.demo;

import java.io.*;

public class HomeWork01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("F:\\Java\\java");
//		File[] arr = file.listFiles(new MyFile());
		//traverseFile(file,new MyFile(),"");
//		chooseFile(arr);
		
		System.out.println("asdfo...".matches("\\..."));
		
	}
	
	public static void traverseFile(File file,MyFile myfile,String value) {
		value = value+" ";
		File[] arr = file.listFiles(myfile);
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].isDirectory()) {
				traverseFile(arr[i],myfile,value);
			}
			System.out.println(value+arr[i].getName());
		}
	}
	public static void traverseFile(File file,MyFileString myfile) {
		String[] arr = file.list(myfile);
		for (int i = 0; i < arr.length; i++) {
//			if(arr[i].matches("java")) {
//				traverseFile(arr[i],myfile);
//			}
			System.out.println(arr[i]);
		}
	}
	
//	public static File[] chooseFile(File[] arr) {
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
//		return arr;
//	}

}
