package BJ;

import java.io.*;
import java.util.*;

public class BJ1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
//			int[] arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			int[] priority = new int[10];
			Queue<Integer[]> q = new LinkedList<>();
			
			for (int j = 0; j < N; j++) {
				int p=Integer.parseInt(st.nextToken());
				q.add(new Integer[] {j,p});
//				arr[j] = p;
				priority[p]++;
			}
			int cnt=0;
			total:while(!q.isEmpty()) {
				Integer[] now = q.poll();
				for (int j = now[1]+1; j < 10; j++) {
					if(priority[j]!=0) {
						q.add(now);
						continue total;
					}
				}
				cnt++;
				priority[now[1]]--;
				if (now[0]==M) break;
			}
			
			
			
			sb.append(cnt+"\n");
		}
		System.out.print(sb);
		
	}
}

