package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(tree);
		int start = 0;
		int end = tree.length;
		int lenSum=0;
		
		while (start!=end) {
			lenSum = 0;
			int mid = (end-start)/2;
			
			for (int i = mid; i < tree.length; i++) {
				lenSum += tree[i] - tree[start];
			}
			
			if (lenSum<M) {
				start=mid;
			} else {
				end=mid;
			}
		}
		
		System.out.println(lenSum);
		System.out.println(tree[start]);
	}
}
