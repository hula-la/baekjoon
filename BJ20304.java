package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20304 {
	static char[][] nums;
	static int N,M,len;
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
		
		len = Integer.toBinaryString(N).length();
		nums = new char[N][len];
		
		zeroNums = new int[len][2];
		
		for(int i=0;i<M;i++) {
			int n =Integer.parseInt(st.nextToken());
			char[] a = Integer.toBinaryString(n).toCharArray();
			
			for(int j=len-a.length;j<len;j++) {
				nums[i][j] = a[j-len+a.length];
			}
		}
		
//		for(int i=0;i<len;i++) {
//			for(int j=0;j<M;j++) {
//				zeroNums[i][1] +=  nums[i][j]=='1'?1:0;
//				zeroNums[i][0] += nums[i][j]!='1'?1:0;
//			}
//		}
		
		Find(0, new int[M], new char[len]);
		System.out.println(answer);
		System.out.println(count);
	}
	
	static void Find(int cnt, int[] priv, char[] currentN) {
		
		if(cnt==len) {
//			System.out.println(String.valueOf(currentN));

			if (Integer.parseInt(String.valueOf(currentN),2)<=N) {
				int min=100;
				int max=0;
				for(int i=0;i<M;i++) {
					min = Math.min(priv[i],min);
					max = Math.max(priv[i],max);
				}
//				System.out.print(min+" "+(len-max));
//				System.out.println();
				answer = Math.max(min, answer);
			}
		}
		else {
			int[] temp = priv.clone();
			int[] temp2 = priv.clone();
			
			count++;
			for(int i=0;i<M;i++) {
				temp[i] += nums[i][cnt]=='1'?1:0;
				temp2[i] += nums[i][cnt]!='1'?1:0;
			}
			
			currentN[cnt] = '0';
			Find(cnt+1,temp,currentN);

			currentN[cnt] = '1';
			Find(cnt+1,temp2,currentN);
		}
		
	}
	
}
