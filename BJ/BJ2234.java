package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2234 {
	static int[][] dl = new int[][] {{0,-1},{-1,0},{0,1},{1,0}};
	static int[][] map;
	static int[][] visited;
	static int N,M,maxOR;
	static int sumArea;
	static ArrayList<Integer> area = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new int[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		
		int n = 1;
		int maxSum = 0;
		int max = 0;
		area.add(0);
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == 0) {
					maxOR=0;
					sumArea=0;
					findRoom(i,j,n);
					area.add(sumArea);
					maxSum = Math.max(maxSum, sumArea+maxOR);
					max = Math.max(max, sumArea);
					n++;
				}
			}
		}
		System.out.print(n-1+"\n"+max+"\n"+maxSum);
	}
	
	static void findRoom(int i, int j, int n) {
//		System.out.println(i+" "+j);
		visited[i][j] = n;
		sumArea++;
		
		for (int k = 0; k < 4; k++) {
			int nx = i+dl[k][0];
			int ny = j+dl[k][1];
			if (!(nx>=0&&nx<M&&ny>=0&&ny<N)) continue;
			if((1<<k & map[i][j]) == 0) {
//				System.out.println(i+" "+j+" "+k);
				if(visited[nx][ny] == 0) {
					findRoom(nx,ny,n);
				}
			} else {
				if (visited[nx][ny]<n) {
					maxOR = Math.max(maxOR, area.get(visited[nx][ny]));		
				}
			}
		}
	}
}
