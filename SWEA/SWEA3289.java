package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3289 {
	static int[] parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parent = new int[n+1];
			
			sb.append("#"+i+" ");
			setP(n);
			
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int union = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(union == 1) {
					if(findP(a)==findP(b)) sb.append(1);
					else sb.append(0);
				}
				else {
					Uni(a,b);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	static void setP(int n) {
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}
	
	static int findP(int n) {
		if (parent[n] == n) return n;
		else return parent[n] = findP(parent[n]);
	}
	
	static void Uni(int a, int b) {
		parent[findP(b)] = findP(a);
	}
}
