package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1249_2 {
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
	
	public static void main(String[] args) throws IOException {
		int[] dx =  {0,1,0,-1};
		int[] dy =  {1,0,-1,0};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TN = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TN; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			for (int j = 0; j < N; j++) {
				char[] arr = br.readLine().toCharArray();
				for (int k = 0; k < N; k++) {
					map[j][k]=arr[k]-'0';
				}
			}
			int answer=0;
			PriorityQueue<Point> pq = new PriorityQueue<>();
			pq.add(new Point(0,0,0));
			boolean[][] visited = new boolean[N][N];
			
			while(!pq.isEmpty()) {
				Point now = pq.poll();
				
				if (now.x==N-1&&now.y==N-1) {
					answer= now.d;
					break;
				}
				for (int k = 0; k < 4; k++) {
					int nx = now.x+dx[k];
					int ny = now.y+dy[k];
					if (nx>=0&&nx<N&&ny>=0&&ny<N&&!visited[nx][ny]) {
						visited[nx][ny]=true;
						pq.add(new Point(nx,ny,now.d+map[nx][ny]));
					}
				}
			}
			sb.append("#"+i+" "+answer+"\n");
		}
		System.out.print(sb);
	}
}
