package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ8958 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < N; i++) {
			int p = 0;
			int count = 0;
			for(char c:br.readLine().toCharArray()) {
				if(c=='O') {
					p++;
					count+=p;
				} else {
					p=0;
				}
				
			}
			sb.append(count+"\n");
		}
		System.out.println(sb);
	}
}
