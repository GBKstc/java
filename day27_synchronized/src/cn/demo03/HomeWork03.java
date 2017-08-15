package cn.demo03;

import java.lang.Thread.State;
//import java.awt.List;
import java.util.*;

public class HomeWork03 {

	public static void main(String[] args) {
//		List<Integer> list = new ArrayList<Integer>();
		Door d1 = new Door();
//		Door d2 = new Door("后门");
		Thread td1 = new Thread(d1);
		Thread td2 = new Thread(d1);
		td1.setName("前门");
		td2.setName("后门");
		td1.start();
		td2.start();
		while(td1.getState().toString()!="TERMINATED"&&td2.getState().toString()!="TERMINATED") {
			d1.showPerson();
		}
		
	}

}
