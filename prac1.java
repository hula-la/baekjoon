package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class prac1 {
	static int R;
	static int C;
	static int answer = 0;
	static char[][] map;
	static int visited[];
	static int[] dy = {-1,0,1};
	
	public static void main(String[] args) throws IOException {
		long start = System.nanoTime();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			char[] s = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] =s[j];
			}
		}
		
		visited = new int[C];
		
		for (int i = 0; i < R; i++) {
			back(0, i);
		}
		
		System.out.println(answer);
		long end = System.nanoTime();
		System.out.println(end-start);
	}
	
	public static void back(int cnt, int idx) {
		if (cnt==C-1){
			for (int i = 0; i < C; i++) {
				map[visited[i]][i] = 'X';
			}
			answer++;
			return;
		}
		if (!(idx>=0 && idx<R && map[idx][cnt]=='.')) return;
		visited[cnt] = idx;
		for (int i = 0; i < 3; i++) {
			int y = idx+dy[i];
			back(cnt+1,y);
			if(map[idx][cnt]!='.') return;
		}

	}

}