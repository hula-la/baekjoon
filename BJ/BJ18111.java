package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int answer=Integer.MAX_VALUE;
		int height=0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}
		
		for (int k = max; k >= min; k--) {
			int add = 0;
			int remove=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==k) continue;
					if(map[i][j]>k) {
						remove+= map[i][j]-k;
					}
					else add+=k-map[i][j];
				}
			}
//			System.out.println(k+" "+add+" "+remove);
			if (add<=remove+B) {
				int total = add+2*remove;
				if (answer>total) {
					answer = total;
					height = k;
				}
				
			}
		}
		
		System.out.println(answer+" "+height);
		
		
	}
}
