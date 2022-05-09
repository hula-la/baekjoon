package BJ;

import java.io.*;

public class BJ2602 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] target = br.readLine().toCharArray();
		char[] engel = br.readLine().toCharArray();
		char[] devil = br.readLine().toCharArray();
		int TL = target.length;
		int L = engel.length;
		
		long[][] dpE = new long[L][TL];
		long[][] dpD = new long[L][TL];
		
		for (int i = 0; i < L; i++) {
			if (i!=0) {
				dpE[i] = dpE[i-1].clone();
				dpD[i] = dpD[i-1].clone();
			}
			
			for (int j = 0; j < TL; j++) {
				if (target[j]==engel[i]) {
					if (j==0) dpE[i][j]++;
					else dpE[i][j] += dpD[i-1][j-1];
				}
				if (target[j]==devil[i]) {
					if (j==0)dpD[i][j]++;
					else dpD[i][j] += dpE[i-1][j-1];
				}
				if (i==0) break;
			}
		}
		System.out.print(dpE[L-1][TL-1]+dpD[L-1][TL-1]);
	}
}
