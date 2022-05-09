package BJ;

import java.io.*;
import java.util.*;

public class BJ2467 {
	static int sum = 2100000000;
	static int ansA = 0;
	static int ansB = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> neg = new ArrayList<Integer>();
		List<Integer> pos = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n<0) {
				neg.add(n);
			} else {
				pos.add(n);
			}
		}
		Collections.reverse(neg);
		
		// 같은 특성의 용액을 섞을 경우
		if (neg.size()>1) compare(neg.get(0),neg.get(1));
		if(pos.size()>1) compare(pos.get(0),pos.get(1));
		
		if (neg.size()<pos.size()) binarySearch(neg,pos);
		else binarySearch(pos,neg);
		
		System.out.print(ansA+" "+ansB);
	}
	
	static void compare(int a, int b) {
		int tmpS=Math.abs(a+b);
		if (tmpS<sum) {
			ansA=Math.min(a, b);
			ansB=Math.max(a, b);
			sum=tmpS;
		}
	}
	
	static void binarySearch(List<Integer> A, List<Integer> B) {
		for(int n:A) {
			int s=0;
			int e = B.size();
			while (s<e) {
				int m=(s+e)/2;
				if (Math.abs(B.get(m))<Math.abs(n)) {
					s=m+1;
				} else {
					e=m;
				}
			}
//			System.out.println(n);
//			System.out.println(e+" "+s);
			if(s-1>=0) compare(n,B.get(s-1));
			if(s<B.size()) compare(n,B.get(s));
		}
	}
}
/*
8
-100 -98 -95 -7 1 2 9 97
*/
