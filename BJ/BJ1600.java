package BJ;

import java.io.*;
import java.util.*;

public class BJ1600 {
	static int H,W;
	static int[][] map;
	static class Pos{
		int x, y, k, dir;
		Pos(int x, int y, int k, int dir){
			this.x = x;
			this.y = y;
			this.k = k;
			this.dir = dir;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] mdl= {{0,1},{1,0},{0,-1},{-1,0}};
		int[][] hdl= {{1,2},{-1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,1},{-2,-1}};
		
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
			int dir = now.dir;
			if (x==H-1&&y==W-1) {
				answer=dir;
				break;
			}
			
			// 말걸음
			if(k>0) {
				for (int i = 0; i < 8; i++) {
					int nx = x + hdl[i][0];
					int ny = y + hdl[i][1];
					if(checkPos(nx,ny)) {
						if(dp[nx][ny][k-1]==0) {
							dp[nx][ny][k-1]=dir+1;
							q.add(new Pos(nx,ny,k-1,dir+1));
						}
					}
				}
			}
			// 원숭이 걸음
			for (int i = 0; i < 4; i++) {
				int nx = x + mdl[i][0];
				int ny = y + mdl[i][1];
				if(checkPos(nx,ny)) {
					if(dp[nx][ny][k]==0) {
						dp[nx][ny][k]=dir+1;
						q.add(new Pos(nx,ny,k,dir+1));
					}
				}
			}
			
		}
		System.out.print(answer);
	}
	static boolean checkPos(int x, int y) {
		if (x>=0&&y>=0&&x<H&&y<W&&map[x][y]==0) return true;
		else return false;
	}
	
}
