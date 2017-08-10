package cn.demo;
import java.io.*;
import java.util.*;
public class HomeWork02 {

	public static void main(String[] args) throws IOException {
		File file = new File("F:\\Java\\tese\\config.properties");
//		Properties pss= new Properties();
//		pss = readProperties(file);	
////		System.out.println(pss.put("name","西瓜"));
////		System.out.println(pss);
//		FileOutputStream fos = new FileOutputStream(file);
//		pss.store(fos, null);
//		fos.close();
		FileReader fis = new FileReader(file);
		BufferedReader bis = new BufferedReader(fis);
		StringBuilder sb = new StringBuilder();
		String s = null;
		while((s = bis.readLine())!=null) {
			if(s.matches("^#.*")) {
				continue;
			}
//			System.out.println(s.matches("^#.*"));
			sb.append(s+"\r\n");
		}
		bis.close();
		System.out.println(sb.toString());
		FileWriter foss = new FileWriter(file);
		BufferedWriter bos = new BufferedWriter(foss);
		bos.write(sb.toString());
		bos.close();
	}
	
	public static Properties readProperties(File file) throws IOException{
		Properties ps = new Properties();
		FileInputStream fis = new FileInputStream(file);
		ps.load(fis);
		fis.close();
		return ps;
	}
}
