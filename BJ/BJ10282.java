package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ10282 {
	static class Point implements Comparable<Point>{
		int x,t;
		Point(int x, int t){
			this.x=x;
			this.t=t;
		}
		@Override
		public int compareTo(Point o) {
			return this.t-o.t;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			//컴퓨터 배열 생성
			ArrayList<Point>[] com = new ArrayList[n+1];
			for(int j=0;j<n+1;j++){
				com[j] = new ArrayList<>();
			}
			
			// 그래프 입력
			for (int j = 0; j < d; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				com[b].add(new Point(a,t));
			}
			
			PriorityQueue<Point> pq = new PriorityQueue<>();
			pq.add(new Point(c,0));
			boolean[] visited = new boolean[n+1];
			
			int cnt=0;
			int maxT = 0;
			
			while(!pq.isEmpty()) {
				Point now = pq.poll();
				if (visited[now.x]) continue;
				visited[now.x]=true;
				cnt++;
				maxT=Math.max(maxT, now.t);
				
				for (Point p:com[now.x]) {
					if (!visited[p.x]) {
						pq.add(new Point(p.x,p.t+now.t));
					}
				}
			}
			
			sb.append(cnt+" "+maxT+"\n");
			
		}
		System.out.print(sb);
		
	}

}
