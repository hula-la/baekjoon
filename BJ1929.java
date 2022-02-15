package bj;

import java.util.Scanner;

public class BJ1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		boolean[] numsVisited = new boolean[N+1];
		
		for(long i = 2;i<=N;i++) {
			if (numsVisited[(int) i]==false) {
				if (i>=M) {
					System.out.print(i+"\n");
				}
				
				for (long j=(long)i*i;j<=N;j+=i) {
//					System.out.println(i+" "+j);
					numsVisited[(int) j]=true;
				}
			}
			
		}

	}
}
