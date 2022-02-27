package BJ;

import java.io.*;

public class BJ16916 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] S = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		int pl = P.length;
		int sl = S.length;
		int[] pi = new int[pl];
		
		for (int i=1,j=0; i < pl; i++) {
			while(P[i]!=P[j]&&j!=0) j=pi[j-1];
			if(P[i]==P[j]) pi[i]=++j;
		}
		
		for (int i=0,j=0; i < sl; i++) {
			while(S[i]!=P[j]&&j!=0) {
				j=pi[j-1];
			}
			if(S[i]==P[j]&&++j==pl) {
				System.out.print(1);
				System.exit(0);
			}
		}
		System.out.print(0);
		
	}
}
