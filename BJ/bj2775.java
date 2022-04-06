package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2775 {
	public static void main(String[] args) throws NumberFormatException, IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int[][] map = new int[k+2][n+1];
			
			for (int x = 0; x <= k; x++) {
				for (int y = 1; y <= n; y++) {
					if(x==0) {
						map[x][y] = y;
					}else {
						map[x][y]=map[x][y-1]+map[x-1][y];
					}
				}
			}
			
			sb.append(map[k][n]+"\n");
		}
		System.out.print(sb);
	}
}
