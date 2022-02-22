package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA4012 {
	static int minV;
	static int[][] arr;
	static int N;
	static Deque<Integer> sum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sum = new LinkedList<Integer>();
		int T = Integer.parseInt(br.readLine());
		
		for (int i=1;i<=T;i++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for (int j=0;j<N;j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k=0;k<N;k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			combination(0, 0,new int[N/2],0);
			int size = sum.size();
			int minV = Integer.MAX_VALUE;
			for(int j=0;j<size/2;j++) {
				int a= sum.pollLast();
				int b=sum.poll();
				minV=Math.min(Math.abs(a-b),minV);
			}
			
			System.out.println("#"+i+" "+minV);
		}
		
		
	}

	static void combination(int idx, int cnt, int[] ingre, int sumA) {
		if (cnt==N/2) {
			sum.add(sumA);
		} else {
			for (int j=idx;j<N;j++) {
				
				ingre[cnt] = j;
				int sum = calculS(j,ingre,cnt,sumA);
				
				combination(j+1,cnt+1,ingre,sum);
			}
		}
	}
	
	static int calculS(int selectedIngre, int[] ingre, int idx, int sum) {
		for (int i=0;i<idx;i++) {
			sum += arr[ingre[i]][selectedIngre]+arr[selectedIngre][ingre[i]];
		}
		return sum;
	}
}
