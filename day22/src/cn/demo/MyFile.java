package cn.demo;

import java.io.File;
import java.io.FileFilter;

public class MyFile implements FileFilter{

	public boolean accept(File pathname) {
		//System.out.println(pathname.length()<1000);
//		System.out.println(pathname.getName().matches(".*day.*"));
		return pathname.isDirectory()||pathname.getName().matches(".*java");
	}
}
