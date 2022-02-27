package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2804 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		char[] A = st.nextToken().toCharArray();
		char[] B = st.nextToken().toCharArray();
		int idxa = 0, idxb = 0;
		
		total: for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				if(A[i] == B[j]) {
					idxa = i;
					idxb = j;
					break total;
				}
			}
		}
		
		for (int i = 0; i < B.length; i++) {
			if (i==idxb) {
				sb.append(String.valueOf(A)+"\n");
			}else {
				for (int j = 0; j < idxa; j++) {
					sb.append(".");
				}
				sb.append(B[i]);
				for (int j = idxa+1; j < A.length; j++) {
					sb.append(".");
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
		
	}
}
