package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class fighting {
	static int R, C, answer;
	static char[][] map;
	static int[] dy = {-1,0,1};
	
	public static void main(String[] args) throws IOException {
		long start = System.nanoTime();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
//		for (int i = 0; i < R; i++) {
//			map[i] = br.readLine().toCharArray();
//		}
		
		for (int i = 0; i < R; i++) {
			char[] s = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] =s[j];
			}
		}
		
//		for (int i = 0; i < R; i++) {
//			String s = br.readLine();
//			for (int j = 0; j < C; j++) {
//				map[i][j] =s.charAt(j);}
			
		
		for (int i = 0; i < R; i++) {
			back(0, i);
		}
		
		long end = System.nanoTime();
		
		System.out.println(end-start);
		System.out.println(answer);
	}
	
	public static void back(int cnt, int idx) {
		map[idx][cnt] = 'x';
		
		if (cnt==C-1){
			answer++;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			int y = idx+dy[i];
			if (!(y>=0 && y<R && map[y][cnt+1]=='.')) continue;
			int beforeA = answer;
			back(cnt+1, y);
			if(beforeA!=answer) return;
		}

	}

}