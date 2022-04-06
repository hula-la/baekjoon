package BJ;

import java.util.Scanner;

public class prac2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i-2]+dp[i-1]*2;
		}
		System.out.print(dp[N]);
	}

}
