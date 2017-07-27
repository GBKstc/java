import java.util.ArrayList;

public class TestPhone{
	public static void main(String[] args){
		
		ArrayList<String> arr1 = new ArrayList<String>();
		//ArrayList<Integer> arr2 = new ArrayList();
		
		arr1.add("A");
		arr1.add("B");
		arr1.add("C");
		arr1.add("D");
		
		System.out.println(arr1.size());
		
		Phone p = new Phone();
		p.brand = "Åµ»ùÑÇ";
		p.color = "°×É«";
		p.size = 5.5;
	}
}