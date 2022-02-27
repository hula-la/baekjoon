package BJ;

import java.io.*;

public class BJ10026_2 {
	static int[][] dl = {{1,0},{0,1},{-1,0},{0,-1}};
	static int N;
	static char[][] map;
	static boolean visited[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		visited=new boolean[N][N];
		int a1=cal();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='G') map[i][j]='R';
			}
		}
		visited=new boolean[N][N];
		int a2=cal();
		System.out.println(a1+" "+a2);
	}
	static int cal() {
		int a=0;
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if(!visited[k][i]) {
					a++;
					findMap(k,i, map[k][i]);
				}
			}
		}
		return a;
	}

	static void findMap(int x, int y, char color) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nX = x+dl[i][0];
			int nY = y+dl[i][1];
			if(nX>=0&&nX<N&&nY>=0&&nY<N&&!visited[nX][nY]&&map[nX][nY]==color) {
				findMap(nX,nY,color);
			}
		}
	}
}
