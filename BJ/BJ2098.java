package BJ;

import java.io.*;
import java.util.*;

public class BJ2098 {
	static int N;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		dp = new int[1<<N][N];
		
		for(int l=1;l<N;l*=2) {
			
		}
		
		
	}
	
	static void combi(int l, int cnt, int n) {
		if(l==cnt) {
			for (int i = 0; i < N; i++) {
				if(dp[n][i]!=0) {
					
				}
			}
		}
	}
}
