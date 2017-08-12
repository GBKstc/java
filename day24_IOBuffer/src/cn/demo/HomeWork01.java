package cn.demo;

import java.io.*;
import java.util.*;

public class HomeWork01 {
	
	public static void main(String[] args) throws IOException{
		File file = new File("F:\\Java\\java");
		List<File> list = new ArrayList<File>();
		list = chooseFile(file,list);
		Iterator<File> it = list.iterator();
		
		while(it.hasNext()) {
//			String FileOld = "F:\\Java\\tese";
			File file1 = it.next();
			File file2 = new File("F:\\Java\\tese",file1.getAbsolutePath().split("\\\\java")[1]);
			System.out.println(file2);
			if(file1.isDirectory()&&(!file2.exists())) {
				file2.mkdirs();
			}else if(!file1.isDirectory()) {
				CopyFile(file1,file2);
			}
//			System.out.println(file1);

		}
	}
	
	public static List<File> chooseFile(File file,List<File> list){
		File[] arr = file.listFiles(new MyFile());
		for(File fl:arr) {
			list.add(fl);
			if(fl.isDirectory()) {
				chooseFile(fl,list);
			}
		}
		return list;
	}
	
	public static void CopyFile(File file1,File file2) throws IOException {
		FileInputStream fis = new FileInputStream(file1);
		FileOutputStream fos = new FileOutputStream(file2);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		byte[] arr = new byte[1024];
		int len = 0;
		while(bis.read(arr)!=-1) {
//			System.out.println(arr);
			bos.write(arr,0,len);
		}
		bos.close();
		bis.close();
	}
}
