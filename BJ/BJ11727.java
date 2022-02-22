package bj;

import java.util.Scanner;

public class BJ11727 {
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp= new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2;i<=n;i++) {
			dp[i] = (2*dp[i-2]+dp[i-1])%10007;
		}
	
		System.out.print(dp[n]);
	}
}