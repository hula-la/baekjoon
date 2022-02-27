package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16967 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[H][W];
		
		for (int i = 0; i < H+X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W+Y; j++) {
				if(i<H && j<W &&(i>=X && j>=Y)) {
					A[i][j] = Integer.parseInt(st.nextToken())-A[i-X][j-Y];
				}
				else if (i<H && j<W &&(i<X || j<Y)) {
					A[i][j] = Integer.parseInt(st.nextToken());
				} else {
					st.nextToken();
					
				}
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sb.append(A[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
}
