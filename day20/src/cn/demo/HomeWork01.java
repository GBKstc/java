package cn.demo;

import java.util.*;

public class HomeWork01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student Sd1 = new Student("张三",20);
		Student Sd2 = new Student("李四",21);
		
		Map<Student, String> mlist = new HashMap<Student, String>();
		mlist.put(Sd1, "下沙");
		mlist.put(Sd2, "西湖");
		//System.out.println(mlist);
		
		Set<Student> list = mlist.keySet();
		Iterator<Student> it = list.iterator();
		while(it.hasNext()) {
			Student ii = it.next();
			System.out.println(ii+".."+mlist.get(ii));
		}
		
		Set<Map.Entry<Student,String>> set = mlist.entrySet();
		
		for(Map.Entry<Student,String> iss:set) {
			System.out.println(iss.getKey()+".."+iss.getValue());
		}
		
//		Iterator<Map.Entry<Student,String>> setList = set.iterator();
		
//		while(setList.hasNext()) {
//			Map.Entry<Student,String> is = setList.next();
//			System.out.println(is.getKey()+"..."+is.getValue());
//		}
		
		
	}

}
