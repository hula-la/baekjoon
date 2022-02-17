package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2567 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] paper = new int[102][102];
		int[] dx = {-1,1,0,0};
		int[]dy = {0,0,1,-1};
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int j = x+1; j <= x+10; j++) {
				for (int k = y+1; k <= y+10; k++) {
					paper[j][k] = 1;
				}
			}
		}
		int cnt = 0;
		
		for (int j = 1; j <= 100; j++) {
			for (int k = 1; k <= 100; k++) {
				for(int i = 0;i<4;i++) {
					if(paper[j][k] == 1&&paper[j+dx[i]][k+dy[i]] == 0) cnt++;
				}
			}
		}
		System.out.print(cnt);
	}
}
