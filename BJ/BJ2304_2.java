package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2304_2 {
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
		ArrayList<Point> arr = new ArrayList<>();
		int answer=0;
		int maxH = 0;
		int endIdx=0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			arr.add(new Point(x,h));
			if(h==maxH) {
				endIdx=Math.max(endIdx, x);
			}else if(h>maxH) {
				endIdx=x;
				maxH = h;
			}
		}
		Collections.sort(arr);
		
		Stack<Point> stack = new Stack<>();
		stack.add(new Point (0,0));
		for(Point p:arr) {
			// endIdx보다 작을 땐 증가
			if(p.x<=endIdx) {
				if(stack.peek().h<=p.h) {
					stack.add(p);
				}
			}else {
				while(stack.peek().h<p.h) {
					stack.pop();
				}
				stack.add(p);
			}
		}
		
		// 계산
		while(stack.size()!=1) {
			Point p =stack.pop();
//			System.out.println(p.x+" "+p.h);
			if(p.x>endIdx) {
				answer+=(p.x-stack.peek().x)*p.h;
			} else {
				answer+=(p.x-stack.peek().x)*stack.peek().h;
			}
		}
		System.out.print(answer+maxH);
	}
}
