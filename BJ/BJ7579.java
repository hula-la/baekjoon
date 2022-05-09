package BJ;

import java.io.*;
import java.util.*;

public class BJ7579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[M+1];
		int MAXV = 100000;
		for (int i = 1; i <= M; i++) {
			dp[i]=MAXV;
		}
		
		int[] mArr = new int[M];
		int[] cArr = new int[M];
		// 메모리 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			mArr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cArr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = M-mArr[i]; j > 0; j--) {
				dp[j+mArr[i]]=Math.min(dp[j+mArr[i]], dp[j]+cArr[i]);
			}
			int e = Math.min(mArr[i], M);
			for (int j = 1; j <= e; j++) {
				dp[j]=Math.min(dp[j], cArr[i]);
			}
		}
		System.out.print(dp[M]);
	}
}
