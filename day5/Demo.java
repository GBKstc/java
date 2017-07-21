import java.util.Scanner;

public class Demo{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入长方形长度:");
		int l = sc.nextInt();
		System.out.println("请输入长方形宽度:");
		int w = sc.nextInt();
		System.out.println("长方形面积是:");
		System.out.println(gitArea(l,w));
		
	}
	
	public static int gitArea(int l,int w){
		
		return l*w;
		
	}
	
}