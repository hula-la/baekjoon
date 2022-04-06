package BJ;

import java.io.*;
import java.util.*;

public class BJ7568 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] h = new int[N][2];
		int[][] w = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			h[i][0] = w[i][0]=i;
			w[i][1] = Integer.parseInt(st.nextToken());
			h[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Comparator<int[]> compare= new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1]-o1[1];
			}
		};
		
		Arrays.sort(h, compare);
//		Arrays.sort(w, compare);
		int[] rank = new int[N];
		int n=1;
		
//		ArrayList<Integer> al = new ArrayList<>();
//		for (int i = 0; i < N; i++) {
//			if (al.isEmpty() &&h[i][0]==w[i][0]) {
//				rank[h[i][0]] = i+1;
//				n= i+2;
//			} else {
//				if (al.contains(h[i][0])) {
//					rank[h[i][0]] = n;
//					al.remove(al.indexOf(h[i][0]));
//				} else {
//					al.add(h[i][0]);
//				}
//				if (al.contains(w[i][0])) {
//					rank[w[i][0]] = n;
//					al.remove(al.indexOf(w[i][0]));
//				} else {
//					al.add(w[i][0]);
//				}
//			}
//		}
		int sum=0;
		for (int i = 0; i < N; i++) {
			System.out.println(h[i][0]);
			if (rank[h[i][0]]!=0) continue;
			for (int j = 0; j < N; j++) {
				if (rank[j]==0 && w[h[i][0]][1]<=w[j][1]) {
					rank[j] = n;
					sum++;
				}
			}
			if (sum<=1) n=i+2;
			sum=0;
		}
		
		
		for (int r:rank) {
			sb.append(r+" ");
		}
		System.out.print(sb);
	}
}
