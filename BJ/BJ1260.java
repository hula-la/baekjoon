package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1260 {
	static int[][] graph;
	static int N,M,V;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x][y] = 1;
			graph[y][x] = 1;
		}
		DFS(new boolean[N+1],V);
		sb.append("\n");
		BFS(new boolean[N+1],V);
		
		System.out.println(sb);
	}
	
	static void BFS(boolean visited[], int p) {
		Queue<Integer> s = new LinkedList<Integer>();
		s.add(p);
		visited[p] = true;
		
		while (!s.isEmpty()) {
			int a = s.poll();
			
			sb.append(a+" ");
			for (int i = 0; i <= N; i++) {
				if (graph[a][i] == 1 && !visited[i]) {
					visited[i] = true;
					s.add(i);
				}
			}
			
		}
	}
	
	static void DFS(boolean visited[], int p) {
		visited[p] = true;
		sb.append(p+" ");
		
		for (int i = 0; i <= N; i++) {
			if (graph[p][i] == 1 && !visited[i]) {
				DFS(visited, i);
			}
		}
	}
}
