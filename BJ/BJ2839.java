package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2839 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int result = -1;
		for(int i=N/5;i>=0;i--) {
			int rest = N-i*5;
			if (rest%3==0) {
				result=i+rest/3;
				break;
			}
		}
		System.out.println(result);
	}
}
