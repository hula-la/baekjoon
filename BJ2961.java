package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2961 {
	static int[][] ingre;
	static int N;
	static long answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ingre = new int[N][2];
		answer=Long.MAX_VALUE;
		
		for(int i=0;i<N;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			ingre[i][0]= Integer.parseInt(st2.nextToken());
			ingre[i][1]=Integer.parseInt(st2.nextToken());
		}
		
		Find(0,0,1,0);
		System.out.println(answer);
	}
	
	static void Find(int idx, int cnt, int sour, int bitter) {
		if (idx==N) {
			if (cnt!=0) {
				answer = Math.min(answer, Math.abs(sour-bitter));
			}
			
		} else {
			Find(idx+1,cnt+1,sour*ingre[idx][0],bitter+ingre[idx][1]);
			Find(idx+1,cnt,sour,bitter);
		}
	}
}
