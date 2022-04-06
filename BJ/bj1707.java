package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1707 {
	static String answer;
	static int[] visited;
	static Queue<Integer> q;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int  V = Integer.parseInt(st.nextToken());
			int  E = Integer.parseInt(st.nextToken());
			answer = "YES";
			
			// 그래프 생성
			graph = new ArrayList[V+1];
			for (int j = 1; j <= V; j++) {
				graph[j] = new ArrayList<>();
			}
			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b);
				graph[b].add(a);
			}
			
			// 방문했는지 확인
			visited = new int[V+1];
			q = new LinkedList<>();
			
			
			for (int j = 1; j <= V; j++) {
				if(visited[j]==0) {
					q.add(j);
					visited[j] =1;
					check();
				}
			}
			
			sb.append(answer+"\n");
		}
		System.out.print(sb);
		
		
	}
	
	static void check() {
		total: while(!q.isEmpty()) {
			int now = q.poll();
//			visited[now[0]]=true;
			
			for(Integer next:graph[now]) {
				if(visited[next]==0) {
					visited[next] = visited[now]==1?2:1;
					q.add(next);
				} else {
					if (visited[next] == visited[now]) {
						answer = "NO";
						break total;
					}
				}
			}
		}
	}
}
