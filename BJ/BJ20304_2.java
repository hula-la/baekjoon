package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
		
		int[] nums = new int[M];
		
		for (int i = 0; i < M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// BFS를 위한 큐 생성
		Queue<Integer> q = new LinkedList<Integer>();
		
		while(!q.isEmpty()) {
			int[][] arr = new int [M][2];
			for (int i = 0; i < M; i++) {
				if(nums[i]&1<<<idx==0) {
					
				}
			}
			
		}
	}

}

