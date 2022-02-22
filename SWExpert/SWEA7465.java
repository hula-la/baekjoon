package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7465 {
	static int[] parent;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			parent = new int[N+1];
			set();
			
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a,b);
			}
			boolean[] visited = new boolean[N+1];
			int cnt = 0;
			for (int j = 1; j <= N; j++) {
				int p = findP(j);
				if (!visited[p]) {
					cnt++;
					visited[p]=true;
				}
			}
			
			sb.append("#"+i+" "+cnt+"\n");
			
		}
		System.out.println(sb);
	}
	
	static void set() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	static int findP(int i) {
		if(parent[i] == i) return i;
		else return parent[i] = findP(parent[i]);
	}
	
	static void union(int a, int b) {
		parent[findP(b)] = findP(a);
	}
}
