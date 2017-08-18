package cn.demo02;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {
	
	public static void main(String[] args) throws IOException {
		getServerSocket();
	}

	private static void getServerSocket() throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(8050);
		Socket socket= ss.accept();
		
		InputStream is = socket.getInputStream();
		int len = 0;
		byte[] data = new byte[1024];
		while((len=is.read(data))!=-1) {
			System.out.println(new String(data,0,len));
		};
		System.out.println("输入成功");
	}

}
