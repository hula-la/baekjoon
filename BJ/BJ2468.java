package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2468 {
	static int n, N;
	static int[][] dl= {{0,1},{0,-1},{1,0},{-1,0}};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}
		
		int answer = 0;
		
		for (int i = min-1; i < max; i++) {
			int cnt = 0;
			
			int[][] temp = new int[N][N];
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (map[j][k]<=i) {
						temp[j][k] = 0;
					}
					else{
						temp[j][k] = map[j][k];
					}
				}
			}
//			print(temp);
//			System.out.println("******");
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (temp[j][k]!=0) {
						cnt++;
						searchMap(temp, j, k);
//						print(temp);
					}
				}
			}
			
			answer = Math.max(answer, cnt);
		}
		System.out.println(answer);
		
	}
	
	public static void searchMap(int[][] map,int i, int j) {
		if (i<0||i>=N||j<0||j>=N) return;
		if (map[i][j] == 0) return;
		
		
		
		map[i][j] = 0;
		for (int j2 = 0; j2 < 4; j2++) {
			searchMap(map, i+dl[j2][0], j+dl[j2][1]);
		}
	}
	
	static void print (int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
