package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BJ1927 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<Integer> pq = new PriorityQueue<Integer>();
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			
			if (a==0) {
				Object b = pq.poll();
				sb.append((b==null?0:b)+"\n");
			} else pq.add(a);
		}
		System.out.println(sb);
		
	}
}
