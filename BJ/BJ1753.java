package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1753 {
	static class Point{
		int[] value;
		Point next;
		Point(int[] value, Point next){
			this.value=value;
			this.next=next;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		Point[] map = new Point[V+1];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			map[u] = new Point(new int[] {v,w},map[u]);
		}
		
		int[] distance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[K] = 0;
		int idx = K;
		
		for (int i = 1; i <= V; i++) {
			visited[idx] = true;
			
			int min = Integer.MAX_VALUE;
			int minIdx=0;
			for (Point j = map[idx];j!=null;j=j.next) {
				int a=j.value[0];
				if(!visited[a]) {
					distance[a] = Math.min(distance[a], distance[idx]+j.value[1]);
					
				}
			}
			for (int j = 1; j <= V; j++) {
				if(!visited[j]&&distance[j]<min) {
					min = distance[j];
					minIdx = j;
				}
			}
			idx = minIdx;
		}
		
		for (int i = 1; i <= V; i++) {
			if(distance[i]==Integer.MAX_VALUE) {
				sb.append("INF"+"\n");
			}
			else sb.append(distance[i]+"\n");
		}
		
		System.out.println(sb);

	}
}
