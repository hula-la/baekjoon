package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2309 {
	static int[] answer = new int[7];
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		arr = new int[9];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i=0;i<9;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		combination(0,0,0);
	}
	
	public static void combination(int idx, int count, int sum) {
		if (count==7) {
			if (sum == 100) {
				Arrays.sort(answer);
				for(int i: answer) {
					System.out.println(i);
				}
				System.exit(0);
			}
			return;
		}
		if ((sum>100)||(idx==9)) return;
		
		
		combination(idx+1,count,sum);
		answer[count] = arr[idx];
		combination(idx+1,count+1,sum+arr[idx]);
		
	}
}
