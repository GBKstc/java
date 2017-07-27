package cn.itcast.demo04;

public  class Laptop {
	
	public  void Open() {
		System.out.println("Open");
	};
	public  void Close() {
		System.out.println("Close");
	};
	public void useUSB(USB usb) {
		usb.use();
		//usb.close();
	}
	
}
