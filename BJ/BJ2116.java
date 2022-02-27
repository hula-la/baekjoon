package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2116 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][6];
		int[] opposite = {5,3,4,1,2,0};
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 6; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int idx = 0;
		int result=0;
		
		for(int i:arr[0]) {
			int sum = 0;
			int next = i;
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 6; k++) {
					if (next == arr[j][k]) {
						idx = k;
					}
				}
				next = arr[j][opposite[idx]];
				
				int max = 0;
				
				for (int l = 0; l < 6; l++) {
					if (l!=idx&&l!=opposite[idx]) {
						max = Math.max(max, arr[j][l]);
					}
				}
				sum+= max;
				
			}
			result = Math.max(result, sum);
			
		}
		System.out.print(result);
	}
}
