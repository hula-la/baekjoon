package bj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		Queue<Integer> nums = new LinkedList<Integer>();
		
		for (int i = 2;i<N;i++) {
			nums.add(i);
		}
		
		while(!nums.isEmpty()) {
			int n = nums.poll();
			if (n>=M) {
				System.out.print(n+"\n");
			}
			nums.removeIf(i->(i%n ==0));
		}

	}
}
