package BJ;

import java.util.Scanner;

public class bj15649 {
	static boolean[] visited;
	static int[] arr;
	static int N,M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[M];
		visited = new boolean[N+1];
		
		permutation(0);
		
	}
	
	static void permutation(int count) {
		if (count==M) {
			for (int i:arr) {
				System.out.print(i+" ");
			}
			System.out.print("\n");
			return;
		}
		
		for (int j = 1;j<N+1;j++) {
			if (visited[j]!=true) {
				arr[count] = j;
				visited[j] = true;
				permutation(count+1);
				visited[j] = false;
			}
		}
	}
}
