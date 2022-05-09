package BJ;

import java.io.*;
import java.util.*;

public class BJ1019_2 {
	static int[] count = new int[10];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		long n=sc.nextLong();
		sum(n);
		for(int i:count) System.out.print(i+" ");
	}
	
	static void sum(long a) {
		//자릿수
		int n=1;
		while(n<=a) {
			// 윗자리 수
			long upper=a/(n*10)*n;
			//해당 자리의 수
			long b=(a/n)%10;
			for (int i = 0; i <= 9; i++) {
				if (i<b) count[i]+=upper+n;
				else if (i>b) count[i]+=upper;
				else if (i==b) count[i]+=upper+a%n+1;
			}
			count[0]-=n;
			n*=10;
		}
	}
}
