package bj;

import java.util.Scanner;

public class BJ9663 {
	static int answer=0;
	static boolean[] row,col,rUp, rDown;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		row = new boolean[N];
		col = new boolean[N];
		rUp = new boolean[2*N-1];
		rDown = new boolean[2*N-1];
		
		findN(0);
		System.out.println(answer);
	}
	
	public static void findN(int cnt) {
		if (cnt==N) {
			answer+=1;
		} else {
			for(int i=0;i<N;i++) {
				
				if(!row[i]&&!col[cnt]&&!rUp[i-cnt+N-1]&&!rDown[i+cnt]) {
					row[i]=true;
					col[cnt]=true;
					rUp[i-cnt+N-1]=true;
					rDown[i+cnt]=true;	
					findN(cnt+1);
					row[i]=false;
					col[cnt]=false;
					rUp[i-cnt+N-1]=false;
					rDown[i+cnt]=false;
				}
			}
		}
	}
}
