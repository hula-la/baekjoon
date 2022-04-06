package BJ;

import java.io.*;
import java.util.*;

public class BJ1600_2 {
	static int H,W;
	static int[][] map;
	static class Pos{
		int x, y, k, d;
		Pos(int x, int y, int k, int d){
			this.x = x;
			this.y = y;
			this.k = k;
			this.d = d;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] dl= {{0,1},{1,0},{0,-1},{-1,0}};
		
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		int[][][] dp = new int[H][W][K+1];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0,0,K,0));
		
		int answer=-1;
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			int x = now.x;
			int y = now.y;
			int k = now.k;
			int d = now.d;
			if (x==H-1&&y==W-1) {
				answer=d;
				break;
			}
			// 말걸음
			if(k>0) {
				for (int i = 0; i < 4; i++) {
					for (int j = 1; j < 4; j+=2) {
						int nx = x + dl[i][0]*2 + dl[(i+j)%4][0];
						int ny = y + dl[i][1]*2 + dl[(i+j)%4][1];
						
						if(checkPos(nx,ny)) {
							if(dp[nx][ny][k-1]==0) {
								dp[nx][ny][k-1]=d+1;
								q.add(new Pos(nx,ny,k-1,d+1));
							}
						}
					}
				}
			}
			// 원숭이 걸음
			for (int i = 0; i < 4; i++) {
				int nx = x + dl[i][0];
				int ny = y + dl[i][1];
				if(checkPos(nx,ny)) {
					if(dp[nx][ny][k]==0) {
						dp[nx][ny][k]=d+1;
						q.add(new Pos(nx,ny,k,d+1));
					}
				}
			}
			
		}
		System.out.print(answer);
	}
	static boolean checkPos(int x, int y) {
		if (x>=0&&y>=0&&x<H&&y<W&&map[x][y]==0) return true;
		return false;
	}
	
}