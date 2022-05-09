package BJ;

import java.io.*;
import java.util.*;

public class BJ2143 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Long, Long> sumA = new HashMap<>();
		
		long T = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		long[] arrA = new long[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int num=Integer.parseInt(st.nextToken());
			if (i==0)arrA[i]=num;
			else arrA[i]=num+arrA[i-1];
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				long sum=arrA[i]-arrA[j];
				if(!sumA.containsKey(sum)) {
					sumA.put(sum, (long) 1);
				} else {
					sumA.put(sum, sumA.get(sum)+1);
				}
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		long[] arrB = new long[m+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= m; i++) {
			int num=Integer.parseInt(st.nextToken());
			if (i==0)arrB[i]=num;
			else arrB[i]=num+arrB[i-1];
		}
		
		long ans=0;
		for (int i = 1; i <= m; i++) {
			for (int j = 0; j < i; j++) {
				long sum=arrB[i]-arrB[j];
				if(sumA.containsKey(T-sum)) {
					ans+=sumA.get(T-sum);
				}
			}
		}
		System.out.print(ans);
	}
}
