package com.my.app.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioClientSocket1 {

	public static void main(String[] args) {
		Selector selector = null;
		SocketChannel socketChannel = null;
		
		try {
			// 셀렉터를 열자. 외부로부터 접속이 들어오면 각 접속마다 셀렉터가 담당하게 된다.
			selector = Selector.open();
			// 서버 채널을 열자.
			socketChannel = SocketChannel.open();
			// 비블록 상태로 만들어서 넌블로킹 통신을 하자.
			socketChannel.configureBlocking(false);
			// 서버로 접속을 하자.
			SocketAddress remote = new InetSocketAddress("127.0.0.1", 8080);
			// SocketChannel open시 서버 접속 정보를 넣어주면 비블로킹 모드로 수행이 안됨.
			socketChannel.connect(remote);
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
			
			while (true) {
				selector.select();
				
				Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
				while (keys.hasNext()) {
					SelectionKey key = keys.next();
					keys.remove();

					if (key.isConnectable()) {
						SocketChannel channel = (SocketChannel) key.channel();

						if (channel.isConnectionPending()) {
							if (channel.finishConnect()) {
								key.interestOps(SelectionKey.OP_WRITE);
								System.out.println("Connected to: " + channel.getRemoteAddress());
							} else {
								key.cancel();
							}
						}
					} else if (key.isReadable()) {
						System.out.println("Client read.");
					} else if (key.isWritable()) {
						System.out.println("Client write.");
						SocketChannel channel = (SocketChannel) key.channel();
						ByteBuffer buffer = ByteBuffer.allocateDirect(8192);
						buffer.put("Hello World!".getBytes());
						buffer.flip();
						channel.write(buffer);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socketChannel != null) try { socketChannel.close(); } catch (IOException e) { }
			if (selector != null) try { selector.close(); } catch (IOException e) { }
		}
	}
	
}
