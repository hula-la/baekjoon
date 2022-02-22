package bj;

import java.util.Scanner;

public class BJ2941 {
	public static void main(String[] args) {
		String[] croatia = {"dz=","c=","c-","d-","lj","nj","s=","z="};
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		int n = 0;
		int cnt=0;
		while(n!=word.length()) {
			cnt++;
			n++; 
			for (String s:croatia) {
				if (word.startsWith(s, n-1)) {
					n+=s.length()-1;
					break;
				}
			}
		}
		System.out.println(cnt);
		
	}
}
