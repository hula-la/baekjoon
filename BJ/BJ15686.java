package BJ;

import java.io.*;
import java.util.*;

public class BJ15686 {
	static int N,M;
	static List<point> home,chicken;
	static int answer= Integer.MAX_VALUE;
	
	public static class point{
		int x,y;
		point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		
		// �? ?��?��(1?�� ?��?�� 집리?��?��?�� 추�??���?, 2?�� ?��?�� 치킨집리?��?��?�� 추�?)
		for(int i=0;i<N;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int n = Integer.parseInt(st2.nextToken());
				if (n==1) home.add(new point(i,j));
				else if (n==2) chicken.add(new point(i,j));
			}
		}
		// 치킨집들?�� 조합?�� 구해?��, ?��?�� 최소?�� 치킨거리�? 구한?��.
		combi(0,0,new point[M]);
		// ?�� 출력
		System.out.println(answer);
	}
	
	// ?��?�� 치킨집들?�� 조합?�� 구하�?, ?��?�� 최소?�� 치킨거리�? 구한?��.
	static void combi(int idx,int cnt, point[] chickPart) {
		if (cnt==M) {
			answer = Math.min(calDir(chickPart), answer);
			return;
		}
		
		for (int i = idx; i < chicken.size(); i++) {
			chickPart[cnt] = chicken.get(i);
			combi(i+1,cnt+1, chickPart);
		}
	}
	
	// ?��?��?��?�� 치킨집을 기�??���? 치킨거리�? 구하?�� ?��?��
	static int calDir(point[] chickPart) {
		int total = 0;
		for(point h:home) {
			int min = Integer.MAX_VALUE;
			for(point c:chickPart) {
				min = Math.min(min, Math.abs(h.x-c.x)+Math.abs(h.y-c.y));
			}
			total += min;
			if (total>answer) return total;
		}
		return total;
	}
}
