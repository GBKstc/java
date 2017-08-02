package cn.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {

	public static void main(String[] args) {
		function();
	}

	private static void function() {
		// TODO Auto-generated method stub
		Collection<String> coll = new ArrayList<String>();
		coll.add("11");
		coll.add("11");
		coll.add("11");
		coll.add("11");
		
		Iterator<String> i = coll.iterator();
	}
}
