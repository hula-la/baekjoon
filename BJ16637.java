package bj;

import java.util.Scanner;

public class BJ16637 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		char[] exp = sc.next().toCharArray();
		int[][] dp = new int[N/2+1][2];
		dp[0] = new int[] {exp[0]-'0',exp[0]-'0'};
		if (N>=3) {
			dp[1] = new int[] {cal(exp[1],exp[0]-'0',exp[2]-'0'),cal(exp[1],exp[0]-'0',exp[2]-'0')};
		}

//		for (int i = 4; i < N; i+=2) {
//			int a = 
//			dp[i/2][0] = cal(exp[i-1],Math.max(dp[i/2-1][0], dp[i/2-1][1]),exp[i]-'0');
//			dp[i/2][1] = cal(exp[i-3],Math.max(dp[i/2-2][0], dp[i/2-2][1]),cal(exp[i-1],exp[i-2]-'0',exp[i]-'0'));
//			
//		}
		for (int i = 4; i < N; i+=2) {
//			System.out.println(i+" "+(exp[i]-'0'));
			int a = cal(exp[i-1],dp[i/2-1][0],exp[i]-'0');
			int b = cal(exp[i-1],dp[i/2-1][1],exp[i]-'0');
			dp[i/2][0] = Math.max(a, b);
			a = cal(exp[i-3],dp[i/2-2][0],cal(exp[i-1],exp[i-2]-'0',exp[i]-'0'));
			b = cal(exp[i-3],dp[i/2-2][1],cal(exp[i-1],exp[i-2]-'0',exp[i]-'0'));
			dp[i/2][1] = Math.max(a, b);
			
		}
		
		for (int[] i:dp) {
			System.out.println(i[0]+" "+i[1]);
			
		}
		
		System.out.println(Math.max(dp[N/2][0],dp[N/2][1]));
	}
	
	static int cal(char c, int a, int b) {
		switch(c) {
		case('+'): return a+b;
		case('*'): return a*b;
		case('-'): return a-b;
		default: return 0;
		}
	}
}
