package BJ;

import java.io.*;
import java.util.*;

public class BJ2696 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < T; i++) {
			int M = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> higher = new PriorityQueue<>();
			int mid=0;
			int cnt=0, cnt2=0;
			sb.append((M+1)/2+"\n");
			for (int j = 0; j <= (M-1)/10; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 10; k++) {
					if (cnt++==M) break;
					int n = Integer.parseInt(st.nextToken());
					if (cnt==1) mid=n;
					else {
						if(mid<n) {
							higher.add(n);
							if(higher.size()>lower.size()+1) {
								lower.add(mid);
								mid=higher.poll();
							} 
						} else {
							lower.add(n);
							if(higher.size()+1<lower.size()) {
								higher.add(mid);
								mid=lower.poll();
							} 
						}
					}
					if (cnt%2==1) {
						cnt2++;
						sb.append(mid+" ");
						if (cnt2%10==0||cnt2==(M+1)/2)sb.append("\n");
					}
				}
			}
		}
		
		System.out.print(sb);
	}
}
