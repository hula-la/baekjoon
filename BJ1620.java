package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] dic= new String[N+1];
		Map<String, Integer> dic2= new HashMap<String, Integer>();

		
		for(int i=1;i<=N;i++) {
			String name = br.readLine();
			dic[i]=name;
			dic2.put(name, i);
			
		}
		
		for(int i=0;i<M;i++) {
			String a = br.readLine();
			if (a.toCharArray()[0]-'0'>=0 && a.toCharArray()[0]-'0'<=9) {
				sb.append(dic[Integer.parseInt(a)]+"\n");
			} else {
				sb.append(dic2.get(a)+"\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
