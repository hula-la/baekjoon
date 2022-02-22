package bj;

import java.util.Scanner;

public class BJ16637 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		char[] exp = sc.next().toCharArray();
		int[][] dp = new int[N/2+1][2];
		int f = exp[0]-'0';
		dp[0] = new int[] {f,f};
		if (N>=3) {
			int s = exp[2]-'0';
			int a = cal(exp[1],f,s);
			dp[1] = new int[] {a,a};
		}

		for (int i = 4; i < N; i+=2) {
			int a = cal(exp[i-1],exp[i-2]-'0',exp[i]-'0');
			dp[i/2][0] = Math.max(cal(exp[i-1],dp[i/2-1][0],exp[i]-'0'),cal(exp[i-3],dp[i/2-2][0],a));
			dp[i/2][1] = Math.min(cal(exp[i-1],dp[i/2-1][1],exp[i]-'0'),cal(exp[i-3],dp[i/2-2][1],a));

			dp[i/2][0] = Math.max(dp[i/2][0],cal(exp[i-3],dp[i/2-2][1],a));
			dp[i/2][1] = Math.min(dp[i/2][1],cal(exp[i-3],dp[i/2-2][0],a));
		}
//
//		for (int[] i:dp) {
//			System.out.println(i[0]+" "+i[1]);
//			
//		}
		
		System.out.println(dp[N/2][0]);
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
