package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class testD {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int answer=0;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 간선수
		int[] tailN = new int[N];
		
		// 부모 설정
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i]=i;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			tailN[a]++;
			
//			if (findP(a)!=findP(b)) {
//				tailN[a]++;
//				parent[findP(a)] = findP(b);
//			}else {
//				tailN[a]--;
//			}
		}
		
		for (int i = 0; i < N; i++) {
//			System.out.println(tailN[i]);
			if(tailN[i]==0) {
				answer++;
			}
		}
		System.out.println(answer);
		
	}
	
	static int findP(int i) {
		if (parent[i]==i) return i;
		else return parent[i]=findP(parent[i]);
	}
}
