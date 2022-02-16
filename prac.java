package bj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class prac {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		long start = System.nanoTime();
		Queue<Integer> nums = new LinkedList<Integer>();
		
		for (int i = 2;i<N;i++) {
			nums.add(i);
		}
		long mid = System.nanoTime();
		long rm1 = 0,rm2 = 0;
		while(!nums.isEmpty()) {
			int n = nums.poll();
			if (n>=M) {
				System.out.print(n+"\n");
			}
			rm1 = System.nanoTime();
			nums.removeIf(i->(i%n ==0));
			rm2 = System.nanoTime();
			System.out.println("*********************");
			System.out.println(rm2-rm1);
			System.out.println("*********************");

		}
		System.out.println(mid-start);
		
		
	}
}