package BJ;

import java.util.Scanner;

public class BJ11444 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		long N = sc.nextLong();
		int tmp;
		int a=1;
		int b=1;
		for (int i = 0; i < N; i++) {
			tmp = b;
			b = a+b;
			a = tmp;
			if (b==1000000007) {
				System.out.println(i);
			}
			b=(a+b)/1000000007;
		}
		System.out.println(b);
	}
}
