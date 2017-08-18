package cn.demo03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo {
	
	public static void main(String[] args) throws IOException {
		
		getServer();
		
	}

	private static void getServer() throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(8020);
		
		while(true) {
			Socket socket = ss.accept();
			ServerThreadDemo std = new ServerThreadDemo(socket);
			new Thread(std).start();
		}
	}
	

}
