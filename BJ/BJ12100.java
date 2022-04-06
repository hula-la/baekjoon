package BJ;

import java.io.*;
import java.util.*;

public class BJ12100 {
	static int[][] m = {{0,1},{0,-1},{1,0},{-1,0}};
	static int[][] midx;
	static int answer=0;
	static int N;
	static int[][] map;
	static int[][] mapCopy;
//	static int[][] moveMap;
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		mapCopy = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		allCase(0,map);
		System.out.println(answer);
		
	}
	
	static void allCase(int idx, int[][] nowMap) {
		if(idx==5) return;
		else {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						mapCopy[j][k] = nowMap[j][k];
					}
				}
				int[][] moveMap = new int[N][N];
				caseMove(i,moveMap);
				
				allCase(idx+1,moveMap);
			}
		}
	}
	
	static void caseMove(int c, int[][] moveMap) {
		for (int i = 0; i < N; i++) {
			switch(c) {
			case 0:moveLine(c, new Point(i,1), mapCopy[i][0], new Point(i,0),moveMap); break;
			case 1:moveLine(c, new Point(i,N-2), mapCopy[i][N-1], new Point(i,N-1),moveMap); break;
			case 2:moveLine(c, new Point(1,i), mapCopy[0][i], new Point(0,i),moveMap); break;
			case 3:moveLine(c, new Point(N-2,i), mapCopy[N-1][i], new Point(N-1,i),moveMap); break;
			}
		}
	}
	static void moveLine(int c,Point now, int lst, Point idx, int[][] moveMap) {
		int x = now.x;
		int y = now.y;
		if (x<0||x>=N||y<0||y>=N) {
			moveMap[idx.x][idx.y] = lst; 
			answer=Math.max(answer, moveMap[idx.x][idx.y]);
			return;
		}
		
		if (mapCopy[x][y]!=0) {
			if (lst!=0) {
				if (mapCopy[x][y]==lst) {
					moveMap[idx.x][idx.y] = 2*lst; 
					lst=0;
				} else {
					moveMap[idx.x][idx.y] = lst; 
					lst=mapCopy[x][y];
				}
				answer=Math.max(answer, moveMap[idx.x][idx.y]);
				idx.x+=+m[c][0];
				idx.y+=+m[c][1];			
			} else {
				lst=mapCopy[x][y];
			}
		}
		
		now.x += m[c][0];
		now.y += m[c][1];
		moveLine(c,now,lst,idx, moveMap);
		
	}
}
