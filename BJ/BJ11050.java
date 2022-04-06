package BJ;

import java.io.*;
import java.util.*;

public class BJ11050 {
	public static void main(String[] args) throws IOException {
		int answer=1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for (int i = N; i > N-K; i--) {
			answer*=i;
			answer/=N+1-i;
		}
//		for (int i = 1; i <= K; i++) {
//			answer/=i;
//		}
		System.out.print(answer);
	}
}
