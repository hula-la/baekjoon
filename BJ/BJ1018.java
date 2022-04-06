package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = Integer.MAX_VALUE;
		
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N-7; i++) {
			for (int j = 0; j < M-7; j++) {
				int count = 0;
				for (int i2 = 0; i2 < 8; i2++) {
					for (int j2 = 0; j2 < 8; j2++) {
						if ((i2+j2)%2 == 0) {
							if (map[i+i2][j+j2] == 'B') count++;
						} else {
							if (map[i+i2][j+j2] == 'W') count++;
						}
					}
				}
				answer = Math.min(Math.min(count, 64-count), answer);
			}
		}
		System.out.print(answer);
	}
}
