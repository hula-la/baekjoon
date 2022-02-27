package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		int[] tree = new int[N+1];
		tree[0] = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(tree);
		int start = 0;
		int end = N;
		long lenSum=0;
		
		while (start<=end) {
			lenSum = 0;
			int mid = (end+start)/2;
			
			for (int i = mid; i <= N; i++) {
				lenSum += tree[i] - tree[mid];
			}
			
			// ê°™ì„ ?•Œ
			if(lenSum==M) {
				end = mid;
				break;
			}
			
			// ?•©?´ ?” ?´ ?•Œ
			if (lenSum>M) {
				start=mid+1;
			} else {
				end=mid-1;
			}
		}
		int restNum = N-end;
		int answer = tree[end];
		
		lenSum = 0;
		for (int i = end; i <= N; i++) {
			lenSum += tree[i] - tree[end];
		}
		
		answer += (lenSum-M)/restNum;

		
		System.out.println(answer);
	}
	
}
