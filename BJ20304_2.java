package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20304_2 {
	static int[] nums;
	static int N,M;
	static int len;
	static int answer=0;
	static int[][] zeroNums;
	static int count = 0;
	static int totalcnt=0;
	
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
		
	
		Find(0, new int[M], Integer.MAX_VALUE, 0);
		System.out.println(answer);
		System.out.println(totalcnt);
	}
	
	static void Find(int cnt, int[] state, int min, int num) {
		System.out.println(num);
		for
//			for (int i = 0; i < oneState.length; i++) {
//				System.out.print(oneState[i]);
//			}
//			System.out.println();

			Find(cnt+1,oneState,minOne, num +(1<<cnt));
			Find(cnt+1,zeroState,minZero, num);

		}
		
	}
	
}

