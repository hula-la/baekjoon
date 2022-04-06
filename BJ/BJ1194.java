package BJ;

import java.io.*;
import java.util.*;

public class BJ1194 {
	static class Pos{
		int x,y,d,k;
		Pos(int x, int y, int d,int k){
			this.x=x;
			this.y=y;
			this.d=d;
			this.k=k;
		}

	}
	public static void main(String[] args) throws IOException {
		int[][] dl = {{1,0},{0,1},{-1,0},{0,-1}};
		int answer = -1;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		int[][][] dp = new int[N][M][1<<6];
		Pos o = null;
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j]=='0') o=new Pos(i,j,0,0);
			}
		}
		
		Queue<Pos> q = new LinkedList<>();
		q.add(o);
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			int x = now.x;
			int y = now.y;
			int d = now.d;
			
			if (map[x][y]=='1') {
				answer=now.d;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = now.x+dl[i][0];
				int ny = now.y+dl[i][1];
				int k = now.k;

				if (nx>=0&&nx<N&&ny>=0&&ny<M&&dp[nx][ny][k]==0) {
					// 벽이면 패스
					if (map[nx][ny]=='#') continue;
					// 빈칸이면 바로 감
					else if (map[nx][ny]-'A'<0) {}
					// 문이면, 열쇠가 없을 때 패스
					else if (map[nx][ny]-'A'<6&&(k&1<<(map[nx][ny]-'A'))==0) continue;
					else {
						k = k|1<<(map[nx][ny]-'a');
					}
					q.add(new Pos(nx,ny,d+1,k));
					dp[nx][ny][k] = d+1;
				}
			}
		}
		System.out.print(answer);
	}
}
