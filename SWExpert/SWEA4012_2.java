package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA4012_2 {
	static int minV = Integer.MAX_VALUE;
	static int[][] arr;
	static int N;
	static boolean[] visited;
	
	static void combination(int idx, int cnt) {
		if (cnt==N/2) {
			int sum = cal();
			minV = Math.min(minV, sum);
		} else {
			for (int j=idx;j<N;j++) {
				visited[j] = true;
				combination(j+1,cnt+1);
				visited[j] = false;
			}
		}
	}
	
	static int cal() {
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		int aSum=0;
		int bSum=0;
		
		for (int i=0;i<N;i++) {
			if(visited[i]) {
				a.add(i);
			}
			else {
				b.add(i);
			}
		}
		
		for(int i=0;i<N/2-1;i++) {
			for(int j=i;j<N/2;j++) {
				aSum += arr[a.get(i)][a.get(j)];
				aSum += arr[a.get(j)][a.get(i)];
				bSum += arr[b.get(i)][b.get(j)];
				bSum += arr[b.get(j)][b.get(i)];
			}
		}
		System.out.println(aSum);
		System.out.println(bSum);
		System.out.println("최소"+Math.abs(aSum-bSum));
		return Math.abs(aSum-bSum);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
			minV = Integer.MAX_VALUE;
			visited=new boolean[N];
			
			combination(0, 0);
			
			System.out.println("#"+i+" "+minV);
		}
	}

}
