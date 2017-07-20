import java.util.Scanner;
import java.util.Random;

public class ScannerDemo{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(num);
		
		Random ran = new Random();
		int ranNum = ran.nextInt(50);
		double ranNumD = ran.nextDouble();
		System.out.println(ranNum);
		System.out.println(ranNumD);
	}
}