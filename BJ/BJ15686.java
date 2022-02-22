package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ15686 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int homeN=0;
		int chickN=0;
		int[][] map = new int[N][N];
		int[][] chick = new int [13][2];
		
		
		
		for(int i=0;i<N;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int n = Integer.parseInt(st2.nextToken());
				map[i][j] = n;
				if (n==1) homeN++;
				else if (n==2) {
					chick[chickN][0] = i;
					chick[chickN][1] = j;
					chickN++;
				}
			}
		}
		
		
	}
}
