package BJ;

import java.io.*;
import java.util.*;

public class BJ16948 {
	static int[] dx= {-2,-2,0,0,2,2};
	static int[] dy= {-1,1,-2,2,-1,1};
	static class Point{
		int x,y,d;
		Point(int x, int y, int d){
			this.x=x;
			this.y=y;
			this.d=d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1=Integer.parseInt(st.nextToken());
		int c1=Integer.parseInt(st.nextToken());
		int r2=Integer.parseInt(st.nextToken());
		int c2=Integer.parseInt(st.nextToken());
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r1,c1,0));
		boolean[][] visited = new boolean[N][N];
		visited[r1][c1]=true;
		int ans=-1;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			if (now.x==r2&&now.y==c2) {
				ans=now.d;
				break;
			}
			for (int i = 0; i < 6; i++) {
				int nx=now.x+dx[i];
				int ny=now.y+dy[i];
				
				if (nx>=0&&nx<N&&ny>=0&&ny<N&&!visited[nx][ny]) {
					q.add(new Point(nx,ny,now.d+1));
					visited[nx][ny]=true;
				}
			}
		}
		System.out.print(ans);
	}
}
