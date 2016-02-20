package com.my.app.common.util;

import java.util.Arrays;

public class DataUtil {

	public static void main(String[] args) {
		String arr = "3434,1212";
		Arrays.asList(arr.split(",")).stream().forEach(System.out::println);
	}
	
}
