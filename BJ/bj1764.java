package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bj1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<String> answer = new ArrayList<>();
		Set<String> s = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			s.add(name);
		}
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if(s.contains(name)) {
				answer.add(name);
			}
		}
		Collections.sort(answer);
		sb.append(answer.size()+"\n");
		for(String a :answer) {
			sb.append(a+"\n");
		}
		System.out.print(sb);
	}
}
