package BJ;

import java.util.Scanner;

public class bj1676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		int f = (int) (Math.log(n)/Math.log(5));
		int t=0;
		while(n!=0) {
			t+=n/5;
			n/=5;
		}
		System.out.println(t);
		
	}
}
