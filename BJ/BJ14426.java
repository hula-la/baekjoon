package BJ;

import java.io.*;
import java.util.*;

public class BJ14426 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] word = new String[N];
		
		for (int i = 0; i < N; i++) {
			word[i]=br.readLine();
		}
		int ans=0;
		for (int i = 0; i < M; i++) {
			String test=br.readLine();
			for (int j = 0; j < N; j++) {
				if(word[j].startsWith(test)) {
					ans++;
					break;
				}
			}
		}
		
		System.out.print(ans);
	}
}
