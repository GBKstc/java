package cn.demo;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Iterator;

//import java.awt.List;
//import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("f");
		list.add("b");
		list.add("c");
		list.add("a");
		list.add("d");
		System.out.println(list);
		
		LinkedHashSet<String> linkHash = new LinkedHashSet<>();
		
		for(String i:list) {
			linkHash.add(i);
		}
		System.out.println(linkHash);
		List<Integer> mylist = new ArrayList<Integer>();
		mylist.add(1);
		mylist.add(2);
		mylist.add(3);
		mylist.add(4);
		mylist.add(5);
		System.out.println(exchangeIndex(mylist,0,2));
		System.out.println(reversalList(mylist));
		Word("goOd gooD stUdy   dAy dAy up");
	}
	
	public static <T> List<T> exchangeIndex(List<T> coll,int index1,int index2) {
		T a = coll.get(index1);
		T b = coll.get(index2);
		coll.set(index2, a);
		coll.set(index1, b);
		return coll;
	}
	
	public static <T> List<T> reversalList(List<T> coll){
		List<T> arr1 = new ArrayList<T>();
//		Iterator<T> it = coll.iterator();
		for(int i=coll.size()-1;i>-1;i--) {
			arr1.add(coll.get(i));
		}
//		while(it.hasNext()) {
//			
//		}
		
		return arr1;
	}
	
	public static void Word(String value) {
		//List<String> arr = new ArrayList<String>();
		String[] wordArr = value.split(" +");
		for (int i = 0; i < wordArr.length; i++) {
			wordArr[i] = wordArr[i].toLowerCase();
			String aa = Character.toString(wordArr[i].charAt(0));
			String bb = aa.toUpperCase();
			wordArr[i] = wordArr[i].replaceFirst(aa,bb);
			System.out.println(wordArr[i]);
		}
		
	}
	

}
