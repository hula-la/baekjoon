package BJ;

import java.io.*;
import java.util.*;

public class BJ17143 {
	static shark[][] map;
	static int R,C,ans;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,1,-1};
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
			
//			for (int x = 0; x < R; x++) {
//				for (int y = 0; y < C; y++) {
//					
//					System.out.print((map[x][y]==null?0:map[x][y].d+1)+" ");
//				}
//				System.out.println();
//				}
//			System.out.println();
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
					
//					System.out.println("이전 i"+i+"j"+j+"방향"+s.d);
//					System.out.println("방향"+s.d+"속도"+s.s);
					int RL=R-1;
					
					int r=i;
					int c=j;
					
					if (dr[s.d]!=0) {
						r= dr[s.d]==1?i:2*RL-i;
						r = r+dr[s.d]*dr[s.d]*s.s;
						s.d = r/RL%2==0?(dr[s.d]==1?s.d:oppo[s.d]):(dr[s.d]==1)?oppo[s.d]:s.d;
						r=r/RL%2==0?r%RL:RL-r%RL;
					} else {
						int CL=C-1;
						c= dc[s.d]==1?j:2*CL-j;
						c = c+dc[s.d]*dc[s.d]*s.s;
						s.d = c/CL%2==0?(dc[s.d]==1)?s.d:oppo[s.d]:(dc[s.d]==1)?oppo[s.d]:s.d;
						c=c/CL%2==0?c%CL:CL-c%CL;
//						System.out.println("i"+r+"j"+c);
					}
//						System.out.println("i"+r+"j"+c+"방향"+s.d);
					
					
					
					
						map[i][j]=null;
					if (tmp[r][c]==null||(tmp[r][c]!=null && tmp[r][c].z<s.z)) {
						tmp[r][c]=s;
					}
				}
			}
		}
		return tmp;
	}
}
