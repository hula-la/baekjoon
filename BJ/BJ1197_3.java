package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1197_3 {
	static int[] parent;
	static class Node implements Comparable<Node>{
		int a,b,w;
		Node(int a, int b, int w){
			this.a = a;
			this.b = b;
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
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		Queue<Node> q = new PriorityQueue<Node>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			q.add(new Node(a,b,w));
		}
		
		parent = new int[V];
		for (int i = 0; i < V; i++) {
			parent[i] =i;
		}
		int answer = 0;
		int num=0;
		
		while(true) {
			Node now = q.poll();
			if(join(now.a,now.b)) {
				answer+=now.w;
				num++;
				if(num==V-1) break;
			}

		}
		System.out.println(answer);
	}
	
	static boolean join(int a, int b) {
		if (findP(a) == findP(b)){
			return false;
		}
		else {
			parent[findP(a)] = findP(b);
			return true;
		}
	}
	
	static int findP(int j) {
		if (parent[j]==j) return j;
		else return parent[j]=findP(parent[j]);

	}

}
