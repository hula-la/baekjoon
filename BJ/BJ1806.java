package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer=Integer.MAX_VALUE;
		
		int start = 0;
		int sum=0;
		for (int end = 0; end < N; end++) {
			sum+=arr[end];
			while(sum>=S) {
				answer=Math.min(answer, end-start+1);
				sum-=arr[start];
				start++;
			}
		}
		
		if (answer==Integer.MAX_VALUE) answer=0;
		System.out.println(answer);
	}
}
