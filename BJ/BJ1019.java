package BJ;

import java.io.*;
import java.util.*;

public class BJ1019 {
	static int[] count = new int[10];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		long n=sc.nextLong();
		sum(n);
		for(int i:count) System.out.print(i+" ");
	}
	
	static void sum(long a) {
		long multi=1;
		while (a>=multi) {
			int n=(int) ((a/multi)%(10));
			for (int i = 0; i <= 9; i++) {
				if (i<n)count[i]+=multi;
				count[i]+=multi*(a/(multi*10));
			}
			count[n]+=(a%multi+1);
			count[0]-=multi;
			multi*=10;
		}
	}
}
