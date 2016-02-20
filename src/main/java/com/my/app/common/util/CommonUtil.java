package com.my.app.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CommonUtil {

	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	public static String toJson(Object obj) {
		return gson.toJson(obj);
	}
	
}
