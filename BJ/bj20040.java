package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20040 {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int answer = 0;
		parent = new int[n];
		
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(!join(Math.min(a, b),Math.max(a, b))) {
				answer = i;
				break;
			}
		}
		System.out.print(answer);
	}
	static int findP(int a) {
		if (parent[a]==a) return a;
		else return parent[a]=findP(parent[a]);
	}
	static boolean join(int a, int b) {
		if (findP(a)==findP(b)) return false;
		else {
			parent[findP(b)] = a;
			return true;
		}
	}
}
