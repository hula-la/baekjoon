package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2798 {
	static int max = 0;
	static int N,M;
	static int[] cards;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		cards = new int[N];
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		com(0,0,0);
		System.out.print(max);
		
	}
	
	public static void com(int cnt, int idx, int sum) {
		if (sum>M) return;
		if (cnt==3) {
			max = Math.max(max, sum);
		}else {
			for (int j = idx; j < N; j++) {
				com(cnt+1,j+1,sum+cards[j]);
			}
		}
		
	}
}
