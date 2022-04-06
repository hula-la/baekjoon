package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14503_2 {
	static int[][] map;
	static int[][]dl = {{-1,0},{0,1},{1,0},{0,-1}};
	static int N,M;
	static int answer=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		
		int x=Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());
		int dir=Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		clear(x,y,dir);
		
		System.out.print(answer);
	}
	
	static void clear(int x, int y, int dir) {
		if (map[x][y]==0) {
			map[x][y]=2;
			answer++;
		}
		for (int i = 1; i <= 4; i++) {
			int nD = (dir-i+4)%4;
			int nX = x+dl[nD][0];
			int nY = y+dl[nD][1];
			if (nX>=0&&nY>=0&&nX<N&&nY<M&&map[nX][nY]==0) {
				clear(nX,nY,nD);
				return;
			}
		}
		int nX = x-dl[dir][0];
		int nY = y-dl[dir][1];
		if (nX>=0&&nY>=0&&nX<N&&nY<M&&map[nX][nY]!=1) {
			clear(nX,nY,dir);
		}
	}
}
