package com.my.app.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Socket1 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			InetAddress bindAddr = InetAddress.getByName("localhost");
			System.out.println(bindAddr.getHostName() + " => " + bindAddr.getHostAddress());
			serverSocket = new ServerSocket(8080, 100, bindAddr);
			Socket socket = serverSocket.accept();
			
			// 외부로부터 접속이 왔다. 스레드 풀을 빌려서 실행하자.
			
			// 외부로부터 온 데이터를 읽자.
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			br.close();
			socket.close();
			
			// 외부로부터 통신이 종료됐다. 스레드 풀에 반환하자.
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 서버 작업 끝났으니 종료하자.
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
}
