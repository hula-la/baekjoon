package BJ;

import java.util.Scanner;

public class BJ12927 {
	static char[] swit;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		swit = sc.nextLine().toCharArray();
		N=swit.length;
		
		int cnt = 0;
		if (!check(0)) {
			count: for (int i=0;i<N;i++) {
				if (swit[i] == 'Y') {
					changeArr(i);
					cnt++;
										
					if (check(i)) {
						break count;
					}
				}
				
			}
		}
		
		System.out.println(cnt);
		
 	}
	
	static void changeArr(int n) {
		for (int i=n;i<N;i+=n+1) {
			swit[i]=swit[i]=='Y'?'N':'Y';
		}
	}
	
	
	static boolean check(int num) {
		for(int i=num;i<N;i++) {
			if (swit[i]=='Y') {
				return false;
			}
		}
		return true;
	}
}
