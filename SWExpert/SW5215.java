package ssafy.com.algo2;

import java.util.Scanner;

public class SW5215 {
	static int T, N,L;
	static int maxTaste;
	static int[] input, numbers;
	static boolean[] isSelected;
	static int[] taste, kalory;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for(int i = 0; i < T; i++) {
			N = sc.nextInt();
			L = sc.nextInt();
			maxTaste = 0;
			
			taste = new int[N];
			kalory = new int[N];
			
			for(int j = 0; j < N; j++) {
				taste[j] = sc.nextInt();
				kalory[j] = sc.nextInt();
			}
			findA(0,0,0);
			System.out.println("#"+(i+1)+" " +maxTaste);
		}
	}
	
	public static void findA(int cnt, int sumK, int sumT) {
		if ((sumK <= L)&&(maxTaste<sumT)) {
			maxTaste = sumT;
		}
		if  ((cnt>=N)||(sumK > L)) {
			return;
		}

		
		
		findA(cnt+1, sumK, sumT);	
		findA(cnt+1, sumK+ kalory[cnt], sumT+ taste[cnt]);
			
	}
	
}



