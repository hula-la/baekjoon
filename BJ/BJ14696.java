package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14696 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		testcase: for (int i=0;i<N;i++) {
			StringTokenizer A = new StringTokenizer(br.readLine());
			StringTokenizer B = new StringTokenizer(br.readLine());
			
			int Anum = Integer.parseInt(A.nextToken());
			int Bnum = Integer.parseInt(B.nextToken());
			int[][] arr = new int[2][5];
			for (int a=0;a<Anum;a++) {
				arr[0][Integer.parseInt(A.nextToken())]++; 
			}
			for (int b=0;b<Bnum;b++) {
				arr[1][Integer.parseInt(B.nextToken())]++; 
			}
			
			for (int j=4;j>0;j--) {
				if (arr[0][j]>arr[1][j]) {
					sb.append("A"+"\n");
					continue testcase;
				}
				else if (arr[1][j]>arr[0][j]) {
					sb.append("B"+"\n");
					continue testcase;
				}
			}
			sb.append("D"+"\n");
			
		}
		System.out.println(sb);
	}
}
