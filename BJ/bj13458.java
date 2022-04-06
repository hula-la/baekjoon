package BJ;

import java.io.*;
import java.util.*;

public class bj13458 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long answer = N;
		for (int i = 0; i < N; i++) {
			answer += Math.ceil((float)(arr[i]>B?arr[i]-B:0)/C);
		}
		System.out.println(answer);
		
	}
}
