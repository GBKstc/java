package cn.itcast.demo04;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Laptop a = new Laptop();
		a.Open();
		a.useUSB(new Mouse());
		a.Close();
		
	}

}
