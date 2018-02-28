package cn.demo.conversion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConversion1 implements Converter<String, Date> {

	@Override
	public Date convert(String arg0) {
		try {
			if(null!=arg0) {
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return df.parse(arg0);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
