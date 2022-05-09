package BJ;

import java.io.*;
import java.util.*;

public class BJ17135_2 {
	static int N,M,D,maxT,ans=0;
	static int[][] dl = {{0,-1},{-1,0},{0,1}};
	static int[][] map,temp;
	static int[] archer = new int[3];
	
	static class Point{
		int x,y,d;
		Point(int x, int y,int d){
			this.x=x;
			this.y=y;
			this.d=d;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		temp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n=Integer.parseInt(st.nextToken());
				if (n==1) {
					map[i][j] = 1;
					temp[i][j] = 1;
					maxT=Math.max(maxT, N-i);
				}
			}
		}
		
		combi(0,0);
		System.out.print(ans);
	}
	static void combi(int idx, int cnt) {
		if(cnt==3) atk();
		else {
			for (int i = idx; i < M; i++) {
				archer[cnt]=i;
				combi(i+1,cnt+1);
			}
		}
	}
	static void atk() {
		for (int j = 0; j < N; j++) map[j] = temp[j].clone();
		int cnt=0;
		
		for (int t = 0; t < maxT; t++) {
			for (int j = 0; j < 3; j++) {
				Queue<Point> q = new LinkedList<>();
				q.add(new Point(N-1-t,archer[j],1));
				boolean visited[][] = new boolean[N][M];
				
				while(!q.isEmpty()) {
					Point now = q.poll();
					if (map[now.x][now.y]==t+2) break;
					if (map[now.x][now.y]==1) {
						map[now.x][now.y]=t+2;
						cnt++;
						break;
					}
					for (int i = 0; i < 3; i++) {
						int nx = now.x+dl[i][0];
						int ny = now.y+dl[i][1];
						if (nx>=0&&ny>=0&&ny<M&&!visited[nx][ny]&&now.d<D) {
							q.add(new Point(nx,ny,now.d+1));
							visited[nx][ny]=true;
						}
					}
				}
			}
		}
		
		ans=Math.max(cnt, ans);
	}
}
