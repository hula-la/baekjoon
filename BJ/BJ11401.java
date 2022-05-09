package BJ;

import java.io.*;
import java.util.*;

public class BJ11401 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
			
		System.out.println(nCr(n, r, 1000000007));
	}
	static long power(long x, long y, long p) {
		long res=1;
		while(y>0) {
			if (y%2==1) {
				res=res*x%p;
			}
			y>>=1;
			x=x*x%p;
		}
		return res;
	}
	
	static long nCr(int n,int r, int p) {
		long[] fac=new long[n+1];
		fac[0]=1;
		for (int i = 1; i <= n; i++) {
			fac[i]=fac[i-1]*i%p;
		}
		return fac[n]*power(fac[r]*fac[n-r]%p,p-2,p)%p;
	}
}
