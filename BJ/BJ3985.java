package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3985 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int[] roll = new int[L+1];
		int maxGiven = 0;
		int maxGivenI = 0;
		int maxExpected = 0;
		int maxExpectedI = 0;
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			for (int j = a; j <= b; j++) {
				if (roll[j]==0) {
					roll[j] = i;
					cnt++;
				}
			}
			
			if (maxGiven<cnt) {
				maxGiven=cnt;
				maxGivenI=i;
			}
			if (maxExpected<b-a+1) {
				maxExpected=b-a+1;
				maxExpectedI=i;
			}

		}
		
		System.out.println(maxExpectedI);
		System.out.println(maxGivenI);
		
	}
}
