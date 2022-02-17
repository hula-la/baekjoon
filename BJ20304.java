package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20304 {
	static int[] nums;
	static int N,M;
	static int len;
	static int answer=0;
	static int[][] zeroNums;
	static int count = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 데이터 읽기를 위한 버퍼드리더 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 패스워드 최댓값  N 입력
		N = Integer.parseInt(br.readLine());
		// 패스워드의 개수  M 입력
		M = Integer.parseInt(br.readLine());
		// 패스워드 입력을 위한 스트링토크나이저 생성
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		nums = new int[M];
		double a = Math.log(N)/Math.log(2);
		len = (int) Math.ceil(a);
		
		for(int i=0;i<M;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
	
		Find(0, new int[M], Integer.MAX_VALUE);
		System.out.println(answer);
	}
	
	static void Find(int cnt, int[] state, int min) {
		
		if(cnt==len) {
			answer = Math.max(min, answer);
		}
		else {
			System.out.println(min);
			System.out.println(cnt);
			int minOne = Integer.MAX_VALUE;
			int minZero = Integer.MAX_VALUE;
			int[] oneState = new int[M];
			int[] zeroState = new int[M];
			for (int i=0;i<M;i++) {
				if ((1>>cnt & nums[i]) !=0) {
					oneState[i] = state[i] + 1;
					zeroState[i] = state[i];
				} else {
					zeroState[i] = state[i] + 1;
					oneState[i] = state[i];
				}
				minOne = Math.min(minOne, oneState[i]);
				minZero = Math.min(minZero, zeroState[i]);
			}

			Find(cnt+1,state,minOne);

			Find(cnt+1,state,minZero);
		}
		
	}
	
}
