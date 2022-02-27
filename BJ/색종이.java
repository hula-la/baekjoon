package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] paper = new boolean[101][101];
		int sumA = 0;
		
		for (int i=0;i<4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for (int j=x;j<w;j++) {
				for (int k=y;k<h;k++) {
					if (paper[j][k] != true){
						sumA ++;
						paper[j][k] = true;
					}
				}
			}
			
		}
		
		System.out.print(sumA);
	}
}