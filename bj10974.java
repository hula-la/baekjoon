package bj;

import java.util.Scanner;

public class bj10974 {
	static int n;
	static boolean[] visited;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		visited = new boolean[n];
		permutation(0,new int[n]);
	}
	
	static void permutation(int count, int[] arr) {
		if (count == n) {
			for(int i:arr) {
				System.out.print(i+" ");
			}
			System.out.print("\n");
		}
		else {
			for (int j = 1;j<n+1;j++) {
				if (visited[j-1] != true) {
					
					arr[count] = j;
					visited[j-1] = true;
					permutation(count+1,arr);
					visited[j-1] = false;
				}
			}
		}
	}
}
