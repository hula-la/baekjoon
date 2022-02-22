package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1247 {
	static boolean[] visited;
	static int[][] cust;
	static int answer, N;
	static int homeX,homeY;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TN = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= TN; i++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int comX = Integer.parseInt(st.nextToken());
			int comY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());

			answer=Integer.MAX_VALUE;
			visited = new boolean[N];
			cust = new int[N][2];
			
			for (int j = 0; j < N; j++) {
				cust[j][0] = Integer.parseInt(st.nextToken());
				cust[j][1] = Integer.parseInt(st.nextToken());
			}
			
			per(0,0,comX,comY);
			System.out.println("#"+i+" "+answer);
		}
		
	}
	
	public static void per(int cnt, int sum, int x, int y) {
		if (sum>answer) return;
		if (cnt==N) {
			answer = Math.min(Math.abs(x-homeX)+Math.abs(y-homeY)+sum, answer);
		}
		else {
			for (int i=0;i<N;i++) {
				if(visited[i]) continue;
				int x2 = cust[i][0];
				int y2 = cust[i][1];
				
				visited[i] = true;
				per(cnt+1, sum+Math.abs(x-x2)+Math.abs(y-y2),x2,y2);
				visited[i] = false;
			}
		}
	}
}
