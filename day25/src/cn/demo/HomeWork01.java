package cn.demo;

import java.io.*;
import java.util.*;

public class HomeWork01 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Person p1 = new Person("P1",21);
		Person p2 = new Person("P2",22);
		Person p3 = new Person("P3",23);
		Person p4 = new Person("P4",20);
		Person p5 = new Person("P5",25);
		Person p6 = new Person("P1",26);
		List<Person> list = new ArrayList<Person>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		list.add(p5);
		list.add(p6);
		File file = new File("F:\\Java\\tese\\test.txt");
		writeStudent(file,list);
		List<Person> list1 = readStudeng(file);
		Set<Person> newList = new HashSet<Person>();
		for(Person ps:list1) {
			newList.add(ps);
//			System.out.println(newList);
		}
		list1.clear();
		list1.addAll(newList);
		Collections.sort(list1);
		System.out.println(list1);
	}
	
	private static List<Person> readStudeng(File file) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<Person> list = (List<Person>) ois.readObject();
		ois.close();
		return list;
	}

	public static void writeStudent(File file,List<Person> list) throws IOException{
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream ois = new ObjectOutputStream(fos);
		ois.writeObject(list);
		ois.close();
	}
	
}
