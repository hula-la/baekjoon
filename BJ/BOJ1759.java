package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
	
	static int C;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		char[] letters = br.readLine().replace(" ", "").toCharArray();
		Arrays.sort(letters);
		StringBuilder word = new StringBuilder();
		StringBuilder codes = new StringBuilder();
		int vowels;
		int[] c = new int[C];
		for (int i = L; i < C; i++) c[i] = 1;
		do {
			vowels = 0;
			for (int i = 0; i < C; i++) {
				if (c[i] == 0) {
					if (letters[i] == 'a' || letters[i] == 'e' || letters[i] == 'i' || letters[i] == 'o' || letters[i] == 'u') vowels++;
					word.append(letters[i]);
				}
			}
			if (1 <= vowels && vowels <= L - 2) {
				codes.append(word).append("\n");
			}
			word.setLength(0);
		} while (np(c));
		System.out.println(codes);
		
	}
	
	private static boolean np(int[] c) {
		int i = C - 1;
		while (i > 0 && c[i - 1] >= c[i]) --i;
		if (i == 0) return false;
		int j = C - 1;
		while(c[i - 1] >= c[j]) --j;
		swap(c, i - 1, j);
		int k = C - 1;
		while(i < k) {
			swap(c, i++, k--);
		}		
		return true;
	}
	
	private static void swap(int[] c, int i , int j) {
		int temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}

}
