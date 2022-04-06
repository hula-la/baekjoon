package BJ;

import java.io.*;
import java.util.*;

public class BJ1655 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> lessN= new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> moreN= new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int mid = Integer.parseInt(br.readLine());
		sb.append(mid+"\n");
		
		
		for (int i = 1; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (mid<num) {
				moreN.add(num);
			} else {
				lessN.add(num);
			}
			
			if (lessN.size()>moreN.size()) {
				moreN.add(mid);
				mid = lessN.poll();
			} 
			else if (moreN.size() > lessN.size()+1) {
				lessN.add(mid);
				mid = moreN.poll();
			}
			sb.append(mid+"\n");
		}
		
		System.out.println(sb);
		
	}
}
