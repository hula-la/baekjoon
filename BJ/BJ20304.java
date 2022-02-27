package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ20304 {
	static int[] nums;
	static int N,M;
	static int len;
	static int answer=0;
	static int[][] zeroNums;
	static int count = 0;
	static int totalcnt=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//숫자 배열 
		nums = new int[M];
		double a = Math.log(N)/Math.log(2);
		len = (int) Math.ceil(a);
		
		// dp를 위한 배열
		int[] dp = new int[1<<len];
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<M;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			dp[i] = 0;
			q.add(i);
		}
		
		
		while(!q.isEmpty()) {
			
		}
		
	
		Find(0, new int[M], Integer.MAX_VALUE, 0);
		System.out.println(answer);
	}
	
}

