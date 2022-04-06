package BJ;

import java.io.*;
import java.util.*;

public class BJ14503 {
	static int[][] map;
	static int[][]dl = {{-1,0},{0,1},{1,0},{0,-1}};
	static int N,M,x,y,dir;
	static int answer=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		dir=Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(clear()) {

		}
		
		System.out.print(answer);
	}
	
	static boolean clear() {
		if (map[x][y]==0) {
			map[x][y]=2;
			answer++;
		}
		int nD = dir;
		for (int i = 1; i <= 4; i++) {
			nD = (dir-i+4)%4;
			int nX = x+dl[nD][0];
			int nY = y+dl[nD][1];
			if (nX>=0&&nY>=0&&nX<N&&nY<M&&map[nX][nY]==0) {
				x = nX;
				y = nY;
				dir = nD;
				return true;
			}
		}
		int nX = x-dl[dir][0];
		int nY = y-dl[dir][1];
		if (nX>=0&&nY>=0&&nX<N&&nY<M&&map[nX][nY]!=1) {
			x = nX;
			y = nY;
//			dir = nD;
			return true;
		} else return false;
	}
}
