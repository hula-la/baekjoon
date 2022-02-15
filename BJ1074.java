package bj;

import java.io.IOException;
import java.util.Scanner;

public class BJ1074 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		int result = 0;
		
		char[] R = Integer.toBinaryString(r).toCharArray();
		char[] C = Integer.toBinaryString(c).toCharArray();
		
		for(int i=0;i<R.length;i++) {
			result+=2*(R[R.length-1-i]-'0')*Math.pow(2, i*2);
		}
		for(int i=0;i<C.length;i++) {
			result+=(C[C.length-1-i]-'0')*Math.pow(2, i*2);
		}
		
		System.out.println(result);
		sc.close();
	}
}
