package com.my.app.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;

public class NioServerSocket1 {

	public static void main(String[] args) {
		Selector selector = null;
		ServerSocketChannel serverSocketChannel = null;
		ServerSocket serverSocket = null;
		
		Charset charset = Charset.forName("UTF-8");
		CharsetDecoder decoder = charset.newDecoder();
		
		try {
			// 셀렉터를 열자. 외부로부터 접속이 들어오면 각 접속마다 셀렉터가 담당하게 된다.
			selector = Selector.open();
			// 서버소켓 채널을 열자.
			serverSocketChannel = ServerSocketChannel.open();
			// 비블록 상태로 만들어서 넌블로킹 통신을 하자.
			serverSocketChannel.configureBlocking(false);
			// 통신을 담당하는 서버 소켓을 반환하자.
			serverSocket = serverSocketChannel.socket();
			// 호스트와 포트로 서버를 바인딩하자.
			SocketAddress endpoint = new InetSocketAddress("127.0.0.1", 8080);
			serverSocket.bind(endpoint, 50);
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			// 외부로부터 접속 승인 상태.
			
			while (true) {
				// 외부로부터 통신을 하자.
				selector.select();
				
				Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
				while (keys.hasNext()) {
					SelectionKey key = keys.next();
					
					// 다음 요청 시에 중복 키가 발생할 수 있어 제거.
					keys.remove();
					
					if (!key.isValid()) {
						continue;
					}
					
					if (key.isAcceptable()) {
						// 접속 승인 처리
						ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
						SocketChannel channel = serverChannel.accept();
						channel.configureBlocking(false);
						Socket socket = channel.socket();
						System.out.println("Connected to: " + socket.getRemoteSocketAddress());
						channel.register(selector, SelectionKey.OP_READ);
					} else if (key.isReadable()) {
						// 읽기 처리
						SocketChannel channel = (SocketChannel) key.channel();
						ByteBuffer buffer = ByteBuffer.allocate(8192);
						int read = channel.read(buffer);
						
						if (read == -1) {
							Socket socket = channel.socket();
							SocketAddress remoteAddr = socket.getRemoteSocketAddress();
							System.out.println("Connection closed by client: " + remoteAddr);
							channel.close();
							key.cancel();
							break;
						}
						
						buffer.flip();
						System.out.println("Got: " + decoder.decode(buffer).toString());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null) try { serverSocket.close(); } catch (IOException e) { }
			if (serverSocketChannel != null) try { serverSocketChannel.close(); } catch (IOException e) { }
			if (selector != null) try { selector.close(); } catch (IOException e) { }
		}
	}
	
}
