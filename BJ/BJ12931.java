package BJ;

import java.io.*;
import java.util.*;

public class BJ12931 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] two = new int[N];
		int[] one = new int[N];
		int ans=0;
		int max=0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int n=Integer.parseInt(st.nextToken());
			int[] num=calN(n);
			two[i]=num[0];
			one[i]=num[1];
			ans+=one[i];
			max=Math.max(max, two[i]);
		}
		System.out.print(ans+max);
	}
	static int[] calN(int n) {
		int a=0;
		int b=0;
		while (n!=0) {
			if(n%2==0) {
				n/=2;
				a++;
			} else {
				n--;
				b++;
			}
		}
		return new int[]{a,b};
	}
}
