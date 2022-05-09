package BJ;

import java.io.*;
import java.util.*;

public class BJ2513 {
	static class Point{
		int p, n;
		Point(int p, int n){
			this.p=p;
			this.n=n;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int lowerCnt=0;
		
		Point[]	arr = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Point(a,b);
			if (a<S) lowerCnt++;
		}
		Arrays.sort(arr, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return o1.p-o2.p;
			}
		});
		int cnt=0;
		int rest=0;
		for (int i = 0; i < lowerCnt; i++) {
			int p =Math.abs(arr[i].p-S);
			int n=arr[i].n-rest;
			if (n<=0) {
				rest=-n;
				continue;
			}
			int plus=(n-1)/K+1;
			cnt+=p*2*plus;
			rest=plus*K-n;
		}
		rest=0;
		for (int i = N-1; i >= lowerCnt; i--) {
			int p =Math.abs(arr[i].p-S);
			int n=arr[i].n-rest;
			if (n<=0) {
				rest=-n;
				continue;
			}
			int plus=(n-1)/K+1;
			cnt+=p*2*plus;
			rest=plus*K-n;
		}
		System.out.print(cnt);
		
	}
}
