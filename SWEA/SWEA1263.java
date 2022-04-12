package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1263 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for (int i = 1; i <= T; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];
            for (int j = 0; j < N; j++) {
            	for (int k = 0; k < N; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
					if (map[j][k]==0) map[j][k]=1000000;
				}
            }
            for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					for (int l = 0; l < N; l++) {
						map[k][l] = Math.min(map[k][l], map[k][j] + map[j][l]);
					}
				}
			}
            int min=Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
            	int sum=0;
				for (int k = 0; k < N; k++) {
					if (j==k) continue;
					sum+=map[j][k];
				}
				min=Math.min(min, sum);
//				System.out.println(Arrays.toString(map[j]));
			}
            sb.append("#"+i+" "+min+"\n");
        }
        System.out.print(sb);
	}
}
