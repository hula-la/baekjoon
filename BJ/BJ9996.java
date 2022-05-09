package BJ;

import java.io.*;
import java.util.*;

public class BJ9996 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(br.readLine());
		String reg = br.readLine();
		int s=reg.indexOf("*");
		String prefix=reg.substring(0, s);
		String suffix=reg.substring(s+1, reg.length());
		for (int i = 0; i < N; i++) {
			String word=br.readLine();
			if (word.startsWith(prefix)&&word.substring(s).endsWith(suffix)) {
				sb.append("DA\n");
			} else {
				sb.append("NE\n");
			}
		}
		
		System.out.print(sb);
	}
}
