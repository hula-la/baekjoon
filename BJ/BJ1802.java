package BJ;

import java.io.*;
import java.util.*;

public class BJ1802 {
	static int L;
	static char[] paper;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			paper= br.readLine().toCharArray();
			L=paper.length;
			int n = (L-1)/2;
			if (check(n)) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.print(sb);
	}
	
	static boolean check(int n) {
		if (n==0) return true;
		if (check((n-1)/2)) {
			for (int i = 1; i <= n; i++) {
				if (paper[n+i]==paper[n-i]) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}
