package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10817 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = 0;
		int b=0;
		
		for (int i = 0; i < 3; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n>a){
				b=a;
				a=n;
			}
			else if (n>b) b=n;
		}
		System.out.print(b);
		

	}
}
