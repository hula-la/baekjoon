package BJ;

import java.io.*;
import java.util.*;

public class BJ14502 {
	static int N,M,map[][],max,rest;
	static List<Point> zeroList,virusList;
	static int[] dx =  {-1,0,1,0};
	static int[] dy =  {0,1,0,-1};
	
	static class Point{
		int x,y;
		
		Point(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		max=0;
		
		zeroList = new ArrayList<>();
		virusList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j]==0) {
					zeroList.add(new Point(i,j));
				} else if (map[i][j]==2) {
					virusList.add(new Point(i,j));
				}
			}
		}
		rest=zeroList.size();
		comb(0,0);
		System.out.print(max);
		
	}
	
	static void comb(int cnt, int idx) {
		if (cnt==3) {
			int now=check();
			max=Math.max(max, rest-now-3);
		} else {
			for (int i = idx; i < rest; i++) {
				Point a = zeroList.get(i);
				map[a.x][a.y] = 1;
				comb(cnt+1, i+1);
				map[a.x][a.y] = 0;
			}
		}
	}
	
	static int check() {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		for (Point virus:virusList) q.add(virus);
		int cnt=0;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx=now.x+dx[i];
				int ny=now.y+dy[i];
				if (nx>=0&&nx<N&&ny>=0&&ny<M&&!visited[nx][ny]&&map[nx][ny]==0) {
					q.add(new Point(nx,ny));
					visited[nx][ny] =true;
					cnt++;
				}
			}
		}
		return cnt;
	}
}
