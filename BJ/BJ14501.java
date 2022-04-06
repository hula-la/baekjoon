package BJ;

import java.io.*;
import java.util.*;

public class BJ14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			dp[i] = Math.max(dp[i],i>0?dp[i-1]:0);
			if (i+t<=N) {
				dp[i+t] = Math.max(dp[i]+p, dp[i+t]);
			}
		}
		System.out.print(Math.max(dp[N-1],dp[N]));
	}
}
