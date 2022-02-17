package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1987 {
	static boolean visited[] = new boolean[26];
	static boolean[][] mapvisited;
	static int[][] dl = {{0,1},{1,0},{0,-1},{-1,0}};
	static int answer = 0;
	static int R,C;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		mapvisited = new boolean[R][C];
		move(0,0,1);
		
		System.out.print(answer);
		
		
	}
	
	public static void move(int x, int y, int move) {
		mapvisited[x][y] = true;
		visited[map[x][y]-'A'] = true;
		answer = Math.max(move, answer);
		
		for (int i = 0; i < 4; i++) {
			int nextX = x+dl[i][0];
			int nextY = y+dl[i][1];
			if (nextX<0||nextX>=R||nextY<0||nextY>=C||mapvisited[nextX][nextY]||visited[map[nextX][nextY]-'A']) continue;
			move(nextX, nextY, move+1);
			mapvisited[nextX][nextY] = false;
			visited[map[nextX][nextY]-'A'] = false;
		}

	}
}
