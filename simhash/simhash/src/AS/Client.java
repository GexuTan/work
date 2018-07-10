package AS;

import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends Thread {
	String addressPath;
	int portNumber;
	static Socket socket;
	SocketAddress socketAddress;
	SocketChannel socketChannel;

	private final static Logger logger = Logger.getLogger(Client.class
			.getName());

	public Client() {

	}

	public Client(String s, int i) {
		String addressPath = s;
		int portNumber = i;
		socket = new Socket();
		socketAddress = new InetSocketAddress(addressPath, portNumber);
		System.out.println("初始化结束");
		socketChannel = null;
		try {
			socketChannel = SocketChannel.open();
			socketAddress = new InetSocketAddress(addressPath, portNumber);
			socketChannel.connect(socketAddress);
		} catch (Exception ex) {
			System.out.println("申请 send");
		} finally {
			try {
				socketChannel.close();
			} catch (Exception ex) {
			}
		}
	}

	public boolean apply(String s, int i) throws Exception {
		socket.bind(socketAddress);
		// 连接地址
		socket.connect(socketAddress);
		System.out.println("申请 send");
		return true;
	}

	
	
	public boolean sendFile() throws IOException {
		FileInputStream fis = null;
		FileChannel channel = null;
		String file = "clientH.txt";
		try {
			fis = new FileInputStream(file);
			channel = fis.getChannel();
			ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
			int size = 0;
			while ((size = channel.read(buffer)) != -1) {
				buffer.rewind();
				buffer.limit(size);
				socketChannel.write(buffer);
				buffer.clear();
			}
			socketChannel.socket().shutdownOutput();
		} finally {
			try {
				channel.close();
			} catch (Exception ex) {
			}
			try {
				fis.close();
			} catch (Exception ex) {
			}
		}
		return true;
	}

	public boolean receiveFile() throws IOException {
		FileOutputStream fos = null;
		FileChannel channel = null;
		String file = "serverH.txt";
		try {
			fos = new FileOutputStream(file);
			channel = fos.getChannel();
			ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

			int size = 0;
			while ((size = socketChannel.read(buffer)) != -1) {
				buffer.flip();
				if (size > 0) {
					buffer.limit(size);
					channel.write(buffer);
					buffer.clear();
				}
			}
		} finally {
			try {
				channel.close();
			} catch (Exception ex) {
			}
			try {
				fos.close();
			} catch (Exception ex) {
			}
			
		}
		return true;
	}

}
