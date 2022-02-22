package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2564 {
	static int W,H;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());
		int result = 0;

		
		int[] arrDis = new int[N];
		
		for (int i=0;i<N;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st2.nextToken());
			int dis = Integer.parseInt(st2.nextToken());
			
			arrDis[i] = findDis(dir,dis);
			
		}
		st = new StringTokenizer(br.readLine());
		int dDir = Integer.parseInt(st.nextToken());
		int dDis = Integer.parseInt(st.nextToken());
		int dongDir = findDis(dDir,dDis);
		
		for (int i=0;i<N;i++) {
			int diff = Math.abs(dongDir-arrDis[i]);
			diff = diff>W+H? 2 * (W+H)-diff:diff;
			result += diff;
		}
		System.out.print(result);
	}
	
	static int findDis(int dir, int dis) {
		switch (dir){
		case 1:
			return dis;
		case 2:
			return 2*W+H-dis;
		case 3:
			return  2*W+2*H-dis;
		case 4:
			return  W+dis;
		default:
			return 0;
		}
	}
}
