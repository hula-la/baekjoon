package BJ;

import java.io.*;
import java.util.*;

public class BJ17143_2 {
	static shark[][] map;
	static int R,C,ans;
	static int[][] dl= {{-1,1,0,0},{0,0,1,-1}};
	static int[] oppo = {1,0,3,2};
	static class shark{
		int s,d,z;
		shark(int s, int d, int z){
			this.s=s;
			this.d=d;
			this.z=z;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new shark[R][C];
		
		// 상어 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			
			map[r][c] = new shark(s,d,z);
		}
		
		ans=0;
		
		for (int i = 0; i < C; i++) {
			// 가장 가까운 상어 잡기
			fishing(i);
			// 상어 이동
			map=move();
			
		}
		System.out.print(ans);
		
	}
	
	static void fishing(int c) {
		for (int i = 0; i < R; i++) {
			if (map[i][c]!=null) {
				ans+=map[i][c].z;
				map[i][c]=null;
				return;
			}
		}
	}
	
	static shark[][] move() {
		shark[][] tmp = new shark[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j]!=null) {
					shark s= map[i][j];
					
					int r = i,c = j;
					
					if(s.d/2==0) r=calP(i,s.d/2,R-1,s);
					else c=calP(j,s.d/2,C-1,s);
							
					if (tmp[r][c]==null||(tmp[r][c]!=null && tmp[r][c].z<s.z)) {
						tmp[r][c]=s;
					}
				}
			}
		}
		return tmp;
	}
	
	static int calP(int r, int a,int L, shark s) {
		r += dl[a][s.d]*s.s;
		if(r<0) r=(Math.abs(r/(2*L))+1)*2*L+r;
		s.d = r/L%2==0?s.d:oppo[s.d];
		r=r/L%2==0?r%L:L-r%L;
		
		return r;
	}
}
