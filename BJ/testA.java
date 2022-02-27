package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class testA {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		l lst = arr[0];
		int lstI = 0;
		for (int i = 1; i < N; i++) {
			if (arr[i]!=lst) {
				for (int j = lstI; j < i; j++) {
					sb.append((i+1)+" ");
				}
				lstI=i;
				lst = arr[i];
			}
		}
		
		for (int j = lstI; j < N; j++) {
			sb.append(-1+" ");
		}
	
		
		System.out.println(sb);

	}
}
