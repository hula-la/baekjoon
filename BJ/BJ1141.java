package BJ;

import java.io.*;
import java.util.*;

public class BJ1141 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int ans=0;
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i]=br.readLine();
		}
		Arrays.sort(arr);
		boolean[] not = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (not[i]) continue;
			ans++;
			for (int j = 0; j < N; j++) {
				if (i!=j&&arr[j].startsWith(arr[i])) {
					not[j]=true;
					break;
				}
			}
		}
		System.out.print(ans);
	}
}
