package BJ;

import java.io.*;
import java.util.*;

public class BJ10026 {
	static int[][] dl = {{1,0},{0,1},{-1,0},{0,-1}};
	static int N;
	static char[][] map;
	static Map<Character, Character> nextC= new HashMap<Character, Character>() {
		{
			put('G', 'Z');
			put('R', 'Z');
			put('Z', 'A');
			put('B', 'Z');
		}
	};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a1=0;
		int a2=0;
		
		char[] colorSeq = {'G','R','Z','B'};
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int k = 0; k < 4; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j]==colorSeq[k]) {
						if (k!=2) a1++;
						if (k>=2) a2++;
						findMap(i,j,colorSeq[k]);
					}
				}
			}
			
		}
		
		System.out.println(a1+" "+a2);
	}
	
	static void findMap(int x, int y, char color) {
		map[x][y] = nextC.get(color);
		
		for (int i = 0; i < 4; i++) {
			int nX = x+dl[i][0];
			int nY = y+dl[i][1];
			if(nX>=0&&nX<N&&nY>=0&&nY<N&&map[nX][nY]==color) {
				findMap(nX,nY,color);
			}
		}
	}
}
