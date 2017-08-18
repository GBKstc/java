package cn.demo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class HomeWork01_1 {

	public static void main(String[] args) throws Exception {
		function();
	}

	private static void function() throws Exception {
		// TODO Auto-generated method stub
		byte[] data = new byte[1024];
		DatagramPacket dp = new DatagramPacket(data, data.length);
		DatagramSocket ds = new DatagramSocket(8000);
		while(true) {
			ds.receive(dp);
			int len  = dp.getLength();
			String data1 = new String(dp.getData(),0,len);
			System.out.println(dp.getAddress()+"..."+data1);
		}
	}
	
}
