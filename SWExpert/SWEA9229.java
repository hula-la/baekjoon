package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA9229 {
	static int[] cookie;
	static int N;
	static int M;
	static int max;
	static int sum;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int caseN = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<caseN;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			max = -1;
			
			StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
			
			cookie = new int[N];
			
			for(int j = 0;j<N;j++) {
				cookie[j] = Integer.parseInt(st2.nextToken());
				for (int k = 0;k<j;k++) {
					sum = cookie[j] + cookie[k];
					
					if ((sum<=M)&&(sum>max)) {
						max = sum;
					}
				}
			}
			System.out.print("#"+(i+1)+" "+max+"\n");
			
		}
	}
}
