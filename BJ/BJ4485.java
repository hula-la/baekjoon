package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ4485 {
	static class Pos implements Comparable<Pos>{
		int x,y,w;
		Pos(int x,int y,int w){
			this.x=x;
			this.y=y;
			this.w=w;
		}
		@Override
		public int compareTo(Pos o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
	}
	public static void main(String[] args) throws IOException {
		int[][] dl = {{1,0},{0,1},{-1,0},{0,-1}};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t=1;
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N==0) break;
			
			
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean[][] visited = new boolean[N][N];
			int answer=0;
			PriorityQueue<Pos> pq = new PriorityQueue<>();
			pq.add(new Pos(0,0,map[0][0]));
			while(!pq.isEmpty()) {
				Pos now = pq.poll();
				int x = now.x;
				int y = now.y;
				visited[x][y]=true;
				if (x==N-1&&y==N-1) {
					answer=now.w;
					break;
				}
				for (int i = 0; i < 4; i++) {
					int nx = now.x+dl[i][0];
					int ny = now.y+dl[i][1];
					if (nx>=0&&nx<N&&ny>=0&&ny<N&&!visited[nx][ny]) {
						pq.add(new Pos(nx,ny,now.w+map[nx][ny]));
					}
				}
			}
			sb.append("Problem "+t+": "+answer+"\n");
			t++;
		}
		System.out.println(sb);
	}
}
