import java.util.*;

public class LoopTest{
	
	public static void main (String[] args){
		Boolean i = true;
		while(i){
			
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			if(num==100){
				i = false;
				return false;
			}
			num = Loop(num);
		}
		
		
		
	}
	
	public static int Loop (int num){
		System.out.println(num);
		return num;
		//for(int i=0;i<num;i++){
		
		//}
	}
	
}