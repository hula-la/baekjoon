package BJ;

import java.io.*;
import java.util.*;

public class BJ5213_2 {
	static int[] dx= {-1,1,0,1,-1,0,-1,1};
	static int[] dy= {-1,-1,-1,0,0,1,1,1};
	static Point[][] map;
	static int[] dp;
	static int N;
	static class Point {
		int a,b,idx;
		Point(int a,int b,int idx){
			this.a=a;
			this.b=b;
			this.idx=idx;
		}
	}
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new Point[N][N];
		dp = new int[N*N-N/2+1];
		
		int x = 0,y = 0;
		for (int i = 1; i <= N*N-N/2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[x][y++] = new Point(a,b,i);
			if(x%2==0&&y==N) {
				x++;
				y=0;
			}
			else if(x%2==1&&y==N-1) {
				x++;
				y=0;
			}
		}
		printAns(BFS());
	}
	
	static int BFS() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0,map[0][0].idx));
		dp[1]=-1;
		int max=0;
		
		while(!q.isEmpty()) {
			Point now=q.poll();
			max=Math.max(now.idx, max);
			int s = now.a%2*2;
			
			for (int i = s; i < s+6; i++) {
				int nx = now.a+dx[i];
				int ny = now.b+dy[i];
				
				if (nx>=0&&nx<N&&ny>=0&&ny<N&&map[nx][ny]!=null&&dp[map[nx][ny].idx]==0) {
					if(i-s<3) {
						if (map[now.a][now.b].a==map[nx][ny].b) {
							q.add(new Point(nx,ny,map[nx][ny].idx));
							dp[map[nx][ny].idx]=map[now.a][now.b].idx;
						}
					} else {
						if (map[now.a][now.b].b==map[nx][ny].a) {
							q.add(new Point(nx,ny,map[nx][ny].idx));
							dp[map[nx][ny].idx]=map[now.a][now.b].idx;
						}
					}
				}
			}
		}
		return max;
	}
	
	static void printAns(int i) {
		Stack<Integer> s = new Stack<>();
		
		while(i!=-1) {
			s.add(i);
			i=dp[i];
		}
		sb.append(s.size()+"\n");
		while(!s.empty()) {
			sb.append(s.pop()+" ");
		}
		System.out.print(sb);
	}
}
