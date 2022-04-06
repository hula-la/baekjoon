package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int lst = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		for (int i = 1; i < 8; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(n>lst) {
				answer = answer==1?3:2;
			} else {
				answer = answer==2?3:1;
			}
//			System.out.println(answer);
			lst = n;
			if(answer==3)break;
		}
		if (answer==3) System.out.print("mixed");
		else if (answer==2) System.out.print("ascending");
		else System.out.print("descending");
	}
}
