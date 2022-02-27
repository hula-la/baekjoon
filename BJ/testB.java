package BJ;

import java.util.Scanner;

public class testB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] S = sc.next().toCharArray();
		char[] T = sc.next().toCharArray();
		
		int[] arr = new int[T.length];
		
		for (char c:S) {
			for (int i = 0; i < T.length; i++) {
				if(c==T[i]) {
					if(i==0) {
						arr[i]++;
					}
					else if(arr[i-1]>0) {
						arr[i-1]--;
						arr[i]++;
					}
				}
			}
		}
		System.out.println(arr[T.length-1]);
	}
	
	
}
