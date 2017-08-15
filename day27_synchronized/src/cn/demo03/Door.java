package cn.demo03;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Door implements Runnable{
	private Map<String,Integer> Person = new HashMap<String,Integer>();
	private Integer person = 0;
//	private String name ;
	private static Lock lock = new ReentrantLock();

	public Door(String name) {
		super();
//		this.name = name;
//		this.list = list;
	}
	public Door() {
		super();
		this.Person.put("前门", 0);
		this.Person.put("前门a", 0);
		this.Person.put("后门", 0);
		this.Person.put("后门", 0);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		int a = 0;
		while(true) {
			synchronized (person) {
				if(person<100) {
//					System.out.println(Person);
//					if(Person.get(name)==null) {
//						Person.put(name, 0);
//					}
					a = Person.get(name);
					a = a+1;
					Person.put(name,a);
					person++;
					System.out.println(person+"员工从"+name+"进来 双色球是"+getUnionLotto());
				}else {
//					Person.put(name+"a",1);
//					System.out.println(Person.get(name)+"个员工是从"+name+"进来的");
					return ;
				}
//				if(person<100&&(Person.get("前门a")==1)&&(Person.get("后门a")==1)) {
//					System.out.println(Person.get(name)+"个员工是从"+name+"进来的");
//					return ;
//				}
			}
				
		}
//		synchronized (list) {
//			
//		}
		

		
		
	}
	
	public static List<Integer> getUnionLotto() {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<7;i++) {
			list.add((int)(Math.random()*100));
		}
		return list;
	}
	
	public void showPerson() {
		Set<String> list = Person.keySet();
		for(String name:list) {
			System.out.println(Person.get(name)+"个员工是从"+name+"进来的");

		}
//		System.out.println(Person.get(name)+"个员工是从"+name+"进来的");
	}

}
