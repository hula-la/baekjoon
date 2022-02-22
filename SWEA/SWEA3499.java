package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA3499 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for (int i=1;i<tc+1;i++) {
			int N = Integer.parseInt(br.readLine());
			int halfN = (N+1)/2;
			String[] cards = br.readLine().split(" ");
			
			System.out.print("#"+i);
			for (int j=0;j<N;j++) {
				System.out.print(" "+cards[j%2==0?j/2:halfN+j/2]);
			}
			System.out.print("\n");
			
		}
	}
}
