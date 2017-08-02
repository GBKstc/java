package cn.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//import javax.swing.text.html.HTMLDocument.Iterator;

public class demo {

	public static void main(String[] args) {
//		ArrayList<Integer> arr = new ArrayList<>();
		System.out.println(function_4("c"));
	}
	
	private static String function_4(String value) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		
		Iterator<String> it = list.iterator();
		int i = 0;
		while(it.hasNext()) {
			if(it.next().equals(value)) {
				i++;
			}
		}
		return value+"有"+i+'个';
	}

	private static void function_3() {
		// TODO Auto-generated method stub
		Collection<String> coll = new ArrayList<String>();
		coll.add("11");
		coll.add("12");
		coll.add("13");
		System.out.println(coll.remove("10"));
		System.out.println(coll.remove("11"));
		System.out.println(coll);
	}

	private static void function_2() {
		// TODO Auto-generated method stub
		Collection<String> coll = new ArrayList<String>();
		coll.add("11");
		coll.add("12");
		coll.add("13");
		coll.add("14");
		
		Object[] objs = coll.toArray();
		System.out.println(objs);
		for (int i = 0; i < objs.length; i++) {
			Object object = objs[i];
			System.out.println(object);
		}
	}

	public static void function_1() {
		Collection<String> coll = new ArrayList<String>();
		coll.add("11");
		coll.add("12");
		coll.add("13");
		coll.add("14");
		System.out.println(coll.contains("13"));
	}
	
	public static void function() {
		Collection<String> coll = new ArrayList<String>();
		coll.add("11");
		coll.add("11");
		coll.add("11");
		coll.add("11");
		coll.clear();
		System.out.println(coll);
	}
}
