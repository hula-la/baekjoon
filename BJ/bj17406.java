package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj17406 {
	static int[][] arr,tmp;
	static int N,M,K,r,c,s;
	static int answer=(int) 10e4;
	static boolean[] visited;
	
	static int[][] rArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr=new int[N][M];
		visited = new boolean[K];
		// ë°°ì—´ ?ž…? ¥
		for (int i=0;i<N;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		rArr = new int[K][3];
		// ëª…ë ¹ ?ž…? ¥
		for (int i=0;i<K;i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			
			rArr[i][0] = Integer.parseInt(st3.nextToken())-1;
			rArr[i][1] = Integer.parseInt(st3.nextToken())-1;
			rArr[i][2] = Integer.parseInt(st3.nextToken());
	
		}

		
		comRotate(0,arr);
		
		System.out.print(answer);
		
	}
	
	static int[][] ratate(int r, int c, int s, int[][] arr) {
		tmp = new int[N][M];
		for (int i=0;i<N;i++) {
			for (int j=0;j<M;j++) {
				tmp[i][j] = arr[i][j];
			}
		}
		
		for(int i=1;i<s+1;i++) {
			for(int j=c-i;j<c+i;j++) {
				tmp[r-i][j+1] = arr[r-i][j];
			}
			for(int j=r-i;j<r+i;j++) {
				tmp[j+1][c+i] = arr[j][c+i];
			}
			for(int j=c-i+1;j<=c+i;j++) {
				tmp[r+i][j-1] = arr[r+i][j];
			}
			for(int j=r-i+1;j<=r+i;j++) {
				tmp[j-1][c-i] = arr[j][c-i];
			}
			
				
		}
		return tmp;
	}
	
	static void comRotate(int cnt, int[][] arr) {
		if (cnt==K) {
			for (int x=0;x<N;x++) {
				int sum = 0;
				for (int y=0;y<M;y++) {
					sum += arr[x][y];
				}
				answer = answer<sum?answer:sum;
			}
		}
		
		for(int i=0;i<K;i++) {
			if (!visited[i]) {
				
				int[][] temp = ratate(rArr[i][0],rArr[i][1],rArr[i][2],arr);
				
				visited[i]=true;
				comRotate(cnt+1,temp);
				
				visited[i]=false;
			}
		}
		
		
	}
	
}
