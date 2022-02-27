package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int room = 0;
		
		int[][] table = new int[6][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st2.nextToken());
			int grade = Integer.parseInt(st2.nextToken());
			
			table[grade-1][sex]+=1;
		}
		
		for(int i=0;i<6;i++) {
			for(int j=0;j<2;j++) {
				room += Math.ceil((double)(table[i][j])/K);
			}
		}
		System.out.println(room);
	}
}
