package BJ;

import java.io.*;
import java.util.*;

public class BJ17779 {
	static int totalS,N,ans=Integer.MAX_VALUE, map[][], arr[]=new int[4];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		totalS=0;
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				totalS+=map[i][j];
			}
		}
		
		DFS(0);
		
		System.out.print(ans);
	}
	
	static void DFS(int idx) {
		if (idx==4) {
//			System.out.println(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]);
			ans=Math.min(cal(), ans);
//			System.out.println();
		} else {
			int s=idx==3?arr[0]:0;
			int e=idx==3?arr[1]:(idx==2?arr[0]+arr[1]:2);
			for (int i = 1+s; i <= N-e; i++) {
				arr[idx]=i;
				DFS(idx+1);
			}
		}
	}
	
	static int cal() {
		int d1=arr[0];
		int d2=arr[1];
		int x=arr[2];
		int y=arr[3];
		
		int[] arr=new int[5];
		arr[4]=totalS;
		// 1번
		for (int i = 1; i < x+d1; i++) {
			for (int j = 1; j<= y; j++) {
				if(i>=x&&j>=y-(i-x)) break;
				arr[0]+=map[i][j];
			}
		}
		for (int i = 1; i <= x+d2; i++) {
			for (int j = y+1; j<= N; j++) {
				if(i>=x&&j<=y+(i-x)) continue;
				arr[1]+=map[i][j];
			}
		}
		for (int i = x+d1; i <= N; i++) {
			for (int j = 1; j< y-d1+d2; j++) {
				if(i<x+d1+d2&&j>=y-d1+(i-x-d1)) break;
				arr[2]+=map[i][j];
			}
		}
		for (int i = x+d2+1; i <= N; i++) {
			for (int j = y-d1+d2; j<= N; j++) {
				if(i<=x+d1+d2&&j<=y+d2-(i-x-d2)) continue;
				arr[3]+=map[i][j];
			}
		}
		int min=Integer.MAX_VALUE;
		int max=0;
		for (int i = 0; i < 5; i++) {
//			System.out.print(arr[i]+" ");
			if (i!=4) arr[4]-=arr[i];
			min=Math.min(min, arr[i]);
			max=Math.max(max, arr[i]);
		}
		return max-min;
	}
}
