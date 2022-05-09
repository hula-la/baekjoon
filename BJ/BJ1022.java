package BJ;

import java.io.*;
import java.util.*;

public class BJ1022 {

	public static void main(String[] args) throws IOException {
		int[] dx =  {0,-1,0, 1};
		int[] dy =  {1,0,-1,0};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r1=Integer.parseInt(st.nextToken());
		int c1=Integer.parseInt(st.nextToken());
		int r2=Integer.parseInt(st.nextToken());
		int c2=Integer.parseInt(st.nextToken());
		
		int r=Math.max(Math.abs(r1), Math.abs(r2));
		int c=Math.max(Math.abs(c1), Math.abs(c2));
		int N = Math.max(r, c);
		
		int[][] arr = new int[r2-r1+1][c2-c1+1];
		
		int d=0;
		int l=0;
		int maxl=1;
		int num=1;
		int x=N,y=N;
		
		while(true) {
			if (x>=N+r1&&x<=N+r2&&y>=N+c1&&y<=N+c2) {
				arr[x-N-r1][y-N-c1]=num;
			}
			num++;
			x+=dx[d];
			y+=dy[d];
			
			if (x<0||x>=2*N+1||y<0||y>=2*N+1) break;
			if(++l==maxl) {
				d=(d+1)%4;
				if(d%2==0)maxl++;
				l=0;
			}
		}
		
		int L=String.valueOf(arr[(Math.abs(r1)>Math.abs(r2)?r1:r2)-r1][(Math.abs(c1)>Math.abs(c2)?c1:c2)-c1]).length(); 
		for (int i = 0; i <= r2-r1; i++) {
			for (int j = 0; j <= c2-c1; j++) {
				System.out.printf("%"+L+"d ",arr[i][j]);
			}
			System.out.print("\n");
		}
	}
}
