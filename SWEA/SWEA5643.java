package SWEA;

import java.io.*;
import java.util.*;


public class SWEA5643 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
         
        for (int i = 1; i <= T; i++) {
        	int N = Integer.parseInt(br.readLine());
        	int M = Integer.parseInt(br.readLine());
        	
        	List<Integer>[] up = new List[N];
        	List<Integer>[] down = new List[N];
        	
        	for (int j = 0; j < N; j++) {
				up[j] = new ArrayList<>();
				down[j] = new ArrayList<>();
			}
        	
            for (int j = 0; j < M; j++) {
            	st = new StringTokenizer(br.readLine());
            	int a = Integer.parseInt(st.nextToken())-1;
            	int b = Integer.parseInt(st.nextToken())-1;
            	up[a].add(b);
            	down[b].add(a);
            }
            
            int ans=0;
            
            for (int j = 0; j < N; j++) {
            	boolean[] visited = new boolean[N];
            	Queue<Integer> q = new LinkedList<Integer>();
            	q.add(j);
            	int cnt=1;
				while(!q.isEmpty()) {
					int now = q.poll();
					for(int a:up[now]) {
						if (!visited[a]) {
							visited[a]=true;
							cnt++;
							q.add(a);
						}
					}
				}
				q.add(j);
				while(!q.isEmpty()) {
					int now = q.poll();
					for(int a:down[now]) {
						if (!visited[a]) {
							visited[a]=true;
							cnt++;
							q.add(a);
						}
					}
				}
				if (cnt==N) ans++;
			}
            
            
            
            sb.append("#"+i+" "+ans+"\n");
        }
        System.out.print(sb);
	}
}

