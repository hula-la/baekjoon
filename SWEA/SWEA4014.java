package SWEA;

import java.io.*;
import java.util.*;

public class SWEA4014 {
	static int[][] map;
	static int N,X,cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int TN = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TN; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					map[j][k]=Integer.parseInt(st.nextToken());
				}
			}
			cnt=0;
			
			find(0);
			find(1);
			
			sb.append("#"+i+" "+cnt+"\n");
		}
		System.out.print(sb);
	}
	
	static void find(int d) {
		total:for (int j = 0; j < N; j++) {
			int lst= d==0?map[j][0]:map[0][j];
			int keep=1;
			for (int k = 1; k < N; k++) {
				int a=d==0?j:k;
				int b=d==0?k:j;
				if(Math.abs(map[a][b]-lst)>1) continue total;
				if(map[a][b]==lst) keep++;
				else if (map[a][b]==lst-1) {
					if(keep<0) continue total;
					keep=-X+1;
				}
				else {
					if(keep<X) continue total;
					keep=1;
				}
				lst=map[a][b];
			}
			if (keep>=0) {
				cnt++;
			}
		}
	}

}
