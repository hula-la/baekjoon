package BJ;

import java.io.*;
import java.util.*;

public class BJ1107 {
	static int N,L,ans;
	static boolean[] remote;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ans=Math.abs(100-N);
		char[] nArr=String.valueOf(N).toCharArray();
		
		if(M!=0) st = new StringTokenizer(br.readLine());
		remote = new boolean[10];
		for (int i = 0; i < M; i++) {
			int n=Integer.parseInt(st.nextToken());
			remote[n] = true;
		}
		
		DFS(0,0);
		System.out.print(ans);
	}
	
	static void DFS(int idx, int ch) {
//		System.out.println(idx+" "+ch);
		for (int i=0;i<10;i++) {
			if (!remote[i]) {
				int n=(int) (ch+Math.pow(10, idx)*i);
				ans=Math.min(ans, String.valueOf(n).length()+Math.abs(n-N));
				if (n>N||idx>ch+1) return;
				DFS(idx+1,n);
			}
		}
	}
}
