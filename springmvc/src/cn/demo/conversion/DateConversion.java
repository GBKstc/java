package cn.demo.conversion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConversion implements Converter<String, Float> {

	@Override
	public Float convert(String arg0) {
		try {
			if(null!=arg0) {
				System.out.println(Float.parseFloat(arg0));
				Float f = Float.parseFloat(arg0);
				return f;
				/*DateFormat df = new SimpleDateFormat("yyyy-MM_dd HH:mm:ss");
				return df.parse(arg0);*/
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
