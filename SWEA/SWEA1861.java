package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1861 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		
		int tn = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=tn;i++) {
			int N = Integer.parseInt(br.readLine());
//			int[][] arr = new int[N][N];
//			boolean[] checked = new boolean[(int) Math.pow(N,2)];
//			Queue<Integer[]> queue= new LinkedList<Integer[]>(); 
			int[][] numArr = new int[(int) (Math.pow(N, 2)+1)][];
			
			// idx 0: 시작 위치, idx 1: 길이
			int[] result = {1,1};
			int[] sum = {1,1};
			 
			
			// 배열 이력
			for(int x=0;x<N;x++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int y=0;y<N;y++) {
					int num = Integer.parseInt(st.nextToken());
//					System.out.println(num);
					numArr[num] = new int[]{x,y};	
				}
			}
			
			for(int j=2;j<=(int) (Math.pow(N, 2));j++) {
				int x1 = numArr[j-1][0];
				int y1 = numArr[j-1][1];
				int x2 = numArr[j][0];
				int y2 = numArr[j][1];
				
				if (((Math.abs(x1-x2)==1)&&(y1==y2))||(Math.abs(y1-y2)==1)&&(x1==x2)) {
					sum[1] ++;
					if (result[1]<sum[1]) {
						result = sum.clone();

					}
				}
				else {
					sum[1] = 1;
					sum[0] = j;
				}
				
			}
			
			System.out.print("#"+i+" "+result[0]+" "+result[1]+"\n");
		}
	}
}
