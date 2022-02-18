package bj;

import java.util.Scanner;

public class BJ8320 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		int cnt=0;
		
		for (int i = 1; i <= N; i++) {
			for(int j=1;j<=Math.sqrt(i);j++) {
				if(i%j==0) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
