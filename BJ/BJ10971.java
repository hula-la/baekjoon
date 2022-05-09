import java.io.*;
import java.util.*;

public class Main {
	static int N,map[][],dp[][];
	static int INF=987654321;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp= new int[N][1<<N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < (1<<N)-1; j++) {
				dp[i][j]=INF;
			}
		}
		System.out.print(findP(0,1));
	}
	
	static int findP(int end, int visit) {
		if (visit==(1<<N)-1) {
			if(map[end][0]==0) return INF;
			else return map[end][0];
		} else if (dp[end][visit]!=INF) return dp[end][visit];
		else {
			for (int i = 0; i < N; i++) {
				if((visit&1<<i)==0&&map[end][i]!=0) {
					dp[end][visit]=Math.min(findP(i,visit|1<<i)+map[end][i], dp[end][visit]);
				}
			}
			return dp[end][visit];
		}
	}
}