package bj;

import java.util.Arrays;
import java.util.Scanner;

public class BJ15665 {
	static int[] arr;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		permutation(0, new int[M]);
		System.out.println(sb.toString());
	}
	
	public static void permutation(int cnt, int[] temp) {
		if (cnt==M) {
			for(int i:temp) sb.append(i+" ");
			sb.append("\n");
			return;
		}
		
		int last = 0;
		for (int i=0;i<N;i++) {
			if (last!=arr[i]) {
				temp[cnt] = arr[i];
				permutation(cnt+1,temp);
				last = arr[i];
			}
		}
	}
}
