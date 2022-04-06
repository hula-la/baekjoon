package BJ;

import java.io.*;
import java.util.*;

public class BJ17471_2 {
	static int total,N,ans,map[][],popu[];
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		popu = new int[N];
		map = new int[N][];
		ans=Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			popu[i] = Integer.parseInt(st.nextToken());
			total+=popu[i];
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			map[i] = new int[S];
			for (int j = 0; j < S; j++) {
				map[i][j]=Integer.parseInt(st.nextToken())-1;
			}
		}
		com(1,1);
		if(!flag) ans=-1;
		System.out.print(ans);
	}
	
	static void com(int arr, int i) {
		if(i==N) {
			int a = BFS(arr);
			int b = BFS((1<<N)-1-arr);
			if(a!=0&&b!=0) {
				flag=true;
				ans=Math.min(Math.abs(a-b), ans);
			}
		} else {
			com(arr,i+1);
			com(arr|1<<i,i+1);
		}
	}
	static int BFS(int arr) {
		int sum=0;
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			if ((1<<i&arr)!=0) {
				q.add(i);
				arr = arr&~(1<<i);
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int a = q.poll();
			sum+=popu[a];
			for (int j = 0; j < map[a].length; j++) {
				int n = map[a][j];
				if ((1<<n&arr)!=0) {
					q.add(n);
					arr = arr&~(1<<n);
				}
			}
		}
		if(arr==0) return sum;
		return 0;
	}
}
