package BJ;

import java.util.Scanner;

public class BJ2999 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String mes = sc.next();
		StringBuilder sb = new StringBuilder();
		int N = mes.length();
		int R=0;
		int C=0;
		for (int i = (int) Math.sqrt(N); i > 0; i--) {
			if (N%i == 0) {
				R = i;
				C = N/i;
				break;
			}
		}
		for (int j = 0; j < R; j++) {
			for (int i = 0; i < C; i++) {
				sb.append(mes.charAt(R*i+j));
			}
		}
		
		System.out.print(sb);
		sc.close();
	}
}
