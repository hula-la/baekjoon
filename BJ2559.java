package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2559 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
 		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int max = -100000000;
		int sum = 0;
		int cnt = 0;
		
		for (int j = 0;j<N;j++) {
			int num = Integer.parseInt(st2.nextToken());
			arr[j] = num;
			sum+=num;
			cnt++;
			
			if (cnt==K) {
				max = Math.max(sum, max);
				sum -= arr[j-K+1];
				cnt--;
			}
		}
		
		System.out.println(max);	
	}
}
