package BJ;

import java.io.*;
import java.util.*;

public class BJ10836 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[M][M];
		long[] plus = new long[3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				plus[j] += Integer.parseInt(st.nextToken());
			}
		}
		
		int idx,lstIdx = 0;
		long rest,lst = 0;
		int x,y;
		for (int i = 0; i < 3; i++) {
			idx=(int) ((plus[i]+lst)/N);
			rest=(plus[i]+lst)%N;
			for (int j = lstIdx; j < idx; j++) {
				if(j<M) {
					x=M-1-j;
					y=0;
				} else {
					x=0;
					y=j-M;
				}
				if (j==lstIdx) map[x][y]+=i*(N-lst);
				map[0][j]+=i*N;
			}
			if (i!=2) {
				lst=rest;
				lstIdx=idx;
				map[0][idx]+=i*rest;
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if (i!=0&&j!=0) map[i][j] = Math.max(Math.max(map[i-1][j-1], map[i-1][j]), map[i][j-1]);
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
