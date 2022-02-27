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
		
		// ë§? ?…? ¥(1?¼ ?•Œ?Š” ì§‘ë¦¬?Š¤?Š¸?— ì¶”ê??•˜ê³?, 2?¼ ?•Œ?Š” ì¹˜í‚¨ì§‘ë¦¬?Š¤?Š¸?— ì¶”ê?)
		for(int i=0;i<N;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int n = Integer.parseInt(st2.nextToken());
				if (n==1) home.add(new point(i,j));
				else if (n==2) chicken.add(new point(i,j));
			}
		}
		// ì¹˜í‚¨ì§‘ë“¤?˜ ì¡°í•©?„ êµ¬í•´?„œ, ? œ?¼ ìµœì†Œ?¸ ì¹˜í‚¨ê±°ë¦¬ë¥? êµ¬í•œ?‹¤.
		combi(0,0,new point[M]);
		// ?‹µ ì¶œë ¥
		System.out.println(answer);
	}
	
	// ?‚¨?Š” ì¹˜í‚¨ì§‘ë“¤?˜ ì¡°í•©?„ êµ¬í•˜ê³?, ? œ?¼ ìµœì†Œ?¸ ì¹˜í‚¨ê±°ë¦¬ë¥? êµ¬í•œ?‹¤.
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
	
	// ?‚¨?•„?ˆ?Š” ì¹˜í‚¨ì§‘ì„ ê¸°ì??œ¼ë¡? ì¹˜í‚¨ê±°ë¦¬ë¥? êµ¬í•˜?Š” ?•¨?ˆ˜
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
