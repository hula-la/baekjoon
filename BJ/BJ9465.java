package BJ;

import java.io.*;
import java.util.*;

public class BJ9465 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][2];
			
			for (int j = 0; j < 2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for (int k = 0; k < n; k++) {
					arr[k][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] dp = new int[n][2];
			dp[0]=arr[0].clone();
			for (int k = 1; k < n; k++) {
				int preD=0;
				if (k>1) preD = Math.max(dp[k-2][0], dp[k-2][1]);
				dp[k][0] = Math.max(preD, dp[k-1][1])+arr[k][0];
				dp[k][1] = Math.max(preD, dp[k-1][0])+arr[k][1];
				
			}
			
//			for (int j = 0; j < n; j++) {
//				System.out.println(dp[j][0]+" "+dp[j][1]);
//			}
			sb.append(Math.max(dp[n-1][0], dp[n-1][1])+"\n");
		}
		System.out.print(sb);
	}
}
