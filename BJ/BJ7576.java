package BJ;

import java.io.*;
import java.util.*;

public class BJ7576 {
	static class Point{
		int x,y,t;
		Point(int x,int y, int t){
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][]map = new int[N][M];
		int[][] dl = {{0,1},{1,0},{0,-1},{-1,0}};
		
		int zeroN = 0;
		int answer = 0;
		Queue<Point> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j]==0) {
					// 안익은 토마토 개수 카운팅
					zeroN++;
				}
				else if (map[i][j]==1) {
					q.add(new Point(i,j,0));
				}
			}
		}
		int convertZ = 0;
		while(!q.isEmpty()) {
			Point lst = q.poll();
			answer = Math.max(answer, lst.t);
			for (int i = 0; i < 4; i++) {
				int nX = lst.x+dl[i][0];
				int nY = lst.y+dl[i][1];
				// 익은 토마토를 중심으로 사방탐색
				if(nX>=0&&nY>=0&&nX<N&&nY<M&&map[nX][nY]==0) {
					q.add(new Point(nX,nY,lst.t+1));
					map[nX][nY] = 1;
					// 익은 토마토로 바뀐 안익은 토마토 개수 카운팅
					convertZ++;
				}
			}
		}
		// 모든 안익은 토마토가 안 익었으면 -1 출력
		if(convertZ!=zeroN) answer=-1;
		System.out.print(answer);

	}
}
