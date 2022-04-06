package BJ;

import java.io.*;
import java.util.*;

public class BJ2258 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		System.out.println(Integer.MAX_VALUE);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			arr[i] = new int[] {w,p};
		}
		
		Arrays.sort(arr,new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[1]!=b[1])	return a[1]-b[1];
				else return b[0]-a[0];
			}
		});
		
		int sum=0;
		int price=0;
		boolean flag=false;
		int answer=Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			sum += arr[i][0];
			if (i!=0&&arr[i-1][1]==arr[i][1]) {
				price+=arr[i][1];
			} else {
				price=arr[i][1];
			}
			if(sum>=M) {
				flag=true;
				answer=Math.min(answer, price);
			}
		}
		
		if (flag) {
			System.out.print(answer);
		} else {
			System.out.print(-1);
		}
	}
}