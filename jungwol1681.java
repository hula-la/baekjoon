import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungwol1681 {
	static int answer=Integer.MAX_VALUE;
	static int N;
	static boolean[] visited;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N];
		permutation(0,0,0);
		
		System.out.println(answer);
	}

	static void permutation(int cnt, int sum, int lst) {
		if (sum>answer) return;
		if (cnt==N-1) {
			// 마지막 노드에서 1번으로 가는 방법이 없을 때 고려해줘야함!
			if (map[lst][0]==0) return;
			answer = Math.min(answer, sum+map[lst][0]);
		}
		else {
			for (int i = 1; i < N; i++) {
				if (!visited[i]&&map[lst][i]!=0) {
					visited[i]=true;
					permutation(cnt+1,sum+map[lst][i],i);
					visited[i]=false;
				}
			}
		}
		
	}
}
