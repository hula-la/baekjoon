package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2578 {
	static boolean [][] checked = new boolean[5][5];
	static boolean [][] bingoA = new boolean[3][5];
	
	
	public static void main(String[] args) throws IOException {
		int[][] bingo = new int[26][];
		int round=0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				bingo[Integer.parseInt(st.nextToken())] = new int[] {i,j};
			}
		}
		
		roundset: for (int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				round ++;
				int num = Integer.parseInt(st.nextToken());
				int x = bingo[num][0];
				int y = bingo[num][1];
				checked[x][y] = true;
								
				if (x==y) {
					bingoA[2][0] = check(x,y,2);
				}
				if(x+y==4) {
					bingoA[2][1] = check(x,y,3);
				}
				bingoA[0][x] = check(x,y,0);
				bingoA[1][y] = check(x,y,1);
				
				// ê²??‚¬
				int bingoNum = 0;
				for(int i1=0;i1<3;i1++) {
					for(int j1=0;j1<5;j1++) {
						if (bingoA[i1][j1]){
							bingoNum+=1;
						}
					}
				}
				if (bingoNum >=3) {
					System.out.print(round);
					break roundset;
				}
			}
		}
		
	}
	
	public static boolean check(int x, int y, int n) {

		for(int i=0;i<5;i++) {
			int a,b;
		
			switch (n) {
			case 0:a=x;b=i;break;
			case 1:a=i;b=y;break;
			case 2:a=i;b=i;break;
			case 3:a=i;b=4-i;break;
			
			default: a=0;b=0;
			}
			if (checked[a][b] != true) {
				return false;
			}
		}
		return true;
	}

}

