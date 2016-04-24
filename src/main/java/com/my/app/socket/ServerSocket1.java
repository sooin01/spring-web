package com.my.app.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSocket1 {
	
	private ExecutorService executorService = Executors.newFixedThreadPool(10);
	
	private ServerSocket serverSocket;
	
	public ServerSocket1() throws IOException {
		InetAddress bindAddr = InetAddress.getByName("localhost");
		System.out.println(bindAddr.getHostName() + " => " + bindAddr.getHostAddress());
		// 포트는 8080, 접속 대기는 100
		this.serverSocket = new ServerSocket(8080, 100, bindAddr);
	}
	
	public void run() {
		try {
			while (true) {
				System.out.println("waiting..");
				Socket socket = serverSocket.accept();
				SocketProcess1 socketProcess1 = new SocketProcess1(socket);
				executorService.execute(socketProcess1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (executorService != null) {
				executorService.shutdown();
			}
		}
	}
	
	public void close() {
		try {
			if (serverSocket != null) {
				serverSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServerSocket1 serverSocket1 = null;
		
		try {
			serverSocket1 = new ServerSocket1();
			serverSocket1.run();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			serverSocket1.close();
		}
	}
	
}

class SocketProcess1 extends Thread {
	
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;

	public SocketProcess1(Socket socket) throws IOException {
		this.socket = socket;
		br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
	}
	
	@Override
	public void run() {
		System.out.println("start..");
		String line = null;
		
		try {
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				pw.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) pw.close();
			if (br != null) try { br.close(); } catch (IOException e) { }
			if (socket != null) try { socket.close(); } catch (IOException e) { }
		}
		
		System.out.println("end..");
	}
	
}