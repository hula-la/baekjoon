package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1953 {
	static boolean[][] visited;
	static int[] dx =  {-1,0,1,0};
	static int[] dy =  {0,1,0,-1};
	static int[][] dl = {{},{0,1,2,3},{0,2},{1,3},{0,1},{1,2},{2,3},{3,0}};
	
	static class Point{
		int x,y,t;
		Point(int x, int y, int t){
			this.x=x;
			this.y=y;
			this.t=t;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N,M,R,C,L,ans,map[][];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		StringBuilder sb = new StringBuilder();
		
		int TN = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TN; i++) {
			ans=1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					map[j][k]=Integer.parseInt(st.nextToken());
				}
			}
			visited = new boolean[N][M];
			visited[R][C]=true;
			
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(R,C,1));
			
			while(!q.isEmpty()) {
				Point now = q.poll();
				if (now.t==L) continue;
				for (int d:dl[map[now.x][now.y]]) {
					int nx = now.x+dx[d];
					int ny = now.y+dy[d];
					if (nx>=0&&nx<N&&ny>=0&&ny<M&&!visited[nx][ny]) {
						boolean flg=false;
						for (int j:dl[map[nx][ny]]) {
							if (j==(d+2)%4) {
								flg=true;
								break;
							}
						}
						if (flg) {
							ans++;
							visited[nx][ny]=true;
							q.add(new Point(nx,ny,now.t+1));
						}
					}
				}
			}
			
			sb.append("#"+i+" "+ans+"\n");
			
//			for (int j = 0; j < N; j++) {
//				for (int k = 0; k < M; k++) {
//					System.out.print(visited[j][k]+" ");
//				}
//				System.out.println();
//			}
		}
		System.out.print(sb);
	}

}
