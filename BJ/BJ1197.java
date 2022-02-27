package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1197 {
	static int[] parent;
	static int V;
	
	static class Node{
		int n,w;
		Node(int n, int w){
			this.n = n;
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		ArrayList<Node> map[] = new ArrayList[V];
		for(int i=0;i<V;i++){
		    map[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			map[a].add(new Node(b,w));
			map[b].add(new Node(a,w));
		}
		
		parent = new int[V];
		for (int i = 0; i < V; i++) {
			parent[i]=i;
		}
		
		int[] dis = new int[V];
		boolean[] visited = new boolean[V];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[0]=0;
		int nowN = 0;
		int answer=0;
		
		for (int i = 0; i < V-1; i++) {
			visited[nowN]=true;
			// dis 배열 업데이트
			for (Node node:map[nowN]) {
				dis[node.n] = Math.min(dis[node.n], node.w);
			}
			
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < V; j++) {
				if(!visited[j]) {
					if(dis[j]<min) {
						nowN=j;
						min = dis[j];
					}
					
				}
			}
			answer+=dis[nowN];
		}
		System.out.println(answer);

	}

}
