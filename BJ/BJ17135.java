package BJ;

import java.io.*;
import java.util.*;

public class BJ17135 {
	static int N,M,D,answer,tmp,dieN;
	static boolean[][] visited;
	static int[][] dl = {{0,-1},{-1,0},{0,1}};
	static int[][] map,temp;
	static int[][] die = new int[3][];
	
	static class Point{
		int x,y,dis;
		Point(int x, int y,int dis){
			this.x=x;
			this.y=y;
			this.dis=dis;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		temp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = map[i][j];
			}
		}
		
		answer=0;
		combi(0,0,new int[3]);
		System.out.println(answer);
	}
	static void combi(int idx, int cnt, int[] arr) {
		if(cnt==3) {
//			
//			for(int i:arr) {
//				System.out.print(i+" ");
//			}
//			System.out.println();
//			System.out.println("*********************");
			
			tmp=0;
			cal(arr);
			answer=Math.max(tmp, answer);
		}else {
			for (int i = idx; i < M; i++) {
				arr[cnt]=i;
				combi(i+1,cnt+1,arr);
			}
		}
	}
	static void cal(int[] arr) {
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				map[j][k] = temp[j][k];
			}
		}
		
		for (int t = 0; t< N; t++) {
			dieN=0;
			for (int j = 0; j < 3; j++){
				visited=new boolean[N][M];
				findN(arr[j],N-t-1);
			}
			for (int i = 0; i < dieN; i++) {
				if(map[die[i][0]][die[i][1]]==1) {
					tmp++;
					map[die[i][0]][die[i][1]]=0;
				}
//				for (int j = 0; j < N; j++) {
//					for (int k = 0; k < M; k++) {
//						System.out.print(map[j][k]+" ");
//					}
//					System.out.println();
//				}
			}
			
		}
	}
	static void findN(int i, int s) {
//		System.out.println("i: "+i+" s:"+s);
		
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(s,i,1));
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(map[p.x][p.y]==1) {
				die[dieN]= new int[] {p.x,p.y};
				dieN++;
				break;
			}
			if(p.dis==D) continue;
			for (int j = 0; j < 3; j++) {
				int nX = p.x+dl[j][0];
				int nY = p.y+dl[j][1];
				
				if(nX>=0&&nX<N&&nY>=0&&nY<M&&!visited[nX][nY]) {
					q.add(new Point(nX,nY,p.dis+1));
				}
			}
		}
	}
}
