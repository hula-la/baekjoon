package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1592 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] count = new int[N];
		int idx = 0;
		int cnt = 0;
		
		while (true) {
			count[idx]++;
			if (count[idx]==M) break;
			idx = count[idx]%2==0?(idx-L)%N:(idx+L)%N;
			idx += idx<0?N:0;
			cnt++;
		}
		System.out.print(cnt);
		
	}
}
