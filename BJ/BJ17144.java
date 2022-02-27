package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17144 {
	static int R,C,T, acloc;
	static int[][] map;
	static int[][] dl = {{1,0},{0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j]==-1) acloc=i;
			}
		}
		
		for (int i = 0; i < T; i++) {
			map = diffu();
			fresh(acloc-2,-1);
			fresh(acloc+1,1);
		}
		
		System.out.println(calS());

	}
	
	static void fresh(int s, int a) {
		// acloc-1 : 반시계
		int x=s;
		int y=0;
		int j2=1-a;
		
		int start,end;
		if (a==-1) {
			start=0; end=s-a;
		} else {
			start=s-a;
			end=R-1;
		}
		while(true) {
			
			int nX = x+dl[j2][0];
			int nY = y+dl[j2][1];
			
			if(nX>=start&&nY>=0&&nX<=end&&nY<C) {
				if(map[nX][nY]==-1) {
					map[x][y] = 0;
					break;
				}
				map[x][y] = map[nX][nY];
				x = nX;
				y = nY;
			} else {
				j2+=a;
				if(j2==-1) j2=3;
			}
		}
	}
	
	static int[][] diffu() {
		int[][] tmp = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				tmp[i][j] += map[i][j];
				if (map[i][j]!=0) {
					for (int j2 = 0; j2 < 4; j2++) {
						int nX = i+dl[j2][0];
						int nY = j+dl[j2][1];
						
						if(nX>=0&&nY>=0&&nX<R&&nY<C&&map[nX][nY]!=-1) {
							tmp[nX][nY] += map[i][j]/5;
							tmp[i][j] -= map[i][j]/5;
						}
						
					}
				}
			}
		}
		return tmp;
	}
	
	static int calS() {
		int sum=0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j]);
				if (map[i][j]!=-1)sum+=map[i][j];
			}
//			System.out.println();
		}
		return sum;
	}
}
