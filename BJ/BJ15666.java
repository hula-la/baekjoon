package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ15666 {
	static int N,M;
	static ArrayList<Integer> nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new ArrayList<Integer>();
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for (int i=0;i<N;i++) {
			nums.add(Integer.parseInt(st2.nextToken()));
		}
		
		Collections.sort(nums);
		Permutation(0, new int[M], 0);
	}
	
	static void Permutation(int cnt, int[] arr, int start) {
		
		if (cnt==M) {
			for(int i: arr) {
				System.out.print(i+" ");
			}
			System.out.print("\n");
			return;
		}
		int last=0;
		for(int i=start;i<N;i++) {
			if (last==nums.get(i)) {
				continue;
			}
			last = nums.get(i);
			arr[cnt] = nums.get(i);
			Permutation(cnt+1, arr, i);
			
		}
	}
}
