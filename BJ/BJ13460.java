package BJ;

import java.io.*;
import java.util.*;

public class BJ13460 {
	static Point blue,red,goal;
	static int N,M,ans=Integer.MAX_VALUE;
	static int goalFlg;
	static char[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static class Point{
		int x,y;
		Point(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j]=='B') blue=new Point(i,j);
				else if (map[i][j]=='R') red=new Point(i,j);
				else if (map[i][j]=='O') goal=new Point(i,j);
			}
		}
		
		for (int i = 0; i < 4; i++) {
			Permutatione(1, move(map,i), i);
		}
		if(ans==Integer.MAX_VALUE) System.out.print(-1);
		else System.out.print(ans);
		
	}
	
	static void Permutatione(int idx, char[][] lst, int lstD) {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(lst[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		if (idx>10) return;
		if (goalFlg==-1) return;
		else if (goalFlg==1) ans=Math.min(idx, ans);
		else {
			for (int i = 0; i < 4; i++) {
				if (i==(lstD+2)%4) continue;
				Permutatione(idx+1,move(lst,i),i);
			}
		}
	}
	
	static char[][] move(char[][] m, int d){
		char[][] tmp=new char[N][M];
		
		Point r = null,b = null;
		boolean rG = false,bG = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (m[i][j]=='R') r=new Point(i,j);
				if (m[i][j]=='B') b=new Point(i,j);
				tmp[i][j] = m[i][j];
			}
		}
		if (d%2==0&&r.y==b.y) {
			if (r.x*dx[d]>b.x*dx[d]) {
				//r부터
				rG=find(tmp,r,d);
				bG=find(tmp,b,d);
			} else {
				bG=find(tmp,b,d);
				rG=find(tmp,r,d);
			}
		} else {
//			 if (d%2==1&&r.x==b.x)
			if (r.y*dy[d]>b.y*dy[d]) {
				rG=find(tmp,r,d);
				bG=find(tmp,b,d);
			} else {
				bG=find(tmp,b,d);
				rG=find(tmp,r,d);
			}
		}
		if (bG) goalFlg=-1;
		else if (rG) goalFlg=1;
		else goalFlg=0;
		return tmp;
	}
	
	static boolean find (char[][] m, Point s, int d) {
		int x = s.x;
		int y = s.y;
		char color=m[x][y];
		while (true) {
			x += dx[d];
			y += dy[d];
			if (m[x][y]!='.') {
				m[s.x][s.y]='.';
				if (m[x][y]=='O') {
//					if(color=='R') return true; 
//					else return false;
					return true;
				} else {
					m[x-dx[d]][y-dy[d]]=color;
					return false;
				}
			}
		}
	}
}

//3 6
//######
//#.ROB#
//######
//
//1

//6 7
//#######
//#R....#
//#.....#
//#..O..#
//#..B..#
//#######
//
//3


//3 5
//#####
//#OBR#
//#####
//answer=-1
//
//-1

//5 7
//#######
//#.RB###
//#.#.#O#
//#.....#
//#######
//
//4


//11 13
//#############
//#.RB#########
//#.#.........#
//#.#.#######.#
//#.#.#.....#.#
//#.#.#..O#.#.#
//#.#.#####.#.#
//#.#.......#.#
//#.#########.#
//#...........#
//#############
//
//-1

//11 13
//#############
//#RB##########
//#.#.........#
//#.#.#######.#
//#.#.#.....#.#
//#.#.#..O#.#.#
//#.#.#####.#.#
//#.#.......#.#
//#.#########.#
//#...........#
//#############
//
//10
