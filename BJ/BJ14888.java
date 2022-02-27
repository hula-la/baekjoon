package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14888 {
	static int min=Integer.MAX_VALUE;
	static int max=Integer.MIN_VALUE;
	static int N;
	static int[] arr,exer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		exer = new int[4];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < 4; i++) {
			exer[i] = Integer.parseInt(st.nextToken());
		}
		
		permu(0,arr[0]);
		System.out.println(max);
		System.out.print(min);
	}
	static void permu(int cnt, int sum) {
		if (cnt==N-1) {
			min=Math.min(sum, min);
			max=Math.max(sum, max);
		}
		else {
			for (int i = 0; i < 4; i++) {
				if (exer[i]!=0) {
					exer[i]--;
					permu(cnt+1,cal(sum,arr[cnt+1],i));
					exer[i]++;
				}
			}
		}
	}
	static int cal(int a,int b,int exer) {
		switch(exer) {
		case 0:return a+b;
		case 1:return a-b;
		case 2:return a*b;
		case 3:return a/b;
		default:return 0;
		}
	}
}
