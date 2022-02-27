package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2851 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int sumB = 0;
		for (int i=0;i<10;i++) {
			int n = Integer.parseInt(br.readLine());
			if (sum+n>=100) {
				sumB = sum +n;
				break;
			}
			sum += n;
		}
		if (Math.abs(sumB-100)>100-sum) {
			System.out.print(sum);
		} else System.out.print(sumB);
	}
}
