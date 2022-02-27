package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10163 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] paper = new int[1001][1001];
		int[] cnt = new int[N+1];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			for(int x=x1;x<x1+W;x++) {
				for(int y=y1;y<y1+H;y++) {
					paper[x][y] = i+1;
				}
			}
		}
		
		for(int x=0;x<1001;x++) {
			for(int y=0;y<1001;y++) {
				cnt[paper[x][y]]++;
			}
		}
		
		
		for(int i=1;i<=N;i++) {
			System.out.print(cnt[i]+"\n");
		}

	}
}
