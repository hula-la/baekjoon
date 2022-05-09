package BJ;

import java.io.*;
import java.util.*;

public class BJ10836_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[2*M-1];
		for (int i = 0; i < 2*M-1; i++) {
			arr[i] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int z = Integer.parseInt(st.nextToken());
			int o = Integer.parseInt(st.nextToken())+z;
			int t = Integer.parseInt(st.nextToken())+o;
			
			for (int j = z; j < o; j++) {
				arr[j]+=1;
			}
			for (int j = o; j < t; j++) {
				arr[j]+=2;
			}
		}
		
//		for (int i = 0; i < 2*M-1; i++) {
//			
//			System.out.print(arr[i]+" ");
//		}
//		System.out.println();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if (j==0) sb.append(arr[M-1-i]+" ");
				else sb.append(arr[M-1+j]+" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}
