package cn.demo02;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.OutputStream;

public class SocketDemo {
	
	public static void main(String[] args) throws IOException {
		getSocket();
	}

	private static void getSocket() throws IOException {
		// TODO Auto-generated method stub
		InetAddress Inet = InetAddress.getByName("127.0.0.1");
		Socket sc = new Socket(Inet,8050);
		OutputStream os = sc.getOutputStream();
		os.write("TCP测试".getBytes());
		os.close();
		sc.close();
	}

}
