package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2805_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		int[] tree = new int[N];
		
		int min = 0;
		int max = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			
			if(tree[i]>max) {
				max = tree[i];
			}
		}
		
		long lenSum;
		
		while (min<=max) {
			lenSum = 0;
			int mid = (min+max)/2;
			
			for(int h:tree) {
				lenSum += h-mid>0?h-mid:0;
			}
			
			// 같을 때
			if(lenSum==M) {
				max = mid;
				break;
			}
			
			// 합이 더 클 때
			if (lenSum>M) min=mid+1;
			else max=mid-1;
		}
		System.out.println(max);
	}

}
