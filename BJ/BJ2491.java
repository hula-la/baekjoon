package BJ;

import java.util.Scanner;

public class BJ2491 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N];
		int[]dp = new int[N];
		int result = 1;
		int isInc = -1;
		int same = 0;
		
		dp[0] = 1;
		nums[0] = sc.nextInt();
		
		for(int i=1;i<N;i++) {
			nums[i] = sc.nextInt();
			if (nums[i-1]>nums[i]) {
				dp[i] = isInc==0?dp[i-1]+1:2+same;
				isInc = 0;
				same = 0;
			}
			else if(nums[i-1]<nums[i]) {
				dp[i] = isInc==1?dp[i-1]+1:2+same;
				isInc = 1;
				same = 0;
			}
			else {
				same += 1;
				dp[i] = dp[i-1]+1;
			}
			result = Math.max(dp[i], result);
		}
		
		System.out.print(result);
	}
}
