package BJ;

import java.io.*;
import java.util.*;

public class BJ2931 {
	static char[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int[][] path = {{0,2},{0,3},{1,3},{1,2},{2,3},{0,1},{0,1,2,3}};
	static char[] pipe= {'1','2','3','4','|', '-', '+'};
	static class Point {
		int x,y;
		Point(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		Point s = null;
		boolean[][] visited=new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				switch(map[i][j]) {
				case '|':map[i][j]='5'; break;
				case '-':map[i][j]='6'; break;
				case '+':map[i][j]='7'; 
				}
				if (s==null&&map[i][j]-'1'>=0&&map[i][j]-'1'<7) {
					s=new Point(i,j);
					visited[i][j]=true;
				}
			}
		}
		
		Queue<Point> q = new LinkedList<>();
		q.add(s);
		while(!q.isEmpty()) {
			Point now = q.poll();
			int value=map[now.x][now.y];
			if (value=='M'||value=='Z') continue;
			if (value=='.') {
				s=now;
				break;
			}
			for (int i:path[map[now.x][now.y]-'1']) {
				int nx=now.x+dx[i];
				int ny=now.y+dy[i];
				
				if (nx>=0&&nx<R&&ny>=0&&ny<C&&!visited[nx][ny]) {
					visited[nx][ny]=true;
					q.add(new Point(nx,ny));
				}
			}
		}
		List<Integer> connect=new ArrayList<>();
		t:for (int i = 0; i < 4; i++) {
			int nx=s.x+dx[i];
			int ny=s.y+dy[i];
			
			if (nx>=0&&nx<R&&ny>=0&&ny<C&&map[nx][ny]!='.') {
				if (map[nx][ny]=='M'||map[nx][ny]=='Z') {
					for (int k = 0; k < 4; k++) {
						int nnx=s.x+dx[k];
						int nny=s.y+dy[k];
						
						if (nnx>=0&&nnx<R&&nny>=0&&nny<C&&map[nnx][nny]-'1'>=0&&map[nnx][nny]-'1'<7) {
							for (int j = 0; j < path[map[nnx][nny]-'1'].length; j++) {
								int a=path[map[nnx][nny]-'1'][j];
								if (dx[a]==-dx[i]&&dy[a]==-dy[i]) {
									continue t;
								}
							}
						}
					}
					connect.add(i);
					continue;
				}
				else {
					for (int j = 0; j < path[map[nx][ny]-'1'].length; j++) {
						int a=path[map[nx][ny]-'1'][j];
						if (dx[a]==-dx[i]&&dy[a]==-dy[i]) {
							connect.add(i);
							continue;
						}
					}
				}
			}
		}
		int ans = 0;
		if(connect.size()==4) ans=6;
		else {
			for (int i = 0; i < 6; i++) {
				if (connect.get(0)==path[i][0]&&connect.get(1)==path[i][1]) {
					ans=i;
					break;
				}
			}
		}
		System.out.print((s.x+1)+" "+(s.y+1)+" "+pipe[ans]);
	}
	
}
