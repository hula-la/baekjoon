package BJ;

import java.io.*;
import java.util.*;

public class BJ11437 {
	static int[] level,parent;
	static List<Integer>[] node;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		node = new ArrayList[N+1];
		level = new int[N+1];
		parent = new int[N+1];
		
		for (int i = 0; i < N+1; i++) {
			node[i]=new ArrayList<Integer>();
		}
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			node[a].add(b);
			node[b].add(a);
		}
		boolean visited[] = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1]=true;
		
		while(!q.isEmpty()) {
			int now=q.poll();
			
			for(int a:node[now]) {
				if (!visited[a]) {
					parent[a]=now;
					level[a]=level[now]+1;
					q.add(a);
					visited[a]=true;
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(findLCA(a, b)+"\n");
		}
		
		System.out.print(sb);
	}
	
	static int findLCA(int a, int b) {
		while(a!=b) {
			if (level[a]>level[b]) a=parent[a];
			else if (level[a]<level[b]) b=parent[b];
			else {
				a=parent[a];
				b=parent[b];
			}
		}
		return a;
	}
}
