package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2636 {
	static int H,W;
	static int[][] dl= {{0,1},{0,-1},{1,0},{-1,0}};
	static int t;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		int chSum = 0;
		
		int[][] map = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 1) {
					chSum++;
				}
			}
		}
		
		t=1;
		
		total: while(true) {
			searchMap(map,0,0);
//			print(map);
			
			int meltSum = 0;
			// 2인 치즈 찾아서 없애기
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1) {
						meltSum++;
					}
				}
			}
//			System.out.println(meltSum);
			if (meltSum==0) {
				System.out.println(t);
				System.out.println(chSum);
				break total;
			}
			chSum = meltSum;
			t++;
		}
		
	}
	
	public static void searchMap(int[][] map,int i, int j) {
//		System.out.print(i);
//		System.out.println(" " +j);
		if (i<0||i>=H||j<0||j>=W) return;
		if (map[i][j] == -t) return;
		// 치즈일 경우
		if (map[i][j] == 1) {
			map[i][j] = -t; 
			return;
		}
		map[i][j] = -t; 
		
		for (int j2 = 0; j2 < 4; j2++) {
			searchMap(map, i+dl[j2][0], j+dl[j2][1]);
		}
	}
	
//	static void print (int[][] map) {
//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < W; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
}
