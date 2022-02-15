package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA6808 {
	static int win, lose;
	static ArrayList<Integer> iny,gyu;
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		
		for(int i=1;i<=tc;i++) {
			iny = new ArrayList<Integer>();
			gyu = new ArrayList<Integer>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append("#"+i+" ");
			
			for(int j=1;j<=18;j++) iny.add(j);
			
			for(int j=0;j<9;j++) {
				int n = Integer.parseInt(st.nextToken());
				gyu.add(n);
			}
			
			iny.removeAll(gyu);

			win=0;
			lose=0;
			visited = new boolean[9]; 
			
			Count(0,0);
			sb.append(win+" "+lose+"\n");
		}
		System.out.println(sb.toString());
	}
	
	static void Count(int Gsum, int cnt) {
		if (cnt==9) {
			if (Gsum>0) {
				win++;
			} if (Gsum<0) {
				lose++;
			}
		} else {
			for (int i=0;i<9;i++){
				if (!visited[i]) {
					int point = gyu.get(cnt)+iny.get(i);
					int sum = Gsum;
					sum += (gyu.get(cnt)>iny.get(i))?point:-point;
					visited[i] = true;
					Count(sum, cnt+1);
					visited[i] = false;
				}
			}
		}
	}
}
