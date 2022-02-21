package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1759 {
	static String vowel = "aeiou";
	static int L,C;
	static String[] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = br.readLine().split(" ");
		
		Arrays.sort(arr);
		
		Combination(0,0,0,new String[L]);
		
		System.out.println(sb);
	}
	
	static void Combination(int idx,int cnt, int vowN, String[] part) {
		if (cnt==L) {
			if (vowN>=1 && cnt-vowN>=2) {
				for(String s:part) {
					sb.append(s);
				}
				sb.append("\n");
			}
		} else {
			for (int i = idx; i < C; i++) {
				part[cnt] = arr[i];
				if (vowel.contains(arr[i])) {
					Combination(i+1, cnt+1, vowN+1, part);
				} else {
					Combination(i+1, cnt+1, vowN, part);
					
				}

			}
		}
	}
}
