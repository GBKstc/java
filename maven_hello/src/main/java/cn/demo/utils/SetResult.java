package cn.demo.utils;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class  SetResult {
	private static Gson gson = new Gson();
	
	public static <T> String setResult(String msg,T data) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("code", "0");
		if(msg.isEmpty())
			msg = "成功";
		map.put("msg", msg);
		map.put("data", data);
		return gson.toJson(map);
	}

	//默认返回结果
	public static String setDefaultResult(){
		return setResult("", "");
	}	
	
	//返回错误信息 msg返回error_code所代表的信息,在配置中配置
	public static String sendErrorByCode(String error){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("error", "1");
		map.put("msg", error);
		map.put("data", "");
		return gson.toJson(map);
	}	
}
