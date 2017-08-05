package cn.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class HomeWork02 {

	public static void main(String[] args) {
		String a = "If~you-want~to~change-your_fate_I_think~you~must~come-to-the-dark-horse-to-learn-java";
		String[] list = a.split("");
//		System.out.println(map);
		HashMap<String,Integer> map1 = new HashMap<String,Integer>();
		for (int i = 0; i < list.length; i++) {
			map1 = function(map1,list[i]);
		}
		System.out.println(map1);
		Set<String> set = map1.keySet();
		List<String> listaa = new ArrayList<>();
		listaa.addAll(set);
		Collections.sort(listaa);
//		Collections.sort(set);
		for(String i:listaa) {
			System.out.print(i+"("+map1.get(i)+")");
		}
	}
	
	public static HashMap<String,Integer> function(HashMap<String,Integer> map,String value) {
//		System.out.println(map.get(value));
		if(map.get(value)==null) {
			map.put(value, 1);
			return map;
		}
		
		int i = map.get(value);
		map.put(value, ++i);
		return map;
		
	}
}
