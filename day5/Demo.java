import java.util.Scanner;

public class Demo{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�����볤���γ���:");
		int l = sc.nextInt();
		System.out.println("�����볤���ο��:");
		int w = sc.nextInt();
		System.out.println("�����������:");
		System.out.println(gitArea(l,w));
		
	}
	
	public static int gitArea(int l,int w){
		
		return l*w;
		
	}
	
}