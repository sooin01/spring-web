package com.my.app.common.util;

import java.io.IOException;

public class ConsoleUtil {

	public static void consoleExec() throws IOException {
		String path = "C:/dev/workspace/spring-web/src/main/resources/util/";
		String exec = "putty.exe -ssh root@192.168.56.101 -P 22 -pw admin123";
		Runtime.getRuntime().exec(path + exec);
	}
	
}
