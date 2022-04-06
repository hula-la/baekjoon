package BJ;

import java.io.*;
import java.util.*;

public class BJ17070 {
	static class Point{
		int x,y;
		Point(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] dx = {0,1,1};
		int[] dy = {1,0,1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][][] dp = new int[N][N][3];
		boolean[][] visited = new boolean[N][N];
		dp[0][1][0] = 1;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,1));
		
		while(!q.isEmpty()) {
			Point now=q.poll();
			for (int i = 0; i < 3; i++) {
				int nx=now.x+dx[i];
				int ny=now.y+dy[i];
				if(nx>=0&&nx<N&&ny>=0&&ny<N) {
					if(!visited[nx][ny]) {
						q.add(new Point(nx,ny));
						visited[nx][ny]=true;
					}
					if(map[nx][ny]==0) {
						if(i==2&&(map[nx-1][ny]==1||map[nx][ny-1]==1)) continue;
						for (int j = 1; j <= 3; j++) {
							if ((j&(i+1))!=0) {
								dp[nx][ny][i] += dp[now.x][now.y][j-1];
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
