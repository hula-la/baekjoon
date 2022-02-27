package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[K+1];
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st2.nextToken());
			int V = Integer.parseInt(st2.nextToken());
			
			for(int j=K;j>=W;j--) {
				arr[j] = Math.max(arr[j], arr[j-W]+V);
			}
		}
		
		System.out.println(arr[K]);
	}
}
