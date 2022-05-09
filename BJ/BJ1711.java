package BJ;

import java.io.*;
import java.util.*;

public class BJ1711 {
	static Point[] arr,triangle = new Point[3];
	static int N,cnt=0;
	static class Point{
		long x,y;
		Point(long x, long y){
			this.x=x;
			this.y=y;
		}
		long dot(Point o1, Point o2){
			long a=(this.x-o1.x)*(this.x-o2.x)+(this.y-o1.y)*(this.y-o2.y);
			return a;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new Point[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			arr[i]=new Point(x,y);
		}
		DFS(0,0);
		System.out.print(cnt);
	}
	
	static void DFS(int idx, int lst) {
		if (idx==3) {
			for (int i = 0; i < 3; i++) {
				if(triangle[i].dot(triangle[(i+1)%3], triangle[(i+2)%3])==0) {
					cnt++;
					return;
				}
			}
		} else {
			for (int i = lst; i < N; i++) {
				triangle[idx]=arr[i];
				DFS(idx+1,i+1);
			}
		}
	}
}
