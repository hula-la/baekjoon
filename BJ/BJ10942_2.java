package BJ;

import java.io.*;
import java.util.*;

public class BJ10942_2 {
	static class Point {
		int s,e;
		Point(int s, int e){
			this.s=s;
			this.e=e;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// dp 생성
		int[][] p = new int[N][N];
		Queue<Point> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			p[i][i] =1;
			q.add(new Point(i,i));
		}
		for (int i = 0; i < N-1; i++) {
			if(arr[i]==arr[i+1]) p[i][i+1]=1;
			q.add(new Point(i,i+1));
		}
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			int ns = now.s-1;
			int ne = now.e+1;
			if (ns>=0 && ne<N) {
				if (arr[ns]==arr[ne]) {
					p[ns][ne] =1;
					q.add(new Point(ns,ne));
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			sb.append(p[a][b]+"\n");
		}
		System.out.print(sb);
	}
}