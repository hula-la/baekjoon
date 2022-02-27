package BJ;

import java.util.Scanner;

public class BJ10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String w = sc.next();
		StringBuilder sb = new StringBuilder();
		total: for (int j = 0; j <= 'z'-'a'; j++) {
			for (int i = 0; i < w.length(); i++) {
				if (w.charAt(i)==(char)'a'+j) {
					sb.append(i+" ");
					continue total;
				}
			}
			sb.append(-1+" ");
		}
		
		System.out.println(sb);
		
		
	}
}
