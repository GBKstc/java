package cn.demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class HomeWork01 {

	public static void main(String[] args) throws Exception {
		
		function_1();
		
	}

	private static void function_1() throws Exception {
		// TODO Auto-generated method stub
		byte[] data = "发送测试".getBytes();
		InetAddress Inet = InetAddress.getByName("127.0.0.1");
		DatagramPacket dp = new DatagramPacket(data, data.length, Inet,8000);
		DatagramSocket ds = new DatagramSocket(5688);
		ds.send(dp);
		ds.close();
	}

	private static void function() throws UnknownHostException {
		// TODO Auto-generated method stub
		System.out.println(InetAddress.getLocalHost().getHostAddress());
	}
	
}
