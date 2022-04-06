package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[K];
		long max = 0;
		
		for (int i = 0; i < K; i++) {
			arr[i]= Long.parseLong(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		long s=1;
		long e=max;
		
		while(s<=e){
			int sum=0;
			long mid=(s+e)/2;
			for (int i = 0; i < K; i++) {
				sum+= arr[i]/mid;
			}
			if (sum<N) {
				e=mid-1;
			}else {
				s=mid+1;
			}
		}
		
		System.out.print(e);
	}
}
