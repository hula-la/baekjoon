package BJ;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BJ1938 {
	static int[] dx= {0,0,-1,1,-1,1,-1,1};
	static int[] dy= {-1,1,0,0,-1,-1,1,1};
	static class Point implements Comparable<Point>{
		int x,y,d,l;
		Point(int x, int y, int d,int l){
			this.x=x;
			this.y=y;
			this.d=d;
			this.l=l;
		}
		@Override
		public int compareTo(Point o) {
			return this.l-o.l;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		
		char[][] map = new char[N][N];
		boolean[][][] visited= new boolean[N][N][2];
		Point s = null;
		Point e = null;
		
		int BCnt=0;
		int ECnt=0;
		for (int i = 0; i < N; i++) {
			map[i]=br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='B') BCnt++;
				if(BCnt==2) {
					if(j-1>=0&&map[i][j-1]=='B') s=new Point(i,j,0,1);
					else s=new Point(i,j,1,1);
					BCnt=0;
				}
				if(map[i][j]=='E') ECnt++;
				if(ECnt==2) {
					if(j-1>=0&&map[i][j-1]=='E') e=new Point(i,j,0,1);
					else e=new Point(i,j,1,1);
					ECnt=0;
				}
			}
		}
		
		PriorityQueue<Point> q = new PriorityQueue<>();
		q.add(s);
		visited[s.x][s.y][s.d]=true;
		int ans=0;
		while(!q.isEmpty()) {
			Point now = q.poll();
			if (now.x==e.x&&now.y==e.y&&now.d==e.d) {
				ans=now.l-1;
				break;
			}
			boolean rotate=true;
			for (int i = 0; i < 8; i++) {
				int nx=now.x+dx[i];
				int ny=now.y+dy[i];
				if (nx>=0&&nx<N&&ny>=0&&ny<N&&map[nx][ny]!='1') continue;
				rotate=false;
				break;
			}
			for (int i = 0; i < 4; i++) {
				// 가로
				for (int j = 0; j < 2; j++) {
					if (j==1&&!rotate) continue;
						Point center=new Point(now.x+dx[i],now.y+dy[i],(now.d+j)%2,now.l+j);
					
					if (center.x+dx[center.d*2]>=0&&center.x-dx[center.d*2]<N
							&&center.y+dy[center.d*2]>=0&&center.y-dy[center.d*2]<N&&!visited[center.x][center.y][center.d]) {
						if (map[center.x][center.y]=='1'||map[center.x+dx[center.d*2]][center.y+dy[center.d*2]]=='1'
								||map[center.x-dx[center.d*2]][center.y-dy[center.d*2]]=='1') continue;
						q.add(new Point(center.x,center.y,center.d,center.l+1));
						visited[center.x][center.y][center.d]=true;
					}
					
				}
			}
		}
		
		System.out.print(ans);
	}
}
