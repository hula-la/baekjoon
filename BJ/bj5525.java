package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj5525 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		int answer=0;
		
		char lst = arr[0];
		int n=lst=='I'?1:0;
		for (int i = 1; i < M; i++) {
			if(lst!=arr[i]) {
				n+=1;
			}else {
				answer+=Math.max((n-2*N+1)/2, 0);
				n=lst=='I'?1:0;
			}
			lst = arr[i];
//			System.out.println(n);
		}
		answer+=Math.max((n-2*N+1)/2, 0);
		System.out.print(answer);
		
	}
}
