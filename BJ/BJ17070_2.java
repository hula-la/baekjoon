package BJ;

import java.io.*;
import java.util.*;

public class BJ17070_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] dx = {0,1,1};
		int[] dy = {1,0,1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][][] dp = new int[N][N][3];
		dp[0][1][0] = 1;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				for (int i = 0; i < 3; i++) {
					int nx=x+dx[i];
					int ny=y+dy[i];
					if(nx<N&&ny<N&&map[nx][ny]==0) {
						if(i==2&&(map[nx-1][ny]==1||map[nx][ny-1]==1)) continue;
						for (int j = 1; j <= 3; j++) {
							if ((j&(i+1))!=0) {
								dp[nx][ny][i] += dp[x][y][j-1];
							}
						}
					}
				}
				
			}
		}
		
		int ans=0;
		for (int i = 0; i < 3; i++) {
			ans+=dp[N-1][N-1][i];
		}
		System.out.print(ans);
	}
}
