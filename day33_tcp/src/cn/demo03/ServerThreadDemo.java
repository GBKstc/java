package cn.demo03;

import java.io.*;
//import java.io.IOException;
//import java.io.InputStream;
import java.net.Socket;

public class ServerThreadDemo implements Runnable {
	Socket socket;
	
	
	public ServerThreadDemo(Socket socket) {
		super();
		this.socket = socket;
	}

	public ServerThreadDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			InputStream is = socket.getInputStream();
			File file = new File("F:\\Java\\tese\\xg.jpg");
			FileOutputStream fos = new FileOutputStream(file);
			int len = 0;
			byte[] data = new byte[1024];
			while ((len=is.read(data))!=-1) {
				fos.write(data, 0, len);
			}
			fos.close();
			is.close();
			System.out.println("上传服务器成功");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
