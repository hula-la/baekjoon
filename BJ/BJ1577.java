package BJ;

import java.io.*;
import java.util.*;

public class BJ1577 {
	static class Point{
		int x,y;
		Point(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map=new int[M+1][N+1];
		
		int k = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			// 세로면 -1, 가로면 -2
			if (a==c) {
				map[Math.min(b, d)][a]=map[Math.min(b, d)][a]==-2?-3:-1;
			} else {
				map[b][Math.min(a,c)]=map[b][Math.min(a,c)]==-1?-3:-2;
			}
		}
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0));
		long[][] dir=new long[M+1][N+1];
		dir[0][0] = 1;
		boolean[][] visited = new boolean[M+1][N];
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			if (visited[now.y][now.x]) continue;
			visited[now.y][now.x]=true;
			if(map[now.y][now.x]==-3)continue;
			if(!(map[now.y][now.x]==-2)&&now.x+1<=N) {
				dir[now.y][now.x+1] +=dir[now.y][now.x];
				q.add(new Point(now.x+1,now.y));
			}
			if(!(map[now.y][now.x]==-1)&&now.y+1<=M){
				dir[now.y+1][now.x] +=dir[now.y][now.x];
				q.add(new Point(now.x,now.y+1));
			}
		}
//		Queue<Point> q = new LinkedList<>();
//		q.add(new Point(1,0));
//		q.add(new Point(0,1));
//		long[][] dir=new long[M+1][N+1];
//		dir[0][0] = 1;
//		
//		while(!q.isEmpty()) {
//			Point now = q.poll();
//			if(map[now.y][now.x]!=0)continue;
//			if(map[now.y][now.x]==0)map[now.y][now.x]=1;
//			long a1 = now.x>0&&!(map[now.y][now.x-1]==-2||map[now.y][now.x-1]==-3)?dir[now.y][now.x-1]:0;
//			long a2 = now.y>0&&!(map[now.y-1][now.x]==-1||map[now.y-1][now.x]==-3)?dir[now.y-1][now.x]:0;
//			
//			dir[now.y][now.x] = a1+a2;
//			
//			
//			if(now.x+1<=N) {
//				q.add(new Point(now.x+1,now.y));
//			}
//			if(now.y+1<=M){
//				q.add(new Point(now.x,now.y+1));
//			}
//		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(dir[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(dir[0][1]);
		System.out.println(dir[M][N]);
	}
}
