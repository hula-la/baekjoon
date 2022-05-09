package BJ;

import java.io.*;
import java.util.*;

public class BJ1939 {
	static class Bridge implements Comparable<Bridge>{
		int i,w;
		Bridge(int i, int w){
			this.i=i;
			this.w=w;
		}
		@Override
		public int compareTo(Bridge o) {
			return o.w-this.w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		List<Bridge>[] lst = new List[N];
		
		for (int i = 0; i < N; i++) {
			lst[i]=new ArrayList<Bridge>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken())-1;
			int B = Integer.parseInt(st.nextToken())-1;
			int C = Integer.parseInt(st.nextToken());
			lst[A].add(new Bridge(B, C));
			lst[B].add(new Bridge(A, C));
		}
		st = new StringTokenizer(br.readLine());
		int start=Integer.parseInt(st.nextToken())-1;
		int end=Integer.parseInt(st.nextToken())-1;
		
		// BFS 로 계산
		PriorityQueue<Bridge> q = new PriorityQueue<>();
		q.add(new Bridge(start,Integer.MAX_VALUE));
		boolean[] visited = new boolean[N];
		while(!q.isEmpty()) {
			Bridge now = q.poll();
			if (visited[now.i]) continue;
			visited[now.i]=true;
			if(now.i==end) {
				System.out.print(now.w);
				break;
			}
			for(Bridge o:lst[now.i]) {
				if(!visited[o.i]) q.add(new Bridge(o.i,Math.min(o.w, now.w)));
			}
		}
	}
}
