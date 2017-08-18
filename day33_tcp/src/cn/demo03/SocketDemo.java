package cn.demo03;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketDemo {
	
	public static void main(String[] args) throws IOException {
		putSocket();
	}

	private static void putSocket() throws IOException {
		// TODO Auto-generated method stub
		Socket socket = new Socket("127.0.0.1",8020);
		OutputStream os = socket.getOutputStream();
		File file = new File("F:\\Java\\a.jpg");
//		System.out.println(file);
		FileInputStream fis = new FileInputStream(file);
		int len = 0;
		byte[] data = new byte[1024];
		while((len=fis.read(data))!=-1) {
			os.write(data,0,len);
		}
		socket.shutdownOutput();
		fis.close();
		os.close();
		socket.close();
		System.out.println("发送完毕");
	}

}
