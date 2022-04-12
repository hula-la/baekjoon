package SWEA;

import java.io.*;
import java.util.*;

public class SWEA5604 {
	static int[] sumArr = new int[10];
	public static void main(String[] args) throws IOException {
		for (int i = 1; i < 10; i++) {
			sumArr[i]=sumArr[i-1]+i;
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TN = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TN; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			sb.append("#"+i+" "+(sum(b)-sum(a-1))+"\n");
		}
		System.out.print(sb);
	}
	
	static long sum(long a) {
		long sum=0;
		long multi=1;
		while (a>=multi) {
			int n=(int) ((a/multi)%(10));
			if (n!=0) {
				sum+=multi*sumArr[n-1];
			}
			sum+=multi*(a/(multi*10))*sumArr[9];
			sum+=(a%multi+1)*n;
			multi*=10;
		}
		return sum;
	}
}
