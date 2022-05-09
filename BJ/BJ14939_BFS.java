package BJ;

import java.io.*;

public class BJ14939_BFS {
	static int[] dx = {0,0,1,0,-1};
	static int[] dy = {0,1,0,-1,0};
	static int ans=1000;
	static boolean[][] visited;
	static class Point{
		char[][] map;
		int x,y;
		Point(char[][] map, int x, int y){
			this.map=map;
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[10][10];
		visited=new boolean[10][10];
		
		for (int i = 0; i < 10; i++) {
			map[i]=br.readLine().toCharArray();
		}
		

		DFS(map,0);
		
		if (ans==1000) System.out.print(-1);
		else System.out.print(ans);
		
	}
	
	static void DFS(char[][] map, int cnt) {
		if (cnt>ans) return;
//		System.out.println(cnt);
		for (int i = 0; i < 10; i++) {
			row: for (int j = 0; j < 10; j++) {
				if (!visited[i][j]) {
//					System.out.println("i="+i+", j="+j);
					visited[i][j]=true;
					DFS(chMap(new Point(map,i,j)),cnt+1);
					DFS(map,cnt);
					visited[i][j]=false;
					return;
				} else {
					if (map[i][j]=='O') {
						for (int t = 0; t < 5; t++) {
							int nx=i+dx[t];
							int ny=j+dy[t];
							
							if(nx>=0&&nx<10&&ny>=0&&ny<10&&!visited[nx][ny]) continue row;
						}
						return;
					}
				}
			}
		}
//		print(map);
		ans=Math.min(ans, cnt);
	}
	
	static char[][] chMap(Point p){
		char[][] tmp = new char[10][10];
		for (int i = 0; i < 10; i++) {
			tmp[i]=p.map[i].clone();
		}
		for (int i = 0; i < 5; i++) {
			int nx=p.x+dx[i];
			int ny=p.y+dy[i];
			
			if(nx>=0&&nx<10&&ny>=0&&ny<10) {
				tmp[nx][ny]=tmp[nx][ny]=='#'?'O':'#';
			}
		}
		return tmp;
	}
	
//	static void print (char[][] map) {
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}
