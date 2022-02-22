package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3234 {
	static int[] arr;
	static int sum, N, cnt;
	static int[] fac;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int i = 1; i <= TC; i++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[N];
			sum = 0;
			cnt = 0;
			fac = new int[N+1];
			fac[0] = 1;
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum+=arr[j];
				fac[j+1]=(j+1)*fac[j];
			}
			permu(0,0,0,0);
			sb.append("#"+i+" "+cnt+"\n");
		}
		System.out.println(sb);
	}
	
	static void permu(int Lsum, int Rsum, int idx, int tmp) {
//		System.out.println(Lsum);
		if (idx==N) {
			cnt++;
			return;
		}
		if (Lsum>sum/2) {
			int rest = N-idx;
			cnt+=fac[rest]*(1<<rest);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((tmp&1<<i)==0) {
					permu(Lsum+arr[i],Rsum, idx+1,tmp|1<<i);
					if (Lsum>=Rsum+arr[i]) permu(Lsum,Rsum+arr[i],idx+1,tmp|1<<i);
				
			}
		}
	
	}
}
	
