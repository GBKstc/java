package cn.demo02;

import java.text.SimpleDateFormat;
import java.util.Date;

public class demo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date d = new Date();
		System.out.println(d.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH点mm分ss秒");
		System.out.println(sdf.format(d.getTime()));
	}

}
