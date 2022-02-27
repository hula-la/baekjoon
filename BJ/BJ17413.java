package BJ;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		boolean tag = false;
		
		for (int i = 0; i < s.length; i++) {
			if (s[i]=='<') tag=true;
			if (tag){
				while(!stack.empty()) {
					sb.append(stack.pop());
				}
				sb.append(s[i]);
			} 
			else {
				if(s[i]==' ') {
					while(!stack.empty()) {
						sb.append(stack.pop());
					}
					sb.append(s[i]);
				}else {
					stack.add(s[i]);
				}
			}
			if (s[i]=='>') tag=false;
		}
		while(!stack.empty()) {
			sb.append(stack.pop());
		}
		System.out.print(sb);

	}
}
