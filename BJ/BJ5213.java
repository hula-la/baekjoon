package BJ;

import java.io.*;
import java.util.*;

public class BJ5213 {
	static int[] dx= {-1,1,0,1,-1,0,-1,1};
	static int[] dy= {-1,-1,-1,0,0,1,1,1};
	static Point[][] map;
	static int N;
	static int[] dp;
	static boolean[][] visited;
	static class Point {
		int a,b,idx,dp,i;
		Point(int a,int b,int idx,int dp,int i){
			this.a=a;
			this.b=b;
			this.idx=idx;
			this.dp=idx;
			this.i=i;
		}
	}
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new Point[N][N];
		
		int x = 0,y = 0;
		for (int i = 1; i <= N*N-N/2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[x][y++] = new Point(a,b,i,0,Integer.MAX_VALUE);
			if(x%2==0&&y==N) {
				x++;
				y=0;
			}
			else if(x%2==1&&y==N-1) {
				x++;
				y=0;
			}
		}
		visited=new boolean[N][N];
		visited[0][0]=true;
		DFS(0,0,0);
		printAns();
	}
	
	static int DFS(int x,int y, int idx) {
		map[x][y].i=Math.min(map[x][y].i, idx);
		
		if (map[x][y].dp!=map[x][y].idx) return map[x][y].dp;
		int s = x%2*2;
		
		for (int i = s; i < s+6; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if (nx>=0&&nx<N&&ny>=0&&ny<N&&!visited[nx][ny]&&map[nx][ny]!=null) {
				visited[nx][ny]=true;
				if(i-s<3) {
					if (map[x][y].a==map[nx][ny].b) {
						map[x][y].dp=Math.max(map[x][y].dp, DFS(nx,ny,idx+1));
					}
				} else {
					if (map[x][y].b==map[nx][ny].a) {
						map[x][y].dp=Math.max(map[x][y].dp, DFS(nx,ny,idx+1));
					}
				}
				visited[nx][ny]=false;
			}
		}
		return map[x][y].dp;
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