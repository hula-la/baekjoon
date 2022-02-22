package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2477 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		int[] arr = new int[7];
		int[] Max = new int[2];
		int[] idx = new int[2];

		for(int i=0;i<6;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			arr[i] = Integer.parseInt(st.nextToken());
			
			if (arr[i]>Max[(dir-1)/2]) {
				Max[(dir-1)/2] = arr[i];
				idx[(dir-1)/2] = i;
			}
		}
		
		int startIdx = (Math.abs(idx[0]-idx[1])==1)? (Math.max(idx[0],idx[1])+2)%6:2;
		
		int area = Max[0]*Max[1]-arr[startIdx]*arr[(startIdx+1)%6];
		System.out.println(area*K);

	}
}
