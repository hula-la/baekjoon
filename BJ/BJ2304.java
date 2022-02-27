package BJ;

import java.io.*;
import java.util.*;


public class BJ2304 {
	static Point[] arr;
	static int result, maxH;
	static class Point implements Comparable<Point>{
		int x,h;
		Point(int x, int h){
			this.x=x;
			this.h=h;
		}
		@Override
		public int compareTo(Point o) {
			return this.x-o.x;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new Point[N];
		maxH = 0;
		
		for (int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			maxH = Math.max(maxH, h);
			arr[i]=new Point(idx,h);
		}
		
		Arrays.sort(arr);
		
		result = 0;
		int i= cal(N-1,-1);
		int j=cal(0,1);
		
		result +=(arr[i].x+1-arr[j].x)*maxH;
		
//		result +=
		
		System.out.print(result);
	}
	static int cal(int i, int plus) {
		int lstIdx = 0;int lstH = 0;
		
		while (arr[i].h!=maxH) {
			if (arr[i].h>lstH) {
				result += lstH*plus*(arr[i].x-lstIdx);
//				System.out.println(result);
				lstH = arr[i].h;
				lstIdx = arr[i].x;
			}
			i+=plus;
		}
		result += lstH*plus*(arr[i].x-lstIdx);
		return i;
	}
}
