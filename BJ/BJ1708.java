package BJ;

import java.io.*;
import java.util.*;

public class BJ1708 {
	static BufferedReader br;
	static StringTokenizer st;
	static Vector origin,lst;
	static class Vector{
		long x,y;
		Vector(long x,long y){
			this.x=x;
			this.y=y;
		}
		
		double abs() {
//			System.out.println("**abs**");
			System.out.println(this.x*this.x+this.y*this.y);
//			System.out.println(this.x+" "+this.y);
			return Math.sqrt(this.x*this.x+this.y*this.y);
		}
		
		double dot(Vector o) {
			return (this.x*o.x+this.y*o.y)/(o.abs()*this.abs());
		}
		double cross(Vector o) {
			return (this.x*o.y-this.y*o.x);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int maxY=-40001;
		int maxX=0;
		Vector[] arr=new Vector[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			arr[i]=new Vector(x,y);
			if(y>maxY) {
				origin=arr[i];
				maxY=y;
				maxX=x;
			} else if (y==maxY) {
				if (x>maxX) {
					maxX=x;
					origin=arr[i];
				}
			}
		}
//		System.out.println(origin.x+" "+origin.y);
//		System.out.println();
		lst = new Vector(1,0);
//		Vector start = origin;
		Arrays.sort(arr, new Comparator<Vector>() {
			@Override
			public int compare(Vector o1, Vector o2) {
				Vector aV=new Vector(o1.x-origin.x,o1.y-origin.y);
				Vector bV=new Vector(o2.x-origin.x,o2.y-origin.y);
				if (Double.compare(aV.abs(),0)==0) return -1;
				if (Double.compare(bV.abs(),0)==0) return 1;
//				System.out.println(aV.dot(lst));
//				int compare=-Double.compare(aV.dot(lst), bV.dot(lst));
				int compare=-Double.compare(Math.round(aV.dot(lst)*1000)/1000.0, Math.round(bV.dot(lst)*1000)/1000.0);
				if (compare==0) return -Double.compare(aV.abs(), bV.abs());
				return compare;
			}
		});
		
		Stack<Vector> s = new Stack<>();
		s.add(arr[0]);
		s.add(arr[1]);
		
//		for(Vector v:arr) {
//			System.out.println(v.x+" "+v.y);
//		}
//		
//		System.out.println();
		
		for (int i = 2; i <= N; i++) {
			while(true) {
				Vector p2 = s.pop();
				Vector p1 = s.pop();
//				System.out.println(p1.x+" "+p1.y);
//				System.out.println(p2.x+" "+p2.y);
//				System.out.println(arr[i%N].x+" "+arr[i%N].y);
				Vector prevV = new Vector(p2.x-p1.x,p2.y-p1.y);
				Vector nowV = new Vector(arr[i%N].x-p2.x,arr[i%N].y-p2.y);
				s.add(p1);
//				System.out.println(prevV.cross(nowV));
//				System.out.println(prevV.dot(nowV));
				if(prevV.cross(nowV)<0)  {
					s.add(p2);
					s.add(arr[i%N]);
					break;
				}
				else if (Math.abs(prevV.cross(nowV))<0.00001) {
					System.out.println("일직선");
					if(prevV.dot(nowV)>0) {
						s.add(arr[i%N]);
						break;
					}
					s.add(p2);
					break;
				}
			}
		}
		System.out.println();
		for(Vector v:s) {
			System.out.println(v.x+" "+v.y);
		}
		
		System.out.print(s.size()-1);
	}
}
