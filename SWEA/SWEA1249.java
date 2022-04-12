package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1249 {
	static int N;
	static class Point implements Comparable<Point>{
		int x, y, d;
		Point(int x, int y, int d){
			this.x=x;
			this.y=y;
			this.d=d;
		}
		@Override
		public int compareTo(Point o) {
			return this.d-o.d;
		}
	}
	static int[] dx =  {0,1,0,-1};
	static int[] dy =  {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TN = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TN; i++) {
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			for (int j = 0; j < N; j++) {
				char[] arr = br.readLine().toCharArray();
				for (int k = 0; k < N; k++) {
					map[j][k]=arr[k]-'0';
				}
			}

			sb.append("#"+i+" "+path(map)+"\n");
		}
		System.out.print(sb);
	}
	
	static int path(int[][] map) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(0,0,0));
		boolean[][] visited = new boolean[N][N];
		
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			
			if (now.x==N-1&&now.y==N-1) {
				return now.d;
			}
			for (int i = 0; i < 4; i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				if (nx>=0&&nx<N&&ny>=0&&ny<N&&!visited[nx][ny]) {
					visited[nx][ny]=true;
					pq.add(new Point(nx,ny,now.d+map[nx][ny]));
				}
			}
		}
		return 0;
	}
}
