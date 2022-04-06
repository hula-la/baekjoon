package BJ;

import java.io.*;
import java.util.*;

public class BJ17471 {
	static int total,N,ans,sum,map[][],popu[];
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
		combi(1,1);
		if(!flag) ans=-1;
		System.out.print(ans);
	}
	
	static void combi(int arr, int idx) {
		if(idx==N) {
			if(arr==(1<<N)-1) return;
			sum=0;
			if(conn(arr)) {
				flag=true;
				System.out.println(Math.abs(total-2*sum));
				System.out.println(arr);
				ans=Math.min(Math.abs(sum), ans);
			}
		} else {
			combi(arr,idx+1);
			combi(arr|1<<idx,idx+1);
		}
	}
	static boolean conn(int arr) {
		total:for (int i = 0; i < N; i++) {
			if ((1<<i&arr)!=0) {
				for (int j = 0; j < map[i].length; j++) {
					if ((1<<map[i][j]&arr)!=0) {
						sum+=popu[i];
						continue total;
					}
				}
				return false;
			} else {
				for (int j = 0; j < map[i].length; j++) {
					if ((1<<map[i][j]&~arr)!=0) {
						sum-=popu[i];
						continue total;
					}
				}
				return false;
			}
		}
		return true;
	}
}
