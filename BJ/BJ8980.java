package BJ;

import java.io.*;
import java.util.*;

public class BJ8980 {
	static class Move implements Comparable<Move>{
		int s,e,w;
		Move(int s, int e, int w){
			this.s=s;
			this.e=e;
			this.w=w;
		}
		@Override
		public int compareTo(Move o) {
			if (o.e==this.e) {
				return o.s-this.s;
			} else return this.e-o.e;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		
		Move[] move = new Move[M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			move[i] = new Move(s, e,w);
		}
		
		Arrays.sort(move);
		int[] dp = new int[N];
		int ans=0;
		
		for (int i = 0; i < M; i++) {
			int max=0;
			for (int j = move[i].s; j < move[i].e; j++) {
				max=Math.max(dp[j], max);
			}
			int plus=0;
			if(max+move[i].w>C) plus=C-max;
			else plus=move[i].w;
			for (int j = move[i].s; j < move[i].e; j++) {
				dp[j]+=plus;
			}
			ans+=plus;
		}
//		for (int i = 0; i < N; i++) {
//			System.out.print(dp[i]+" ");
//		}
//		System.out.println();
		System.out.print(ans);
	}
}
