package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class bj2605 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		LinkedList<Integer> arr = new LinkedList<>();

		for(int i=0; i<n;i++) {
			arr.add(Integer.parseInt(st.nextToken()), i+1);
		}
		
		for(int j=0;j<n;j++) {
			System.out.print(arr.removeLast()+" ");
		}
	}
}
