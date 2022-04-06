package BJ;

import java.io.*;
import java.util.*;

public class bj9205 {
	static Pos[] pArr;
	static boolean[]  visited;
	static int n;
	static ArrayList<Pos>[] posPoint;
	static class Pos{
		int x,y,idx;
		Pos(int x, int y, int idx){
			this.x = x;
			this.y = y;
			this.idx = idx;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int t = Integer.parseInt(br.readLine());
		tc: for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			
			pArr= new Pos[n+2];
			visited = new boolean[n+2];
			
			// 범위 내에 있는 점 리스트
			posPoint = new ArrayList[n+2];
			for (int j = 0; j < n+2; j++) {
				posPoint[j] = new ArrayList();
			}
			
			for (int j = 0; j < n+2; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				pArr[j] = new Pos(x,y,j);
				
				for (int k = 0; k < j; k++) {
					if(calDir(pArr[k],pArr[j])<=1000) {
						posPoint[k].add(pArr[j]);
						posPoint[j].add(pArr[k]);
					}
				}
			}
			
			Queue<Pos> q = new LinkedList<Pos>();
			q.add(pArr[0]);
			visited[0] = true;
			
			total: while(!q.isEmpty()) {
				Pos now = q.poll();
				for(Pos p:posPoint[now.idx]) {
					if (!visited[p.idx]) {
						if (p.idx==n+1) {
							sb.append("happy\n");
							continue tc;
						}
						q.add(p);
						visited[p.idx]=true;
					}
				}
			}
			sb.append("sad\n");
		}
		System.out.print(sb);
	}

	
	static int calDir(Pos p1, Pos p2) {
		return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
	}
}
