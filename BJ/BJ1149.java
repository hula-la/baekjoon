package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1149 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int answer = Integer.MAX_VALUE;
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][3];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				int x = Integer.parseInt(st.nextToken());
				dp[i][j] =  Math.min(dp[i-1][(j+1)%3], dp[i-1][(j+2)%3])+x;
				if (i==N) {
					answer = Math.min(answer, dp[i][j]);
				}
			}
		}
		System.out.print(answer);
	}
}
