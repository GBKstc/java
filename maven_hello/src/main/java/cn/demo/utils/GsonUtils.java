package cn.demo.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonUtils {

	// 将Json数据解析成相应的映射对象
	public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        T result = gson.fromJson(jsonData, type);
        return result;
    }     
	 
	// 将Json数组解析成相应的映射对象列表
	public static <T> List<T> parseJsonArrayWithGson(String jsonData, Class<T> type) {
		Gson gson = new Gson();
		List<T> result = new ArrayList<T>(); 
		result = gson.fromJson(jsonData, new TypeToken<List<T>>() {
		}.getType());
	

		return result;
	}
}
