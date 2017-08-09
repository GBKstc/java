package cn.demo;
import java.io.File;
import java.io.FileFilter;

public class MyFile implements FileFilter{

	@Override
	public boolean accept(File pathname) {
		// TODO Auto-generated method stub
		return pathname.getName().matches(".*java")||pathname.isDirectory();
	}
	
}
