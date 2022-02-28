package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7465_2 {
	
	// 탐색으로 푸는 방법
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] graph = new int[N+1][N+1];
			
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a][b] = 1;
				graph[b][a] = 1;
			}
			int cnt=0;
			boolean[] visited = new boolean[N+1];
			for (int j = 1; j <= N; j++) {
				if (!visited[j]) {
					cnt++;
					while
					visited[j] = true;
					for (int j2 = 1; j2 <= N; j2++) {
						if(graph[j][j2]==1) visited[j2] = true;
					}
				}
			}
			
			
			
			sb.append("#"+i+" "+cnt+"\n");
			
		}
		System.out.println(sb);
	}
}
