package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BJ3052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Set<Integer> mod = new HashSet<Integer>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 10; i++) {
			mod.add(Integer.parseInt(br.readLine())%42);
		}
		System.out.print(mod.size());
	}
}
