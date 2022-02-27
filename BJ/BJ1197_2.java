package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1197_2 {
	static int[] parent;
	static int V;
	
	static class Node implements Comparable<Node>{
		int n,w;
		Node(int n, int w){
			this.n = n;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
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
		
		Queue<Node> q = new PriorityQueue<Node>();
		
		boolean[] visited = new boolean[V];
		int answer=0;
		int n=0;
		q.add(new Node(0,0));
		
		while(true) {
			Node nowN=q.poll();
			if (visited[nowN.n]) continue;
			
			visited[nowN.n]=true;
			answer+=nowN.w;
			n++;
			if (n==V) break;
			
			for (Node node:map[nowN.n]) {
				q.add(node);
			}
			
		}
		System.out.println(answer);

	}

}
