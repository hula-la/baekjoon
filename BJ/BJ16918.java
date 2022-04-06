package BJ;

import java.util.*;
import java.io.*;

public class BJ16918 {
	static int[][] dl = new int[][] {{0,-1},{-1,0},{0,1},{1,0}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			char[] cArr = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (cArr[j]=='O') {
					map[i][j] = 2;
				} else {
					map[i][j] = 0;
				}
			}
		}
		
		for (int i = 2; i <= N; i++) {	
			for (int k = 0; k < R; k++) {
				for (int j = 0; j < C; j++) {

					if (map[k][j]==1) {
						map[k][j] = 0;
						for (int j2 = 0; j2 < 4; j2++) {
							int nx = k+dl[j2][0];
							int ny = j+dl[j2][1];
							
							if (nx>=0&&nx<R&&ny>=0&&ny<C&&map[nx][ny]>(j2<2?0:1)) {
								map[nx][ny] = 0;
							}
						}
					} else if (map[k][j]>1) {
						map[k][j] -= 1; 
					}
					if(i%2==0) {
						if(map[k][j]==0) {
							map[k][j]=3;
						}
					}
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j]>0)sb.append('O');
				else sb.append('.');
			}
			sb.append("\n");
		}
		System.out.print(sb);

	}
}
