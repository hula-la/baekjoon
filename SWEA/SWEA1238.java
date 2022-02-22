package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1238 {
	static int[][] graph;
	static int N,S;
	static int max;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int j = 1; j <= 10; j++) {
			max=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			graph = new int[101][101];
			
			for (int i = 0; i < N/2; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				graph[x][y] = 1;
			}
			
			
			BFS(new boolean[101],S);
			
			sb.append("#"+j+" "+max+"\n");
		}
		System.out.println(sb);
	}
	
	static void BFS(boolean visited[], int p) {
		Queue<Integer[]> s = new LinkedList<>();
		s.add(new Integer[]{p,0});
		visited[p] = true;
		int mT = 0;
		
		while (!s.isEmpty()) {
			Integer[] a = s.poll();
			
			boolean last = true;
			
			for (int i = 0; i <= 100; i++) {
				if (graph[a[0]][i] == 1 && !visited[i]) {
					visited[i] = true;
					s.add(new Integer[]{i,a[1]+1});
					last = false;
				}
			}
			if (last) {
				if (a[1]>mT) {
					max = a[0];
					mT = a[1];
				}
				else if (a[1]==mT) {
					max = Math.max(a[0], max);
				}
			}
			
		}
	}

}
