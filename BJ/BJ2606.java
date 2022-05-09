package BJ;

import java.io.*;
import java.util.*;

public class BJ2606 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		List<Integer>[] map = new List[C];
		
		for (int i = 0; i < C; i++) {
			map[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a].add(b);
			map[b].add(a);
		}
		
		boolean[] visited=new boolean[C];
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		visited[0]=true;
		int cnt=0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(Integer o:map[now]) {
				if(!visited[o]) {
					q.add(o);
					visited[o]=true;
					cnt++;
				}
			}
		}
		System.out.print(cnt);
		
	}
}
