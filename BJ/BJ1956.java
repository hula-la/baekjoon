package BJ;

import java.io.*;
import java.util.*;

public class BJ1956 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[][] map = new int [V][V];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = c;
		}
		
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (map[i][j] == 0) map[i][j] = Integer.MAX_VALUE;
			}
		}
		int INF=Integer.MAX_VALUE;
		int ans=INF;
		
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				for (int k = 0; k < V; k++) {
					if (map[j][i]!=INF && map[i][k]!=INF) {
						if (map[j][i]+map[i][k]<map[j][k]) {
							map[j][k] = map[j][i]+map[i][k];
							if(j==k) {
								ans=Math.min(ans, map[j][k]);
							}
						}
					}
				}
			}
		}
		
		if (ans==INF) ans=-1;
		
		System.out.print(ans);
		
	}
}
