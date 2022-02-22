package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1992 {
	static char[][] map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		map = new char[N][]; 
		
		for(int i=0;i<N;i++) {
			map[i] =br.readLine().toCharArray();
		}
		
		find(0,0,N);
		System.out.println(sb.toString());
	}
	
	static void find(int a, int b, int N) {
		
		if (check(a,b,N)) {
			
			sb.append(map[a][b]);
		} else {
			sb.append("(");
			find(a,b,N/2);
			find(a,b+N/2,N/2);
			find(a+N/2,b,N/2);
			find(a+N/2,b+N/2,N/2);
			sb.append(")");
		}
	}
	
	static boolean check(int a, int b, int N) {
		int base = map[a][b];
		for (int i=a;i<a+N;i++) {
			for(int j=b;j<b+N;j++) {
				if (map[i][j] != base) return false;
			}
		}
		return true;
	}
}
