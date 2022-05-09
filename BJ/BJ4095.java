package BJ;

import java.io.*;
import java.util.*;

public class BJ4095 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if (N==0&&M==0) break;
			
			int[][] dp = new int[N+1][M+1];
			int ans=0;
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= M; j++) {
					int a = Integer.parseInt(st.nextToken());
					if(a==1)dp[i][j]=Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1])+1;
					ans=Math.max(dp[i][j], ans);
				}
			}
			sb.append(ans+"\n");
		}
		System.out.print(sb);
	}
}
