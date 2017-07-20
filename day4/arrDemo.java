import java.util.Random;

public class arrDemo{
	public static void main(String[] args){
		String[] arr = {"Î÷¹Ï","ÂÜ²·","°×²Ë","Æ»¹û","Ïã½¶","°ÅÀ­"};
		int[] arr1 = new int[5];
		int[][] arr2 = new int[5][2];
		//System.out.println(arr2[2]);
		Random ran = new Random();
		int ranNum = ran.nextInt(arr.length);
		
		System.out.println(arr[ranNum]);
	}
}