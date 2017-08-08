package cn.demo;

import java.io.File;
import java.io.FilenameFilter;

public class MyFileString implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
//		System.out.println(dir);
		String a = name;
//		System.out.println("]day".matches(".*day$"));
		return a.matches(".*day.*");
	}

}
