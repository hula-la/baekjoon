package BJ;

import java.io.*;
import java.util.*;

public class BJ9252 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] a = br.readLine().toCharArray();
		char[] b = br.readLine().toCharArray();
		int aL = a.length;
		int bL = b.length;
		
		int[][] dp = new int[aL+1][bL+1];
		
		for (int i = 1; i <= aL; i++) {
			for (int j = 1; j <= bL; j++) {
				if(a[i-1]==b[j-1]) dp[i][j]=dp[i-1][j-1]+1;
				else dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		int x=aL;
		int y=bL;
		int ansL=dp[x][y];
		char[] ans=new char[ansL];
		while(dp[x][y]!=0) {
			if(dp[x-1][y]==dp[x][y]) x--;
			else if(dp[x][y-1]==dp[x][y]) y--;
			else {
				ans[dp[x][y]-1]=a[x-1];
				x--;
				y--;
			}
		}
		
		System.out.print(ansL+"\n");
		System.out.print(new String(ans));
	}
}
