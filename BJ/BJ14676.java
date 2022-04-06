package BJ;

import java.io.*;
import java.util.*;

public class BJ14676 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String ans="King-God-Emperor";
		
		List<Integer> map[] = new List[N];
		int[] need = new int[N];
		int[] tower= new int[N];
		for (int i = 0; i < N; i++) {
			map[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a].add(b);
			need[b]++;
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken())-1;
			if (a==1) {
				if (need[b]>0) {
					ans="Lier!";
					break;
				}
				tower[b]++;
				if (tower[b]==1) {
					for(int n:map[b]) {
						need[n]--;
					}
				}
			} else {
				if (tower[b]==0){
					ans="Lier!";
					break;
				}
				tower[b]--;
				if (tower[b]==0) {
					for(int n:map[b]) {
						need[n]++;
					}
				}
			}
		}
		System.out.print(ans);
	}
}
