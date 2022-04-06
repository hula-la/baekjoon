package BJ;

import java.io.*;

public class BJ2239_2 {
	static int[][] map;
	static boolean[][][] check;
	static int[][] answer;
	static int zeroCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		check = new boolean[3][9][10];
		zeroCnt = 0;
		
		for (int i = 0; i < 9; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				map[i][j] = line[j]-'0';
				check[0][i][map[i][j]]=check[1][j][map[i][j]]=check[2][i/3*3+j/3][map[i][j]]=true;
				if (map[i][j]==0) zeroCnt++;
			}
		}
		DFS(0);
	}
	
	static void DFS(int cnt) {
		if (cnt==zeroCnt) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (map[i][j]!=0) continue;
				for (int k = 1; k <= 9; k++) {
					if (!check[0][i][k]&&!check[1][j][k]&&!check[2][i/3*3+j/3][k]) {
						map[i][j] = k;
						check[0][i][k]=check[1][j][k]=check[2][i/3*3+j/3][k]=true;
						DFS(cnt+1);
						map[i][j] = 0;
						check[0][i][k]=check[1][j][k]=check[2][i/3*3+j/3][k]=false;
					}
				}
				return;
			}
		}
	}
	
}
